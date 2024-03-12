/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.stream.Stream;

/**
 *
 * @author PIPE
 */
public class Extras {
    private String productos;
    private int cantidad;
    private double precioUnitario;
    private double total;
    private String fechaPago;
    private int idExtras;

    public Extras() {
    }

    public Extras(String productos, int cantidad, double precioUnitario, double total, String fechaPago, int idExtras) {
        this.productos = productos;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.fechaPago = fechaPago;
        this.idExtras = idExtras;
    }
    
    public Extras(int id, String productoNombre, int cantidad, double precioUnitario, double totalCancelar,String fechaPago) {
        this.idExtras = id;
        this.productos = productoNombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = totalCancelar;
        this.fechaPago = fechaPago;
       
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdExtras() {
        return idExtras;
    }

    public void setIdExtras(int idExtras) {
        this.idExtras = idExtras;
    }

    @Override
    public String toString() {
        return "Extras{" + "productos=" + productos + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", total=" + total + ", fechaPago=" + fechaPago + ", idExtras=" + idExtras + '}';
    }

 
    
    
}
