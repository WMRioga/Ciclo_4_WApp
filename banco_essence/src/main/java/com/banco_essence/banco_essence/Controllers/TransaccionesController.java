package com.banco_essence.banco_essence.Controllers;

import com.banco_essence.banco_essence.Models.TransaccionesModel;
import com.banco_essence.banco_essence.Repositories.TransaccionesRepository;
import com.banco_essence.banco_essence.Services.TransaccionesService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/transacciones")
public class TransaccionesController {
    @Autowired
    private TransaccionesRepository transaccionesRepository;
    
    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping (value = "/")
    @ResponseBody
    public ResponseEntity<TransaccionesModel> agregar (@RequestBody TransaccionesModel transaccionesModel){
        System.out.println(transaccionesModel);
        TransaccionesModel obj = transaccionesService.save(transaccionesModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<TransaccionesModel> eliminar (@PathVariable Integer id){
        TransaccionesModel obj = transaccionesService.findById(id);
        if (obj != null){
            transaccionesService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping (value = "/")
    public ResponseEntity<TransaccionesModel> editar (@RequestBody TransaccionesModel transaccionesModel){
        TransaccionesModel obj = transaccionesService.findById(transaccionesModel.getIdTransaccion());
        if (obj != null){
            obj.setFechaTransaccion(transaccionesModel.getFechaTransaccion());
            obj.setValorTransaccion(transaccionesModel.getValorTransaccion());
            obj.setCuenta(transaccionesModel.getCuenta());
            transaccionesService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping ("/list")
    public List<TransaccionesModel> consultarTodo(){
        return transaccionesService.findAll();
    }
    @GetMapping ("/list/{id}")
    public TransaccionesModel consultarPorId (@PathVariable Integer id){
        return transaccionesService.findById(id);
    }
    @GetMapping ("/consulta")
    @ResponseBody
    public List<TransaccionesModel> consulta_cuenta(@RequestParam ("idc") String idcta){
        return transaccionesService.consulta_cuenta(idcta);
    }
}
