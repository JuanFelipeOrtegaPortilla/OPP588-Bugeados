/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Producto;
import org.bson.Document;

/**
 *
 * @author PIPE
 */
public class MetodoCliente implements ICliente {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    private MongoCollection<Document> coleccion2;

    public MetodoCliente() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("clientes");
            this.coleccion2 = database.getCollection("productos");
        }
    }

    private void cerrarConexion() {
        try {
            conn.getMongo().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.toString());
        }
    }

    private int generarID() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(900) + 100;
        return numeroAleatorio;
    }

    @Override
    public List<Clientes> ListaCliente() {
        List<Clientes> listaClientes = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccion.find();
            for (Document temp : documentos) {
                Clientes clientes = new Clientes();

                clientes.setId(temp.getInteger("idClientes"));
                clientes.setNombre(temp.getString("nombreCliente"));
                clientes.setTelefono(temp.getString("telefono"));
                clientes.setTipoCliente(temp.getString("tipoCliente"));
                clientes.setFechaCompra(temp.getDate("fechaCompra"));
                clientes.setFechaPago(temp.getDate("fechaPago"));
                clientes.setnCuenta(temp.getString("cuenta"));
                clientes.setCancelado(temp.getBoolean("cancelado"));

                listaClientes.add(clientes);

            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaClientes;
    }

    @Override
    public boolean InsetarClientes(Clientes clientes) {
        Document documento;
        try {
            documento = new Document("idClientes", generarID())
                    .append("nombreCliente", clientes.getNombre())
                    .append("telefono", clientes.getTelefono())
                    .append("tipoCliente", clientes.getTipoCliente())
                    .append("fechaCompra", clientes.getFechaCompra())
                    .append("fechaPago", clientes.getFechaPago())
                    .append("cuenta", clientes.getnCuenta())
                    .append("cancelado", clientes.isCancelado());

            coleccion.insertOne(documento);
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
        return true;
    }

    @Override
    public boolean ActualizarClientes(Clientes clientes) {
        Document filtro = null;
        Document resultado = null;
        boolean actualizar = false;

        try {
            filtro = new Document("id_perfil", clientes.getId());
            resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                clientes.setCancelado(resultado.getBoolean("cancelado"));
                clientes.setFechaPago(resultado.getDate("fechaPago"));

                actualizar = true;
            }

        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }

        return actualizar;
    }

    @Override
    public Clientes BuscarClientes(int id) {
        Clientes clientes = null;
        try {
            Document filtro = new Document("idCliente", id);
            FindIterable<Document> resultados = coleccion.find(filtro);
            Document resultado = resultados.first();

            if (resultado != null) {
                clientes = new Clientes();
                clientes.setId(resultado.getInteger("idCliente"));
                clientes.setNombre(resultado.getString("nombreClientes"));
                clientes.setTipoCliente(resultado.getString("tipoCliente"));
                clientes.setTelefono(resultado.getString("telefono"));
                clientes.setnCuenta(resultado.getString("cuenta"));
                clientes.setFechaCompra(resultado.getDate("fechaCompra"));
                clientes.setFechaPago(resultado.getDate("fechaPago"));
                clientes.setCancelado(resultado.getBoolean("cancelado"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar datos:" + ex.toString());
        } finally {
            cerrarConexion();
        }
        return clientes;
    }

    @Override
    public boolean ActualizarStock(Clientes clientes) {
            try {
            for (Producto productoStock : clientes.getListaCompra()) {
                Document filtro = new Document("nombreProducto", productoStock.getNombreProducto());
                Document resultado = coleccion2.find(filtro).first();
                Document cambioStock = new Document("cantidad", resultado.getInteger("cantidad")-productoStock.getCantidad());
            UpdateResult result = coleccion2.updateOne(filtro, new Document("$set", cambioStock ));
            }
            return true;
            
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

}
  
            