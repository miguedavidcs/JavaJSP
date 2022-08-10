/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.GenerarSerie;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    
    Producto pr=new Producto();
    ProductoDAO pdao=new ProductoDAO();
    int idp;
    int ide;
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String Nombre;
    Double Precio;
    String Peso;
    int Cantidad;
    String Categoria;
    String Stock;
    String FechaCreacion;
    Double subtotal;
    Double totalPagar;
    String numserie;
    
    VentaDAO vdao=new VentaDAO();          
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("ProductoM")) {
            switch (accion) {
                case "ListaM":
                    List lista=pdao.listarM();
                    request.setAttribute("productos", lista);
                    
          }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                
                case "Agregar":
                    String Nombre=request.getParameter("txtNombre");
                    double Precio=Double.valueOf(request.getParameter("txtPrecio"));
                    String Peso=request.getParameter("txtPeso");
                    String Categoria=request.getParameter("txtCategoria");
                    int Stock=Integer.valueOf(request.getParameter("txtStock"));
                    pr.setNombre(Nombre);
                    pr.setPrecio(Precio);
                    pr.setPeso(Peso);
                    pr.setCategoria(Categoria);
                    pr.setStock(Stock);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;  
                case "Editar":       
                    idp = Integer.parseInt(request.getParameter("idProducto"));
                    Producto p = pdao.listarIdProducto(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":                       
                    String Nombre1 = request.getParameter("txtNombre");
                    String Precio1 = request.getParameter("txtPrecio");
                    String Peso1 = request.getParameter("txtPeso");
                    String Categoria1 = request.getParameter("txtCategoria");
                    String Stock1 = request.getParameter("txtStock");
                    
                    pr.setNombre(Nombre1);
                    pr.setPrecio(Double.valueOf(Precio1));
                    pr.setPeso(Peso1);
                    pr.setCategoria(Categoria1);
                    pr.setStock(Integer.valueOf(Stock1));                     
                    pr.setIdProducto(idp);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("idProducto"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("RegistrarVenta")) {            
            switch(accion){
                case "BuscarProducto":
                    String idProducto=request.getParameter("idProducto");
                    pr.setIdProducto(Integer.valueOf(idProducto));
                    pr=pdao.buscar(idProducto);
                    request.setAttribute("p", pr);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    request.setAttribute("p", pr);
                    totalPagar =0.0;
                    item = item+1;
                    cod=pr.getIdProducto();
                    Nombre=request.getParameter("nombreproducto");
                    Precio=Double.parseDouble(request.getParameter("precio"));
                    Cantidad=Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=(Precio*Cantidad);  
                    v=new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setNombre(Nombre);
                    v.setPrecio(Precio);
                    v.setCantidad(Cantidad);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);                                     
                    break;
                case "GenerarVenta":
                    //Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdProducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=(pr.getStock()-cantidad);
                        aO.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setNumserie(numserie);
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Guardar Detalles ventas
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new Venta();
                        v.setIdVenta(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());  
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVentas(v);
                    }
                    
                    break;
                default:
                    numserie=vdao.GenerarSerie();
                    if (numserie==null) {
                        numserie="0000001";
                        request.setAttribute("numserie", numserie);
                        
                    }
                    else{
                        int incrementar=Integer.parseInt(numserie);
                        GenerarSerie gs=new GenerarSerie();
                        numserie=gs.NumSerie(incrementar);
                        request.setAttribute("numserie", numserie);
                    }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        
        switch (accion){
        case "ProductoM":
            request.getRequestDispatcher("ProductoM.jsp").forward(request, response);
            break; 
        case "Productos":
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
            break;        
        case "RegistrarVenta":
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            break;
        default:
        throw new AssertionError();
            
        
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
