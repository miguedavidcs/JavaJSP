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
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int idProducto1){
        Producto p=new Producto();
        String sql="select * from producto where idProducto"+idProducto1;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);            
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setPeso(rs.getString(4));
                p.setCategoria(rs.getString(5));
                p.setStock(rs.getInt(6));
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public int actualizarstock(int sac, int idproducto){
        String sql="update producto set Stock=? where idProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);  
            ps.setInt(1, sac);
            ps.setInt(2, idproducto);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
            
    public Producto buscar(String idProducto){
        Producto p=new Producto();
        String sql="select * from producto where idProducto ="+idProducto;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setPeso(rs.getString(4));
                p.setCategoria(rs.getString(5));
                p.setStock(rs.getInt(6));
                
            }
        } catch (Exception e) {
        }
        return p;
    }
      
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto pr=new Producto();
                pr.setIdProducto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setPeso(rs.getString(4));
                pr.setCategoria(rs.getString(5));
                pr.setStock(rs.getInt(6));
                pr.setFechaCreacion(rs.getString(7));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    } 
    
    public int agregar(Producto pr){
        String sql="insert into producto(Nombre, Precio, Peso, Categoria, Stock)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pr.getNombre());
            ps.setDouble(2,pr.getPrecio());
            ps.setString(3,pr.getPeso());
            ps.setString(4,pr.getCategoria());
            ps.setInt(5,pr.getStock());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Producto listarIdProducto(int idProducto){
        Producto pr=new Producto();
        String sql="select * from producto where idProducto="+idProducto;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setPeso(rs.getString(4));
                pr.setCategoria(rs.getString(5));
                pr.setStock(rs.getInt(6));
                pr.setFechaCreacion(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Producto pr){
        String sql="update producto set Nombre=?, Precio=?, Peso=?, Categoria=?, Stock=? where idProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setString(3, pr.getPeso());
            ps.setString(4, pr.getCategoria());
            ps.setInt(5, pr.getStock());
            ps.setInt(6, pr.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int idProducto){
        String sql="delete from producto where idProducto="+idProducto;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();            
        } catch (Exception e) {
        }
    }
    
}
