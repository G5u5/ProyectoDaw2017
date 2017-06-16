/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;
import appoyofamiliar.controlador.SQLUsuarios;
import java.util.*;
/**
 *
 * @author Felipe José Ruiz
 */
public class ConjuntoPaciente {
    private static LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
    private static ConjuntoPaciente instancia = null;
        
    /**
     * ------ CONSTRUCTOR PRIVADO. CLASE DE INSTANCIA ÚNICA --------------------
     */
    private ConjuntoPaciente(){
        pacientes = SQLUsuarios.instancia().descargarDatosP();
    }
    
    /**
     *--- DEVUELVE LA INSTANCIA ÚNICA PARA PODER MANEJAR LA LISTA DE PACIENTES.
     */
    public static ConjuntoPaciente instancia(){
        if (instancia == null){
            instancia = new ConjuntoPaciente();
        }
        return instancia;
    }
    
    //--------------------------------------------------------------------------
    //------- GESTION DE DATOS
    //--------------------------------------------------------------------------
    /**
     * AÑADE EL PACIENTE PASADO COMO PARÁMETRO A LA LISTA
     */
    public void nuevoPaciente(Paciente p){
        p.setControl("insertar");
        pacientes.add(p);
    }
        
    /**
     *elimina el paciente de la lista con el indice establecido 
     * @param indice
     * @return
     */
    public void borrarPaciente(String dni){
        pacientes.get(buscarPosicionPaciente(dni)).setControl("borrar");        
    }
    
    /**
     *Actualiza los datos del paciente selecionado por el indice de la lista
     * @param indice
     */
    public void modificarPaciente(String dni, String nombre, String apellidos, String telefono, String centro){
        pacientes.get(buscarPosicionPaciente(dni)).actualizarDatos(nombre, apellidos, telefono, centro);
    }

    //--------------------------------------------------------------------------
    //------- GETTERS
    //--------------------------------------------------------------------------
    
    public static Paciente getPacienteDni(String denei){
        Paciente encontrado = null;
        boolean bandera = true;
        for (int i = 0; i < pacientes.size() && bandera; i++){
            if (pacientes.get(i).getDni().equals(denei)){
                encontrado = pacientes.get(i);
                bandera = false;
            }
        } 
        return encontrado;
    }
    
    /**
     *Se recorre la lista y devuelve los datos en formato de matriz de Strings
     * @return
     */
    public String [][] obtenerDatosTabla() {
        String [][] arrayPacientes = new String [pacientes.size()][5];
        for (int indice = 0; indice < pacientes.size(); indice++  )  {
            Paciente paciente = pacientes.get(indice);
            if (!paciente.getControl().equals("borrar")){
                arrayPacientes[indice][0] = paciente.getNombre();
                arrayPacientes[indice][1] = paciente.getApellidos();
                arrayPacientes[indice][2] = paciente.getDni();
                arrayPacientes[indice][3] = paciente.getTelefonoFamilia();
                arrayPacientes[indice][4] = paciente.getCentro();
            }
        }      
        return arrayPacientes;
    }
    
    //--------------------------------------------------------------------------
    //------- OTROS MÉTODOS
    //--------------------------------------------------------------------------
    
    public int buscarPosicionPaciente(String dni){
        
        for (int i = 0; i<pacientes.size(); i++){
            if (pacientes.get(i).getDni().equals(dni)){
                return i;
            }
        }
        return -1;
    }
}
