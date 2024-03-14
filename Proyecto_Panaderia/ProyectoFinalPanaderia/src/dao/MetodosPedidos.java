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
import com.mongodb.client.result.UpdateResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Pedidos;
import org.bson.Document;
import org.bson.types.Decimal128;

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

                pedido.setPedido(temp.getString("nombrePedido"));
                pedido.setProducto(temp.getString("producto"));
                Integer cantidad = temp.getInteger("cantidad");
                pedido.setCantidad(cantidad != null ? cantidad.intValue() : 0);
                pedido.setFechaPedido(temp.getString("fechaPedido"));
                pedido.setFechaEntrega(temp.getString("fechaEntrega"));
                pedido.setPrecio(temp.getDouble("precio"));
                pedido.setTotal(temp.getDouble("total"));
                Integer idPedido = temp.getInteger("idPedido");
                pedido.setPagado(temp.getBoolean("cancelado"));
                pedido.setIdPedido(idPedido != null ? idPedido.intValue() : 0);

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
            documento = new Document("idPedido", pedido.getIdPedido())
                    .append("nombrePedido", pedido.getPedido())
                    .append("producto", pedido.getProducto())
                    .append("cantidad", pedido.getCantidad())
                    .append("fechaPedido", pedido.getFechaPedido())
                    .append("fechaEntrega", pedido.getFechaEntrega())
                    .append("precio", pedido.getPrecio())
                    .append("total", pedido.getTotal())
                    .append("cancelado", pedido.isPagado());

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
    boolean actualizar = false;

    try {
        Document filtro = new Document("idPedido", pedido.getIdPedido());
        Document updateDocument = new Document();

       
        if (!pedido.getFechaEntrega().isEmpty()) {
            // Formatear la fecha de entrega al formato deseado
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaEntregaStr = dateFormat.format(pedido.getFechaEntrega());
            updateDocument.append("fechaEntrega", fechaEntregaStr);
        }

     
        updateDocument.append("pagado", pedido.isPagado());

        Document updateQuery = new Document("$set", updateDocument);

        UpdateResult result = coleccion.updateOne(filtro, updateQuery);

        if (result.getModifiedCount() > 0) {
            actualizar = true;
        }
    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.getMessage());
    }

    return actualizar;
}







    @Override
    public boolean EliminarPedido(int idPedido) {
        Document filtro = new Document("idPedido", idPedido);

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
            System.out.println("Buscando pedido con ID: " + idPedido);
            Document filtro = new Document("idPedido", idPedido);
            FindIterable<Document> resultados = coleccion.find(filtro);
            Document resultado = resultados.first();

            if (resultado != null) {
                pedido = new Pedidos();
                pedido.setPedido(resultado.getString("nombrePedido"));
                pedido.setProducto(resultado.getString("producto"));
                Integer cantidad = resultado.getInteger("cantidad");
                pedido.setCantidad(cantidad != null ? cantidad.intValue() : 0);

                String fechaPedido = resultado.getString("fechaPedido");
                String fechaEntrega = resultado.getString("fechaEntrega");

                pedido.setFechaPedido(fechaPedido);
                pedido.setFechaEntrega(fechaEntrega);

                pedido.setPrecio(resultado.getDouble("precio"));
                pedido.setTotal(resultado.getDouble("total"));
                pedido.setPagado(resultado.getBoolean("cancelado"));
            } else {
                System.out.println("No se encontraron resultados para el ID: " + idPedido);
            }
        } catch (MongoException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar datos: " + ex.toString());
        } finally {
            cerrarConexion();
        }

        return pedido;
    }

}
