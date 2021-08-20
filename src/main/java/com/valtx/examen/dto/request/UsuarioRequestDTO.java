package com.valtx.examen.dto.request;

import com.valtx.examen.entity.Sucursal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class UsuarioRequestDTO {

    private String cod_usuario;
    private String nombre;
    private String user;
    private String password;
    private String codSucursal;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String cod_usuario, String nombre, String user, String password, String codSucursal) {
        this.cod_usuario = cod_usuario;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.codSucursal = codSucursal;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }
}
