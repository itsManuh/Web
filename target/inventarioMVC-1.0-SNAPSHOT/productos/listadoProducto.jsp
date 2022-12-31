<%-- 
    Document   : listadoProducto
    Created on : 15 dic. 2022, 08:38:28
    Author     : levi1
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Prodcutos</title>
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
                <h2 align='center'>Listado productos</h2>
                <div class='col s6 m6 l6'>
                    <p class='flow-text'>Crear nuevo producto:
                        <a class='waves-effect waves-light btn green lighten-1' href='ProductoServlet?accion=nuevo'>
                            Agregar
                        </a>
                    </p>
                </div>
            </div>
            <table class='responsive-table striped'>
                <thead>
                    <tr>
                        <th WIDTH='5%'>Clave</th>
                        <th WIDTH='15%'>Nombre</th>
                        <th WIDTH='25%'>Descripcion</th>
                        <th WIDTH='10%'>Precio</th>
                        <th WIDTH='10%'>Existencia</th>
                        <th WIDTH='5%'>Categoria</th>
                        <th WIDTH='15%'>Actualizar</th>
                        <th WIDTH='15%'>Eliminar</th>
                    </tr>
                </thead>

                <tbody class='striped responsive-table'>

                    <c:if test="${listado !=null}">
                    <tbody class='striped responsive-table'>
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td WIDTH='5%'>
                                    <a href='ProductoServlet?accion=ver&id=<c:out value="${dto.entidad.idProducto}"/>' class='waves-effect waves-light btn green lighten-1'>
                                        <c:out value="${dto.entidad.idProducto}"/>
                                    </a>
                                </td>
                                <td WIDTH='15%'><c:out value="${dto.entidad.nombreProducto}"/></td>
                                <td WIDTH='25%'><c:out value="${dto.entidad.descripcionProducto}"/></td>
                                <td WIDTH='10%'><c:out value="${dto.entidad.precio}"/></td>
                                <td WIDTH='10%'><c:out value="${dto.entidad.existencia}"/></td>
                                <td WIDTH='5%'><c:out value="${dto.entidad.idCategoriaProducto}"/></td>


                                <td WIDTH='15%'>
                                    <a href='ProductoServlet?accion=actualizar&id=<c:out value="${dto.entidad.idProducto}"/>' class='waves-effect waves-light btn blue lighten-1'>
                                        Actualizar
                                    </a>
                                </td>
                                <td WIDTH='15%'>
                                    <a href='ProductoServlet?accion=eliminar&id=<c:out value="${dto.entidad.idProducto}"/>'' class='waves-effect waves-light btn red lighten-1'>
                                        Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </c:if>
                <c:if test="${listado ==null}">
                    <tbody class='striped responsive-table'>
                        <tr>
                            <td colspan="8">
                                <c:out value="NO HAY DATOS" />
                            </td>
                        </tr>
                    </tbody>
                </c:if>
            </table>

        </div>

    </body>
</html>

