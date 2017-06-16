/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;
import java.util.Scanner;
/**
 *
 * @author Felipe José Ruiz
 */
public class Paciente {
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefonoFamilia;
    private String centro;
    private String control;//"mantener", "modificar", "borrar", "insertar"
    
    //--------------------------------------------------------------------------
    //------- CONSTRUCTOR
    //--------------------------------------------------------------------------
    
    public Paciente(String nombre, String apellidos, String dni, String telefonoFamilia, String centro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefonoFamilia = telefonoFamilia;
        this.centro = centro;
        this.control = "mantener";
    }
    
    //--------------------------------------------------------------------------
    //------- MANEJO DE DATOS
    //--------------------------------------------------------------------------
    /**
     *Re-escribe los datos del paciente sustituyendolos
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param centro
     */
    public void actualizarDatos(String nombre, String apellidos, String telefono, String centro){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefonoFamilia = telefono;
        this.centro = centro;
        this.control = "modificar";
    }

    //--------------------------------------------------------------------------
    //------- GETTERS
    //--------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefonoFamilia() {
        return telefonoFamilia;
    }

    public String getCentro() {
        return centro;
    }

    public String getControl() {
        return control;
    }
    
    //--------------------------------------------------------------------------
    //------- SETTERS
    //--------------------------------------------------------------------------
    
    /**
     * "mantener", "modificar", "borrar", "insertar"
     */
    public void setControl(String c){
        this.control = c;
    }
}
