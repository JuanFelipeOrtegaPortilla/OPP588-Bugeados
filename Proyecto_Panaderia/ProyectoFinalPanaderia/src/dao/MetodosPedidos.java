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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Pedidos;
import org.bson.Document;

/**
 *
 * @author PIPE
 */
public class MetodosPedidos implements IPedidos {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public MetodosPedidos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("pedidos");
            
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
    public List<Pedidos> ListarPedidos() {
        List<Pedidos> listaPedido = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccion.find();
            for (Document temp : documentos) {
                Pedidos pedido = new Pedidos();

                pedido.setIdProducto(temp.getInteger("idProducto"));
                pedido.setProducto(temp.getString("producto"));
                pedido.setCantidad(temp.getInteger("cantidad"));

              
                Date fechaPedido = temp.getDate("fechaPedido");
                Date fechaEntrega = temp.getDate("fechaEntrega");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                pedido.setFechaPedido(dateFormat.format(fechaPedido));
                pedido.setFechaEntrega(dateFormat.format(fechaEntrega));

                pedido.setPrecio(temp.getDouble("precio"));
                pedido.setTotal(temp.getDouble("total"));
                listaPedido.add(pedido);
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaPedido;
    }

    @Override
    public boolean InsetarPedido(Pedidos pedido) {
        Document documento;
        try {
            documento = new Document("idProducto", pedido.getIdProducto())
                    .append("producto", pedido.getProducto())
                    .append("cantidad", pedido.getCantidad())
                    .append("fechaPedido", pedido.getFechaPedido())
                    .append("fechaEntrega", pedido.getFechaEntrega())
                    .append("precio", pedido.getPrecio())
                    .append("total", pedido.getTotal());
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
    public boolean ActualizarPedidos(Pedidos pedido) {
        Document filtro = null;
        Document resultado = null;
        boolean actualizar = false;

        try {
            filtro = new Document("idPedido", pedido.getIdPedido());
            resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                // Obtener la fecha de entrega como Date
                Date fechaEntregaDate = resultado.getDate("fechaEntrega");

                // Convertir la fecha de entrega a String usando SimpleDateFormat
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fechaEntregaString = dateFormat.format(fechaEntregaDate);

                // Asignar la fecha de entrega como String al objeto Pedidos
                pedido.setFechaEntrega(fechaEntregaString);

                // Realizar otras operaciones si es necesario
                actualizar = true;
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.getMessage());
        }

        return actualizar;
    }

    @Override
    public boolean EliminarPedido(int idPedido) {
        Document filtro = new Document("idProducto", idPedido);

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
    public Pedidos BuscarIdPedido(int idPedido) {
        Pedidos pedido = null;

        try {
            Document filtro = new Document("idProducto", idPedido);
            FindIterable<Document> resultados = coleccion.find(filtro);
            Document resultado = resultados.first();

            if (resultado != null) {
                pedido = new Pedidos();
                pedido.setIdProducto(resultado.getInteger("idProducto"));
                pedido.setProducto(resultado.getString("producto"));
                pedido.setCantidad(resultado.getInteger("cantidad"));

                
                Date fechaPedido = resultado.getDate("fechaPedido");
                Date fechaEntrega = resultado.getDate("fechaEntrega");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                pedido.setFechaPedido(dateFormat.format(fechaPedido));
                pedido.setFechaEntrega(dateFormat.format(fechaEntrega));

                pedido.setPrecio(resultado.getDouble("precio"));
                pedido.setTotal(resultado.getDouble("total"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar datos:" + ex.toString());
        } finally {
            cerrarConexion();
        }

        return pedido;
    }

}
