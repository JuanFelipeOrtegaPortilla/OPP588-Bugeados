/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Perfil;

/**
 *
 * @author PIPE
 */
public interface IPerfil {
    public List<Perfil> ListarPerfil();
    public boolean InsetarPerfil(Perfil perfil);
    public boolean ActualizarPerfil(Perfil perfil);
    public boolean EliminarPerfil(int idperfil);
    public Perfil BuscarIdPerfil( int idPerfil);
}
