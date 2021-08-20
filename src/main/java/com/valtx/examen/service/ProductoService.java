package com.valtx.examen.service;

import com.sun.tools.doclint.Entity;
import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.entity.Producto;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.repo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductoService {

    ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listProducto() {
        return productoRepository.findAll();
    }

    @Transactional
    public ResponseMessage saveProducto(Producto producto) {
        productoRepository.save(producto);
        return new ResponseMessage(200, "Producto grabado correctamente");
    }

    @Transactional
    public ResponseMessage updateProducto(Producto producto) {
        if (productoRepository.findById(producto.getCod_producto()).isPresent()) {

            productoRepository.save(producto);
            return new ResponseMessage(200, "Producto actualizado correctamente");

        } else {
            return new ResponseMessage(404, "El Producto "+producto.getNombre()+" no existe");
        }
    }

    @Transactional
    public ResponseMessage deleteProducto(String codProducto) {

        if (productoRepository.findById(codProducto).isPresent()) {

            productoRepository.deleteById(codProducto);

            return new ResponseMessage(200, "Producto eliminado correctamente");
        } else {
            return new ResponseMessage(404, "Producto no encontrado");
        }
    }
}
