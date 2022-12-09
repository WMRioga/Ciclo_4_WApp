package com.banco_essence.banco_essence.Repositories;

import com.banco_essence.banco_essence.Models.TransaccionesModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransaccionesRepository extends CrudRepository <TransaccionesModel, Integer> {
    // Operación para seleccionar transacciones de una cuenta particular (SELECT)
    @Transactional (readOnly = true)
    @Query (value = "SELECT * FROM c4g21_transacciones WHERE _id_cuenta= :idcta", nativeQuery = true)
    public List <TransaccionesModel> consulta_cuenta(@Param ("idcta") String idcta);
}
