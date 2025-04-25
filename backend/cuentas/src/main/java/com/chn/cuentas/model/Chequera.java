package com.chn.cuentas.model;

import jakarta.persistence.*;

@Entity
public class Chequera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    private Integer cantidadCheques = 25; // Valor por defecto
    private String estado = "activa";
    private String motivoEstado;
    private Integer numeroInicial;
    private Integer numeroFinal;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    public Integer getCantidadCheques() { return cantidadCheques; }
    public void setCantidadCheques(Integer cantidadCheques) { this.cantidadCheques = cantidadCheques; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMotivoEstado() { return motivoEstado; }
    public void setMotivoEstado(String motivoEstado) { this.motivoEstado = motivoEstado; }
    public Integer getNumeroInicial() { return numeroInicial; }

    public void setNumeroInicial(Integer numeroInicial) { this.numeroInicial = numeroInicial; }

    public Integer getNumeroFinal() { return numeroFinal; }
    public void setNumeroFinal(Integer numeroFinal) { this.numeroFinal = numeroFinal; }


}
