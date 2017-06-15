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
    private Plantilla pl = new Plantilla();
    private ConjuntoPaciente pc = new ConjuntoPaciente();
    
    public static SQLUsuarios instancia() {
        if (instancia == null) {
            instancia = new SQLUsuarios();
        }
        
        return instancia;
    }
    
    //--------------------------------------------------------------------------
    //    DESCARGA DE DATOS. Creación de las diferentes listas.
    //--------------------------------------------------------------------------
    
    public LinkedList<Usuario> descargarDatosU() throws SQLException {
    //Descarga los datos de la tabla "Usuario" y crea la lista correspondiente
        LinkedList<Usuario> llu = new LinkedList<Usuario>();
        
        try {
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Usuario"
                );
            while (rsi.next()) {
                if(rsi.getString(9) != null){
                    llu.add(new Empleado (rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9)));
                    
                } else if (rsi.getString(8) != null){
                    llu.add(new Jefe(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(8)));

                } else if (rsi.getString(10) != null && rsi.getString(9) != null){
                    llu.add(new Encargado(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9), rsi.getString(10)));
                    
                }
            }
        } 
        catch (Exception e) {
            System.err.println("ERROR: Fallo al descargar los datos de los Usuarios.");
        }
        
        return llu;
    }
    
    public LinkedList<Paciente> descargarDatosP() throws SQLException {
        
        LinkedList<Paciente> llp = new LinkedList<Paciente>();
        
        try{
            
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Paciente"
            );
            while (rsi.next()) {
                llp.add(new Paciente(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5)));
            }
        }
        catch (Exception e){
            System.err.println("ERROR: Fallo al descargar los datos de los Pacientes.");
        }
        
        return llp;
    }
    
    public LinkedList<Salida> descargarDatosS() throws SQLException {
        LinkedList<Salida> lls = new LinkedList<Salida>();
        Salida sa = null;
        try{
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Salida"
            );
            while (rsi.next()) {
                sa = new Salida(obtenerEmpleado(rsi.getString(1)), obtenerPaciente(rsi.getString(2)), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(8), rsi.getDate(9));
                lls.add(sa);
            }
        }catch (Exception e){
            System.err.println("ERROR: Fallo al descargar los datos de las Salidas.");
        }
        return lls;
    }
    
    //--------------------------------------------------------------------------
    //    CARGA DE DATOS. Guarda o modifica los datos marcados en la base de datos.
    //--------------------------------------------------------------------------
    public void guardarNuevoEmpleado(Empleado em) {        
        //Guarda el objeto Empleado pasado como parametro en la base de datos.
        try {
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, localidad) values (" +
                    "'" + em.getIdentificador()+ "'" + ", " +
                    "'" + em.getClave()+ "'" + ", " +
                    "'" + em.getNombre()+ "'" + ", " +
                    "'" + em.getApellidos() + "'" + ", " +
                    "'" + em.getDni() + "'" + ", " +
                    "'" + em.getTelefono() + "'"  + "," +
                    "'" + em.getDireccion() + "'" +
                    "'" + em.getLocalidad() + "'" +
                    ")"
                ); 
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al crear el Empleado.");
        }        
    }
    public void guardarNuevoEncargado(Encargado en) {        
        //Guarda el objeto Encargado pasado como parametro en la base de datos.
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, localidad, area) values (" +
                    "'" + en.getIdentificador()+ "'" + ", " +
                    "'" + en.getClave()+ "'" + ", " +
                    "'" + en.getNombre()+ "'" + ", " +
                    "'" + en.getApellidos() + "'" + ", " +
                    "'" + en.getDni() + "'" + ", " +
                    "'" + en.getTelefono() + "'"  + "," +
                    "'" + en.getDireccion() + "'" +
                    "'" + en.getLocalidad() + "'" +
                    "'" + en.getArea() + "'" +
                    ")"
                ); 
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Encargado.");
        }        
    }
    public void guardarNuevoJefe(Jefe je) {        
        //Guarda el objeto Jefe pasado como parametro en la base de datos.
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario (identificador, clave, nombre, apellidos, dni, telefono, direccion, sede) values (" +
                    "'" + je.getIdentificador()+ "'" + ", " +
                    "'" + je.getClave()+ "'" + ", " +
                    "'" + je.getNombre()+ "'" + ", " +
                    "'" + je.getApellidos() + "'" + ", " +
                    "'" + je.getDni() + "'" + ", " +
                    "'" + je.getTelefono() + "'"  + "," +
                    "'" + je.getDireccion() + "'" +
                    "'" + je.getSede() + "'" +
                    ")"
                ); 
            
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Jefe.");
        }        
    }
    
    public void modificarUsuario(Usuario u){
        /**
         * Sobreescribe los datos del Usuario ya modificado que se pasa como parámetro.
         * El identificador no puede cambiar nunca.
         */
         
        try {
            ConexionBD.instancia().getStatement().execute(
                    "update Usuario set clave='" + u.getClave()
                            + "', nombre='" + u.getNombre() + "',"
                            + "', apellidos='" + u.getNombre() + "',"
                            + "', dni='" + u.getNombre() + "',"
                            + "', telefono='" + u.getNombre() + "',"
                            + "', direccion='" + u.getNombre() + "',"
                            + "', sede='" + u.getNombre() + "',"
                            + "', localidad='" + u.getNombre() + "',"
                            + "', area='" + u.getNombre() + "',"
                            + "where Identificador='" + u.getIdentificador() + "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Usuario");
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
                            + "', apellidos='" + p.getApellidos() + "',"
                            + "', telefonoFamilia='" + p.getTelefonoFamilia() + "',"
                            + "', centro='" + p.getCentro() + "',"
                            + "where dni='" + p.getDni() + "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Paciente");
        }
    }
    
    public void modificarSalida(Salida s){
        /**
         * Sobreescribe los datos de la Salida ya modificada que se pasa como parámetro.
         * El identificador no puede cambiar nunca.
         */
        try {
            ConexionBD.instancia().getStatement().execute(
                    "update Usuario set medico='" + s.getMedico()
                            + "', especialidad='" + s.getEspecialidad() + "',"
                            + "', centro='" + s.getCentro() + "',"
                            + "', area='" + s.getArea() + "',"
                            + "', descripcion='" + s.getDescripcion() + "',"
                            + "', transporte='" + s.getTransporte() + "',"
                            + "where Identificador='" + s.getEmpleado().getIdentificador() + "'"
                            + " AND dniPaciente='" + s.getPaciente().getDni()+ "'"
                            + " AND fechaInicio='" + s.getFechaInicio() + "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Usuario");
        }
    }
    
    public void guardarHoraFin(Date h){
        
    }
    
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
    //    OTROS MÉTODOS
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
                em = new Empleado(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6));
            }
        }catch (Exception e){
            System.err.println("ERROR: Fallo de conexión al buscar el Empleado");
        }
        return em;
    }
    
     
}
