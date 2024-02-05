
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IDC
 */
public class Conexion {
    private MongoClient mongo;
    private MongoDatabase dataB;

    public Conexion(MongoClient mongo, MongoDatabase dataB) {
        this.mongo = mongo;
        this.dataB = dataB;
    }

    public Conexion() {
    }
    

    public Conexion crearConexion() {
        String servidor = "localhost";
        int puerto = 27017;

        try {
            mongo = new MongoClient(servidor, puerto) {};
            dataB = mongo.getDatabase("db_panaderia");
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en a conexion a Mongo db error: "+ ex.toString());
        }

        return new Conexion(mongo, dataB);

    }

    public MongoClient getMongo() {
        return mongo;
    }

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }

    public MongoDatabase getDataB() {
        return dataB;
    }

    public void setDataB(MongoDatabase dataB) {
        this.dataB = dataB;
    }
}
