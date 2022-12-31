package com.ipn.mx.modelo.entidades;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovimientosInventario {
    private int idMovimientosInventario;
    private String tipoMovimiento;
    private Date fechaMovimiento;
    private int cantidad;
    private int idProducto;
}
