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
                <div class="mb-3">
                    <h2 class="text-center">Productos</h2>
                </div>
                <div class="mb-3">
                    <a class="btn btn-dark w-100" href="ProductoServlet?accion=nuevo">Añadir Producto</a>
                </div>
                <table class="table table-dark w-100 table-striped"\> 
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Inventario</th>
                        <th>Categoria</th>
                        <th>Eliminar</th>
                        <th>Actualizar</th>
                    </tr>
                    <c:if test="${listado !=null}">
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td><a class="btn btn-light" href='ProductoServlet?accion=ver&id=<c:out value="${dto.entidad.idProducto}"/>'><c:out value="${dto.entidad.idProducto}"/></a></td>
                                <td><c:out value="${dto.entidad.nombreProducto}"/></td>
                                <td><c:out value="${dto.entidad.descripcionProducto}"/></td>
                                <td><c:out value="${dto.entidad.precio}"/></td>
                                <td><c:out value="${dto.entidad.existencia}"/></td>
                                <td><c:out value="${dto.entidad.idCategoriaProducto}"/></td>
                                <td>
                                    <a class="btn btn-danger" href='ProductoServlet?accion=eliminar&id=<c:out value="${dto.entidad.idProducto}"/>'>Eliminar</a>
                                </td>
                                <td>
                                    <a class="btn btn-success" href='ProductoServlet?accion=actualizar&id=<c:out value="${dto.entidad.idProducto}"/>'>Actualizar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
        </div>
    </body>
</html>

