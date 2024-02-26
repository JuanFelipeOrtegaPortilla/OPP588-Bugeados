/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Producto;
import org.bson.Document;



/**
 *
 * @author PIPE
 */
public class MetodoProducto implements IProducto{
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    
    
     public MetodoProducto() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("productos");
        }
    }

    private void cerrarConexion() {
        try {
            conn.getMongo().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.toString());
        }
    }
    private int generarID(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(900) + 100;
        return numeroAleatorio;
    }
    
    @Override
    public List<Producto> ListaProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccion.find();
            for (Document temp : documentos) {
                Producto producto = new Producto();
   
                producto.setIdProducto(generarID());
                producto.setNombreProducto(temp.getString("nombreProducto"));
                producto.setMarca(temp.getString("marca"));
                producto.setCantidad(Integer.getInteger("cantidad"));
                producto.setPrecio(temp.getDouble("precio"));
                listaProductos.add(producto);
                
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaProductos;
    }

    @Override
    public boolean InsetarProductos(Producto producto) {
       Document documento;
        try {
            documento = new Document("idProducto", generarID())
                    .append("nombreProducto", producto.getNombreProducto())
                    .append("marca", producto.getMarca())
                    .append("cantidad", 0)
                    .append("precio", producto.getPrecio());
            

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
    public boolean ActualizarProductos(Producto producto) {
       Document filtro = null;
    Document resultado = null;
    boolean actualizar = false;

    try {
        filtro = new Document("id_perfil", producto.getIdProducto());
        resultado = coleccion.find(filtro).first();

        if (resultado != null) {
            producto.setCantidad(resultado.getInteger("cantidad"));
            producto.setPrecio(resultado.getDouble("precio"));
           
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
    public boolean EliminarProductos(int idProduto) {
        Document filtro = new Document("idProducto", idProduto);

        try {
            DeleteResult resultado = coleccion.deleteOne(filtro);
            return resultado.getDeletedCount() > 0;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el perfil: " + ex.toString());
        } finally {
            cerrarConexion();
        }

        return false;
    }

    @Override
    public Producto BuscarProductos(int idProduto) {
         Producto producto = null;
        try {
            Document filtro = new Document("idProducto", idProduto);
            FindIterable<Document> resultados = coleccion.find(filtro);
            Document resultado = resultados.first();

            if (resultado != null) {
                producto = new Producto();
                producto.setIdProducto(resultado.getInteger("idProducto"));
                producto.setNombreProducto(resultado.getString("nombreProducto"));
                producto.setMarca(resultado.getString("marca"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCantidad(resultado.getInteger("cantidad"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar datos:" + ex.toString());
        } finally {
            cerrarConexion();
        }
        return producto;
    }
    }
    

 
    
    
  
