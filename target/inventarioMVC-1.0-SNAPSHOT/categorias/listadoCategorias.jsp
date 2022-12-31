<%-- 
    Document   : listadoCategorias
    Created on : 15 nov. 2022, 09:11:29
    Author     : levi1
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Lista de categorias</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.13.1/validate.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

        <script>
            $(document).ready(function () {
                $('.sidenav').sidenav();
                $('.tabs').tabs();
                $('select').formSelect();
            });
        </script>
    </head>


    <body class="grey">
        <nav>
            <div class="nav-wrapper green darken-1">
                <a href="index.jsp" class="brand-logo">Practica 3</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="CategoriaServlet?accion=listaDeCategorias">Categorías</a></li>
                    <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li> 
                    <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
                </ul>
            </div>
        </nav>

        <ul class="sidenav" id="mobile-demo">
            <li><a href="CategoriaServlet?accion=listaDeCategorias">Categorías</a></li>
            <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li> 
            <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
        </ul>
        <br>
        <div class="container white z-depth-5">
            <div class="row">
                <br>
                <h2 align="center">Listado de categorias</h2>
                <div class='col s6 m6 l6'>
                    <p class='flow-text'>Crear nueva categoria:
                        <a class='waves-effect waves-light btn green lighten-1' href='CategoriaServlet?accion=nuevo'>
                            Agregar
                        </a>
                    </p>
                </div>
            </div>
            <table class='responsive-table striped'>
                <thead>
                    <tr>
                        <th WIDTH='10%'>Clave</th>
                        <th WIDTH='25%'>Nombre</th>
                        <th WIDTH='35%'>Descripcion</th>
                        <th WIDTH='15%'>Actualizar</th>
                        <th WIDTH='15%'>Eliminar</th>
                    </tr>
                </thead>


                <c:if test="${listado !=null}">
                    <tbody class='striped responsive-table'>
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td WIDTH='10%'>
                                    <a href='CategoriaServlet?accion=ver&id=<c:out value="${dto.entidad.idCategoria}"/>' class='waves-effect waves-light btn green lighten-1'>
                                        <c:out value="${dto.entidad.idCategoria}"/>
                                    </a>
                                </td>

                                <td WIDTH='25%'><c:out value="${dto.entidad.nombreCategoria}"/></td>
                                <td WIDTH='35%'><c:out value="${dto.entidad.descripcionCategoria}"/></td>
                                <td WIDTH='15%'>
                                    <a href='CategoriaServlet?accion=actualizar&id=<c:out value="${dto.entidad.idCategoria}"/>' class='waves-effect waves-light btn blue lighten-1'>
                                        Actualizar
                                    </a>
                                </td>
                                <td WIDTH='15%'><a href='CategoriaServlet?accion=eliminar&id=<c:out value="${dto.entidad.idCategoria}"/>'' class='waves-effect waves-light btn red lighten-1'>Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </c:if>

                <c:if test="${listado ==null}">
                    <tbody class='striped responsive-table'>
                        <tr>
                            <td colspan="5">
                                <c:out value="NO HAY DATOS" />
                            </td>
                        </tr>
                    </tbody>
                </c:if>

            </table>
            <br>

        </div>
    </body>

</html>

