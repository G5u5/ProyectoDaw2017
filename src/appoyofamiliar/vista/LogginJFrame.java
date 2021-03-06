/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.vista;

import appoyofamiliar.controlador.SQLUsuarios;
import appoyofamiliar.modelo.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class LogginJFrame extends javax.swing.JFrame {
    
    LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
    /**
     * Creates new form LogginJFrame
     */
    public LogginJFrame() {
        initComponents();
        this.usuarios = SQLUsuarios.instancia().descargarDatosU();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreUsuario = new javax.swing.JTextField();
        botonSalir = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clave = new javax.swing.JPasswordField();
        falloEnNombre = new javax.swing.JLabel();
        falloEnClave = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AppOyoFamiliar");

        nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioActionPerformed(evt);
            }
        });

        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AppoyoFamiliar");

        clave.setMinimumSize(new java.awt.Dimension(14, 24));
        clave.setPreferredSize(new java.awt.Dimension(119, 24));
        clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveActionPerformed(evt);
            }
        });

        falloEnNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        falloEnClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Usuario:");

        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(falloEnNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(falloEnClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(falloEnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(falloEnClave, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(botonAceptar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed
        botonAceptarActionPerformed(evt);
    }//GEN-LAST:event_nombreUsuarioActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        String idUsuario = nombreUsuario.getText();
        Usuario marcado;
        
        //Variables de comprobación de campos
        boolean checkNombre = false;
        boolean checkClave = false;
        falloEnNombre.setText("");
        falloEnClave.setText("");
        
        String claveString = "";
        char[] passss = clave.getPassword();
        for(int i = 0; i < passss.length; i++){
            claveString += passss[i];
        }
        
        if (idUsuario.toLowerCase().equals("gorrofete") && claveString.toLowerCase().equals("fary")){
            JOptionPane.showMessageDialog(this, "USUARIO ADMINISTRADOR", "Encontrado", HEIGHT);
            return;
        }
                
        if (idUsuario.equals("")){
            falloEnNombre.setForeground(Color.RED);
            falloEnNombre.setText("Introduzca su identificador");
            checkNombre = false;
        } else {
            checkNombre = true;
        }
        if (clave.getPassword().length == 0){
            falloEnClave.setForeground(Color.RED);
            falloEnClave.setText("Introduzca su clave");
            checkClave = false;
        } else {
            checkClave = true;
        }
             
        if (checkClave && checkNombre){
            marcado = buscarUsuario(idUsuario);
            if (marcado != null){
                if (claveString.equals(marcado.getClave())){
                    falloEnNombre.setText("");
                    falloEnClave.setText("");
                    clave.setText("");
                    nombreUsuario.setText("");
                    nombreUsuario.grabFocus();
                    if (marcado instanceof Jefe){
                        JefeJFrame jefejf = new JefeJFrame(marcado, this, usuarios);
                        jefejf.setVisible(true);
                        this.setVisible(false);
                    }
                    if (marcado instanceof Encargado){
                        EncargadoJFrame encjf = new EncargadoJFrame(marcado, this);
                        encjf.setVisible(true);
                        this.setVisible(false);

                    } else if (marcado instanceof Empleado){
                        EmpleadoJFrame empjf = new EmpleadoJFrame(marcado, this);
                        empjf.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    falloEnNombre.setForeground(Color.red);
                    falloEnNombre.setText("DATOS INCORRECTOS");
                }
            } else {
                falloEnNombre.setForeground(Color.red);
                falloEnNombre.setText("DATOS INCORRECTOS");
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    public Usuario buscarUsuario(String id){
        Usuario retorno = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if ((((usuarios.get(i)).getIdentificador()).toLowerCase()).equals(id)){
                retorno = (Usuario) usuarios.get(i);
            }
        }
        return retorno;
    }
    
    private void claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveActionPerformed
        botonAceptarActionPerformed(evt);
    }//GEN-LAST:event_claveActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPasswordField clave;
    private javax.swing.JLabel falloEnClave;
    private javax.swing.JLabel falloEnNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
