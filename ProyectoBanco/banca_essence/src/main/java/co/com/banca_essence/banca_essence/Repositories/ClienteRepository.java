package co.com.banca_essence.banca_essence.Repositories;

import co.com.banca_essence.banca_essence.Models.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends CrudRepository<ClienteModel, String>{
        // Operación de Autentiiicación (SELECT)
        @Transactional(readOnly = true) // No afecta integridad base de datos
        @Query(value = "SELECT * FROM cliente WHERE usserCliente= :usuario AND passwdCliente= :clave", nativeQuery = true)
        public ClienteModel login(@Param("usuario") String usuario, @Param("clave") String clave);
}