package com.chn.cuentas;

import com.chn.cuentas.model.Cuenta;
import com.chn.cuentas.model.Cliente;
import com.chn.cuentas.repository.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @Test
    public void crearCuenta_DeberiaGuardarCuenta() {
        Cliente cliente = new Cliente();
        cliente.setId(1);

        Cuenta cuenta = new Cuenta();
        cuenta.setTipo("ahorro");
        cuenta.setMontoApertura(new BigDecimal("500.00"));
        cuenta.setCliente(cliente);

        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        Cuenta resultado = cuentaRepository.save(cuenta);

        assertNotNull(resultado);
        assertEquals("ahorro", resultado.getTipo());
        assertEquals(new BigDecimal("500.00"), resultado.getMontoApertura());
        verify(cuentaRepository, times(1)).save(cuenta);
    }
}

