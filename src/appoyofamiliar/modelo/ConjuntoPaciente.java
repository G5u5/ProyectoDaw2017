/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;
import java.util.*;
/**
 *
 * @author Felipe José Ruiz
 */
public class ConjuntoPaciente {
  private static LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
   
    /**
     *Itera la lista para mostrar cada atributo del objeto paciente de la lista \n
     * El 
     */
    public void mostrar(){
       Iterator lista = pacientes.iterator();
       Paciente marcado = (Paciente) lista.next();
       while (lista.hasNext()){
           System.out.println("Nombre: " + marcado.getNombre());
           System.out.println("Apellidos " + marcado.getApellidos());
           System.out.println("DNI: " + marcado.getDni());
           System.out.println("Teléfono: " + marcado.getTelefonoFamilia());
           System.out.println("Centro: " + marcado.getCentro());
       }
   }

    /**
     *Introduce por medio de Scanner los datos de un nuevo paciente e incluye
     * el paciente al final de la lista.
     */
    public void nuevoPaciente(){
       Scanner teclado = new Scanner(System.in);
       System.out.println("Introducir nombre del paciente");
       String nombre = teclado.nextLine();
       System.out.println("Introducir apellidos del paciente");
       String apellidos = teclado.nextLine();
       System.out.println("Introducir DNI del paciente");
       String dni = teclado.nextLine();
       System.out.println("Introducir telefono de contacto con los familiares");
       String telefonoFamilia = teclado.nextLine();
       System.out.println("Introducir centro de residencia");
       String centro = teclado.nextLine();
       pacientes.push(new Paciente(nombre, apellidos, dni, telefonoFamilia, centro));
   }

    /**
     *devuelve el paciente alojado en la posición del indice establecido
     * @param indice
     * @return
     */
    public Paciente getPaciente (int indice) {
       return pacientes.get(indice);
   }
     public static Paciente getPacienteDni(String denei){
        Paciente encontrado = null;
        
        for (int i = 0; i < pacientes.size(); i++){
            if (pacientes.get(i).getDni().equals(denei)){
                encontrado = pacientes.get(i);
            }
        } 
        
        return encontrado;
    }
    /**
     *elimina el paciente de la lista con el indice establecido 
     * @param indice
     * @return
     */
    public Paciente borrarPaciente(int indice){
       return pacientes.remove(indice);
   }

    /**
     *Actualiza los datos del paciente selecionado por el indice de la lista
     * @param indice
     */
    public void modificarPaciente(int indice){
       Scanner modifica = new Scanner(System.in);
       System.out.println("Nuevo nombre del paciente:");
       String nombre = modifica.nextLine();
       System.out.println("Nuevo apellido del paciente:");
       String apellidos = modifica.nextLine();
       System.out.println("Nuevo telefono de contacto familiar");
       String telefono = modifica.nextLine();
       System.out.println("Nuevo centro de ingreso");
       String centro = modifica.nextLine();
       getPaciente(indice).actualizarDatos(nombre, apellidos, telefono, centro);
   }
   
    /**
     *Se recorre la lista y devuelve los datos en formato de matriz de Strings
     * @return
     */
    public String [][] obtenerDatosTabla() {
        String [][] arrayStock = new String [pacientes.size()][5];
        for (int indice = 0; indice < pacientes.size(); indice++  )  {
            Paciente paciente = pacientes.get(indice);
            arrayStock[indice][0] = paciente.getNombre();
            arrayStock[indice][1] = paciente.getApellidos();
            arrayStock[indice][2] = paciente.getDni();
            arrayStock[indice][3] = paciente.getTelefonoFamilia();
            arrayStock[indice][4] = paciente.getCentro();
        }      
        return arrayStock;
    }
}
