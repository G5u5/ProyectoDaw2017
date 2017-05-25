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
public class Encargado extends Empleado{
    
    private String area;
    
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
    public Encargado(String identificador, String clave, String nombre, String apellidos, String dni, String telefono, String direccion, String localidad, String area) {
        super(identificador, clave, nombre, apellidos, dni, telefono, direccion, localidad);
        this.area = area;
    }
    
    /**
     * Creacion de usuario Empleado sin identificador ni clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Encargado(String nombre, String apellidos, String dni, String telefono, String direccion, String localidad, String area) {
        super(nombre, apellidos, dni, telefono, direccion, localidad);
        this.area = area;
    }
    
    @Override
    public void modificarDatos(){
        
    }
}
