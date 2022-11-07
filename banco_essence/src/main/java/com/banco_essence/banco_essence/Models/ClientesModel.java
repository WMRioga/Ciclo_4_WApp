package com.banco_essence.banco_essence.Models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table (name="clientes")
public class ClientesModel implements Serializable{
    @Id
    @Column(name="id_cliente")
    private String id_cliente;
    @Column(name="usser_cliente")
    private String usser_cliente;
    @Column(name="passwd_cliente")
    private String passwd_cliente;

    @Override
    public String toString(){
        return "Cliente [id_cliente:" + id_cliente + ", usser_cliente:" + usser_cliente + ", passwd_cliente:"+ passwd_cliente + "]";
    }
}
