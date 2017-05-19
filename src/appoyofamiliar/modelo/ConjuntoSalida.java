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
        System.out.println("Nombre del empleado:");
        String empleado = teclado.nextLine();
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
        Date fechaInicio = teclado.nextInt();
        salidas.add(new Salida(empleado, paciente, medico, especialidad, centro, area, descripcion, transporte, fechaInicio));
    }
}
