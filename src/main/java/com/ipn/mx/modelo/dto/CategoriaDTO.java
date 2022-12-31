package com.ipn.mx.modelo.dto;


import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;
import lombok.Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author levi1
 */
@Data
public class CategoriaDTO implements Serializable{
    
    private Categoria entidad;
    
    public CategoriaDTO(){
        entidad = new Categoria();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdCategoriaProducto()).append("\n");
        sb.append("Nombre: ").append(entidad.getNombreCategoria()).append("\n");
        sb.append("Descripcion: ").append(entidad.getDescripcionCategoria()).append("\n");
        return sb.toString();
    }
    
    
}
