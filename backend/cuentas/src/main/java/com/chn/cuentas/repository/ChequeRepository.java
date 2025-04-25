package com.chn.cuentas.repository;

import com.chn.cuentas.model.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChequeRepository extends JpaRepository<Cheque, Integer> {
    List<Cheque> findByChequeraId(Integer chequeraId);
}

