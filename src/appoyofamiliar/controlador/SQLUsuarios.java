/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.controlador;

import appoyofamiliar.modelo.ConjuntoPaciente;
import appoyofamiliar.modelo.Paciente;
import java.sql.ResultSet;
import appoyofamiliar.modelo.Jefe;
import appoyofamiliar.modelo.Encargado;
import appoyofamiliar.modelo.Empleado;
import appoyofamiliar.modelo.Paciente;
import appoyofamiliar.modelo.Usuario;
import java.sql.SQLException;
import appoyofamiliar.modelo.Plantilla;
import appoyofamiliar.modelo.ConjuntoSalida;
import appoyofamiliar.modelo.Salida;
import java.util.*;
/**
 *
 * @author Felipe Ruiz
 */
public class SQLUsuarios {
    private static SQLUsuarios instancia = null;
    
    public static SQLUsuarios instancia() {
        if (instancia == null) {
            instancia = new SQLUsuarios();
        }
        return instancia;
    }
    
    //--------------------------------------------------------------------------
    //-------DESCARGA DE DATOS. Creación de las diferentes listas en la memoria del sistema.
    //--------------------------------------------------------------------------
    
    public LinkedList<Usuario> descargarDatosU() {
    //Descarga los datos de la tabla "Usuario" y crea la lista correspondiente
        LinkedList<Usuario> llu = new LinkedList<Usuario>();
        
        try {
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Usuario"
                );
            while (rsi.next()) {
                if(rsi.getString(9) != null && rsi.getString(10) == null){
                    llu.add(new Empleado (rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9)));
                    
                } else if (rsi.getString(8) != null){
                    llu.add(new Jefe(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(8)));

                } else if (rsi.getString(10) != null && rsi.getString(9) != null){
                    llu.add(new Encargado(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9), rsi.getString(10)));
                    
                }
                
