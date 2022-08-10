<%-- 
    Document   : Producto
    Created on : 18/07/2022, 11:54:23 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container center">
            <h1>Productos cafeteria</h1>
            <div class="d-flex me-md-3">
                <div class="card col-sm-4">
                    <div class="card-body">
                        <form action="Controlador?menu=Productos" method="POST">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" value="${producto.getNombre()}" name="txtNombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Peso</label>
                                <input type="text" value="${producto.getPeso()}" name="txtPeso" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Categoria</label>
                                <input type="text" value="${producto.getCategoria()}" name="txtCategoria" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                            </div>
                            <br>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-dark">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-dark">
                        </form>
                    </div>
                </div>

                <div class="col-sm-6 me-md-3">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Peso</th>
                                <th>Categoria</th>
                                <th>Stock</th>
                                <th>Fecha creacion</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="pr" items="${productos}">
                            <tr>
                                <td>${pr.getIdProducto()}</td>
                                <td>${pr.getNombre()}</td>
                                <td>${pr.getPrecio()}</td>
                                <td>${pr.getCategoria()}</td>
                                <td>${pr.getStock()}</td>
                                <td>${pr.getFechaCreacion()}</td>
                                <td>
                                    <a class="btn btn-primary" href="Controlador?menu=Productos&accion=Editar&idProducto=${pr.getIdProducto()}">Editar</a>
                                    <a class="btn btn-primary" href="Controlador?menu=Productos&accion=Eliminar&idProducto=${pr.getIdProducto()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    </body>
</html>
