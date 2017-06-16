/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import appoyofamiliar.controlador.SQLUsuarios;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Trinidad Ibáñez
 */
public class ConjuntoSalida {
    private LinkedList<Salida> salidas = new LinkedList<Salida>();
    private static ConjuntoSalida instancia;
    
    private ConjuntoSalida(){
        salidas = SQLUsuarios.instancia().descargarDatosS();
    }
    /**
     *Crea una salida
     */
    public void nuevaSalida(){
        
    }
        
    /**
     *Convierte una String en una fecha tipo Date y la retorna
     * @param fecha
     * @return
     */
    public Date obtenerFecha(String fecha) {
        Date testDate = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("DD/MM/YYYY");
        Date retorno = null;
        
        try{
            testDate = formatoFecha.parse(fecha);
        } catch (Exception e){ System.out.println("Formato no válido.");}

        if (!formatoFecha.format(testDate).equals(fecha)){
            System.out.println("Fecha no válida.");
            
        } else {
            System.out.println("Fecha válida.");
            retorno = testDate;
        }
        
        return retorno;
    }
    
    /**
     *Borra una salida
     * @param indice
     */
    public void borrarSalida(int indice){
        salidas.remove(indice);
    }
    
    /**
     *Modifica algunos datos de una salida existente
     * @param indice
     */
    public void modificarSalida(int indice){
        
    }
    
    //--------------------------------------------------------------------------
    //------- GETTERS
    //--------------------------------------------------------------------------
    
    /**
     *Muestra los datos de las salidas en forma de tabla
     * @return
     */
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[salidas.size()][9];
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[i][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[i][1]= salidas.get(i).getPaciente().getNombre();
                tabla[i][2]= salidas.get(i).getMedico();
                tabla[i][3]= salidas.get(i).getEspecialidad();
                tabla[i][4]= salidas.get(i).getCentro();
                tabla[i][5]= salidas.get(i).getDescripcion();
                tabla[i][6]= salidas.get(i).getTransporte();
                tabla[i][7]= salidas.get(i).getFechaInicio().toString();
                tabla[i][8]= salidas.get(i).getFechaFin().toString();
            }
        }
        return tabla;
    }

}
