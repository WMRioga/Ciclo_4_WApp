package co.com.banca_essence.banca_essence.Controllers;

import co.com.banca_essence.banca_essence.Security.Hash;
import co.com.banca_essence.banca_essence.Models.ClienteModel;
import co.com.banca_essence.banca_essence.Repositories.ClienteRepository;
import co.com.banca_essence.banca_essence.Services.ClienteService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<ClienteModel> agregar(@Valid @RequestBody ClienteModel clienteModel){
        clienteModel.setPasswdCliente(Hash.sha1(clienteModel.getPasswdCliente()));
        ClienteModel obj = clienteService.save(clienteModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteModel> eliminar(@PathVariable String id, @RequestHeader("clave") String clave, @RequestHeader("usuario") String usuario){
        ClienteModel objcli = new ClienteModel();
        objcli = clienteRepository.login(usuario, Hash.sha1(clave));
        if (objcli != null){
            ClienteModel obj = clienteService.findById(id);
            if (obj != null){
            clienteService.delete(id);
            } else {
                return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/")
    @ResponseBody
    public ResponseEntity<ClienteModel> editar(@Valid @RequestBody ClienteModel clienteModel){
        clienteModel.setPasswdCliente(Hash.sha1(clienteModel.getPasswdCliente()));
        ClienteModel obj = clienteService.findById(clienteModel.getIdCliente());
        if (obj != null){
            obj.setUsserCliente(clienteModel.getUsserCliente());
            obj.setPasswdCliente(clienteModel.getPasswdCliente());
            clienteService.save(clienteModel);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<ClienteModel>> consultarTodo(@RequestHeader("clave") String clave, @RequestHeader("usuario") String usuario){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel = clienteRepository.login(usuario, Hash.sha1(clave));
        if (clienteModel != null){
            return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/list/{id}")
    @ResponseBody
    public ResponseEntity<ClienteModel> consultaPorId(@PathVariable String id, @RequestHeader("clave") String clave, @RequestHeader("usuario") String usuario){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel = clienteRepository.login(usuario, Hash.sha1(clave));
        if (clienteModel != null){
            return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public ClienteModel ingresar(@RequestParam("usuario") String usuario, @RequestParam("clave") String clave){
        clave = Hash.sha1(clave);
        return clienteService.login(usuario, clave);
    }
}