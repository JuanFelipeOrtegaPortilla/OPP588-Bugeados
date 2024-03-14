/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PIPE
 */
public class Pedidos {
    private int idProducto;
    private String producto;
    private String pedido;
    private int cantidad;
    private double precio;
    private double total;
    private int idPedido;
    private String fechaPedido;
    private String fechaEntrega;
    private boolean pagado;

    public Pedidos() {
    }
    public Pedidos(int idPedido, String marca, String producto, int cantidad, double precio, double total, boolean pagado, String fechaPedido, String fechaEntrega) {
        this.idPedido = idPedido;
        this.pedido = marca;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.pagado = pagado;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }

    public Pedidos(int idProducto, String producto, String pedido, int cantidad, double precio, double total, int idPedido, String fechaPedido, boolean pagado) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.pagado = pagado;
    }
    

    public Pedidos(int idProducto, String producto, String pedido, int cantidad, double precio, double total, int idPedido, String fechaPedido, String fechaEntrega, boolean pagado) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.pagado = pagado;
    }

    public Pedidos(int idProducto, String producto, int cantidad, double precio, double total, int idPedido, String fechaPedido, String fechaEntrega) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }

    public Pedidos(int idPedidos, String fechaEntrega, boolean pagado) {
        this.idPedido= idPedidos;
        this.fechaEntrega = fechaEntrega;
        this.pagado = pagado;
    }
    

    public Pedidos(int idProducto, String producto, int cantidad, double precio, double total, String fechaPedido, String fechaEntrega) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }
    public Pedidos(int idProducto, String producto, String pedido, int idPedido, int cantidad, double precio, double total, String fechaPedido, String fechaEntrega) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.pedido = pedido;
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }
     public Pedidos(int idProducto, String producto, String nombrePedido, int cantidad, double precio, double total, int idPedido, String fechaPedido, String fechaEntrega) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.pedido = nombrePedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    @Override
    public String toString() {
        return "Pedidos{" + "idProducto=" + idProducto + ", producto=" + producto + ", pedido=" + pedido + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + ", idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega + '}';
    }
    

}
