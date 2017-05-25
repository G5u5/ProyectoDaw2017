/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.modelo;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class Administracion {
    public Plantilla trabajadores; 
    private ConjuntoSalida salidas;
    private ConjuntoPaciente pacientes;
    private Usuario usuarioActual;;

    public Administracion(Plantilla trabajadores, ConjuntoSalida salidas, ConjuntoPaciente pacientes, Usuario usuarioActual) {
        this.trabajadores = trabajadores;
        this.salidas = salidas;
        this.pacientes = pacientes;
        this.usuarioActual = usuarioActual;
    }
    
    public Administracion(Plantilla trabajadores, ConjuntoSalida salidas, ConjuntoPaciente pacientes) {
        this.trabajadores = trabajadores;
        this.salidas = salidas;
        this.pacientes = pacientes;
    }    
}
