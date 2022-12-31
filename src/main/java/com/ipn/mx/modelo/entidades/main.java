package com.ipn.mx.modelo.entidades;


import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.MovimientosInventarioDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.MovimientosInventarioDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        try {
            //CategoriaDTO dto = new CategoriaDTO();
            //dto.getEntidad().setIdCategoriaProducto(2);
            //dto.getEntidad().setNombreCategoria("ESCOM");
            //dto.getEntidad().setDescripcionCategoria("Libros de ESCOM");
            MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
            //dto.getEntidad().setIdMovimientosInventario(1);
            MovimientosInventarioDAO dao = new MovimientosInventarioDAO();
            //System.out.println(dao.readAll(dto));
            //System.out.println(dao.read(dto));
            //CategoriaDAO dao = new CategoriaDAO();
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            System.out.println(dao.readAll());
            //dao.create(dto);
            //System.out.println(dao.read(dto));
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
