package co.com.banca_essence.banca_essence.Services;

import co.com.banca_essence.banca_essence.Models.ClienteModel;
import co.com.banca_essence.banca_essence.Repositories.ClienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }
    @Transactional (readOnly = false)
    public void delete(String id){
        clienteRepository.deleteById(id);
    }
    @Transactional (readOnly = true)
    public ClienteModel findById(String id){
        return clienteRepository.findById(id).orElse(null);
    }
    @Transactional (readOnly = true)
    public List<ClienteModel> findAll(){
        return (List<ClienteModel>) clienteRepository.findAll();
    }
    @Transactional (readOnly = true)
    public ClienteModel login(String usuario, String clave){
        return clienteRepository.login(usuario, clave);
    }
}
