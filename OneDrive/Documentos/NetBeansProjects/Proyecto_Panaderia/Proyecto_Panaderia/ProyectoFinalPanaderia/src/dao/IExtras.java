/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Extras;

/**
 *
 * @author PIPE
 */
public interface IExtras {
    public List<Extras> ListarExtas();
    public boolean InsetarExtras(Extras extras);
    public Extras BuscarIdExtras( int idExtras);
}
