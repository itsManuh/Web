package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;    
    private String descripcionProducto;
    private int precio;             
    private int existencia; 
    private int idCategoriaProducto;
    
    
}
