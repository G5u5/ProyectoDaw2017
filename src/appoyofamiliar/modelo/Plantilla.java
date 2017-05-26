/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import java.util.*;

/**
 *
 * @author Jesús Durántez Prieto
 */

public class Plantilla {
    private static LinkedList<Usuario> listaPlantilla;
    
    public Plantilla(){
        listaPlantilla = new LinkedList<Usuario>();
    }
    
    public void nuevoUsuario(Usuario u){
        
        listaPlantilla.add(u);
    }
        
    public Usuario getUsuario(int indice){
        return listaPlantilla.get(indice);
    }
    
    public static Usuario getUsuarioDni(String denei){
        Usuario encontrado = null;
        
        for (int i = 0; i < listaPlantilla.size(); i++){
            if (listaPlantilla.get(i).getDni().equals(denei)){
                encontrado = listaPlantilla.get(i);
            }
        }
        return encontrado;
    }
    
    public void borrarUsuario(int indice){
        listaPlantilla.remove(indice);
    }
    
    public void borrarUsuario(Usuario usuario){
        listaPlantilla.remove(usuario);
    }
    
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[listaPlantilla.size()][6];
        for (int i = 0; i < listaPlantilla.size(); i++){
            tabla[i][0]= listaPlantilla.get(i).getIdentificador();
            tabla[i][1]= listaPlantilla.get(i).getNombre();
            tabla[i][2]= listaPlantilla.get(i).getApellidos();
            tabla[i][3]= listaPlantilla.get(i).getDni();
            tabla[i][4]= listaPlantilla.get(i).getTelefono();
            tabla[i][5]= listaPlantilla.get(i).getDireccion();
        }
        return tabla;
    }
}