/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import java.util.*;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class Jefe extends Usuario{
    
    private String cargo;
    
    /**
     * Creacion de usuario Jefe con todos los datos
     * @param identificador
     * @param clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Jefe(String identificador, String clave, String nombre, String apellidos, String dni, String telefono, String direccion) {
        super(identificador, clave, nombre, apellidos, dni, telefono, direccion);
    }
    
    /**
     * Creacion de usuario Jefe sin identificador ni clave
     * @param nombre
     * @param apellidos
     * @param dni
     * @param telefono
     * @param direccion
     */
    public Jefe(String nombre, String apellidos, String dni, String telefono, String direccion) {
        super(nombre, apellidos, dni, telefono, direccion);
    }
    
    public String[] getDatosPaciente(Paciente paciente){
        String[] arrayDatos = new String[5];

        arrayDatos[0] = paciente.getNombre();
        arrayDatos[1] = paciente.getApellidos();
        arrayDatos[2] = paciente.getDni();
        arrayDatos[3] = paciente.getTelefonoFamilia();
        arrayDatos[4] = paciente.getCentro();
    
        return arrayDatos;
    }
    
    public String[] getDatosEmpleado(Empleado empleado){
        String[] arrayDatos = new String[7];
        
        arrayDatos[0] = empleado.getIdentificador();
        arrayDatos[1] = empleado.getNombre();
        arrayDatos[2] = empleado.getApellidos();
        arrayDatos[3] = empleado.getDni();
        arrayDatos[4] = empleado.getTelefono();
        arrayDatos[5] = empleado.getDireccion();
        arrayDatos[6] = empleado.getLocalidad();
        
        return arrayDatos;
    }
    
    /**
     * Devuelve un array con los datos del encargado que se pasa como parámetro
     * [identificador, nombre, apellidos, dni, telefono, direccion, localidad, area]
     * @param encargado
     * @return
     */
    public String[] getDatosEncargado(Encargado encargado){
        String[] arrayDatos = new String[8];
        
        arrayDatos[0] = encargado.getIdentificador();
        arrayDatos[1] = encargado.getNombre();
        arrayDatos[2] = encargado.getApellidos();
        arrayDatos[3] = encargado.getDni();
        arrayDatos[4] = encargado.getTelefono();
        arrayDatos[5] = encargado.getDireccion();
        arrayDatos[6] = encargado.getLocalidad();
        arrayDatos[7] = encargado.getArea();
        
        return arrayDatos;
    }
    
    public String[] getDatosJefe(Jefe jefe){
        String[] arrayDatos = new String[7];
        
        arrayDatos[0] = jefe.getIdentificador();
        arrayDatos[1] = jefe.getNombre();
        arrayDatos[2] = jefe.getApellidos();
        arrayDatos[3] = jefe.getDni();
        arrayDatos[4] = jefe.getTelefono();
        arrayDatos[5] = jefe.getDireccion();
        arrayDatos[6] = jefe.getCargo();
        
        return arrayDatos;
    }
    
    //salidas.get(i).obtenerDatos()[1]
    //public void actualizarDatos(String nombre, String apellidos, String telefono, String centro){
    public void modificarPaciente(Paciente paciente, String nombre, String apellidos, String telefono, String centro){
        paciente.actualizarDatos(nombre, apellidos, telefono, centro);
    }
    public void crearPaciente(ConjuntoPaciente conjunto){
        conjunto.nuevoPaciente();
    }
    
    public void borrarPaciente(ConjuntoPaciente conjunto, int indice){
        conjunto.borrarPaciente(indice);
    }
            
    /**
     * + crearEmpleado()
     * + crearJefe()
     * + modificarUsuario()
    */
    
    public void borrarUsuario(Plantilla conjunto, Usuario marcado){
        conjunto.borrarUsuario(marcado);
    }
    
    /*
     * + verSalida()
     * + modificarSalida()
     * + informeSalidas()
     */
    
    /**
     * Modificar los datos del usuario Jefe
     */
    public void modificarDatos(String identificador, String nombre, String apellidos, String dni, String telefono, String direccion, String cargo){
        super.modificarDatos(identificador, nombre, apellidos, dni, telefono, direccion);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
    
    
}
