package com.chn.cuentas.repository;

import com.chn.cuentas.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}


