/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;
import java.lang.reflect.Array;
import java.util.*;
/**
 *
 * @author Felipe José Ruiz
 */
public class ConjuntoPaciente {
   LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
   
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
    public Paciente getPaciente (int indice) {
       return pacientes.get(indice);
    
}
    
   public Paciente borrarPaciente(int indice){
       return pacientes.remove(indice);
   }
   
   public void obtenerDatosTabla(){
       
   }
}
