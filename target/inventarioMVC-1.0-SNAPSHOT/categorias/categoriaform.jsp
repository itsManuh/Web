<%-- 
    Document   : categoriaform
    Created on : 10 nov. 2022, 11:33:43
    Author     : levi1
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Proyecto1</title>
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

            $("#FormAgregarCategoria").validate();
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
            <div class="row"></div>
            <div class="row">
                <h2 align="center">Agregar nueva categoría</h2>
                <form action="CategoriaServlet?accion=guardar" method="post" id="FormAgregarCategoria" name="FormAgregarCategoria">
                    <input id="idCat" name="idCat" type="hidden" 
                           value="<c:out value="${dto.entidad.idCategoria}"/>"
                           >
                    <div class="input-field col s10 m10 l10 offset-l1 offset-m1 offset-s1">
                        <input id="nameCat" 
                               name="nameCat" 
                               type="text" 
                               class="validate" 
                               value="<c:out value="${dto.entidad.nombreCategoria}"/>" 
                               required>
                        <label for="nameCat">Nombre de la categoria</label>
                    </div>
                    <div class="input-field col s10 m10 l10 offset-l1 offset-m1 offset-s1 ">
                        <input id="descCat" name="descCat" type="text" class="validate" value="<c:out value="${dto.entidad.descripcionCategoria}"/>" required>
                        <label for="descCat">Descripción de la categoria</label>
                    </div>
                    <div class="col s4 m4 l4 offset-m4 offset-l4 offset-s4" align="center">
                        <button type="submit" class="waves-effect waves-light btn green lighten-1 col s12 ">Ingresar categoria</button>
                    </div>
                    <div class="col s12">
                        <br>
                    </div> 
                    <div class="col s4 m4 l4 offset-m8 offset-l8 offset-s8" align="center">
                        <input type="reset" class="btn blue lighten-1" value="Limpiar">
                    </div>
                    <div class="col s12">
                        <br>
                    </div>
                </form>
                <br>
            </div>
        </div>
    </body>

</html>
