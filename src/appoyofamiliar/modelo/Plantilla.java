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
    private LinkedList<Usuario> listaPlantilla;
    
    public Plantilla(){
        listaPlantilla = new LinkedList<Usuario>();
    }
    
    /**
     *Genera un iterador que recorre la LinkedList, mostrando cada elemento encontrado.
     */
    public void mostrarPlantilla(){
        if (listaPlantilla != null){
            Iterator iterador = listaPlantilla.iterator();
            Usuario marcado = (Usuario) iterador.next();
            if(iterador.hasNext()){
                marcado.verDatosPropios();
            } else {
                System.out.println("No quedan más elementos.");
            }
        } else {
            Scanner teclado = new Scanner(System.in);
            String opcion = "";
            System.out.println("No existe un registro de usuarios actualmente.");
            System.out.println("¿Desea iniciar la creacion de usuarios? [si/no]");
            do{
                opcion = teclado.nextLine();
                switch (opcion){
                    case "si":
                        nuevoUsuario();
                        break;
                    case "no":
                        break;
                    default:
                        System.out.println("Introduzca una opción válida.");
                        System.out.println("¿Desea iniciar la creacion de usuarios? [si/no]");
                        break;
                }
            }while(!(opcion.toLowerCase().equals("si")) && !(opcion.toLowerCase().equals("no")));
        }
    }
    
    public void nuevoUsuario(){
        
    }
    
    
    public Usuario getUsuario(int indice){
        return listaPlantilla.get(indice);
    }
    
    public Usuario getUsuarioDni(String denei){
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
    
    public void modificarUsuario(int indice){
        listaPlantilla.get(indice).modificarDatos();
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