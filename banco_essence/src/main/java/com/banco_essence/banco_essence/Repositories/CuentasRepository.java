package com.banco_essence.banco_essence.Repositories;

import com.banco_essence.banco_essence.Models.CuentasModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CuentasRepository extends CrudRepository <CuentasModel, String>{
    // Operacion para seleccionar cuentas de un Cliente en particular (SELECT)
    @Transactional (readOnly = true) // No afecta la integridad de la base de datos.
    @Query (value = "SELECT * FROM cuentas WHERE idCliente= :idc", nativeQuery = true)
    public List<CuentasModel> consulta_cuenta(@Param ("idc") String idc);
}
