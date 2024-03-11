package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Perfil;
import org.bson.Document;


public class MetodosPerfil implements IPerfil {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public MetodosPerfil() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("perfil");
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
    public List<Perfil> ListarPerfil() {
        List<Perfil> listaPerfil = new ArrayList<>();
        FindIterable<Document> documentos;

        try {
            documentos = coleccion.find();
            for (Document temp : documentos) {
                Perfil perfil = new Perfil();
                perfil.setId_perfil(temp.getInteger("id_perfil"));
                perfil.setNombrePerfil(temp.getString("nombrePerfil"));
                perfil.setTipoUsuario("tipoUsuario");
                listaPerfil.add(perfil);
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaPerfil;
    }

   
    @Override
    public Perfil BuscarIdPerfil(int idPerfil) {
        Perfil perfil = null;
        Document filtro = null;
        Document resultado = null;

        try {
            filtro = new Document("id_perfil", idPerfil);
            resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                perfil = new Perfil();
                perfil.setId_perfil(resultado.getInteger("id_perfil"));
                perfil.setNombrePerfil(resultado.getString("nombrePerfil"));
                perfil.setTipoUsuario(resultado.getString("descripcion"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el perfil con ID " + idPerfil + ": " + ex.getMessage());
        } finally {
            cerrarConexion();
        }

        return perfil;
    }

  
    @Override
    public boolean InsetarPerfil(Perfil perfil) {
        Document documento;
        try {
            documento = new Document("id_perfil", perfil.getId_perfil())
                    .append("nombrePerfil", perfil.getNombrePerfil())
                    .append("tipoUsuario", perfil.getTipoUsuario());

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
    public boolean ActualizarPerfil(Perfil perfil) {
        Document filtro = null;
        Document resultado = null;
        boolean actualizar = false;

        try {
            filtro = new Document("id_perfil", perfil.getId_perfil());
            resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                perfil.setId_perfil(resultado.getInteger("id_perfil"));
                perfil.setNombrePerfil(resultado.getString("nombrePerfil"));
                perfil.setTipoUsuario(resultado.getString("tipoUsuario"));
                actualizar = true;
            }

        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + ex.toString());
        } finally {
            cerrarConexion();
        }

        return actualizar;
    }

    
    @Override
    public boolean EliminarPerfil(int idPerfil) {
        Document filtro = new Document("id_perfil", idPerfil);

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
}
