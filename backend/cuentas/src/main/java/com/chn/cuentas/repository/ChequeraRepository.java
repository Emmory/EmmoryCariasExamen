package com.chn.cuentas.repository;
import com.chn.cuentas.model.Cuenta;
import com.chn.cuentas.model.Chequera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChequeraRepository extends JpaRepository<Chequera, Integer> {
    List<Chequera> findByCuentaId(Integer cuentaId); // ← ESTE método debe estar
}

