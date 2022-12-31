/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author levi1
 */
@Data
@NoArgsConstructor
public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;    
    private String descripcionProducto;
    private int precio;             
    private int existencia; 
    private int idCategoria;
    
    
}
