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
    private LinkedList listaPlantilla;
    
    public Plantilla(){
        listaPlantilla = new LinkedList();
    }
    
    /**
     *Genera un iterador que recorre la LinkedList, mostrando cada elemento encontrado.
     */
    public void mostrar(){
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
            System.out.println("No existe un registro de usuarios actualmente.");
            System.out.println("¿Desea iniciar la creacion de usuarios? [si/no]");
            String opcion = teclado.nextLine();
            switch (opcion){
                case "si":
                    nuevoUsuario();
                    break;
                case "no":
                    
                    break;
            }
        }
    }
    
    public void nuevoUsuario(){
        
    }
    
    public void borrarUsuario(int indice){
        listaPlantilla.remove(indice);
    }
    
    public void modificarUsuario(int indice){
        ((Usuario) listaPlantilla.get(indice)).modificarDatos();
    }
}
