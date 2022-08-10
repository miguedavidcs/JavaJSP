/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Miguel
 */
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numserie="";
        String sql="select max(NumSerie) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                numserie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numserie;
    }
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql="insert into ventas(Numserie,Monto,Estado)values(?,?,?)";
         try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, ve.getNumserie());
            ps.setDouble(2, ve.getMonto());
            ps.setString(3, ve.getEstado());
            ps.executeUpdate(); 
        }catch(Exception e){         
        }
         return r;
    }
    
    public int guardarDetalleVentas(Venta venta){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getIdVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();             
        } catch (Exception e) {
        }
        return r;
    }
}
