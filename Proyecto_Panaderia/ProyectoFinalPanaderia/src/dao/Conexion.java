/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
/**
 *
 * @author PIPE
 */
public class Conexion {
    private MongoClient mongo;
    private MongoDatabase dataB;
    //getterss y constructor vacio

    public MongoClient getMongo() {
        return mongo;
    }

    public MongoDatabase getDataB() {
        return dataB;
    }

    public Conexion() {
    }
   
    public Conexion(MongoClient mongoClient, MongoDatabase database) {
        this.mongo = mongoClient;
        this.dataB = database;
    }

public Conexion crearConexion(){
    String servidor = "localhost";
    int puerto = 27017;
    try {
        mongo = new MongoClient(servidor, puerto);
        dataB = mongo.getDatabase("panaderia");
    //JOptionPane.showMessageDialog(null,"Conexion Exitosa");
    } catch (MongoException ex ) {
        JOptionPane.showMessageDialog(null, "Error en la conexion a MongoDB error:"+ex.toString());
    }
    return new Conexion(mongo,dataB);
    }
 }

