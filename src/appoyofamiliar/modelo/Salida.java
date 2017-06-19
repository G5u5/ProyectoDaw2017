/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;


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
    private String fechaInicio;
    private String fechaFin;
    private String control; //mantener, modificar, borrar, insertar

    public Salida(Empleado empleado, Paciente paciente, String medico, String especialidad, String centro, String area, String descripcion, String transporte, String fechaInicio) {
        this.empleado = empleado;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.centro = centro;
        this.area = area;
        this.descripcion = descripcion;
        this.transporte = transporte;
        this.fechaInicio = fechaInicio;
        this.control = "mantener";
    }
    
    /**
     * Se introduce una fecha de finalización para una de las salidas
     * @param fechaFin
     */
    public void cerrarSalida(String fechaFin){
        this.fechaFin = fechaFin;
        if (!(this.control.equals("insertar"))){
            this.control = "modificar";
        }
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
    public void actualizarDatos(String medico, String especialidad, String centro, String descripcion, String transporte) {
        this.medico = medico;
        this.especialidad = especialidad;
        this.centro = centro;
        this.descripcion = descripcion;
        this.transporte = transporte;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCentro() {
        return centro;
    }

    public String getArea() {
        return area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTransporte() {
        return transporte;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getControl() {
        return control;
    }
    
    /**
     * mantener, modificar, borrar, insertar
     */
    public void setControl(String c){
        this.control = c;
    }
}
