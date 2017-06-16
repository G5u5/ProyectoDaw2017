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
        
    private ConjuntoPaciente(){
        pacientes = SQLUsuarios.instancia().descargarDatosP();
        
    }
    
    public static ConjuntoPaciente instancia(){
        if (instancia == null){
            instancia = new ConjuntoPaciente();
        }
        return instancia;
    }
    
    /**
     *Introduce por medio de Scanner los datos de un nuevo paciente e incluye
     * el paciente al final de la lista.
     */
    public void nuevoPaciente(Paciente p){
       pacientes.add(p);
    }
    
    public static Paciente getPacienteDni(String denei){
        Paciente encontrado = null;
        
        for (int i = 0; i < pacientes.size(); i++){
            if (pacientes.get(i).getDni().equals(denei)){
                encontrado = pacientes.get(i);
            }
        } 
        return encontrado;
    }
    
    /**
     *elimina el paciente de la lista con el indice establecido 
     * @param indice
     * @return
     */
    public void borrarPaciente(String dni){
        
    }
    
    /**
     * Muestra por consola los datos del paciente. No tiene utilidad con interface gráfica.
     */
    public void mostrar(){
        Iterator lista = pacientes.iterator();
        Paciente marcado = (Paciente) lista.next();
        while (lista.hasNext()){
            System.out.println(marcado.getNombre());
            System.out.println(marcado.getApellidos());
            System.out.println(marcado.getDni());
            System.out.println(marcado.getTelefonoFamilia());
            System.out.println(marcado.getCentro());
        }
    }
    
    /**
     *Actualiza los datos del paciente selecionado por el indice de la lista
     * @param indice
     */
    public void modificarPaciente(String nombre, String apellidos, String telefono, String centro){
        getPaciente(indice).actualizarDatos(nombre, apellidos, telefono, centro);
    }
   
    /**
     *Se recorre la lista y devuelve los datos en formato de matriz de Strings
     * @return
     */
    public String [][] obtenerDatosTabla() {
        String [][] arrayPacientes = new String [pacientes.size()][5];
        for (int indice = 0; indice < pacientes.size(); indice++  )  {
            Paciente paciente = pacientes.get(indice);
            arrayPacientes[indice][0] = paciente.getNombre();
            arrayPacientes[indice][1] = paciente.getApellidos();
            arrayPacientes[indice][2] = paciente.getDni();
            arrayPacientes[indice][3] = paciente.getTelefonoFamilia();
            arrayPacientes[indice][4] = paciente.getCentro();
        }      
        return arrayPacientes;
    }
}
