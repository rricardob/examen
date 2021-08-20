package com.valtx.examen.controller;

import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/sucursal/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("listarSucursalById/{codSucursal}")
    public ResponseEntity<Sucursal> findById(@PathVariable String codSucursal){
        return ok(sucursalService.findByIdSucursal(codSucursal));
    }

    @GetMapping("listarSucursales")
    public ResponseEntity<List<Sucursal>> listSucursal() {
        return ok(sucursalService.listSucursal());
    }

    @PostMapping("guardarSucursal")
    public ResponseEntity<ResponseMessage> guardarSucursal(@RequestBody Sucursal sucursal){
        return ok(sucursalService.saveSucursal(sucursal));
    }

    @PutMapping("actualizarSucursal")
    public ResponseEntity<ResponseMessage> actualizarSucursal(@RequestBody Sucursal sucursal){
        return ok(sucursalService.updateSucursal(sucursal));
    }

    @DeleteMapping("eliminarSucursal/{codSucursal}")
    public ResponseEntity<ResponseMessage> eliminarSucursal(@PathVariable String codSucursal){
        return ok(sucursalService.deleteSucursal(codSucursal));
    }
}
