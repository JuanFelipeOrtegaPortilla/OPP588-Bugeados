/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Clientes;


/**
 *
 * @author PIPE
 */
public interface ICliente {

    public List<Clientes> ListaCliente();

    public boolean InsetarClientes(Clientes clientes);

    public boolean ActualizarClientes(Clientes clientes);

    public Clientes BuscarClientes(int id);
}
