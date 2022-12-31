/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author levi1
 */
@Data
@NoArgsConstructor
public class MovimientosInventario {
    private int idMovimientosInventario;
    private String tipoMovimiento;
    private Date fechaMovimiento;
    private int cantidad;
    private int idProducto;
  
}
