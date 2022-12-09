package com.banco_essence.banco_essence.Controllers;

import com.banco_essence.banco_essence.Models.ClientesModel;
import com.banco_essence.banco_essence.Repositories.ClientesRepository;
import com.banco_essence.banco_essence.Services.ClientesService;

import java.util.List;

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
    public ResponseEntity <ClientesModel> agregar (@RequestBody ClientesModel clientesModel){
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
    public ResponseEntity <ClientesModel> editar (@RequestBody ClientesModel clientesModel){
        ClientesModel obj = clientesService.findById(clientesModel.get_id());
        if (obj != null){
            obj.setClient_name(clientesModel.getClient_name());
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
    public List <ClientesModel> consultarTodo(){
        return clientesService.findAll();
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
