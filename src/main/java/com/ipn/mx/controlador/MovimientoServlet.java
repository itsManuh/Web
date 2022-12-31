package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.MovimientosInventarioDAO;
import com.ipn.mx.modelo.dto.MovimientosInventarioDTO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

@WebServlet(name = "MovimientoServlet", urlPatterns = {"/MovimientoServlet"})
public class MovimientoServlet extends HttpServlet {

    protected void processRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listaDeMovimientos":
                listadoDeMovimientos(request, response);
                break;
            case "nuevo":
                nuevoMovimiento(request, response);
                break;
            case "actualizar":
                actualizarMovimiento(request, response);
                break;
            case "eliminar":
                eliminarMovimiento(request, response);
                break;
            case "ver":
                verMovimiento(request, response);
                break;
            /*case "guardar":
                guardarMovimiento(request, response);
                break;*/
            case "verReporte":
                mostrarReportePDF(request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listadoDeMovimientos(HttpServletRequest request, HttpServletResponse response) {
        MovimientosInventarioDAO dao = new  MovimientosInventarioDAO();
        List lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("movimientos/listadoMovimientos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void nuevoMovimiento(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("movimientos/movimientosForm.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarMovimiento(HttpServletRequest request, HttpServletResponse response) {
        MovimientosInventarioDAO dao = new MovimientosInventarioDAO();
        MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
        dto.getEntidad().setIdMovimientosInventario(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("movimientos/movimientosForm.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarMovimiento(HttpServletRequest request, HttpServletResponse response) {
        MovimientosInventarioDAO dao = new MovimientosInventarioDAO();
        MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
        dto.getEntidad().setIdMovimientosInventario(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            dao.delete(dto);
            request.setAttribute("mensajeDelete", "El registro se elimino satisfactoriamente");
            listadoDeMovimientos(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verMovimiento(HttpServletRequest request, HttpServletResponse response) {
        MovimientosInventarioDAO dao = new MovimientosInventarioDAO();
        MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
        dto.getEntidad().setIdMovimientosInventario(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("movimientos/mostrarMovimientos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*private void guardarMovimiento(HttpServletRequest request, HttpServletResponse response) {
        MovimientosInventarioDAO dao = new MovimientosInventarioDAO();
        MovimientosInventarioDTO dto = new MovimientosInventarioDTO();
        dto.getEntidad().set(request.getParameter("nameCat"));
        dto.getEntidad().setDescripcionCategoria(request.getParameter("descCat"));
        
        
        if (request.getParameter("idCat") != "") {
            dto.getEntidad().setIdCategoriaProducto(Integer.parseInt(request.getParameter("idCat")));
            try {
                dao.update(dto);
                listadoDeCategorias(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                dao.create(dto);
                request.setAttribute("mensajeOK", "El registro se almaceno satisfactoriamente ");
                listadoDeCategorias(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }*/

    private void mostrarReportePDF(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
