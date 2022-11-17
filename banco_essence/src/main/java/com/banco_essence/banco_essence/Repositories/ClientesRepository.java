package com.banco_essence.banco_essence.Repositories;

import com.banco_essence.banco_essence.Models.ClientesModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientesRepository extends CrudRepository <ClientesModel, String>{
    // Operacion de autenticación (SELECT)
    @Transactional (readOnly = true) // No afecta la integridad de la base de datos
    @Query (value = "SELECT * FROM clientes WHERE usserCliente= :usuario AND passwdCliente= :clave", nativeQuery = true)
    public ClientesModel login (@Param ("usuario") String usuario, @Param ("clave") String clave);
}