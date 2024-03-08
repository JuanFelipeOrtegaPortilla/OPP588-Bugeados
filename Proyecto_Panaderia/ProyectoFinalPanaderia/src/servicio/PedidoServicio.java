/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.MetodosPedidos;
import dao.MetodosPerfil;
import java.util.List;
import modelo.Pedidos;


/**
 *
 * @author PIPE
 */
public class PedidoServicio {
    
  
    public static List<Pedidos> ListarPedidos() {
        return new MetodosPedidos().ListarPedidos();
    }

    public static boolean InsertarPedido(Pedidos pedido) {
        return new MetodosPedidos().InsetarPedido(pedido);
    }

    public static boolean ActualizarPedidos(Pedidos pedido) {
        return new MetodosPedidos().ActualizarPedidos(pedido);
    }

    public static boolean EliminarPedido(int idPedido) {
        return new MetodosPedidos().EliminarPedido(idPedido);
    }

    public static Pedidos BuscarIdPedido(int idPedido) {
        return new MetodosPedidos().BuscarIdPedido(idPedido);
    }
}

    

