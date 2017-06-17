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
    
    public static ConjuntoSalida instancia(){
        if (instancia == null){
            instancia = new ConjuntoSalida();
        }
        return instancia;
    }
    
    /**
     *Crea una salida
     */
    public void nuevaSalida(Salida s){
        s.setControl("insertar");
        salidas.add(s);
        
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
    
    public Salida buscarSalida(Empleado e, Paciente p, String fi){
        Salida rtrn = null;
        for (Salida s : salidas){
            if (s.getPaciente().getDni().equals(p.getDni()) && s.getEmpleado().getIdentificador().equals(e.getIdentificador()) && s.getFechaInicio().toString().equals(fi)){
                rtrn = s;
            }
        }
        return rtrn;
    }
    
    public LinkedList<Salida> getSalidas() {
        return salidas;
    }
    
    /**
     *Muestra los datos de las salidas en forma de tabla
     * @return
     */
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[salidas.size()][10];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][1]= salidas.get(i).getPaciente().getDni();
                tabla[contador][2]= salidas.get(i).getMedico();
                tabla[contador][3]= salidas.get(i).getEspecialidad();
                tabla[contador][4]= salidas.get(i).getCentro();
                tabla[contador][5]= salidas.get(i).getArea();
                tabla[contador][6]= salidas.get(i).getDescripcion();
                tabla[contador][7]= salidas.get(i).getTransporte();
                tabla[contador][8]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][9]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaPrevia(){
        String[][] tabla = new String[salidas.size()][5];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][1]= salidas.get(i).getPaciente().getDni();
                tabla[contador][2]= salidas.get(i).getMedico();
                tabla[contador][3]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][4]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaPrevia(Usuario u){
        String[][] tabla = new String[salidas.size()][5];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][1]= salidas.get(i).getPaciente().getDni();
                tabla[contador][2]= salidas.get(i).getMedico();
                tabla[contador][3]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][4]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
                
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTabla(Usuario u){
        String[][] tabla = new String[salidas.size()][10];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][1]= salidas.get(i).getPaciente().getDni();
                tabla[contador][2]= salidas.get(i).getMedico();
                tabla[contador][3]= salidas.get(i).getEspecialidad();
                tabla[contador][4]= salidas.get(i).getCentro();
                tabla[contador][5]= salidas.get(i).getArea();
                tabla[contador][6]= salidas.get(i).getDescripcion();
                tabla[contador][7]= salidas.get(i).getTransporte();
                tabla[contador][8]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][9]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
}
