/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PIPE
 */
public class Proveedor {

    private int idProveedor;
    private String Proveedor;
    private String marca;
    private String nombreProducto;
    private int cantidad;
    private String fechaPedido;
    private String fechaPago;
    private boolean cancelado;
    private List<Producto> listaEntrega;
    private String nombrePerfil;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String Proveedor, String marca, String nombreProducto, int cantidad, String fechaPedido, String fechaPago, boolean cancelado, List<Producto> listaEntrega, String nombrePerfil) {
        this.idProveedor = idProveedor;
        this.Proveedor = Proveedor;
        this.marca = marca;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.fechaPago = fechaPago;
        this.cancelado = cancelado;
        this.listaEntrega = listaEntrega;
        this.nombrePerfil = nombrePerfil;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public List<Producto> getListaEntrega() {
        return listaEntrega;
    }

    public void setListaEntrega(List<Producto> listaEntrega) {
        this.listaEntrega = listaEntrega;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", Proveedor=" + Proveedor + ", marca=" + marca + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", fechaPedido=" + fechaPedido + ", fechaPago=" + fechaPago + ", cancelado=" + cancelado + ", listaEntrega=" + listaEntrega + ", nombrePerfil=" + nombrePerfil + '}';
    }

    

}
