/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import java.util.Date;

/**
 *
 * @author Trinidad Ibáñez
 */
public class Salida {
    private Empleado empleado;
    private Paciente paciente;
    private String medico;
    private String especialidad;
    private String centro;
    private String area;
    private String descripcion;
    private String transporte;
    private Date fechaInicio;
    private Date fechaFin;

    public Salida(Empleado empleado, Paciente paciente, String medico, String especialidad, String centro, String area, String descripcion, String transporte, Date fechaInicio, Date fechaFin) {
        this.empleado = empleado;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.centro = centro;
        this.area = area;
        this.descripcion = descripcion;
        this.transporte = transporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    /**
     *Muestra los datos de las salidas
     */
    public void mostrar(){
        System.out.println("Empleado a cargo:" + empleado);
        System.out.println("Paciente:" + paciente);
        System.out.println("Médico responsable:" + medico);
        System.out.println("Especialidad de la consulta:" + especialidad);
        System.out.println("Centro médico:" + centro);
        System.out.println("Área:" + area);
        System.out.println("Descripción de la salida:" + descripcion);
        System.out.println("Transporte utiliazdo:" + transporte);
        System.out.println("Fecha de salida:" + fechaInicio);
        System.out.println("Fecha de vuelta:" + fechaFin);
    }
    
    /**
     * Se introduce una fecha de finalización para una de las salidas
     * @param fechaFin
     */
    public void cerrarSalida(Date fechaFin){
        this.fechaFin = fechaFin;
    }
       
    /**
     * Actualzia algunos datos de la salida
     * @param empleado
     * @param medico
     * @param especialidad
     * @param centro
     * @param descripcion
     * @param transporte
     * @param fechaInicio
     */
    public void actualizarDatos(Empleado empleado, String medico, String especialidad, String centro, String descripcion, String transporte, Date fechaInicio) {
        this.empleado = empleado;
        this.medico = medico;
        this.especialidad = especialidad;
        this.centro = centro;
        this.descripcion = descripcion;
        this.transporte = transporte;
        this.fechaInicio = fechaInicio;
    }
}
