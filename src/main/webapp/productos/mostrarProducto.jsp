<%-- 
    Document   : mostrarProducto
    Created on : 15 dic. 2022, 08:38:55
    Author     : levi1
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Categorias</title>   
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css'>
        <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js'></script>
        <script>
            $(document).ready(function () {
                $('.sidenav').sidenav();
                $('.tabs').tabs();
                $('select').formSelect();
            });
        </script>
    </head>
    <body class='grey'>
        <nav>
            <div class='nav-wrapper green darken-1'>
                <a href='index.jsp' class='brand-logo'>Practica 3</a>
                <a href='#' data-target='mobile-demo' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
                <ul class='right hide-on-med-and-down'>
                    <li><a href="CategoriaServlet?accion=listaDeCategorias">Categorías</a></li>
                    <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li>
                    <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
                </ul>
            </div>
        </nav>
        <ul class='sidenav' id='mobile-demo'>
            <li><a href="CategoriaServlet?accion=listaDeCategorias">Categorías</a></li>
            <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li> 
            <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
        </ul>
        <br>
        <div class='container white z-depth-5'>
            <div class='row'>
                <br>
                <h2 align='center'>Ver producto</h2>
                <br>
                <table class='centered responsive-table'>           
                    <tbody>
                        <tr>
                            <td width='35%'><b>Identificador</b></td>
                            <td width='65%'><c:out value="${dto.entidad.idProducto}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Nombre</b></td>
                            <td width='65%'><c:out value="${dto.entidad.nombreProducto}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Descripcion</b></td>
                            <td width='65%'><c:out value="${dto.entidad.descripcionProducto}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Precio</b></td>
                            <td width='65%'><c:out value="${dto.entidad.precio}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Existencia</b></td>
                            <td width='65%'><c:out value="${dto.entidad.existencia}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>ID categoria</b></td>
                            <td width='65%'><c:out value="${dto.entidad.idCategoriaProducto}"/></td>
                        </tr>

                </table>           
                </tbody>
                <div class='col s12 m12 l12'><br></div>
                <br>
            </div>
            <div class='col s4 m4 l4 offset-m4 offset-l4 offset-s4' align='center'>
                <a class='waves-effect waves-light btn green lighten-1' href='ProductoServlet?accion=listaDeProductos'>Listado de productos</a>
            </div>
            <div class='col s12 m12 l12'><br></div>
            <br>
        </div>
    </div>
</body>
</html>
