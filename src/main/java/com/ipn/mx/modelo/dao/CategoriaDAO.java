package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.GraficaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {
    private static final String SQL_INSERT = 
            "insert into CategoriaProducto(nombreCategoria, descripcionCategoria) values(?, ?)";
    private static final String SQL_UPDATE = 
            "update CategoriaProducto set nombreCategoria  = ?, descripcionCategoria = ? where idCategoriaProducto = ?";
    private static final String SQL_DELETE = 
            "delete from CategoriaProducto where idCategoriaProducto = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from CategoriaProducto";
    private static final String SQL_SELECT = 
            "select * from CategoriaProducto where idCategoriaProducto = ?";
    private static final String SQL_GRAFICAR = 
            "select CategoriaProducto.nombreCategoria as Nombre, count(Categoria.idCategoriaProducto) as Cantidad "
            + "from CategoriaProducto INNER JOIN Producto ON Categoria.idCategoriaProducto = Producto.idCategoriaProducto "
            + "group by Producto.idCategoriaProducto";
    private Connection con;
    
    public Connection obtenerConexion(){
        String usuario = "root";
        String clave = "123456789";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/practica3";
        try{
            Class.forName(driverMysql);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void create(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public void update(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.setInt(3, dto.getEntidad().getIdCategoriaProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public void delete(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoriaProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public CategoriaDTO read(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = new ArrayList();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdCategoriaProducto());
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
                return (CategoriaDTO) resultados.get(0);
            else
                return null;
            /*rs.next();
                System.out.println("Clave: "+rs.getInt("idCategoria") + ", Nombre categoria: " + rs.getString("nombreCategoria")
                + ", Descripcion: " + rs.getString("descripcionCategoria"));
                */
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public List obtenerResultados(ResultSet rs) throws SQLException{
        List lista = new ArrayList();
        while(rs.next()){
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoriaProducto(rs.getInt("idCategoriaProducto"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
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
            /*rs.next();
                System.out.println("Clave: "+rs.getInt("idCategoria") + ", Nombre categoria: " + rs.getString("nombreCategoria")
                + ", Descripcion: " + rs.getString("descripcionCategoria"));
                */
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    public List graficar() throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = new ArrayList();
        try{
            ps = con.prepareStatement(SQL_GRAFICAR);
            rs = ps.executeQuery();
           while(rs.next()){
               GraficaDTO dto = new GraficaDTO();
               dto.setNombre(rs.getString("Nombre"));
               dto.setCantidad(rs.getInt("Cantidad"));
               resultados.add(dto);
           }
          
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
