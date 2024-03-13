/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.MetodoCliente;
import java.util.List;
import modelo.Clientes;

/**
 *
 * @author PIPE
 */
public class ClienteServicio {
   public static List<Clientes> ListaCliente(){
       return new MetodoCliente().ListaCliente();
       
   }
   public boolean InsetarClientes(Clientes clientes){
       return new MetodoCliente().InsetarClientes(clientes);
   } 
   public boolean ActualizarClientes(Clientes clientes){
       return new MetodoCliente().ActualizarClientes(clientes);
   }
    public Clientes BuscarClientes(int id){
        return new MetodoCliente().BuscarClientes(id);
    }
    public boolean ActualizarStock(Clientes clientes){
        return new MetodoCliente().ActualizarStock(clientes);
    }
  
    public List<Clientes> ListaClientePorMes(List<Clientes> listaClientes, int mes, String tipo){
       return new MetodoCliente().ListaClientePorMes(listaClientes, mes, tipo);
       
   }
}
