/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.MovimientosInventarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author levi1
 */
public class MovimientosInventarioDAO {
    private static final String SQL_INSERT = 
            "insert into MovimientosInventario(tipoMovimiento,fechaMovimiento,cantidad,idProducto) values(?,?,?,?)";
    private static final String SQL_UPDATE = 
            "update MovimientosInventario set tipoMovimiento  = ?, fechaMovimiento = ?, cantidad = ?, idProducto = ? where idMovimientosInventario = ?";
    private static final String SQL_DELETE = 
            "delete from MovimientosInventario where idMovimientosInventario = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from MovimientosInventario";
    private static final String SQL_SELECT = 
            "select * from MovimientosInventario where idMovimientosInventario = ?";
    private Connection con;
    
    private Connection obtenerConexion(){
        String usuario = "root";
        String clave = "escom";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ejercicio1_3cm17";
        
        try{
            Class.forName(driverMysql);
            con = DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void create(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getTipoMovimiento());
            ps.setDate(2, dto.getEntidad().getFechaMovimiento());
            ps.setInt(3, dto.getEntidad().getCantidad());
            ps.setInt(4, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void update(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getTipoMovimiento());
            ps.setDate(2, dto.getEntidad().getFechaMovimiento());
            ps.setInt(3, dto.getEntidad().getCantidad());
            ps.setInt(4, dto.getEntidad().getIdProducto());
            ps.setInt(5, dto.getEntidad().getIdMovimientosInventario());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void delete(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdMovimientosInventario());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public MovimientosInventarioDTO read(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List resultados = new ArrayList();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdMovimientosInventario());
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
                return (MovimientosInventarioDTO) resultados.get(0);
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
            MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
            dto.getEntidad().setIdMovimientosInventario(rs.getInt("idMovimientosInventario"));
            dto.getEntidad().setTipoMovimiento(rs.getString("tipoMovimiento"));
            dto.getEntidad().setFechaMovimiento(rs.getDate("fechaMovimiento"));
            dto.getEntidad().setCantidad(rs.getInt("cantidad"));
            dto.getEntidad().setIdProducto(rs.getInt("idProducto"));
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
