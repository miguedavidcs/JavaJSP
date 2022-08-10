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
public class Venta {

    Integer item;
    Integer idVenta;
    Integer idProducto;
    String Numserie;
    String Nombre;
    Double Precio;
    int cantidad;
    String Peso;
    String Categoria;
    Double Subtotal;
    Integer Stock;
    Double monto;
    String Estado;

    public Venta() {
    }

    public Venta(Double Subtotal, Integer cantidad, Integer item, Integer idVenta, Integer idProducto, String Numserie, String Nombre, Double Precio, String Peso, String Categoria, Integer Stock, Double monto, String Estado) {
        this.cantidad = cantidad;
        this.item = item;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.Numserie = Numserie;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Peso = Peso;
        this.Categoria = Categoria;
        this.Subtotal = Subtotal;
        this.Stock = Stock;
        this.monto = monto;
        this.Estado = Estado;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNumserie() {
        return Numserie;
    }

    public void setNumserie(String Numserie) {
        this.Numserie = Numserie;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
