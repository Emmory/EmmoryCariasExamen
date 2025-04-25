package com.chn.cuentas.controller;

import com.chn.cuentas.model.Chequera;
import com.chn.cuentas.model.Cuenta;
import com.chn.cuentas.model.Cliente;
import com.chn.cuentas.repository.ChequeraRepository;
import com.chn.cuentas.repository.ClienteRepository;
import com.chn.cuentas.repository.CuentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {
    @Autowired
    private ChequeraRepository chequeraRepository;


    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crearCuenta(@RequestBody Cuenta cuenta) {
        try {
            Cliente cliente = clienteRepository.findById(cuenta.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            cuenta.setCliente(cliente);

            Cuenta nuevaCuenta = cuentaRepository.save(cuenta);

            // Crear chequera automáticamente si es tipo "monetaria"
            if ("monetaria".equalsIgnoreCase(nuevaCuenta.getTipo())) {
                Chequera chequera = new Chequera();
                chequera.setCuenta(nuevaCuenta);
                chequeraRepository.save(chequera);
            }

            return ResponseEntity.ok(nuevaCuenta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear cuenta: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(
            @PathVariable Integer id,
            @RequestBody Cuenta cuentaActualizada) {

        return cuentaRepository.findById(id)
                .map(cuenta -> {
                    cuenta.setEstado(cuentaActualizada.getEstado());
                    cuenta.setMotivoEstado(cuentaActualizada.getMotivoEstado());
                    cuentaRepository.save(cuenta);
                    return ResponseEntity.ok(cuenta);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
