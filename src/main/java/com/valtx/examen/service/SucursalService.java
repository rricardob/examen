package com.valtx.examen.service;

import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.dto.response.SucursalDTO;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.repo.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SucursalService {

    SucursalRepository sucursalRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> listSucursal() {
        return sucursalRepository.findAll();
    }

    public Sucursal findByIdSucursal(String idSucursal){
        return sucursalRepository.findById(idSucursal).orElse(null);
    }

    @Transactional
    public ResponseMessage saveSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
        return new ResponseMessage(200, "Sucursal grabada correctamente");
    }

    @Transactional
    public ResponseMessage updateSucursal(Sucursal sucursal) {
        if (sucursalRepository.findById(sucursal.getCod_sucursal()).isPresent()) {

            sucursalRepository.save(sucursal);
            return new ResponseMessage(200, "Sucursal actualizada correctamente");

        } else {
            return new ResponseMessage(404, "La Sucursal "+sucursal.getNombre()+" no existe");
        }
    }

    @Transactional
    public ResponseMessage deleteSucursal(String codSucursal) {

        if (sucursalRepository.findById(codSucursal).isPresent()) {

            sucursalRepository.deleteById(codSucursal);

            return new ResponseMessage(200, "Sucursal eliminada correctamente");
        } else {
            return new ResponseMessage(404, "Sucursal no encontrada");
        }
    }

}
