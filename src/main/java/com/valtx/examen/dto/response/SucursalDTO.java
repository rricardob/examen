package com.valtx.examen.dto.response;

public class SucursalDTO {

    private String cod_sucursal;
    private String nombre;

    public SucursalDTO() {
    }

    public SucursalDTO(String cod_sucursal, String nombre) {
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
