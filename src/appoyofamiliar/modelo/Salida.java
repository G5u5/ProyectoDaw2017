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

    //--------------------------------------------------------------------------
    //--------- ATRIBUTOS
    //-------------------------------------------------------------------------- 
    
    private int codigoSalida;
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
    
    //--------------------------------------------------------------------------
    //--------- CONSTRUCTOR/ES
    //--------------------------------------------------------------------------
    
    public Salida(int cod, Empleado empleado, Paciente paciente, String medico, String especialidad, String centro, String area, String descripcion, String transporte, String fechaInicio) {
        this.codigoSalida = cod;
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
    
    //--------------------------------------------------------------------------
    //--------- MANEJO DE DATOS
    //--------------------------------------------------------------------------    
    
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
     * @param paciente
     * @param medico
     * @param especialidad
     * @param centro
     * @param descripcion
     * @param fi
     * @param transporte
     
     */
    public void actualizarDatos(Empleado empleado, Paciente paciente, String medico, String especialidad, String centro, String area, String descripcion, String transporte, String fechaInicio) {
        this.empleado = empleado;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.centro = centro;
        this.area = area;
        this.descripcion = descripcion;
        this.transporte = transporte;
        this.fechaInicio = fechaInicio;
        this.control = "modificar";
    }
    
    //--------------------------------------------------------------------------
    //--------- GETTERS
    //--------------------------------------------------------------------------
    
    public int getCodigo(){
        return this.codigoSalida;
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
    
    //--------------------------------------------------------------------------
    //--------- SETTERS
    //--------------------------------------------------------------------------

    public void setCodigoSalida(int codigoSalida) {
        this.codigoSalida = codigoSalida;
    }
    
    /**
     * mantener, modificar, borrar, insertar
     * @param control
     */
    public void setControl(String control){
        this.control = control;
    }
}
