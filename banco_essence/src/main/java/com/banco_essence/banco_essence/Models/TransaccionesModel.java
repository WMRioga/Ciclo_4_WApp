package com.banco_essence.banco_essence.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "Transacciones")
public class TransaccionesModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaccion")
    private int idTransaccion;
    private Date fechaTransaccion;
    private double valorTransaccion;
    private String tipoTransaccion;
    @ManyToOne
    @JoinColumn(name = "idCuenta")
    private CuentasModel cuenta;
    
    @Override
    public String toString(){
        return "Transaccion [idTransaccion=" + idTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", valorTransaccion=" + valorTransaccion +  ", tipoTransaccion=" + tipoTransaccion + ", Cuenta=" + cuenta + "]";
    }
}
