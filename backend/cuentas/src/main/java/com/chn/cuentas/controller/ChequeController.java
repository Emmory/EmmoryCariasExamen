package com.chn.cuentas.controller;

import com.chn.cuentas.model.Cheque;
import com.chn.cuentas.repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
@CrossOrigin(origins = "*")
public class ChequeController {

    @Autowired
    private ChequeRepository chequeRepository;

    @GetMapping("/por-chequera/{chequeraId}")
    public List<Cheque> obtenerChequesPorChequera(@PathVariable Integer chequeraId) {
        return chequeRepository.findByChequeraId(chequeraId);
    }

    
    @PutMapping("/{id}/estado")
    public ResponseEntity<Cheque> actualizarEstadoCheque(
            @PathVariable Integer id,
            @RequestParam String nuevoEstado,
            @RequestParam(required = false) String motivoEstado) {

        Optional<Cheque> chequeOpt = chequeRepository.findById(id);
        if (chequeOpt.isPresent()) {
            Cheque cheque = chequeOpt.get();
            cheque.setEstado(nuevoEstado);
            cheque.setMotivoEstado(motivoEstado);
            chequeRepository.save(cheque);
            return ResponseEntity.ok(cheque);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
