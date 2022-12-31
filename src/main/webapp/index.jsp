

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
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
                <a href="index.jsp" class="brand-logo">Proyecto1</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="CategoriaServlet?accion=listaDeCategorias">Categorías</a></li>
                    <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li>
                    <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
                </ul>
            </div>
        </nav>

        <ul class="sidenav" id="mobile-demo">
            <li><a href="CategoriaServlet?accion=listadoDeCategorias">Categorías</a></li>
            <li><a href="ProductoServlet?accion=listaDeProductos">Productos</a></li>
            <li><a href="MovimientosServlet?accion=listaDeMovimientos">Movimientos</a></li>
        </ul>
        <br>
        
    </body>

</html>
