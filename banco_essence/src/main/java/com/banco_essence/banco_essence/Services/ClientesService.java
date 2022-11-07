package com.banco_essence.banco_essence.Services;

import com.banco_essence.banco_essence.Models.ClientesModel;
import com.banco_essence.banco_essence.Repositories.ClientesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesModel save (ClientesModel clientesModel){
        return clientesRepository.save(clientesModel);
    }

    @Transactional (readOnly = false)
    public void delete (String id){
        clientesRepository.deleteById(id);
    }

    @Transactional (readOnly = true)
    public ClientesModel findById (String id){
        return clientesRepository.findById(id).orElse(null);
    }

    @Transactional (readOnly = true)
    public List <ClientesModel> findAll(){
        return (List <ClientesModel>) clientesRepository.findAll();
    }

    @Transactional (readOnly = true)
    public ClientesModel login (String usuario, String clave){
        return clientesRepository.login(usuario, clave);
    }
}
