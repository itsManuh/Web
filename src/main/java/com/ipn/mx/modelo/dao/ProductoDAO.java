package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    private static final String SQL_INSERT = 
            "insert into producto(nombreProducto,descripcionProducto,precio,existencia,idCategoriaProducto) values(?,?,?,?,?)";
    private static final String SQL_UPDATE = 
            "update producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, idCategoriaProducto = ? where idProducto = ?";
    private static final String SQL_DELETE = 
            "delete from producto where idProducto = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from producto";
    private static final String SQL_SELECT = 
            "select * from producto where idProducto = ?";
    private Connection con;
    
    private Connection obtenerConexion(){
        String usuario = "root";
        String clave = "123456789";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/practica3";
        
        try {
            Class.forName(driverMysql);
            con = DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void create(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setInt(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getIdCategoriaProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void update(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setInt(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getIdCategoriaProducto());
            ps.setInt(6, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public void delete(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public ProductoDTO read(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = new ArrayList();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
                return (ProductoDTO) resultados.get(0);
            else
                return null;
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public List obtenerResultados(ResultSet rs) throws SQLException{
        List lista = new ArrayList();
        while(rs.next()){
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(rs.getInt("idProducto"));
            dto.getEntidad().setNombreProducto(rs.getString("nombreProducto"));
            dto.getEntidad().setDescripcionProducto(rs.getString("descripcionProducto"));
            dto.getEntidad().setPrecio(rs.getInt("precio"));
            dto.getEntidad().setExistencia(rs.getInt("existencia"));
            dto.getEntidad().setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
            lista.add(dto);
        }
        return lista;
    }
    
    public List readAll() throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = new ArrayList();
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if(!resultados.isEmpty())
                return resultados;
            else
                return null;
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
}
