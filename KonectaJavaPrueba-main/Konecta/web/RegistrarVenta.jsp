<%-- 
    Document   : RegistrarVenta
    Created on : 18/07/2022, 11:54:47 AM
    Author     : Miguel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Registrar venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                Datos del producto
                            </div><br>
                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <input type="text" name="idProducto" value="${p.getIdProducto()}" class="form-control" placeholder="id producto">
                                </div>
                                <div class="col-sm-3">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-primary">BuscarProducto</button>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" value="${p.getNombre()}" name="nombreproducto" placeholder="Nombre producto" class="form-control">        
                                </div>                            
                            </div><br> <br>

                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" value="${p.getPrecio()}" name="precio" class="form-control" placeholder="Precio">
                                </div>   
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cantidad" class="form-control" placeholder="Cantidad">
                                </div>   
                                <div class="col-sm-3">
                                    <input type="text" value="${p.getStock()}" name="stock" class="form-control" placeholder="Stock">
                                </div>                              
                            </div>   
                            <br>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>N.Serie:  </label>
                            <input type="text" name="NroSerie" value="${numserie}" class="form-control">
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>ID producto</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdProducto()}</td>
                                        <td>${list.getNombre()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a href="Controlador?accion=RegistrarVenta&accion=Editarr&id=${em.getId()}" class="btn btn-primary">Editar</a>
                                            <a href="Controlador?accion=RegistrarVenta&accion=Eliminar&id=${em.getId()}" class="btn btn-primary">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a class="btn btn-primary" href="Controlador?menu=RegistrarVenta&accion=GenerarVenta">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="Total $/. ${totalPagar}" class="form-control">
                        </div>
                    </div>
                </div>                
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>

