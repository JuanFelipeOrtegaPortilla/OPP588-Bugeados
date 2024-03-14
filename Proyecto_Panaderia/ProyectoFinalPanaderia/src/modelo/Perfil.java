/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PIPE
 */
public class Perfil {

    private  int id_perfil;
    private String nombrePerfil;
    private String tipoUsuario;
    private int clave;
    private String descripcion;

    public Perfil() {
    }

    public Perfil(int id_perfil, String nombrePerfil, String tipoUsuario, int clave, String descripcion) {
        this.id_perfil = id_perfil;
        this.nombrePerfil = nombrePerfil;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public Perfil(int id_perfil, String nombrePerfil, String descripcion) {
        this.id_perfil = id_perfil;
        this.nombrePerfil = nombrePerfil;
        this.descripcion = descripcion;
    }

    public Perfil(String nombrePerfil, String tipoUsuario, int clave, String descripcion) {
        this.nombrePerfil = nombrePerfil;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

   
    
    @Override
    public String toString() {
        return "Perfil{" + "id_perfil=" + id_perfil + ", nombrePerfil=" + nombrePerfil + ", tipoUsuario=" + tipoUsuario + '}';
    }

   
   
}

    