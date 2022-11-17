package com.banco_essence.banco_essence.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "Cuentas")
public class CuentasModel implements Serializable{
    @Id
    @Column(name = "idCuenta")
    private String idCuenta;
    @Column(name = "fechaApertura")
    private Date fechaApertura;
    @Column(name = "saldoCuenta")
    private double saldoCuenta;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClientesModel cliente;

    @Override
    public String toString(){
        return "Cuenta [idCuenta=" + idCuenta + ", fechaApertura=" + fechaApertura + ", saldoCuenta=" + saldoCuenta + ", Cliente=" + cliente + "]";
    }
}
