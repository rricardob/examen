package com.valtx.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @Column(name = "cod_sucursal", nullable = false)
    private String cod_sucursal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Sucursal() {
    }

    public Sucursal(String cod_sucursal, String nombre) {
        this.cod_sucursal = cod_sucursal;
        this.nombre = nombre;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
