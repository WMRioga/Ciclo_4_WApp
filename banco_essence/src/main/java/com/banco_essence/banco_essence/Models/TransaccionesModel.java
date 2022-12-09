package com.banco_essence.banco_essence.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "c4g21_transacciones")
public class TransaccionesModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private int _id;
    private Date transaction_date;
    private double transaction_value;
    private String transaction_type;
    @ManyToOne
    @JoinColumn(name = "_id_cuenta")
    private CuentasModel _id_cuenta;
    
    @Override
    public String toString(){
        return "Transaccion [idTransaccion=" + _id + ", fechaTransaccion=" + transaction_date + ", valorTransaccion=" + transaction_value +  ", tipoTransaccion=" + transaction_type + ", Cuenta=" + _id_cuenta + "]";
    }
}
