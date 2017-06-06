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
public abstract class Usuario {
    
    private String identificador, clave, nombre, apellidos, dni, telefono, direccion;

    /**
     * Creacion de Usuario con todos los datos
     * @param identificador
     * @param clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Usuario(String identificador, String clave, String nombre, String apellidos, String dni, String telefono, String direccion) {
        this.identificador = identificador;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    /**
     * Creacion de Usuario sin identificador ni clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Usuario(String nombre, String apellidos, String dni, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }
            
    /**
     * Modifica los datos del objeto Usuario que llama al metodo
     * Metodo abstracto que se redefine en las clases especificas.
     */
    public void modificarDatos(String identificador, String nombre, String apellidos, String dni, String telefono, String direccion){
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }
        
    /**
     *Cambia la clave del usuario que llama al método
     * @param clave
     */
    public void cambiarClave(String clave){
        this.clave = clave;
    }
    
    //GETTERS
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getClave() {
        return clave;
    }
    
    public boolean compararClaves(String clave){
        return this.clave.equals(clave);
    }
    
}
