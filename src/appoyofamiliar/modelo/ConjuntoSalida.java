/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import java.text.SimpleDateFormat;
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
        System.out.println("");
        
        System.out.println("DNI del empleado:");
        String emple = teclado.nextLine();
        Empleado empleado = (Empleado) Plantilla.getUsuarioDni(emple);
        System.out.println("DNI del paciente:");
        String pacient = teclado.nextLine();
        Paciente paciente = (Paciente) ConjuntoPaciente.getPacienteDni(pacient);
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
        System.out.println("Fecha de inicio de salida (dd/mm/yyyy):");
        String fecha = teclado.nextLine();
        obtenerFecha(fecha);
    }
        
    public void obtenerFecha(String fecha) {
        Date testDate = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            
        try{
            testDate = formatoFecha.parse(fecha);
        } catch (Exception e){ System.out.println("invalid format");}

        if (!formatoFecha.format(testDate).equals(fecha)){
            System.out.println("Fecha invalida");
            
        } else {
            System.out.println("Fecha valida: ");
        }
    }
}
