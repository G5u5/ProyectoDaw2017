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
            System.err.println("ERROR: Fallo al descargar los datos de los Usuarios. (SQLUsuarios.descargarDatosU)");
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
            System.err.println("ERROR: Fallo al descargar los datos de los Pacientes. (SQLUsuarios.descargarDatosP)");
        }
        return llp;
    }
    
    public LinkedList<Salida> descargarDatosS() {
    //Descarga los datos de la tabla "Salida" y crea la lista correspondiente
    
        //ArrayList y LinkedList para el manejo de los datos.
        //Necesarias debido a imposible concurrencia de los ResultSet (En este caso)
        ArrayList resultados = new ArrayList();
        ArrayList<Integer> codigos = new ArrayList();
        LinkedList<Salida> lls = new LinkedList();
        
        
        
        
        try{
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Salida"
            );//Realiza la consulta, capturando todos los datos de la tabla Salida en el rs
            
            while (rs.next()) {
            /*
             Hace falta liberar la conexión para poder utilizar el ResultSet en los métodos obtenerEmpleado()
                y obtenerPaciente() que nos devuelven los objetos de las respectivas clases necesarios
                para el constructor
                */
                String[] marcada = {rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
                codigos.add(rs.getInt(1));
                resultados.add(marcada);
            } 
            rs.close();
            
            for (int i = 0; i< resultados.size(); i++){
                String[] marcada = (String[]) resultados.get(i);
                Salida sa = new Salida(codigos.get(i), obtenerEmpleado(marcada[0]), obtenerPaciente(marcada[1]), marcada[2], marcada[3], marcada[4], marcada[5], marcada[6], marcada[7], marcada[8]);
                if (marcada[9] != null){
                    sa.cerrarSalida(marcada[9]);
                }
                sa.setControl("mantener");
                lls.add(sa);
            }
            ConexionBD.desconectar();
        }catch (SQLException e){
            System.err.println("ERROR: SQLException al descargar los datos de las Salidas. (SQLUsuarios.descargarDatosS)" + e);
        } catch (Exception e){
            System.err.println("ERROR: Fallo al descargar los datos de las Salidas. (SQLUsuarios.descargarDatosS)" + e);
        }
        return lls;
    }
    
    //--------------------------------------------------------------------------
    //------CARGA DE DATOS. Guarda o modifica los datos marcados en la base de datos.
    //--------------------------------------------------------------------------
    
    // ------------- GUARDAR -----------------------
    
    public void guardarCambios(){
        for (Usuario u: Plantilla.instancia().getPlantilla()){
            switch (u.getControl()){
                case "mantener": 
                    break;
                case "borrar":
                    borrarUsuario(u);
                    break;
                case "insertar":
                    guardarUsuario(u);
                    break;
                case "modificar":
                    modificarUsuario(u);
                    break;
                default:
                    System.err.println("FALLO AL GUARDAR USUARIOS: Error de control. (SQLUsuarios.guardarCambios)");
            }
        }
        
        for (Paciente p: ConjuntoPaciente.instancia().getPacientes()){
            switch (p.getControl()){
                case "mantener": 
                    break;
                case "borrar":
                    borrarPaciente(p);
                    break;
                case "insertar":
                    guardarPaciente(p);
                    break;
                case "modificar":
                    modificarPaciente(p);
                    break;
                default:
                    System.err.println("FALLO AL GUARDAR PACIENTES: Error de control. (SQLUsuarios.guardarCambios)");
            }
        }
        
        for (Salida s: ConjuntoSalida.instancia().getSalidas()){
            switch (s.getControl()){
                case "mantener": 
                    break;
                case "borrar":
                    borrarSalida(s);
                    break;
                case "insertar":
                    guardarSalida(s);
                    break;
                case "modificar":
                    modificarSalida(s);
                    break;
                default:
                    System.err.println("FALLO AL GUARDAR SALIDAS: Error de control.(SQLUsuarios.guardarCambios)");
            }
        }
    }
    
    public void guardarUsuario(Usuario u){
        if (u instanceof Encargado){
            guardarNuevoEncargado((Encargado)u);
        } else if (u instanceof Empleado){
            guardarNuevoEmpleado((Empleado)u);
        } else if (u instanceof Jefe){
            guardarNuevoJefe((Jefe)u);
        } else {
            System.err.println("ERROR: tipo de Usuario incorrecto. (SQLUsuarios.guardarUsuario)");
        }
    }
    
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
            System.err.println("ERROR: Fallo en sentencia INSERT al crear el Empleado. (SQLUsuarios.guardarNuevoEmpleado)");
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
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Encargado. (SQLUsuarios.guardarNuevoEncargado)");
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
            System.err.println("ERROR: Fallo en sentencia INSERT al guardar el Jefe. (SQLUsuarios.guardarNuevoJefe)");
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
            System.err.println("ERROR: Fallo en sentencia INSERT al crear el Paciente. (SQLUsuarios.guardarPaciente)");
        }  
    }
    
    public void guardarSalida(Salida sa){
       //Guarda el objeto Salida pasado como parametro en la base de datos.
        try {
            if (sa.getFechaFin() == null){
                ConexionBD.instancia().getStatement().execute(
                    "insert into salida (codigoSalida, Identificador, dniPaciente, medico, especialidad, centro, area, descripcion, transporte, fechaInicio) values (" +
                    sa.getCodigo() +
                    ", '" + sa.getEmpleado().getIdentificador() + "', " +
                    "'" + sa.getPaciente().getDni() + "', " +
                    "'" + sa.getMedico() + "', " +
                    "'" + sa.getEspecialidad() + "', " +
                    "'" + sa.getCentro() + "', " +
                    "'" + sa.getArea()+ "', " +
                    "'" + sa.getDescripcion()+ "', " +
                    "'" + sa.getTransporte() + "', " +
                    "'" + sa.getFechaInicio() + "' " +
                    ")"
                ); 
            } else {
                ConexionBD.instancia().getStatement().execute(
                    "insert into salida (codigoSalida, Identificador, dniPaciente, medico, especialidad, centro, area, descripcion, transporte, fechaInicio) values (" +
                    sa.getCodigo() +
                    ", '" + sa.getEmpleado().getIdentificador() + "', " +
                    "'" + sa.getPaciente().getDni() + "', " +
                    "'" + sa.getMedico() + "', " +
                    "'" + sa.getEspecialidad() + "', " +
                    "'" + sa.getCentro() + "', " +
                    "'" + sa.getArea()+ "', " +
                    "'" + sa.getDescripcion()+ "', " +
                    "'" + sa.getTransporte() + "', " +
                    "'" + sa.getFechaInicio() + "', " +
                    "'" + sa.getFechaFin() + "' " +
                    ")"
                ); 
            }
            ConexionBD.desconectar();
                    
        } catch (Exception e) {
            System.err.println("ERROR: Fallo en sentencia INSERT al crear la Salida. (SQLUsuarios.guardarSalida)");
        }   
    }     
        
    // ------------- MODIFICAR -----------------------
    
    public void modificarUsuario(Usuario u){
        if (u instanceof Encargado){
            modificarEncargado((Encargado)u);
        } else if (u instanceof Empleado){
            modificarEmpleado((Empleado)u);
        } else if (u instanceof Jefe){
            modificarJefe((Jefe)u);
        } else {
            System.err.println("ERROR: tipo de Usuario incorrecto. (SQLUsuarios.modificarUsuario)");
        }
    }
    
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
            System.err.println("ERROR: Fallo de conexión al modificar el Empleado. (SQLUsuarios.modificarEmpleado)");
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
            System.err.println("ERROR: Fallo de conexión al modificar el Encargado. (SQLUsuarios.modificarEncargado)");
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
            System.err.println("ERROR: Fallo de conexión al modificar el Jefe. (SQLUsuarios.modificarJefe)");
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
                "update paciente set nombre='" + p.getNombre()
                    + "', apellidos='" + p.getApellidos()
                    + "', telefonoFamilia='" + p.getTelefonoFamilia()
                    + "', centro='" + p.getCentro()
                    + "' where dni='" + p.getDni() + "';"
                );
            ConexionBD.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar el Paciente. (SQLUsuarios.modificarPaciente)");
        }
    }
    
    public void modificarSalida(Salida s){
        /**
         * Sobreescribe los datos de la Salida ya modificada que se pasa como parámetro.
         * Identificador, paciente y fechaInicio no puede cambiar nunca. En caso de 
         * querer cambiar alguno de estos datos, se borrará la salida y se creará una nueva.
         */
        try {
            if (s.getFechaFin() != null){
                ConexionBD.instancia().getStatement().execute(
                    //UPDATE `AppOyoFamiliar`.`salida` SET `area` = 'Norte', `descripcion` = 'Extracción', `fechaFin` = '22-10-2020' WHERE `salida`.`codigoSalida` = 4;

                    "update Salida set " + 
                        "identificador='" +s.getEmpleado().getIdentificador() +
                        "', dniPaciente='" + s.getPaciente().getDni() +
                        "', medico='" + s.getMedico() +
                        "', especialidad='" + s.getEspecialidad() +
                        "', centro='" + s.getCentro() +
                        "', area='" + s.getArea() +
                        "', descripcion='" + s.getDescripcion() +
                        "', transporte='" + s.getTransporte() +
                        "', fechaInicio='" + s.getFechaInicio() +
                        "', fechaFin='" + s.getFechaFin() +
                        "' where codigoSalida=" + s.getCodigo() + ";"
                    );
            } else {
                ConexionBD.instancia().getStatement().execute(
                    "update Salida set identificador='" +s.getEmpleado().getIdentificador() +
                        "', dniPaciente='" + s.getPaciente().getDni() +
                        "', medico='" + s.getMedico() +
                        "', especialidad='" + s.getEspecialidad() +
                        "', centro='" + s.getCentro() +
                        "', area='" + s.getArea() +
                        "', descripcion='" + s.getDescripcion() +
                        "', transporte='" + s.getTransporte() +
                        "', fechaInicio='" + s.getFechaInicio() +
                        "' where codigoSalida=" + s.getCodigo() + ";"
                    );
            }
            ConexionBD.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al modificar Salida. (SQLUsuarios.modificarSalida)");
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
            System.err.println("ERROR: Fallo de conexión al borrar el Usuario. (SQLUsuarios.borrarUsuario)");
        }
    }
    
    public void borrarPaciente(Paciente p) {
        //Borra un Paciente de la base de datos
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Paciente where Dni='" + p.getDni()+ "';"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al borrar el Paciente. (SQLUsuarios.borrarPaciente)");
        }
    }
        
    public void borrarSalida(Salida s) {
        //Borra una Salida de la base de datos
        
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Salida where codigo=" + s.getCodigo() + ";"
                    );
        } catch (Exception e) {
            System.err.println("ERROR: Fallo de conexión al borrar la Salida. (SQLUsuarios.borrarSalida)");
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
            System.err.println("ERROR: Fallo de conexión al buscar el Paciente.  (SQLUsuarios.obtenerPaciente)");
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
            System.err.println("ERROR: Fallo de conexión al buscar el Empleado.(SQLUsuarios.obtenerEmpleado)");
        }
        return em;
    }

}