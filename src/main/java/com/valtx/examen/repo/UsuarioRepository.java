package com.valtx.examen.repo;

import com.valtx.examen.entity.Producto;
import com.valtx.examen.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}