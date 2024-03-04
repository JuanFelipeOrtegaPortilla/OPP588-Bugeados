/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import com.mongodb.client.model.MergeOptions;
import dao.MetodoProducto;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author PIPE
 */
public class ProductoServicio {

    public List<Producto> ListaProductos() {
        return new MetodoProducto().ListaProductos();

    }

    public boolean InsetarProductos(Producto producto) {
        return new MetodoProducto().InsetarProductos(producto);
    }

    public boolean ActualizarProductos(Producto producto) {
        return new MetodoProducto().ActualizarProductos(producto);
    }
    public boolean EliminarProductos(int idProduto){
        return new MetodoProducto().EliminarProductos(idProduto);
    }
     public Producto BuscarProductos(int idProduto){
         return new MetodoProducto().BuscarProductos(idProduto);
     }


}
