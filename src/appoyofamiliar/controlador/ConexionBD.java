/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.controlador;

import java.sql.*;

/**
 * 
 * @author Jesús Durántez Prieto
 */
public class ConexionBD {
    Connection conn;
    Statement stmt;
    
    static ConexionBD instancia = null;
    
    private ConexionBD() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.12:3306/ventasbd","root","mysql");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public Statement getStatement() {
        return stmt;
    }
    
    public static ConexionBD instancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.execute("shutdown");
                instancia.stmt.close();
                instancia.conn.close();
                instancia = null;
            }
            catch(SQLException e) {
            }
        }
    }
}
