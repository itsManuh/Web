/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author levi1
 */
@Data
public class ProductoDTO implements Serializable{
    private Producto entidad;
    
    public ProductoDTO(){
        entidad = new Producto();
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdProducto()).append("\n");
        sb.append("Nombre: ").append(entidad.getNombreProducto()).append("\n");
        sb.append("Descripcion: ").append(entidad.getDescripcionProducto()).append("\n");
        sb.append("Precio: ").append(entidad.getPrecio()).append("\n");
        sb.append("Existencia: ").append(entidad.getExistencia()).append("\n");
        sb.append("Categoria: ").append(entidad.getIdCategoriaProducto()).append("\n");
        return sb.toString();
    } 
    
}
