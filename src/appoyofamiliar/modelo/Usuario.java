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
     *Metodo abstracto que se redefine en las clases especificas.
     */
    public abstract void modificarDatos();
    
    /**
     *Cambia la clave del usuario que llama al método
     * @param clave
     */
    public void cambiarClave(String clave){
        this.clave = clave;
    }
    
    public void holatrini(){
        
    }
}
