/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author levi1
 */
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
