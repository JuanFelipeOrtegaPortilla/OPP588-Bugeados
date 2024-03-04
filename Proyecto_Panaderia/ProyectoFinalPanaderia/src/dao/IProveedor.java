/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Proveedor;

/**
 *
 * @author PIPE
 */
public interface IProveedor {

    public List<Proveedor> ListaProveedor();

    public boolean InsetarProveedor(Proveedor proveedor);

    public boolean ActualizarProveedor(Proveedor proveedor);

    public boolean EliminarProveedor(int idProveedor);

    public Proveedor BuscarProveedor(int idProveedor);
    
    public boolean ActualizarStock(Proveedor proveedor);
}
