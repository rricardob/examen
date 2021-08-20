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

    public Usuario findByIdUsuario(String codUsuario) {
        return usuarioRepository.findById(codUsuario).orElse(null);
    }

    @Transactional
    public ResponseMessage saveUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        Sucursal sucursal = sucursalRepository.findById(usuarioRequestDTO.getCodSucursal()).orElse(null);

        if (sucursal != null) {

            Usuario usuario = new Usuario();
            usuario.setCod_usuario(usuarioRequestDTO.getCod_usuario());
            usuario.setNombre(usuarioRequestDTO.getNombre());
            usuario.setUser(usuarioRequestDTO.getUser());
            usuario.setPassword(usuarioRequestDTO.getPassword());
            usuario.setSucursal(sucursal);

            usuarioRepository.save(usuario);
            return new ResponseMessage(200, "Usuario grabado correctamente");
        } else {
            return new ResponseMessage(200, "La sucursal ingresada no existe");
        }
    }

    @Transactional
    public ResponseMessage updateUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.findById(usuarioRequestDTO.getCod_usuario()).isPresent()) {

            Sucursal sucursal = sucursalRepository.findById(usuarioRequestDTO.getCodSucursal()).orElse(null);

            if (sucursal != null) {

                Usuario usuario = new Usuario();
                usuario.setCod_usuario(usuarioRequestDTO.getCod_usuario());
                usuario.setNombre(usuarioRequestDTO.getNombre());
                usuario.setUser(usuarioRequestDTO.getUser());
                usuario.setPassword(usuarioRequestDTO.getPassword());
                usuario.setSucursal(sucursal);

                usuarioRepository.save(usuario);
                return new ResponseMessage(200, "Usuario actualizado correctamente");
            } else {
                return new ResponseMessage(200, "La sucursal ingresada no existe");
            }
        } else {
            return new ResponseMessage(404, "El Usuario " + usuarioRequestDTO.getNombre() + " no existe");
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
