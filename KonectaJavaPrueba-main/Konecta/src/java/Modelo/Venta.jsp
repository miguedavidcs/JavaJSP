<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Listado de Producto</h1>
        <table align="center" border="1" width="600" class="table" >
            <tr bgcolor="skyblue">
                <th colspan="5" >Producto mas vendido</th>
            </tr>
            <tr bgcolor="skyblue">
                <th bgcolor="green" scope="col">Codigo</th><th scope="col">Numero Stock</th><th scope="col">Producto</th>
                
            <br>
            <% Connection cnx = null;
                Statement sta = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/konecta?user=root&password=");
                    sta = cnx.createStatement();
                    rs = sta.executeQuery("SELECT v.idProducto , COUNT(v.idProducto), p.Nombre FROM detalle_ventas v, producto p WHERE v.IdProducto=p.IdProducto GROUP BY v.IdProducto;");
                    while (rs.next()) {
            %>
            <tr>
                <th scope="col"><%=rs.getString(1)%></th>
                <th scope="col"><%=rs.getString(2)%></th>
                <th scope="col"><%=rs.getString(3)%></th>
                                
            </tr>
            <br>
            <%
                    }
                    sta.close();
                    rs.close();
                    cnx.close();
                } catch (Exception e) {
                }
            %>
            </tr>
        </table>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>