                /*-------------CÓDIGO PARA PRUEBAS------------
                System.out.println("***************");
                System.out.println("Resultado: " + Integer.toString(rsi.getFetchDirection()));
                System.out.println("");
                
                System.out.println("SEDE?: " + rsi.getString(8));
                if (rsi.getString(8) != null){
                    System.out.println("Sede ENCONTRADA!!!");
                } else {
                    System.out.println("Sede vacia...");
                }
                
                System.out.println("LOCALIDAD?: " + rsi.getString(9));
                if(rsi.getString(9) != null){
                    System.out.println("Localidad ENCONTRADA!!!");
                }else {
                    System.out.println("Localidad vacia...");
                }
                
                System.out.println("AREA?: " + rsi.getString(10));
                if (rsi.getString(10) != null && rsi.getString(9) != null){
                    System.out.println("LOCALIDAD Y AREA ENCONTRADAS!!!");
                } else {
                    System.out.println("localidad y area vacias...");
                }
                System.out.println("***************************");*/
                
            }
            ConexionBD.desconectar();
        } 
        catch (Exception e) {
            System.err.println("ERROR: Fallo al descargar los datos de los Usuarios.");
        }
        return llu;
    }
    
    public LinkedList<Paciente> descargarDatosP() {
    //Descarga los datos de la tabla "Paciente" y crea la lista correspondiente    
        LinkedList<Paciente> llp = new LinkedList<Paciente>();
        
        try{
            
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Paciente"
            );
            while (rsi.next()) {
                Paciente p = new Paciente(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5));
                p.setControl("mantener");
                llp.add(p);
            }
            ConexionBD.desconectar();
        }
        catch (Exception e){
            System.err.println("ERROR: Fallo al descargar los datos de los Pacientes.");
        }
        return llp;
    }
    
    public LinkedList<Salida> descargarDatosS() {
    //Descarga los datos de la tabla "Salida" y crea la lista correspondiente
    
        String[][] lista = null;
        ArrayList resultados = new ArrayList();
        LinkedList<Date[]> fechas = new LinkedList();
        LinkedList<Salida> lls;
        lls = new LinkedList();
        
        try{
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Salida"
            );
            
            while (rs.next()) {
                String[] marcada = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                Date[] actuales = {rs.getDate(9), rs.getDate(10)};
                resultados.add(marcada);
                fechas.add(actuales);
            }
            rs.close();
            for (int i = 0; i< resultados.size(); i++){
                String[] marcada = (String[]) resultados.get(i);
                Date[] fetchAs = fechas.get(i);
                Salida sa = new Salida(obtenerEmpleado(marcada[0]), obtenerPaciente(marcada[1]), marcada[2], marcada[3], marcada[4], marcada[5], marcada[6], marcada[7], fetchAs[0]);
                if (fetchAs[1] != null){
                    sa.cerrarSalida(fetchAs[1]);
                }
                sa.setControl("mantener");
                lls.add(sa);
            }
            ConexionBD.desconectar();
        }catch (SQLException e){
            System.err.println("ERROR: SQLException al descargar los datos de las Salidas. " + e);
        } catch (Exception e){
            System.out.println("ERROR: Fallo al descargar los datos de las Salidas. " + e);
        }
        return lls;
    }
    
    //--------------------------------------------------------------------------
    //------CARGA DE DATOS. Guarda o modifica los datos marcados en la base de datos.
    //--------------------------------------------------------------------------
    
    // ------------- GUARDAR -----------------------
    
    public void guardarNuevoEmpleado(Empleado em) {        
        //Guarda el objeto Empleado pasado como parametro en la base de datos.
        try {
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, localidad) values (" +
                    "'" + em.getIdentificador()+ "', " +
                    "'" + em.getClave()+ "', " +
                    "'" + em.getNombre()+ "', " +
                    "'" + em.getApellidos() + "', " +
                    "'" + em.getDni() + "', " +
                    "'" + em.getTelefono() + "', " +
                    "'" + em.getDireccion() + "', " +
                    "'" + em.getLocalidad() + "'" +
                    ")"
                );
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al crear el Empleado.");
        }        
    }
    
    public void guardarNuevoEncargado(Encargado en) {        
        //Guarda el objeto Encargado pasado como parametro en la base de datos.
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, localidad, area) values (" +
                    "'" + en.getIdentificador()+ "', " +
                    "'" + en.getClave()+ "', " +
                    "'" + en.getNombre()+ "', " +
                    "'" + en.getApellidos() + "', " +
                    "'" + en.getDni() + "', " +
                    "'" + en.getTelefono() + "', " +
                    "'" + en.getDireccion() + "', " +
                    "'" + en.getLocalidad() + "', " +
                    "'" + en.getArea() + "'" +
                    ")"
                );
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Encargado.");
        }        
    }
    
    public void guardarNuevoJefe(Jefe je) {        
        //Guarda el objeto Jefe pasado como parametro en la base de datos.
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, sede) values (" +
                    "'" + je.getIdentificador()+ "', " +
                    "'" + je.getClave()+ "', " +
                    "'" + je.getNombre()+ "', " +
                    "'" + je.getApellidos() + "', " +
                    "'" + je.getDni() + "', " +
                    "'" + je.getTelefono() + "', " +
                    "'" + je.getDireccion() + "', " +
                    "'" + je.getSede() + "'" +
                    ")"
                ); 
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Jefe.");
        }        
    }
    
    public void guardarPaciente(Paciente p){
         //Guarda el objeto Paciente pasado como parametro en la base de datos.
        try {
            ConexionBD.instancia().getStatement().execute(
                    "insert into Paciente (nombre, apellidos, dni, telefonoFamilia, centro) values (" +
                    "'" + p.getNombre() + "', " +
                    "'" + p.getApellidos() + "', " +
                    "'" + p.getDni() + "', " +
                    "'" + p.getTelefonoFamilia() + "', " +
                    "'" + p.getCentro() + "'" +
                    ")"
                ); 
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al crear el Paciente.");
        }  
    }
    
    public void guardarSalida(Salida sa){
       //Guarda el objeto Salida pasado como parametro en la base de datos.
        try {
            ConexionBD.instancia().getStatement().execute(
                    "insert into Salida (Identificador, dniPaciente, medico, especialidad, centro, area, descripcion, transporte, fechaInicio, fechaFin) values (" +
                    "'" + sa.getEmpleado().getIdentificador() + "', " +
                    "'" + sa.getPaciente().getDni() + "', " +
                    "'" + sa.getMedico() + "', " +
                    "'" + sa.getEspecialidad() + "', " +
                    "'" + sa.getCentro() + "', " +
                    "'" + sa.getArea()+ "', " +
                    "'" + sa.getDescripcion()+ "', " +
                    "'" + sa.getTransporte() + "', " +
                    "'" + sa.getFechaInicio() + "', " +
                    "'" + sa.getFechaFin() + "'" +
                    ")"
                ); 
            ConexionBD.desconectar();
                    
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al crear la Salida.");
        }   
    }     
        
    // ------------- MODIFICAR -----------------------
    
    public void modificarEmpleado(Empleado em){
        /**
         * Sobreescribe los datos del Empleado ya modificado que se pasa como parámetro.
         * El identificador no puede cambiar nunca. En caso de querer cambiar el Identificador
         * hay que borrarlo y crear uno nuevo.
         */
        
        try {
            ConexionBD.instancia().getStatement().execute(
                "update Usuario set clave='" + em.getClave()
                    + "', nombre='" + em.getNombre() 
                    + "', apellidos='" + em.getApellidos()
                    + "', dni='" + em.getDni()
                    + "', telefono='" + em.getTelefono()
                    + "', direccion='" + em.getDireccion()
                    + "', localidad='" + em.getLocalidad()
                    + "' where Identificador='" + em.getIdentificador() + "';"
                );
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Jefe");
        }
    }
    
    public void modificarEncargado(Encargado en){
        /**
         * Sobreescribe los datos del Encargado ya modificado que se pasa como parámetro.
         * El identificador no puede cambiar nunca. En caso de querer cambiar el Identificador
         * hay que borrarlo y crear uno nuevo.
         */
        
        try {
            ConexionBD.instancia().getStatement().execute(
                "update Usuario set clave='" + en.getClave()
                    + "', nombre='" + en.getNombre()
                    + "', apellidos='" + en.getApellidos()
                    + "', dni='" + en.getDni()
                    + "', telefono='" + en.getTelefono()
                    + "', direccion='" + en.getDireccion()
                    + "', localidad='" + en.getLocalidad()
                    + "', area='" + en.getArea()
                    + "' where Identificador='" + en.getIdentificador() + "';"
                );
            ConexionBD.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Encargado");
        }
    }
    
    public void modificarJefe(Jefe je){
        /**
         * Sobreescribe los datos del Jefe ya modificado que se pasa como parámetro.
         * El identificador no puede cambiar nunca. En caso de querer cambiar el Identificador
         * hay que borrarlo y crear uno nuevo.
         */
        
        try {
            ConexionBD.instancia().getStatement().execute(
                "update Usuario set clave='" + je.getClave()
                    + "', nombre='" + je.getNombre() 
                    + "', apellidos='" + je.getApellidos()
                    + "', dni='" + je.getDni()
                    + "', telefono='" + je.getTelefono()
                    + "', direccion='" + je.getDireccion()
                    + "', sede='" + je.getSede()
                    + "' where Identificador='" + je.getIdentificador() + "';"
                );
            ConexionBD.desconectar();
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Jefe");
        }
    }
    
    public void modificarPaciente(Paciente p){
        /**
         * Sobreescribe los datos del Paciente ya modificado que se pasa como parámetro.
         * El DNI no puede cambiar nunca. En caso de querer cambiarlo se deberá eliminar
         * el paciente y crear uno nuevo.
         */
        
        try {
            ConexionBD.instancia().getStatement().execute(
                "update Usuario set nombre='" + p.getNombre()
                    + "', apellidos='" + p.getApellidos()
                    + "', telefonoFamilia='" + p.getTelefonoFamilia()
                    + "', centro='" + p.getCentro()
                    + "' where dni='" + p.getDni() + "';"
                );
            ConexionBD.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Paciente");
        }
    }
    
    public void modificarSalida(Salida s){
        /**
         * Sobreescribe los datos de la Salida ya modificada que se pasa como parámetro.
         * Identificador, paciente y fechaInicio no puede cambiar nunca. En caso de 
         * querer cambiar alguno de estos datos, se borrará la salida y se creará una nueva.
         */
        try {
            ConexionBD.instancia().getStatement().execute(
                "update Usuario set medico='" + s.getMedico()
                    + "', especialidad='" + s.getEspecialidad()
                    + "', centro='" + s.getCentro()
                    + "', area='" + s.getArea()
                    + "', descripcion='" + s.getDescripcion()
                    + "', transporte='" + s.getTransporte()
                    + "' where Identificador='" + s.getEmpleado().getIdentificador()
                    + "' AND dniPaciente='" + s.getPaciente().getDni()
                    + "' AND fechaInicio='" + s.getFechaInicio() + "';"
                );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Usuario");
        }
    }
    
    // ------------- BORRAR -----------------------
    
    public void borrarUsuario(Usuario u) {
        //Borra un usuario de la base de datos
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Usuario where Identificador='" + u.getIdentificador()+ "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al borrar el Usuario");
        }
    }
    
    public void borrarPaciente(Paciente p) {
        //Borra un Paciente de la base de datos
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Paciente where Dni='" + p.getDni()+ "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al borrar el Paciente");
        }
    }
        
    public void borrarSalida(Salida s) {
        //Borra una Salida de la base de datos
        
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Salida where Identificador='" + s.getEmpleado().getIdentificador() + "'"
                            + " AND dniPaciente='" + s.getPaciente().getDni()+ "'"
                            + " AND fechaInicio='" + s.getFechaInicio() + "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al borrar la Salida.");
        }
    }
    
    //--------------------------------------------------------------------------
    //------- OTROS MÉTODOS
    //--------------------------------------------------------------------------
    
    private Paciente obtenerPaciente(String denei){
        //Busca y devuelve el objeto Paciente cuyo D.N.I. corresponde al que se pasa como parametro.

        Paciente pa = null;
        
        try{
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Paciente where dni='" + denei + "';" 
            );
            while (rsi.next()) {
                pa = new Paciente(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5));
            }
        }catch (Exception e){
            System.err.println("ERROR: Fallo de conexión al buscar el Paciente");
        }
        return pa;
    }
    
    private Empleado obtenerEmpleado(String ident){
        //Busca y devuelve el objeto Empleado cuyo identificador corresponde al que se pasa como parametro.
        
        Empleado em = null;
        
        try{
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Usuario where Identificador='" + ident + "';" 
            );
            while (rsi.next()) {
                em = new Empleado(rsi.getString(1), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9));
            }
        }catch (Exception e){
            System.err.println("ERROR: Fallo de conexión al buscar el Empleado");
        }
        return em;
    }

}