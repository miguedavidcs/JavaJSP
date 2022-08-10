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
public class Producto {

    int idProducto;
    String Nombre;
    double Precio;
    String Peso;
    String Categoria;
    int Stock;
    String FechaCreacion;

    public Producto() {
    }

    public Producto(int idProducto, String Nombre, double Precio, String Peso, String Categoria, int Stock, String FechaCreacion) {
        this.idProducto = idProducto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Peso = Peso;
        this.Categoria = Categoria;
        this.Stock = Stock;
        this.FechaCreacion = FechaCreacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

}
