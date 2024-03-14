/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Extras;
import org.bson.Document;

/**
 *
 * @author PIPE
 */
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MetodosExtras implements IExtras {
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public MetodosExtras() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("extras");
        }
    }

    private void cerrarConexion() {
        try {
            conn.getMongo().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.toString());
        }
    }



@Override
public List<Extras> ListarExtas() {
    List<Extras> listaExtras = new ArrayList<>();
    FindIterable<Document> documentos;

    try {
        documentos = coleccion.find();
        for (Document temp : documentos) {
            Extras extras = new Extras();

            extras.setIdExtras(temp.getInteger("idExtras"));
       

            extras.setProductos(temp.getString("producto"));
    

            extras.setCantidad(temp.getInteger("cantidad"));


            String fechaPagoStr = temp.getString("fechaPago");
            extras.setFechaPago(fechaPagoStr);


            extras.setPrecioUnitario(temp.getDouble("precioUnitario"));


            extras.setTotal(temp.getDouble("total"));

            listaExtras.add(extras);
        }
    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
    } finally {
        cerrarConexion();
    }

    return listaExtras;
}



@Override
public boolean InsetarExtras(Extras extras) {
    Document documento;
    try {
        documento = new Document("idExtras", extras.getIdExtras())
                .append("producto", extras.getProductos())
                .append("precioUnitario", extras.getPrecioUnitario())
                .append("cantidad", extras.getCantidad())
                .append("total", extras.getTotal())  
                .append("fechaPago", extras.getFechaPago());

        coleccion.insertOne(documento);
        System.out.println("Datos insertados correctamente.");
    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error al insertar datos: " + ex.getMessage());
        return false;
    } finally {
        cerrarConexion();
    }
    return true;
}


@Override
public Extras BuscarIdExtras(int idExtras) {
    Extras extras = null;
    try {
        Document filtro = new Document("idExtras", idExtras);
        FindIterable<Document> resultados = coleccion.find(filtro);
        Document resultado = resultados.first();

        if (resultado != null) {
            extras = new Extras();
            extras.setIdExtras(resultado.getInteger("idExtras"));
            extras.setProductos(resultado.getString("producto"));
            extras.setPrecioUnitario(resultado.getDouble("precioUnitario"));
            extras.setCantidad(resultado.getInteger("cantidad"));
            extras.setTotal(resultado.getDouble("total"));

            String fechaPagoStr = resultado.getString("fechaPago");
            Date fechaPago = convertirStringAFecha(fechaPagoStr);
            extras.setFechaPago(fechaPagoStr);

            System.out.println("Búsqueda exitosa. Detalles del resultado: " + extras);
        } else {
            System.out.println("No se encontró ningún documento con ID: " + idExtras);
        }
    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar datos: " + ex.getMessage());
    } finally {
        cerrarConexion();
    }
    return extras;
}



    private Date convertirStringAFecha(String fechaStr) {
        try {
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

