package com.banco_essence.banco_essence.Models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table (name="Clientes")
public class ClientesModel implements Serializable{
    @Id
    @Column(name="idCliente")
    private String idCliente;
    @Column(name="usserCliente")
    private String usserCliente;
    @Column(name="passwdCliente")
    private String passwdCliente;

    @Override
    public String toString(){
        return "Cliente [idCliente:" + idCliente + ", usserCliente:" + usserCliente + ", passwdCliente:"+ passwdCliente + "]";
    }
}
