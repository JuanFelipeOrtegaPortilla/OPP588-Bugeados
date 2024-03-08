/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Pedidos;

/**
 *
 * @author PIPE
 */
public interface IPedidos {
    public List<Pedidos> ListarPedidos();
    public boolean InsetarPedido(Pedidos pedido);
    public boolean ActualizarPedidos(Pedidos pedido);
    public boolean EliminarPedido(int idPedido);
    public Pedidos BuscarIdPedido( int idPedido);
}
