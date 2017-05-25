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
    private LinkedList<Salida> salidas = new LinkedList<Salida>();
    
    public void mostrar(){
       Iterator lista = salidas.iterator();
       Salida marcado = (Salida) lista.next();
       while (lista.hasNext()){
           System.out.println("Nombre del empleado: " + marcado.getEmpleado());
           System.out.println("Nombre del paciente: " + marcado.getPaciente());
           System.out.println("Nombre del médico: " + marcado.getMedico());
           System.out.println("Especialidad: " + marcado.getEspecialidad());
           System.out.println("Centro: " + marcado.getCentro());
           System.out.println("Descripción de la salida: " + marcado.getDescripcion());
           System.out.println("Transporte utilizado: " + marcado.getTransporte());
           System.out.println("Fecha de inicio: " + marcado.getFechaInicio());
           System.out.println("Fecha de finalización: " + marcado.getFechaFin());
       }
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
        
    public Date obtenerFecha(String fecha) {
        Date testDate = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("DD/MM/YYYY");
        Date retorno = null;
        
        try{
            testDate = formatoFecha.parse(fecha);
        } catch (Exception e){ System.out.println("Formato no válido.");}

        if (!formatoFecha.format(testDate).equals(fecha)){
            System.out.println("Fecha no válida.");
            
        } else {
            System.out.println("Fecha válida.");
            retorno = testDate;
        }
        
        return retorno;
    }
    
    public void borrarSalida(int indice){
        salidas.remove(indice);
    }
    
    public void modificarSalida(int indice){
        Empleado empleado;
        String medico;
        String especialidad;
        String centro;
        String descripcion;
        String transporte;
        String fecha;
        Date fechaInicio = null;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Modifica los datos de la salida.");
        System.out.println("");
        
        System.out.println("DNI del empleado:");
        String emple = teclado.nextLine();
        empleado = (Empleado) Plantilla.getUsuarioDni(emple);
        System.out.println("Nombre del médico:");
        medico = teclado.nextLine();
        System.out.println("Especialidad de la consulta");
        especialidad = teclado.nextLine();
        System.out.println("Centro médico:");
        centro = teclado.nextLine();
        System.out.println("Descripción de la salida:");
        descripcion = teclado.nextLine();
        System.out.println("Transporte utilizado");
        transporte = teclado.nextLine();
        System.out.println("Fecha de inicio de salida (dd/mm/yyyy):");
        fecha = teclado.nextLine();
        fechaInicio = obtenerFecha(fecha);
        
        salidas.get(indice).actualizarDatos(empleado, medico, especialidad, centro, descripcion, transporte, fechaInicio);
    }
    
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[salidas.size()][9];
        for (int i = 0; i < salidas.size(); i++){
            tabla[i][0]= salidas.get(i).obtenerDatos()[1];
            tabla[i][1]= salidas.get(i).Paciente.getNombre();
            tabla[i][2]= salidas.get(i).getMedico();
            tabla[i][3]= salidas.get(i).getEspecialidad();
            tabla[i][4]= salidas.get(i).getCentro();
            tabla[i][5]= salidas.get(i).getDescripcion();
            tabla[i][6]= salidas.get(i).getTransporte();
            tabla[i][7]= salidas.get(i).getFechaInicio();
            tabla[i][8]= salidas.get(i).getFechaFin();
        }
        return tabla;
    }
}
