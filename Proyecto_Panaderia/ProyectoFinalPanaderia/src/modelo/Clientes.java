/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PIPE
 */
public class Clientes {
    private int id;
    private String nombre;
    private String nCuenta;
    private String telefono;
    private Date fechaPago;
    private Date fechaCompra;
    private String tipoCliente; 
    private boolean cancelado;
    private List<Producto> listaCompra;

    public Clientes() {
    }

    public Clientes(List<Producto> listaCompra) {
        this.listaCompra = new ArrayList<>();
    }

    
    public Clientes(int id, String nombre, String nCuenta, String telefono, Date fechaPago, Date fechaCompra, String tipoCliente, boolean cancelado) {
        this.id = id;
        this.nombre = nombre;
        this.nCuenta = nCuenta;
        this.telefono = telefono;
        this.fechaPago = fechaPago;
        this.fechaCompra = fechaCompra;
        this.tipoCliente = tipoCliente;
        this.cancelado = cancelado;
    }
    
    public List<Producto> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", nCuenta=" + nCuenta + ", telefono=" + telefono + ", fechaPago=" + fechaPago + ", fechaCompra=" + fechaCompra + ", tipoCliente=" + tipoCliente + ", cancelado=" + cancelado + '}';
    }

   
}
