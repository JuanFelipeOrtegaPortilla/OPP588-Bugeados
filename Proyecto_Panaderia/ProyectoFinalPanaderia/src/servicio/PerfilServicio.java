/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.MetodosPerfil;
import java.util.List;
import modelo.Perfil;

/**
 *
 * @author PIPE
 */
public class PerfilServicio {
   public static List<Perfil> ListaPerfil(){
       return new MetodosPerfil().ListarPerfil(); 
   }
   public Perfil BuscarIdPerfil(int idPerfil){
       return new MetodosPerfil().BuscarIdPerfil(idPerfil);
   }
   public boolean InsetarPerfil(Perfil perfil){
       return new MetodosPerfil().InsetarPerfil(perfil);
   }
   public boolean ActualizarPerfil(Perfil perfil){
       return new MetodosPerfil().ActualizarPerfil(perfil);
   }
   public boolean EliminarPerfil(int idPerfil){
       return new MetodosPerfil().EliminarPerfil(idPerfil);
   }
   public Perfil BuscarPerfil( String nombre, String clave){
       return new MetodosPerfil().BuscarPerfil(nombre, clave);
   }
}
