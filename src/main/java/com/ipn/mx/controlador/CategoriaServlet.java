package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.GraficaDTO;
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

@WebServlet(name = "CategoriaServlet", value = "/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listaDeCategorias":
                listadoDeCategorias(request, response);
                break;
            case "nuevo":
                nuevaCategoria(request, response);
                break;
            case "actualizar":
                actualizarCategoria(request, response);
                break;
            case "eliminar":
                eliminarCategoria(request, response);
                break;
            case "ver":
                verCategoria(request, response);
                break;
            case "guardar":
                guardarCategoria(request, response);
                break;
            case "verReporte":
                mostrarReportePDF(request, response);
                break;
            case "graficar":
                mostrarGrafica(request, response);
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

    private void listadoDeCategorias(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        List lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("categorias/listadoCategorias.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void nuevaCategoria(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("categorias/categoriaform.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoriaProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("categorias/categoriaform.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoriaProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            dao.delete(dto);
            request.setAttribute("mensajeDelete", "El registro se elimino satisfactoriamente");
            listadoDeCategorias(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verCategoria(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoriaProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("categorias/mostrarCategoria.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarCategoria(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setNombreCategoria(request.getParameter("nameCat"));
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

    }

    private void mostrarReportePDF(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarGrafica(HttpServletRequest request, HttpServletResponse response) {
        JFreeChart chart = ChartFactory.createPieChart("Productos por categoria", obtenerDatosGrafica(), true, true, Locale.getDefault());
        String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");

        RequestDispatcher rd = request.getRequestDispatcher("/grafica.jsp");
        try {
            ChartUtils.saveChartAsPNG(new File(archivo), chart, 800, 600);
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PieDataset obtenerDatosGrafica() {
        DefaultPieDataset pie = new DefaultPieDataset();
        CategoriaDAO dao = new CategoriaDAO();
        try {
            List datos = dao.graficar();
            for (int i = 0; i < datos.size(); i++) {
                GraficaDTO dto = (GraficaDTO) datos.get(i);
                pie.setValue(dto.getNombre(), dto.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pie;
    }

}
