package com.valtx.examen.service;

import com.valtx.examen.dto.request.UsuarioRequestDTO;
import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.entity.Producto;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.entity.Usuario;
import com.valtx.examen.repo.SucursalRepository;
import com.valtx.examen.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    SucursalRepository sucursalRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, SucursalRepository sucursalRepository) {
        this.usuarioRepository = usuarioRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<Usuario> listUsuario() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public ResponseMessage saveUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        Sucursal sucursal = sucursalRepository.findById(usuarioRequestDTO.getSucursal().getCod_sucursal()).orElse(null);

        /*if (!sucursal.findByCorreo(contactoDTO.getCorreo()).isPresent()) {

            Contacto contacto = new Contacto();

            contacto.setNombre(contactoDTO.getNombre());
            contacto.setCorreo(contactoDTO.getCorreo());
            contacto.setTelefono(contactoDTO.getTelefono());
            contacto.setCelular(contactoDTO.getCelular());
            contacto.setCargo(contactoDTO.getCargo());
            contacto.setUnidad(contactoDTO.getUnidad());
            contacto.setEliminado(false);
            contacto.setCliente(cliente);

            contacto.setUcreate(UserContextHolder.getUser().getNombres() + UserContextHolder.getUser().getApellidos());

            contactoRepository.save(contacto);*/


        //usuarioRepository.save(usuario);
        return new ResponseMessage(200, "Usuario grabado correctamente");
    }

    @Transactional
    public ResponseMessage updateUsuario(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getCod_usuario()).isPresent()) {

            usuarioRepository.save(usuario);
            return new ResponseMessage(200, "Usuario actualizado correctamente");

        } else {
            return new ResponseMessage(404, "El Usuario "+usuario.getNombre()+" no existe");
        }
    }

    @Transactional
    public ResponseMessage deleteUsuario(String codUsuario) {

        if (usuarioRepository.findById(codUsuario).isPresent()) {

            usuarioRepository.deleteById(codUsuario);

            return new ResponseMessage(200, "Usuario eliminado correctamente");
        } else {
            return new ResponseMessage(404, "Usuario no encontrado");
        }
    }
}
