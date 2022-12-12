package com.banco_essence.banco_essence.Controllers;

import com.banco_essence.banco_essence.Models.ClientesModel;
import com.banco_essence.banco_essence.Repositories.ClientesRepository;
import com.banco_essence.banco_essence.Services.ClientesService;
import com.banco_essence.banco_essence.Security.HashSecurity;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/clientes")
public class ClientesController {
    @Autowired
    private ClientesRepository clientesRepository;
    
    @Autowired
    private ClientesService clientesService;

    @PostMapping (value = "/")
    @ResponseBody
    public ResponseEntity <ClientesModel> agregar (@Valid @RequestBody ClientesModel clientesModel){
        clientesModel.setClient_passwd(HashSecurity.sha1(clientesModel.getClient_passwd()));
        ClientesModel obj = clientesService.save(clientesModel);
        return new ResponseEntity <> (obj, HttpStatus.OK);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity <ClientesModel> eliminar (@PathVariable String id){
        ClientesModel obj = clientesService.findById(id);
        if (obj != null) {
            clientesService.delete(id);
        } else {
            return new ResponseEntity <> (obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity <> (obj, HttpStatus.OK);
    }

    @PutMapping (value = "/")
    @ResponseBody
    public ResponseEntity <ClientesModel> editar (@Valid @RequestBody ClientesModel clientesModel){
        clientesModel.setClient_passwd(HashSecurity.sha1(clientesModel.getClient_passwd()));
        ClientesModel obj = clientesService.findById(clientesModel.get_id());
        if (obj != null){
            obj.setClient_usser(clientesModel.getClient_usser());
            obj.setClient_passwd(clientesModel.getClient_passwd());
            obj.setClient_email(clientesModel.getClient_email());
            clientesService.save(clientesModel);
        } else {
            return new ResponseEntity <> (obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity <> (obj, HttpStatus.OK);
    }

    @GetMapping ("/list")
    @ResponseBody
    // public List<ClientesModel> consultarTodo(){return clientesService.findAll();}   //-- Listar sin contraseñas
    public ResponseEntity<List<ClientesModel>> consultarTodo(@RequestHeader("clave") String clave, @RequestHeader("usuario") String usuario){
        ClientesModel clientesModel = new ClientesModel();
        clientesModel = clientesRepository.login(usuario, HashSecurity.sha1(clave));
        if (clientesModel != null){
            return new ResponseEntity<>(clientesService.findAll(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @GetMapping ("/list/{id}")
    @ResponseBody
    public ClientesModel consultarPorId (@PathVariable String id){
        return clientesService.findById(id);
    }

    @GetMapping ("/login")
    @ResponseBody
    public ClientesModel ingresar (@RequestParam ("usuario") String usuario, @RequestParam ("clave") String clave){
        return clientesService.login(usuario, clave);
    }
}
