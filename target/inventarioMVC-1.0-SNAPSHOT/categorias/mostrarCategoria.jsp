<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <h2 align='center'>Ver categoria</h2>
                <br>
                <table class='centered responsive-table'>
                    <tbody>
                        <tr>
                            <td width='35%'><b>Identificador</b></td>
                            <td width='65%'><c:out value="${dto.entidad.idCategoria}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Descripción</b></td>
                            <td width='65%'><c:out value="${dto.entidad.nombreCategoria}"/></td>
                        </tr>
                        <tr>
                            <td width='35%'><b>Nombre</b></td>
                            <td width='65%'><c:out value="${dto.entidad.descripcionCategoria}"/></td>
                        </tr>

                </table>
                </tbody>
                <div class='col s12 m12 l12'><br></div>
                <br>
            </div>
            <div class='col s4 m4 l4 offset-m4 offset-l4 offset-s4' align='center'>
                <a class='waves-effect waves-light btn green lighten-1' href='listadoCategorias.jsp'>Listado de categorias</a>
            </div>
            <div class='col s12 m12 l12'><br></div>
            <br>
        </div>
    </div>
</body>
</html>

