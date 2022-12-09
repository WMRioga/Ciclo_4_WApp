package com.banco_essence.banco_essence.Services;

import com.banco_essence.banco_essence.Models.CuentasModel;
import com.banco_essence.banco_essence.Repositories.CuentasRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentasService {
    @Autowired
    private CuentasRepository cuentasRepository;

    @Transactional (readOnly = false)
    public CuentasModel save(CuentasModel cuentasModel){
        return cuentasRepository.save(cuentasModel);
    }
    @Transactional (readOnly = false)
    public void delete(String id){
        cuentasRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public CuentasModel findById(String id){
        return cuentasRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List <CuentasModel> findAll(){
        return (List <CuentasModel>) cuentasRepository.findAll();
    }
    @Transactional (readOnly = true)
    public List <CuentasModel> consulta_cliente(String idc){
        return (List <CuentasModel>) cuentasRepository.consulta_cliente(idc);
    }
}
