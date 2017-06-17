/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

import appoyofamiliar.controlador.*;
import appoyofamiliar.vista.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Jesús Durántez Prieto
 */
public class ApPoyoFamiliar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new LogginJFrame()).setVisible(true);
        
        

//***************************************************************************************
//***** PRUEBAS DE CREACION DE LA LISTA DE SALIDAS                            ***********
//***************************************************************************************
        /*
        LinkedList<Salida> salidas;
        salidas = new LinkedList();
        salidas = SQLUsuarios.instancia().descargarDatosS();
        System.out.println("Salidas cargado bien");
        System.out.println("");
        String[][] tabla = new String[salidas.size()][5];
        System.out.println("Tabla creada bien");
        System.out.println("");
        
        int contador = 0;
        System.out.println("Contador creado");
        
        
        for (int i = 0; i < salidas.size(); i++){
            if (!salidas.get(i).getControl().equals("borrar")){
                tabla[contador][0]= salidas.get(i).getEmpleado().getNombre();
                tabla[contador][1]= salidas.get(i).getPaciente().getNombre();
                tabla[contador][2]= salidas.get(i).getMedico();
                tabla[contador][3]= salidas.get(i).getFechaInicio().toString();
                if (salidas.get(i).getFechaFin() != null){
                    tabla[contador][4]= salidas.get(i).getFechaFin().toString();
                }
                System.out.println("Cargando tabla, elemento: " + contador + ". Posicion " + i + " de la lista");
                System.out.println("Señor " + salidas.get(i).getEmpleado().getNombre());
                contador++;
                
            }
            
        }
        
        //****************************************************************************
        //****************************************************************************
        //****************************************************************************
        
        //String[][] tabla = ConjuntoSalida.instancia().obtenerDatosTablaPrevia();
        
        for (String[] tabla1 : tabla) {
            for (String item : tabla1) {
                System.out.print(item);
                System.out.print(" | ");
            }
            System.out.println("");
        }
******************************************************************************************************/
        
//--------- CODIGO PARA PRUEBAS QUE REQUIEREN INPUT --------------------
//JFrame frame = new JFrame("InputDialog Example #1");
//String name = JOptionPane.showInputDialog(frame, "What's your name?");
//----------------------------------------------------------------------
        

//--------------------------------------------------------------------------------------        
/*------------- PRUEBAS SIN CONEXION A BASE DATOS --------------------------------------
//--------------------------------------------------------------------------------------
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        LinkedList<Salida> salidas = new LinkedList<Salida>();
        LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
        Jefe pepe = new Jefe("Pepe", "pepe", "Sr. Pepe", "Pepe de Pepe", "123456789P", "978456123", "Calle del señor Pepe", "Valladolid");
        Empleado pepito = new Empleado("Pepito", "pepi", "Sr. Pepito", "Pepito de Pepito", "987654321P", "978123456", "Calle del señor Pepito", "Palencia");
        Encargado pepote = new Encargado("Pepote", "pepo", "Sr. Pepote", "Pepote de Pe", "654987321P", "978415263", "Calle del señor Pepote", "Palencia" , "Norte");
        usuarios.add(pepe);
        usuarios.add(pepito);
        usuarios.add(pepote);
        ----------------------------------------------------------------------*/

/*
*****************************************************************************************************
//----CÓDIGO PARA PROBAR QUE CADA OBJETO GUARDADO ES DE LA CLASE QUE LE CORRESPONDE------------
        
        LinkedList<Usuario> usuarios = new LinkedList();
        usuarios = SQLUsuarios.instancia().descargarDatosU();

        for (int i=0; i< usuarios.size(); i++){
        if (usuarios.get(i) instanceof Encargado){
        System.out.println(i);
        System.out.println("EMPLEADO " + usuarios.get(i).getIdentificador());
        } else if (usuarios.get(i) instanceof Empleado){
        System.out.println(i);
        System.out.println("ENCARGADO " + usuarios.get(i).getIdentificador());
        } else if (usuarios.get(i) instanceof Jefe){
        System.out.println(i);
        System.out.println("BOSSSSSS " + usuarios.get(i).getIdentificador());
        }else {
        System.err.println("No tengo muy claras las cosas... :(");
        }
        }
******************************************************************************************************
*/
        
    }
    
    /**
     *Genera un iterador que recorre la LinkedList, mostrando cada elemento encontrado.
     * UTILIZADO PARA PRUEBAS
     */
    /*
    public void mostrarPlantilla(){
        if (listaPlantilla != null){
            Iterator iterador = listaPlantilla.iterator();
            Usuario marcado = (Usuario) iterador.next();
            if(iterador.hasNext()){
                marcado.verDatosPropios();
            } else {
                System.out.println("No quedan más elementos.");
            }
        } else {
            Scanner teclado = new Scanner(System.in);
            String opcion = "";
            System.out.println("No existe un registro de usuarios actualmente.");
            System.out.println("¿Desea iniciar la creacion de usuarios? [si/no]");
            do{
                opcion = teclado.nextLine();
                switch (opcion){
                    case "si":
                        nuevoUsuario();
                        break;
                    case "no":
                        break;
                    default:
                        System.out.println("Introduzca una opción válida.");
                        System.out.println("¿Desea iniciar la creacion de usuarios? [si/no]");
                        break;
                }
            }while(!(opcion.toLowerCase().equals("si")) && !(opcion.toLowerCase().equals("no")));
        }
    }
    */
//***************************************************************************************
//***** PRUEBAS DE CREACION DE LA LISTA DE SALIDAS                            ***********
//***************************************************************************************

    /*private static Paciente obtenerPaciente(String denei){
        //Busca y devuelve el objeto Paciente cuyo D.N.I. corresponde al que se pasa como parametro.

        Paciente pa = null;
        
        try{
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Paciente where dni='" + denei + "';" 
            );
            while (rsi.next()) {
                if (rsi.getString(3).equals(denei)){
                    pa = new Paciente(rsi.getString(1), rsi.getString(2), rsi.getString(3), rsi.getString(4), rsi.getString(5));
                }
            }
            rsi.close();
        }catch (Exception e){
            System.err.println("ERROR: Fallo de conexión al buscar el Paciente");
        }
        return pa;
    }
    
    private static Empleado obtenerEmpleado(String ident){
        //Busca y devuelve el objeto Empleado cuyo identificador corresponde al que se pasa como parametro.
        
        Empleado em = null;
        
        try{
            ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select * from Usuario where Identificador='" + ident + "';" 
            );
            while (rsi.next()) {
                if (rsi.getString(1).equals(ident)){
                    em = new Empleado(rsi.getString(1), rsi.getString(3), rsi.getString(4), rsi.getString(5), rsi.getString(6), rsi.getString(7), rsi.getString(9));
                }
            }
            rsi.close();
        }catch (Exception e){
            System.err.println("ERROR: Fallo de conexión al buscar el Empleado");
        }
        return em;
    }
    
***************************************************************************************************/
    
}
