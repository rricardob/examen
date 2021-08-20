package com.valtx.examen.controller;

import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.entity.Producto;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.service.ProductoService;
import com.valtx.examen.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/producto/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("listarProducto")
    public ResponseEntity<List<Producto>> listProducto() {
        return ok(productoService.listProducto());
    }

    @GetMapping("listarProductoById/{codProducto}")
    public ResponseEntity<Producto> findById(@PathVariable String codProducto){
        return ok(productoService.findByIdProducto(codProducto));
    }

    @PostMapping("guardarProducto")
    public ResponseEntity<ResponseMessage> guardarProducto(@RequestBody Producto producto){
        return ok(productoService.saveProducto(producto));
    }

    @PutMapping("actualizarProducto")
    public ResponseEntity<ResponseMessage> actualizarProducto(@RequestBody Producto producto){
        return ok(productoService.updateProducto(producto));
    }

    @DeleteMapping("eliminarProducto/{codProducto}")
    public ResponseEntity<ResponseMessage> eliminarProducto(@PathVariable String codProducto){
        return ok(productoService.deleteProducto(codProducto));
    }
}
