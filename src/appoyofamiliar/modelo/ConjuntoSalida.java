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
    public void modificarSalida(String nE, String dniP, String fi, String me, String esp, String cen, String area, String desc, String trans){
        // nE = nombre del empleado
        // dniP = dni del Paciente
        // fi = fecha inicio
        boolean bandera = true;
        for (int i = 0; i < salidas.size() && bandera; i++){
            if (salidas.get(i).getEmpleado().getNombre().equals(nE) && salidas.get(i).getPaciente().getDni().equals(dniP) && salidas.get(i).getFechaInicio().equals(fi)){
                salidas.get(i).actualizarDatos(obtenerEmpleado(nE), obtenerPaciente(dniP), desc, esp, cen, area, desc, trans, trans);
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
    
    public Salida getSalida(int id){
        Salida s = null;
        boolean bandera = true;
        for (int i = 0; i < salidas.size() && bandera; i++){
            if (salidas.get(i).getCodigo() == id){
                s = salidas.get(i);
                bandera = false;
            }
        }
        return s;
    }
    
    //****************** TABLAS GRANDES GENERALES ****************************//
    
    //---------- TODAS LAS SALIDAS ---------
    public String[][] obtenerDatosTabla(){
        String[][] tabla = new String[calcularDimension()][11];
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
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //------------- PENDIENTES ----------
    public String[][] obtenerDatosTablaPendientes(){
        String[][] tabla = new String[calcularDimensionPendientes()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getFechaFin() == null){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                
                contador++;
            }
        }
        return tabla;
    }
    
    //------------- REALIZADAS ----------
    public String[][] obtenerDatosTablaRealizadas(){
        String[][] tabla = new String[calcularDimensionRealizadas()][11];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getFechaFin() != null){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                tabla[contador][10]= salidas.get(i).getFechaFin();
                
                contador++;
            }
        }
        return tabla;
    }
    
    //****************** TABLAS PEQUEÑAS GENERALES ***************************//
    
    //---------- TODAS LAS SALIDAS -----------
    public String[][] obtenerDatosTablaPrevia(){
        String[][] tabla = new String[calcularDimension()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][5]= salidas.get(i).getFechaFin();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //------------- PENDIENTES ----------
    public String[][] obtenerDatosTablaPreviaPendientes(){
        String[][] tabla = new String[calcularDimensionPendientes()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (salidas.get(i).getFechaFin() == null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                contador++;
                
            }
        }
        return tabla;
    }
    
    //---------- REALIZADAS ---------------
    public String[][] obtenerDatosTablaPreviaRealizadas(){
        String[][] tabla = new String[calcularDimensionRealizadas()][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (salidas.get(i).getFechaFin() != null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                tabla[contador][5]= salidas.get(i).getFechaFin();
                
                contador++;
                
            }
        }
        return tabla;
    }
    
    //****************** TABLAS PEQUEÑAS PARA USUARIOS ***********************//
    
    //------------ TODAS ---------
    public String[][] obtenerDatosTablaPrevia(Usuario u){
        String[][] tabla = new String[calcularDimension(u)][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][5]= salidas.get(i).getFechaFin();
                }
                contador++;
                
            }
        }
        return tabla;
    }
    
    //------------- PENDIENTES ----------
    public String[][] obtenerDatosTablaPreviaPendientes(Usuario u){
        String[][] tabla = new String[calcularDimensionPendientes(u)][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() == null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                contador++;
                
            }
        }
        return tabla;
    }
    
    //---------- REALIZADAS ---------------
    public String[][] obtenerDatosTablaPreviaRealizadas(Usuario u){
        String[][] tabla = new String[calcularDimensionRealizadas(u)][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() != null && (!salidas.get(i).getControl().equals("borrar"))){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                tabla[contador][5]= salidas.get(i).getFechaFin();
                
                contador++;
                
            }
        }
        return tabla;
    }
    
    //---------- POR AREA ----------------
    public String[][] obtenerDatosTablaPreviaArea(String area){
        String[][] tabla = new String[calcularDimensionPorArea(area)][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getArea().toLowerCase().equals(area.toLowerCase())){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][5]= salidas.get(i).getFechaFin();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //****************** TABLAS GRANDES PARA USUARIOS ***********************//
    
    //------------ TODAS ---------
    public String[][] obtenerDatosTablaGrande(Usuario u){
        String[][] tabla = new String[calcularDimension(u)][11];
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
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //------------- PENDIENTES ----------
    public String[][] obtenerDatosTablaGrandePendientes(Usuario u){
        String[][] tabla = new String[calcularDimensionPendientes(u)][11];
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
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                
                contador++;
            }
        }
        return tabla;
    }
    
    //------------- REALIZADAS ----------
    public String[][] obtenerDatosTablaGrandeRealizadas(Usuario u){
        String[][] tabla = new String[calcularDimensionRealizadas(u)][11];
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
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin();
                }
                contador++;
            }
        }
        return tabla;
    }
    
    //---------- POR AREA ----------------
    public String[][] obtenerDatosTablaGrandeArea(String area){
        String[][] tabla = new String[calcularDimensionPorArea(area)][6];
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getArea().toLowerCase().equals(area.toLowerCase())){
                tabla[contador][0]= Integer.toString(salidas.get(i).getCodigo());
                tabla[contador][1]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][2]= salidas.get(i).getPaciente().getDni();
                tabla[contador][3]= salidas.get(i).getMedico();
                tabla[contador][4]= salidas.get(i).getEspecialidad();
                tabla[contador][5]= salidas.get(i).getCentro();
                tabla[contador][6]= salidas.get(i).getArea();
                tabla[contador][7]= salidas.get(i).getDescripcion();
                tabla[contador][8]= salidas.get(i).getTransporte();
                tabla[contador][9]= salidas.get(i).getFechaInicio();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][10]= salidas.get(i).getFechaFin();
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
    
    public int calcularDimension(){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el control "borrar"
        //dentro del conjunto salidas.
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimensionPendientes(){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el contro "borrar"
        //cuya fechaFin sea null (estan pendientes de cerrar) dentro del conjunto salidas.
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getFechaFin() == null){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimensionRealizadas(){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el contro "borrar"
        //que ya tengan una fechaFin (estan cerradas) dentro del conjunto salidas
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getFechaFin() != null){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimensionPorArea(String area){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el contro "borrar"
        //y que sean del mismo area que el indicado como parametro dentro del conjunto salidas.
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && salidas.get(i).getArea().toLowerCase().equals(area.toLowerCase())){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimension(Usuario u){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el control "borrar"
        //dentro del conjunto salidas.
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador())){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimensionPendientes(Usuario u){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el contro "borrar"
        //cuya fechaFin sea null (estan pendientes de cerrar) dentro del conjunto salidas.
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() == null){
                contador++;
            }    
        }
        return contador;
    }
    
    public int calcularDimensionRealizadas(Usuario u){
        //Calcula la cantidad de ocurrencias de Salidas que no tengan el contro "borrar"
        //que ya tengan una fechaFin (estan cerradas) dentro del conjunto salidas
        int contador = 0;
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar") && u.getIdentificador().toLowerCase().equals(salidas.get(i).getEmpleado().getIdentificador()) && salidas.get(i).getFechaFin() != null){
                contador++;
            }    
        }
        return contador;
    }
    
    
}