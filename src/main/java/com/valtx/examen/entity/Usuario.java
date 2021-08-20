package com.valtx.examen.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "cod_usuario", nullable = false)
    private String cod_usuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "`user`", nullable = false)
    private String user;

    @Column(name = "`password`", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "cod_sucursal", nullable = false)
    private Sucursal sucursal;


    public Usuario() {
    }

    public Usuario(String cod_usuario, String nombre, String user, String password, Sucursal sucursal) {
        this.cod_usuario = cod_usuario;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.sucursal = sucursal;
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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
