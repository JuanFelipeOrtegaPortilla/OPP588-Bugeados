/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Producto;

/**
 *
 * @author PIPE
 */
public interface IProducto {
    public List<Producto> ListaProductos();
    public boolean InsetarProductos(Producto producto);
   public boolean ActualizarProductos(Producto producto);
    public boolean EliminarProductos(int idProduto);
    public Producto BuscarProductos( int  idProduto);
    public Producto BuscarProductosPorNombre( String  Produto);
}
