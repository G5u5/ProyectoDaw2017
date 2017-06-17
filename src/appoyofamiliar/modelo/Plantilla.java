/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import appoyofamiliar.controlador.SQLUsuarios;
import java.util.*;

/**
 *
 * @author Jesús Durántez Prieto
 */

public class Plantilla {
    private LinkedList<Usuario> listaPlantilla;
    private static Plantilla instancia;
    
    private Plantilla(){
        listaPlantilla = SQLUsuarios.instancia().descargarDatosU();
    }
    
    public static Plantilla instancia(){
        if (instancia == null){
            instancia = new Plantilla();
        }
        return instancia;
    }
    
    public void nuevoUsuario(Usuario u){
        u.setControl("insertar");
        listaPlantilla.add(u);
    }
    
    /**
     * Cambia el control del usuario para ser borrado a la hora de guardar la
     * informacion en la base de datos.
     */
    public void borrarUsuario(String ident){
        listaPlantilla.get(obtenerPosicionUsuario(ident)).setControl("borrar");
    }
    
    public void modificarJefe(String identificador){
        
    }
    
    //--------------------------------------------------------------------------
    //------- GETTERS
    //--------------------------------------------------------------------------
    
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[listaPlantilla.size()][6];
        for (int i = 0; i < listaPlantilla.size(); i++){
            if (!listaPlantilla.get(i).getControl().equals("borrar")){
                tabla[i][0]= listaPlantilla.get(i).getIdentificador();
                tabla[i][1]= listaPlantilla.get(i).getNombre();
                tabla[i][2]= listaPlantilla.get(i).getApellidos();
                tabla[i][3]= listaPlantilla.get(i).getDni();
                tabla[i][4]= listaPlantilla.get(i).getTelefono();
                tabla[i][5]= listaPlantilla.get(i).getDireccion();
            }
        }
        return tabla;
    }

    public LinkedList<Usuario> getPlantilla() {
        return listaPlantilla;
    }
    
    public Usuario getUsuario(String ident){
        if (obtenerPosicionUsuario(ident) >= 0){
            return listaPlantilla.get(obtenerPosicionUsuario(ident));
        } else {
            return null;
        }
    }
    
    //--------------------------------------------------------------------------
    //------- OTROS MÉTODOS
    //--------------------------------------------------------------------------
    
    private int obtenerPosicionUsuario(String id){
        for( int i = 0; i<listaPlantilla.size(); i++){
            if (listaPlantilla.get(i).getIdentificador().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
    public Usuario buscarUsuario(String id){
        Usuario us = null;
        boolean bandera = true;
        for (int i = 0; i < listaPlantilla.size() && bandera; i++){
            if (listaPlantilla.get(i).getIdentificador().toLowerCase().equals(id.toLowerCase())){
                us = listaPlantilla.get(i);
                bandera = false;
            }
        }
        return us;
    }
}