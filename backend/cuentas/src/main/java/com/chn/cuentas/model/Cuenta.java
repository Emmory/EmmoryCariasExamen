package com.chn.cuentas.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String tipo;

    @Column(name = "monto_apertura", nullable = false)
    private BigDecimal montoApertura;

    private String estado = "activa";;

    @Column(name = "motivo_estado")
    private String motivoEstado;



    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public BigDecimal getMontoApertura() { return montoApertura; }
    public void setMontoApertura(BigDecimal montoApertura) { this.montoApertura = montoApertura; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMotivoEstado() { return motivoEstado; }
    public void setMotivoEstado(String motivoEstado) { this.motivoEstado = motivoEstado; }
}
