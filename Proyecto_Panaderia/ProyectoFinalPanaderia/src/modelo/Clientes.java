/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

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

    public Clientes() {
    }

    public Clientes(int id, String nombre, String nCuenta, String telefono, Date fechaPago, Date fechaCompra, String tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.nCuenta = nCuenta;
        this.telefono = telefono;
        this.fechaPago = fechaPago;
        this.fechaCompra = fechaCompra;
        this.tipoCliente = tipoCliente;
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

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", nCuenta=" + nCuenta + ", telefono=" + telefono + ", fechaPago=" + fechaPago + ", fechaCompra=" + fechaCompra + ", tipoCliente=" + tipoCliente + '}';
    }
    

}
