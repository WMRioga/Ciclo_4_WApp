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
@Table (name = "c4g21_cuentas")
public class CuentasModel implements Serializable{
    @Id
    @Column(name = "_id")
    private String _id;
    @Column(name = "cuenta_fecha_apertura")
    private Date cuenta_fecha_apertura;
    @Column(name = "cuenta_saldo")
    private double cuenta_saldo;
    @ManyToOne
    @JoinColumn(name = "_id_cliente")
    private ClientesModel _id_cliente;

    @Override
    public String toString(){
        return "Cuenta [idCuenta=" + _id + ", fechaApertura=" + cuenta_fecha_apertura + ", saldoCuenta=" + cuenta_saldo + ", Cliente=" + _id_cliente + "]";
    }
}
