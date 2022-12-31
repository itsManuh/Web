package com.ipn.mx.modelo.entidades;


import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        try {
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoriaProducto(2);
            dto.getEntidad().setNombreCategoria("ESCOM");
            dto.getEntidad().setDescripcionCategoria("Libros de ESCOM");
            
            CategoriaDAO dao = new CategoriaDAO();
            dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //dao.selectAll(dto);
            //dao.create(dto);
            //System.out.println(dao.read(dto));
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
