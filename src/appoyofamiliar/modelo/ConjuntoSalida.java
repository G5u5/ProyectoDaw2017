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
 * @author Trinidad Ibáñez
 */
public class ConjuntoSalida {
    private LinkedList<Salida> salidas = new LinkedList<Salida>();
    private static ConjuntoSalida instancia;
    private int ultimoCodigo;
    private ConjuntoSalida(){
        salidas = SQLUsuarios.instancia().descargarDatosS();
        this.ultimoCodigo = salidas.getLast().getCodigo() + 1;
    }
    
    public static ConjuntoSalida instancia(){
        if (instancia == null){
            instancia = new ConjuntoSalida();
        }
        return instancia;
    }
    
    public void nuevaSalida(Salida s){
        s.setControl("insertar");
        this.ultimoCodigo++;
        salidas.add(s);
    }
    
    /**
     *Convierte una String en una fecha tipo Date y la retorna
     * @param fecha
     * @return
    */
    /* 
    public Date convStringToFecha(String fecha) {
        Date testDate = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("DD/MM/YYYY");
        Date retorno = null;
        
        try{
            testDate = formatoFecha.parse(fecha);
        } catch (Exception e){
            System.out.println("Formato no válido.");
        }

        if (!formatoFecha.format(testDate).equals(fecha)){
            System.out.println("Fecha no válida.");
        } else {
            System.out.println("Fecha válida.");
            retorno = testDate;
        }
        return retorno;
    }*/
    
    /**
     *Borra una salida
     * @param indice
     */
    public void borrarSalida(int indice){
        salidas.get(indice).setControl("borrar");
    }
    
    /**
     * Modifica algunos datos de una salida existente
     * 
     * @param nE
     * @param dniP
     * @param fi
     * @param me
     * @param esp
     * @param cen
     * @param desc
     * @param trans
     */
    public void modificarSalida(String nE, String dniP, String fi, String me, String esp, String cen, String desc, String trans){
        // nE = nombre del empleado
        // dniP = dni del Paciente
        // fi = fecha inicio
        boolean bandera = true;
        for (int i = 0; i < salidas.size() && bandera; i++){
            if (salidas.get(i).getEmpleado().getNombre().equals(nE) && salidas.get(i).getPaciente().getDni().equals(dniP) && salidas.get(i).getFechaInicio().equals(fi)){
                salidas.get(i).actualizarDatos(obtenerEmpleado(nE), obtenerPaciente(dniP), desc, esp, cen, desc, trans, trans);
                salidas.get(i).setControl("modificar");
                bandera = false;
            }
        }
    }
    
    public void cerrarSalida(int cod, String ff){
        // nE = nombre del empleado
        // dniP = dni del Paciente
        // fi = fecha inicio
        boolean bandera = true;
        for (int i = 0; i < salidas.size() && bandera; i++){
            if (salidas.get(i).getCodigo() == cod){
                salidas.get(i).cerrarSalida(ff);
                salidas.get(i).setControl("modificar");
                bandera = false;
            }
        }
    }
    
    
    //--------------------------------------------------------------------------
    //------- GETTERS
    //--------------------------------------------------------------------------
    
    public LinkedList<Salida> getSalidas() {
        return salidas;
    }
    
    /**
     *Muestra los datos de las salidas en forma de tabla
     * @return
     */
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[salidas.size()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaPrevia(){
        String[][] tabla = new String[salidas.size()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][5]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    public String[][] obtenerDatosTablaPreviaPendientes(Usuario u){
        String[][] tabla = new String[salidas.size()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() == null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio().toString();
                contador++;
                
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaPreviaRealizadas(Usuario u){
        String[][] tabla = new String[salidas.size()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() != null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio().toString();
                tabla[contador][5]= salidas.get(i).getFechaFin().toString();
                
                contador++;
                
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaPrevia(Usuario u){
        String[][] tabla = new String[salidas.size()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][5]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
                
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaGrande(Usuario u){
        String[][] tabla = new String[salidas.size()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaGrandePendientes(Usuario u){
        String[][] tabla = new String[salidas.size()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() == null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio().toString();
                
                contador++;
            }
        }
        return tabla;
    }
    
    public String[][] obtenerDatosTablaGrandeRealizadas(Usuario u){
        String[][] tabla = new String[salidas.size()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() != null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin().toString();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //--------------------------------------------------------------------------
    //------- OTROS MËTODOS
    //--------------------------------------------------------------------------
    
    private Empleado obtenerEmpleado(String nE){
        return (Empleado)Plantilla.instancia().buscarUsuario(nE);
    }
    
    private Paciente obtenerPaciente(String dniP){
        return ConjuntoPaciente.instancia().getPacienteDni(dniP);
    }
}