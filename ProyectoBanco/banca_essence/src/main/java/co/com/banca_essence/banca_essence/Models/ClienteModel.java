package co.com.banca_essence.banca_essence.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter


@Entity
@Table(name = "clientes")
public class ClienteModel implements Serializable {

    @Id
    @NotEmpty(message = "El campo identificador del cliente no debe ser Vacío")
    //Los atributos de la base de datos.
    // @Column(name = "id_cliente", unique = true, nullable = false) // Cambio de nombre
    private String idCliente; // Nombre en base de datos
    @NotEmpty(message = "El campo Usuario no debe ser Vacío")
    @Size(min = 5, max = 80,message = "El campo nombre Cliente debe tener mínimo 5 caracteres y máximo 80")
    private String usserCliente;
    @NotEmpty(message = "El campo Contraseña no debe ser Vacío")
    @Size(min = 5, max = 80,message = "El campo nombre Cliente debe tener mínimo 5 caracteres y máximo 50")
    private String passwdCliente;
    @Override
    public String toString() {
        return "Cliente [id_cliente=" + idCliente + ", nombre_cliente=" + usserCliente + ", clave_cliente="
                + passwdCliente + "]";
    }
}