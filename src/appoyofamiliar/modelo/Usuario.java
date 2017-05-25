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
        this.identificador = identificador;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }
        
    /**
     *Muestra por pantalla los datos de la cuenta de usuario que llama al método.
     */
    public void verDatosPropios(){
        System.out.println("Datos de la cuenta:");
        System.out.println("------------------------------");
        System.out.println("Usuario: " + this.identificador);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellidos " + this.apellidos);
        System.out.println("DNI: " + this.dni);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: " + direccion);
    }
    
    /**
     * Devuelve los datos del usuario en un array
     * @return String[identificador, nombre, apellidos, dni, telefono, direccion]
     */
    public String[] obtenerDatos(){
        String[] listaDatos = {this.identificador, this.nombre, this.apellidos, this.dni, this.telefono, this.direccion};
        return listaDatos;
    }
    
    /**
     * Modifica los datos del objeto Usuario que llama al metodo
     * Metodo abstracto que se redefine en las clases especificas.
     */
    public abstract void modificarDatos();
    
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
}
