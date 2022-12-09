package com.banco_essence.banco_essence.Models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="c4g21_clientes")
public class ClientesModel implements Serializable{
    @Id
    @Column(name="_id")
    private String _id;
    @Column(name="client_name")
    private String client_name;
    @Column(name="client_passwd")
    private String client_passwd;
    @Column(name="client_email")
    private String client_email;

    @Override
    public String toString(){
        return "Cliente [idCliente:" + _id + ", usserCliente:" + client_name + ", passwdCliente:"+ client_passwd + ", emailCliente:"+ client_email + "]";
    }
}
