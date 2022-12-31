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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author levi1
 */
public class CategoriaDAO {
    private static final String SQL_INSERT = 
            "insert into Categoria(nombreCategoria, descripcionCategoria) values(?, ?)";
    private static final String SQL_UPDATE = 
            "update Categoria set nombreCategoria  = ?, descripcionCategoria = ? where idCategoria = ?";
    private static final String SQL_DELETE = 
            "delete from Categoria where idCategoria = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from Categoria";
    private static final String SQL_SELECT = 
            "select * from Categoria where idCategoria = ?";
    private static final String SQL_GRAFICAR = 
            "select Categoria.nombreCategoria as Nombre, count(Categoria.idCategoria) as Cantidad "
            + "from Categoria INNER JOIN Producto ON Categoria.idCategoria = Producto.idCategoria "
            + "group by Producto.idCategoria";
    private Connection con;
    
    public Connection obtenerConexion(){
        String usuario = "root";
        String clave = "root";
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
            ps.setInt(3, dto.getEntidad().getIdCategoria());
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
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
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
