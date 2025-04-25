package com.chn.cuentas.controller;

import com.chn.cuentas.model.Chequera;
import com.chn.cuentas.model.Cuenta;
import com.chn.cuentas.model.Cheque;
import com.chn.cuentas.repository.ChequeraRepository;
import com.chn.cuentas.repository.CuentaRepository;
import com.chn.cuentas.repository.ChequeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/chequeras")
public class ChequeraController {

    private final ChequeraRepository chequeraRepository;
    private final CuentaRepository cuentaRepository;
    private final ChequeRepository chequeRepository;

    @Autowired
    public ChequeraController(
            ChequeraRepository chequeraRepository,
            CuentaRepository cuentaRepository,
            ChequeRepository chequeRepository
    ) {
        this.chequeraRepository = chequeraRepository;
        this.cuentaRepository = cuentaRepository;
        this.chequeRepository = chequeRepository;
    }

    @GetMapping
    public List<Chequera> listarChequeras() {
        return chequeraRepository.findAll();
    }

    @GetMapping("/cuenta/{cuentaId}")
    public List<Chequera> chequerasPorCuenta(@PathVariable Integer cuentaId) {
        return chequeraRepository.findByCuentaId(cuentaId);
    }

    @PostMapping
    public ResponseEntity<?> crearChequera(@RequestBody Map<String, Object> datos) {
        try {
            Integer cuentaId = (Integer) datos.get("cuentaId");
            Integer numeroInicial = (Integer) datos.get("numeroInicial");
            Integer numeroFinal = (Integer) datos.get("numeroFinal");

            Optional<Cuenta> cuentaOpt = cuentaRepository.findById(cuentaId);
            if (cuentaOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("Cuenta no encontrada");
            }

            Chequera chequera = new Chequera();
            chequera.setCuenta(cuentaOpt.get());
            chequera.setNumeroInicial(numeroInicial);
            chequera.setNumeroFinal(numeroFinal);
            chequera.setEstado("activa");
            chequera.setCantidadCheques(numeroFinal - numeroInicial + 1);

            Chequera guardada = chequeraRepository.save(chequera);

            for (int i = chequera.getNumeroInicial(); i <= chequera.getNumeroFinal(); i++) {
                Cheque cheque = new Cheque();
                cheque.setEstado("activo");
                cheque.setNumeroCheque(i); // 👈 ESTE CAMPO ES OBLIGATORIO
                cheque.setChequera(chequera);
                chequeRepository.save(cheque);
            }

            return ResponseEntity.ok(guardada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear la chequera: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Chequera actualizarChequera(@PathVariable Integer id, @RequestBody Chequera chequera) {
        chequera.setId(id);
        return chequeraRepository.save(chequera);
    }

    @DeleteMapping("/{id}")
    public void eliminarChequera(@PathVariable Integer id) {
        chequeraRepository.deleteById(id);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(@PathVariable Integer id, @RequestBody Chequera nuevaInfo) {
        return chequeraRepository.findById(id)
                .map(chequera -> {
                    chequera.setEstado(nuevaInfo.getEstado());
                    chequera.setMotivoEstado(nuevaInfo.getMotivoEstado());
                    chequeraRepository.save(chequera);
                    return ResponseEntity.ok(chequera);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
