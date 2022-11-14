package com.banco_essence.banco_essence.Services;

import com.banco_essence.banco_essence.Models.TransaccionesModel;
import com.banco_essence.banco_essence.Repositories.TransaccionesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransaccionesService {
    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Transactional (readOnly = false)
    public TransaccionesModel save(TransaccionesModel transaccionesModel){
        return transaccionesRepository.save(transaccionesModel);
    }    
    @Transactional (readOnly = false)
    public void delete(Integer id){
        transaccionesRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public TransaccionesModel findById(Integer id){
        return transaccionesRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List <TransaccionesModel> findAll(){
        return (List <TransaccionesModel>) transaccionesRepository.findAll();
    }
    @Transactional (readOnly = true)
    public List <TransaccionesModel> consulta_cuenta(String idcta){
        return (List <TransaccionesModel>) transaccionesRepository.consulta_cuenta(idcta);
    }
}
