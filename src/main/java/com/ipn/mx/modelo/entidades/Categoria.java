package com.ipn.mx.modelo.entidades;


import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author levi1
 */
@Data
@NoArgsConstructor
public class Categoria implements Serializable{
    
    private int idCategoriaProducto;
    private String nombreCategoria;
    private String descripcionCategoria;

  
    
}
