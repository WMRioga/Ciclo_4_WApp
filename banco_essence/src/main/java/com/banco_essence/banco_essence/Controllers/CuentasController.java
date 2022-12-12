package com.banco_essence.banco_essence.Controllers;

import com.banco_essence.banco_essence.Models.CuentasModel;
import com.banco_essence.banco_essence.Repositories.CuentasRepository;
import com.banco_essence.banco_essence.Services.CuentasService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/cuentas")
public class CuentasController {
    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private CuentasService cuentasService;

    @PostMapping (value = "/")
    public ResponseEntity <CuentasModel> agregar (@Valid @RequestBody CuentasModel cuentasModel){
        CuentasModel obj = cuentasService.save(cuentasModel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity <CuentasModel> eliminar (@PathVariable String id){
        CuentasModel obj = cuentasService.findById(id);
        if (obj != null){
            cuentasService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PutMapping (value = "/")
    public ResponseEntity <CuentasModel> editar (@Valid @RequestBody CuentasModel cuentasModel){
        CuentasModel obj = cuentasService.findById(cuentasModel.get_id());
        if (obj != null){
            obj.setCuenta_fecha_apertura(cuentasModel.getCuenta_fecha_apertura());
            obj.setCuenta_saldo(cuentasModel.getCuenta_saldo());
            obj.set_id_cliente(cuentasModel.get_id_cliente());
            cuentasService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping ("/list")
    public List<CuentasModel> consultarTodo(){
        return cuentasService.findAll();
    }
    @GetMapping ("/list/{id}")
    public CuentasModel consultarPorId (@PathVariable String id){
        return cuentasService.findById(id);
    }
    @GetMapping ("/consulta")
    @ResponseBody
    public List<CuentasModel> consulta_cliente(@RequestParam ("idc") String idc){
        return cuentasService.consulta_cliente(idc);
    }
}
