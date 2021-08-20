package com.valtx.examen.controller;

import com.valtx.examen.dto.request.UsuarioRequestDTO;
import com.valtx.examen.dto.response.ResponseMessage;
import com.valtx.examen.entity.Sucursal;
import com.valtx.examen.entity.Usuario;
import com.valtx.examen.service.SucursalService;
import com.valtx.examen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/usuario/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("listarUsuarios")
    public ResponseEntity<List<Usuario>> listUsuario() {
        return ok(usuarioService.listUsuario());
    }

    @GetMapping("listarUsuarioById/{codUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable String codUsuario) {
        return ok(usuarioService.findByIdUsuario(codUsuario));
    }

    @PostMapping("guardarUsuario")
    public ResponseEntity<ResponseMessage> guardarUsuario(@RequestBody UsuarioRequestDTO usuario){
        return ok(usuarioService.saveUsuario(usuario));
    }

    @PutMapping("actualizarUsuario")
    public ResponseEntity<ResponseMessage> actualizarUsuario(@RequestBody UsuarioRequestDTO usuario){
        return ok(usuarioService.updateUsuario(usuario));
    }

    @DeleteMapping("eliminarUsuario/{codUsuario}")
    public ResponseEntity<ResponseMessage> eliminarUsuario(@PathVariable String codUsuario){
        return ok(usuarioService.deleteUsuario(codUsuario));
    }

}
