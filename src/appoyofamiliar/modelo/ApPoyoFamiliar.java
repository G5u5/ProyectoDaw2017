/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import appoyofamiliar.controlador.*;
import appoyofamiliar.vista.*;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class ApPoyoFamiliar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        (new LogginJFrame(SQLUsuarios.instancia().descargarDatosU())).setVisible(true);
        
        //COMENTAR este bloque para que cargue los datos desde la base de datos
        //NO BORRAR
        /*-------------CÓDIGO PARA PRUEBAS--------------------------------------
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        LinkedList<Salida> salidas = new LinkedList<Salida>();
        LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
        Jefe pepe = new Jefe("Pepe", "pepe", "Sr. Pepe", "Pepe de Pepe", "123456789P", "978456123", "Calle del señor Pepe", "Valladolid");
        Empleado pepito = new Empleado("Pepito", "pepi", "Sr. Pepito", "Pepito de Pepito", "987654321P", "978123456", "Calle del señor Pepito", "Palencia");
        Encargado pepote = new Encargado("Pepote", "pepo", "Sr. Pepote", "Pepote de Pe", "654987321P", "978415263", "Calle del señor Pepote", "Palencia" , "Norte");
        usuarios.add(pepe);
        usuarios.add(pepito);
        usuarios.add(pepote);
        ----------------------------------------------------------------------*/
         
        //usuarios = SQLUsuarios.instancia().descargarDatosU();
        
        /*----CÓDIGO PARA PROBAR QUE CADA OBJETO GUARDADO ES DE LA CLASE QUE LE CORRESPONDE------------
        for (int i=0; i< usuarios.size(); i++){
            if (usuarios.get(i) instanceof Encargado){
                System.out.println(i);
                System.out.println("EMPLEADO " + usuarios.get(i).getIdentificador());
            } else if (usuarios.get(i) instanceof Empleado){
                System.out.println(i);
                System.out.println("ENCARGADO " + usuarios.get(i).getIdentificador());
            } else if (usuarios.get(i) instanceof Jefe){
                System.out.println(i);
                System.out.println("BOSSSSSS " + usuarios.get(i).getIdentificador());
            }else {
                System.err.println("No tengo muy claras las cosas... :(");
            }
        }
        ----------------------------------------------------------------------------------------------*/
        
    }
    
    /**
     *Genera un iterador que recorre la LinkedList, mostrando cada elemento encontrado.
     */
    /*
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
    */
}
