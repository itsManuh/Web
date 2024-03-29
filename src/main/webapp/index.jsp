<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>

        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-3.6.1.min.js"> </script>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Practica 3 </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="./CategoriaServlet?accion=listaDeCategorias">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="./CategoriaServlet?accion=graficar">Grafica</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="ProductoServlet?accion=listaDeProductos">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="MovimientoServlet?accion=listaDeMovimientos">Movimientos</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row pt-2">
                <div class="col-12 text-center">
                    <h1>Cortes Ramirez Roberto Carlos</h1>
                    <h1>Leon Torres Guadalupe Jurian</h1>
                    <h1>Malacara González Manuel Salvador</h1>
                    <h1>3CM17</h1>
                    <br></br>
                    <h2>Practica #3</h2>
                </div>
            </div>
        </div>
    </body>

</html>
