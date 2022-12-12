package com.banco_essence.banco_essence.Models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="c4g21_clientes")
public class ClientesModel implements Serializable{
    @Id
    @NotEmpty(message = "El campo [_id] no puede estar vacío.")
    @Column(name="_id")
    private String _id;
    @NotEmpty(message = "El campo [client_usser] no puede estar vacío.")
    @Size(min = 5, max = 80, message = "El campo [client_usser] debe tener mínimo 5 caracteres y máximo 80.")
    @Column(name="client_usser")
    private String client_usser;
    @NotEmpty(message = "El campo [client_passwd] no puede estar vacío.")
    @Size(min = 6, message = "El campo [client_passwd] mínimo debe tener 6 caracteres.")
    // @Digits(message = "El campo [client_passwd] debe ser solo numerico", fraction = 6, integer = 6)
    @Column(name="client_passwd")
    private String client_passwd;
    @NotEmpty(message = "El campo [client_email] no puede estar vacío.")
    @Column(name="client_email")
    private String client_email;

    @Override
    public String toString(){
        return "Cliente [idCliente:" + _id + ", usserCliente:" + client_usser + ", passwdCliente:"+ client_passwd + ", emailCliente:"+ client_email + "]";
    }
}
