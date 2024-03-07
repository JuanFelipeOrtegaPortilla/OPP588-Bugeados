/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Clientes;

import modelo.Proveedor;
import org.bson.Document;

/**
 *
 * @author IDC
 */
public class MetodosProveedor implements IProveedor {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccionProductos;
    private MongoCollection<Document> coleccionProveedor;
    private MongoCollection<Document> coleccionPerfil;
    public List<Proveedor> ListaProveedor;

    public MetodosProveedor() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccionProveedor = database.getCollection("proveedores");
            this.coleccionProductos = database.getCollection("productos");
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
    public List<Proveedor> ListaProveedor() {
                List<Proveedor> listaProveedores = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccionProveedor.find();
            for (Document temp : documentos) {
                Proveedor proveedor = new Proveedor();

                proveedor.setIdProveedor(generarID());
                proveedor.setProveedor(temp.getString("nombreCliente"));
                proveedor.setMarca(temp.getString("telefono"));
                proveedor.setFechaPedido(temp.getString("fechaCompra"));
                proveedor.setFechaPago(temp.getString("fechaPago"));
                proveedor.setCancelado(temp.getBoolean("cancelado"));

                listaProveedores.add(proveedor);

            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaProveedores;
    }

    @Override
    public boolean InsetarProveedor(Proveedor proveedor) {
        Document documento;
        try {
            documento = new Document("id_proveedor", proveedor.getIdProveedor())
                    .append("proveedor", proveedor.getProveedor())
                    .append("marca", proveedor.getMarca())
                    .append("nombreProducto", proveedor.getNombreProducto())
                    //.append("cantidad", proveedor.getCantidad())
                    .append("fechaPedido", proveedor.getFechaPedido())
                    .append("fehchaPago", proveedor.getFechaPago())
                    .append("listaEntrega",proveedor.getListaEntrega());

            coleccionProveedor.insertOne(documento);
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
        return true;
    }

    @Override
    public boolean ActualizarProveedor(Proveedor proveedor) {
        Document filtro, update;
        UpdateResult resultado;
        boolean actualizar = false;
        try {
        filtro = new Document("id_proveedor", proveedor.getIdProveedor());
        update = new Document("$set", new Document("proveedor", proveedor.getProveedor())
                .append("marca", proveedor.getMarca())
                .append("nombreProducto", proveedor.getNombreProducto())
                .append("fechaPago", proveedor.getFechaPago())); 
        resultado = coleccionProveedor.updateOne(filtro, update);

        if (resultado.getModifiedCount() > 0) {
            actualizar = true;
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar datos " + ex.getMessage());
    } finally {
        cierreConexion();
    }
        return actualizar;
    }

    @Override
    public Proveedor BuscarProveedor(int idProveedor) {
    Proveedor proveedor = null;
    Document filtro = null, resultado = null, perfil = null;
    try {
        filtro = new Document("id_proveedor", idProveedor);
        resultado = coleccionProveedor.find(filtro).first();

        if (resultado != null) {
            proveedor = new Proveedor();
            proveedor.setIdProveedor(resultado.getInteger("id_proveedor"));
            proveedor.setProveedor(resultado.getString("proveedor"));
            proveedor.setMarca(resultado.getString("marca"));
            proveedor.setNombreProducto(resultado.getString("nombreProducto"));
            proveedor.setFechaPedido(resultado.getString("fechaPedido"));
            proveedor.setFechaPago(resultado.getString("fechaPago"));
            proveedor.setCancelado(resultado.getBoolean("cancelado", false)); 

            perfil = coleccionPerfil.find(eq("id_perfil", resultado.getInteger("id_perfil"))).first();
            if (perfil != null) {
               
               proveedor.setNombrePerfil(perfil.getString("nombrePerfil"));
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar datos según ID: " + ex.getMessage());
    } finally {
        cierreConexion();
    }
    return proveedor;
}



    @Override
    public boolean ActualizarStock(Proveedor proveedor) {
       
    boolean actualizado = false;
    
    try {
        Document filtro = new Document("id_proveedor", proveedor.getIdProveedor());
        Document update = new Document("$set", new Document("cantidad", proveedor.getCantidad())); // Ajusta el nombre del campo según tu estructura

        UpdateResult resultado = coleccionProveedor.updateOne(filtro, update);

        if (resultado.getModifiedCount() > 0) {
            actualizado = true;
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar stock: " + ex.getMessage());
    } finally {
        cierreConexion();
    }

    return actualizado;
}

    
  private void cierreConexion() {
        try {
            conn.getMongo().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }
}
