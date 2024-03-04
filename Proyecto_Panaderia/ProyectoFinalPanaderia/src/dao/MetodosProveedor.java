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
    private MongoCollection<Document> coleccion;
    private MongoCollection<Document> coleccion2;

    public MetodosProveedor() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("proveedores");
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
    public List<Proveedor> ListaProveedor() {
                List<Proveedor> listaProveedores = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccion.find();
            for (Document temp : documentos) {
                Proveedor proveedor = new Proveedor();

                proveedor.setIdProveedor(generarID());
                proveedor.setProveedor(temp.getString("nombreCliente"));
                proveedor.setMarca(temp.getString("telefono"));
                proveedor.setFechaPedido(temp.getDate("fechaCompra"));
                proveedor.setFechaPago(temp.getDate("fechaPago"));
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
    /*
     private int idProveedor;
    private String Proveedor;
    private String marca;
    private String nombreProducto;
    private int cantidad;
    private Date fechaPedido;
    private Date fechaPago;
    private boolean cancelado;
    */

    @Override
    public boolean InsetarProveedor(Proveedor proveedor) {

    }

    @Override
    public boolean ActualizarProveedor(Proveedor proveedor) {

    }

    @Override
    public Proveedor BuscarProveedor(int idProveedor) {

    }

    @Override
    public boolean ActualizarStock(Proveedor proveedor) {

    }

}
