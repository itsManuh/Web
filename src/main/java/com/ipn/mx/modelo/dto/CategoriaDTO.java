package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;
import lombok.Data;

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
