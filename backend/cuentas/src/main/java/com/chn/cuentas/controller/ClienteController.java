package com.chn.cuentas.controller;

import com.chn.cuentas.model.Cliente;
import com.chn.cuentas.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }




}

