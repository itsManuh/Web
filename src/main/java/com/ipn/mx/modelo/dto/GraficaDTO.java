package com.ipn.mx.modelo.dto;

import java.io.Serializable;

public class GraficaDTO implements Serializable{
    private int cantidad;
    private String nombre;

    public GraficaDTO() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "GraficaDTO{" + "cantidad=" + cantidad + ", nombre=" + nombre + '}';
    }
}
