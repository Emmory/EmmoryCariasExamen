package com.chn.cuentas;

import com.chn.cuentas.model.Cliente;
import com.chn.cuentas.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    public void crearCliente_DeberiaGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setCorreo("juan@example.com");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteRepository.save(cliente);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }
}

