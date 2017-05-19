/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import java.util.*;
/**
 *
 * @author Trinidad Ibáñez
 */
public class ConjuntoSalida {
    private LinkedList salidas = new LinkedList();
    
    public void mostrar(){
        System.out.println("");
    }
    
    public void mostrarPaciente(String paciente){
        System.out.println("");
    }
    
    public void mostrarEmpleado(String empleado){
        System.out.println("");
    }
    
    public void nuevaSalida(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los datos de la nueva salida.");
        System.out.println(":");
        for(int i = 0; i<obtenerDatosTabla().length; i++){
            System.out.print(i + ".-");
            for(int j = 0; j<tabla[i].length; j++){
                System.out.print(j);
            }
            System.out.println("");
        }
        Empleado empleado = (Empleado) Plantilla.getUsuario(emple);
        System.out.println("Nombre del paciente");
        String paciente = teclado.nextLine();
        
        System.out.println("Nombre del médico:");
        String medico = teclado.nextLine();
        System.out.println("Especialidad de la consulta");
        String especialidad = teclado.nextLine();
        System.out.println("Centro médico:");
        String centro = teclado.nextLine();
        System.out.println("Área a la que pertenece:");
        String area = teclado.nextLine();
        System.out.println("Descripción de la salida:");
        String descripcion = teclado.nextLine();
        System.out.println("Transporte utilizado");
        String transporte = teclado.nextLine();
        System.out.println("Fecha de inicio de salida:");
        
        salidas.add(new Salida(empleado, paciente, medico, especialidad, centro, area, descripcion, transporte, fechaInicio));
        (Empleado empleado, Paciente paciente, String medico, String especialidad, String centro, String area, String descripcion, String transporte, Date fechaInicio)
    }
}
