/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.controlador;

import java.sql.ResultSet;
import appoyofamiliar.modelo.Jefe;
import appoyofamiliar.modelo.Encargado;
import appoyofamiliar.modelo.Empleado;
import appoyofamiliar.modelo.Usuario;
import java.sql.SQLException;
import appoyofamiliar.modelo.Plantilla;
/**
 *
 * @author Felipe Ruiz
 */
public class SQLUsuarios {
    private static SQLUsuarios instancia = null;
    private Plantilla pl = new Plantilla();
    
    public static SQLUsuarios instancia() {
        if (instancia == null) {
            instancia = new SQLUsuarios();
        }
        
        return instancia;
    }
    
    public void descargarDatos(Usuario u) throws SQLException {
        Empleado em = null;
        Encargado en = null;
        Jefe je = null;
        // Nº de columna
        int i = 1;
        try {
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                "select * from Usuario"
                );
            while (rsi.next()) {
                if(rsi.getString(9) != null){
                //Cambiaremos de columna con el metodo absolute diciendole el nº.
                rsi.absolute(i);
                i++;
                em = new Empleado (rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9));
                pl.nuevoUsuario(em);
                }
                else if (rsi.getString(8) != null){
                    rsi.absolute(i);
                    i++;
                    je = new Jefe(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(8));
                    pl.nuevoUsuario(je);
                }
                else if (rsi.getString(10) != null && rsi.getString(9) != null){
                    rsi.absolute(i);
                    i++;
                    en = new Encargado(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9), rsi.getString(10));
                    pl.nuevoUsuario(en);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void crearEm(Empleado em) {        
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario values (" +
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
            System.out.println("Error al crear Empleado");
        }        
    }
    public void crearEn(Encargado en) {        
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario values (" +
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
            System.out.println("Error al crear Encargado");
        }        
    }
    public void crearJ(Jefe je) {        
        try {
               
            ConexionBD.instancia().getStatement().execute(
                    "insert into Usuario values (" +
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
            System.out.println("Error al crear Jefe");
        }        
    }
    public void borrar(Usuario u) {
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from Usuario where Dni=" + 
                    "'"+ u.getDni()+"'"
                    );
        } catch (Exception e) {
            System.out.println("Error al borrar usuario");
        }
    } 
}
