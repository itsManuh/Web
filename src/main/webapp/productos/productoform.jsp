<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>

        <title>Productos</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>   
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
                <div class="card text-white bg-dark">
                    <div class="card-header text-center">Añadir Producto</div>
                    <div class="card-body">
                        <form action="ProductoServlet?accion=guardar" method="POST" id="FormAgregarProducto" name="FormAgregarProducto">
                            <input id="idPro" name="idPro" type="hidden" value="<c:out value="${dto.entidad.idProducto}"/>"/>
                            <div class="mb-3"> <label>Nombre Producto</label></div>
                            <div class="mb-3"><input id="namePro" name="namePro" type="text" class="form-control" value="<c:out value="${dto.entidad.nombreProducto}"/>" required/></div>        
                            <div class="mb-3"> <label>Descripción</label></div>
                            <div class="mb-3"><input id="descPro" name="descPro" type="text" class="form-control" value="<c:out value="${dto.entidad.descripcionProducto}"/>" required></div>
                            <div class="mb-3"> <label>Precio</label></div>
                            <div class="mb-3"><input id="precioPro" name="precioPro" type="text" class="form-control" value="<c:out value="${dto.entidad.precio}"/>" required/></div>
                            <div class="mb-3"> <label>Inventario</label></div>
                            <div class="mb-3"><input id="existenciasPro" name="existenciasPro" type="text" class="form-control" value="<c:out value="${dto.entidad.existencia}"/>" required/></div>
                            <div class="mb-3"> <label>Categoria</label></div>
                            <div class="mb-3"><input id="idCat" name="idCat" type="text" class="form-control" value="<c:out value="${dto.entidad.idCategoriaProducto}"/>" required/></div>
                            <div class="mb-3"><button class="btn btn-secondary w-100" type="submint">Añadir</button> </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                            
    </body>
</html>
