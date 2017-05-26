/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class Empleado extends Usuario {
    
    private String localidad;
    
    /**
     * Creacion de usuario Empleado con todos los datos
     * @param identificador
     * @param clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Empleado(String identificador, String clave, String nombre, String apellidos, String dni, String telefono, String direccion, String localidad) {
        super(identificador, clave, nombre, apellidos, dni, telefono, direccion);
        this.localidad = localidad;
    }
    
    /**
     * Creacion de usuario Empleado sin identificador ni clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Empleado(String nombre, String apellidos, String dni, String telefono, String direccion, String localidad) {
        super(nombre, apellidos, dni, telefono, direccion);
        this.localidad = localidad;
    }
    
    /**
     * Modificar los datos del usuario Empleado
     * @param identificador
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     * @param localidad
     */
    public void modificarDatos(String identificador, String nombre, String apellidos, String dni, String telefono, String direccion, String localidad){
        super.modificarDatos(identificador, nombre, apellidos, dni, telefono, direccion);
        this.localidad = localidad;
    }

    public String getLocalidad() {
        return localidad;
    }
    
}