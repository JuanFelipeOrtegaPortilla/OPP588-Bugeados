/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.MetodosProveedor;
import java.util.List;
import modelo.Proveedor;

/**
 *
 * @author PIPE
 */
public class ProveedorServicio {

    public List<Proveedor> ListaProveedor() {
        return new MetodosProveedor().ListaProveedor();
    }

    public boolean InsetarProveedor(Proveedor proveedor) {
        return new MetodosProveedor().InsetarProveedor(proveedor);
    }
     public boolean ActualizarProveedor(Proveedor proveedor){
         return new MetodosProveedor().ActualizarProveedor(proveedor);
     }
     public Proveedor BuscarProveedor(int idProveedor){
         return new MetodosProveedor().BuscarProveedor(idProveedor);
     }
      public boolean ActualizarStock(Proveedor proveedor){
          return new MetodosProveedor().ActualizarStock(proveedor);
      }
}
