package com.banco_essence.banco_essence.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "El campo [transaction_date] no puede estar vacío.")
    private Date transaction_date;
    @NotEmpty(message = "El campo [transaction_value] no puede estar vacío.")
    private double transaction_value;
    @NotEmpty(message = "El campo [transaction_type] no puede estar vacío.")
    private String transaction_type;
    @NotEmpty(message = "El campo [_id_cuenta] no puede estar vacío.")
    @ManyToOne
    @JoinColumn(name = "_id_cuenta")
    private CuentasModel _id_cuenta;
    
    @Override
    public String toString(){
        return "Transaccion [idTransaccion=" + _id + ", fechaTransaccion=" + transaction_date + ", valorTransaccion=" + transaction_value +  ", tipoTransaccion=" + transaction_type + ", Cuenta=" + _id_cuenta + "]";
    }
}
