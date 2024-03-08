/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.MetodosExtras;
import java.util.List;
import modelo.Extras;

/**
 *
 * @author PIPE
 */
public class ExtrasServicio {
     public List<Extras> ListarExtas(){
         return new MetodosExtras().ListarExtas();
     }
    public boolean InsetarExtras(Extras extras){
        return new MetodosExtras().InsetarExtras(extras);
    }
    public Extras BuscarIdExtras( int idExtras){
        return new MetodosExtras().BuscarIdExtras(idExtras);
    }
}
