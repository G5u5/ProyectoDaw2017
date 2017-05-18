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
   LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
   
   public void mostrar(){
       System.out.println(pacientes);
   }
   public void nuevoPaciente(){
       Scanner teclado = new Scanner(System.in);
       String nombre = teclado.nextLine();
       String apellidos = teclado.nextLine();
       String dni = teclado.nextLine();
       String telefonoFamilia = teclado.nextLine();
       String centro = teclado.nextLine();
       pacientes.push(new Paciente(nombre, apellidos, dni, telefonoFamilia, centro));
   }
   public void borrarPaciente(){
       
   }
}
