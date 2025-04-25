package com.chn.cuentas.model;

import jakarta.persistence.*;

@Entity
public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chequera_id", nullable = false)
    private Chequera chequera;

    private String numeroCheque;
    private String estado; // emitido, usado, anulado
    private String motivoEstado;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Chequera getChequera() { return chequera; }
    public void setChequera(Chequera chequera) { this.chequera = chequera; }

    public String getNumeroCheque() { return numeroCheque; }
    public void setNumeroCheque(String numeroCheque) { this.numeroCheque = numeroCheque; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMotivoEstado() { return motivoEstado; }
    public void setMotivoEstado(String motivoEstado) { this.motivoEstado = motivoEstado; }

    public void setNumero(int i) {

    }

    public void setNumeroCheque(int i) {

    }
}
