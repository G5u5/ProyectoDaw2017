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
    
    Scanner teclado = new Scanner(System.in);
       
    
    public Paciente(String nombre, String apellidos, String dni, String telefonoFamilia, String centro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefonoFamilia = telefonoFamilia;
        this.centro = centro;
        
    }
    
    public void mostrar(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("Telefono de contacto: " + telefonoFamilia);
        System.out.println("Centro de residencia: " + centro);
    }
    public void actualizarDatos(String nombre, String apellidos, String telefono, String centro){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefonoFamilia = telefono;
        this.centro = centro;     
    }
}
