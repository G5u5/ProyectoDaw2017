/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appoyofamiliar.vista;

import appoyofamiliar.modelo.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class GestionarSalidas extends javax.swing.JFrame {
    
    private Usuario usuario;
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
    private LinkedList<Encargado> encargados = new LinkedList<Encargado>();
    private static String[] cabecera = {"CODIGO", "ACOMPAÑANTE", "DNI PACIENTE", "MEDICO", "FECHAINICIO", "FECHAFIN"};
    private static DefaultTableModel dtm;
    
    /**
     * Creates new form GestionarEncargados
     */
    public GestionarSalidas() {
        initComponents();
    }
    
    public GestionarSalidas(Usuario usr) {
        initComponents();
        this.usuario = usr;
        dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPreviaPendientes(usuario),cabecera);
        tablaSalidas.setModel(dtm);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoSalidaButtonGroup = new javax.swing.ButtonGroup();
        botonCerrar = new javax.swing.JButton();
        botonVerMas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        salidasPendientes = new javax.swing.JRadioButton();
        salidasRealizadas = new javax.swing.JRadioButton();
        todasLasSalidas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTIONAR SALIDAS");

        botonCerrar.setText("<html>CERRAR<br/>SALIDA</html>");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonVerMas.setText("VER MAS");
        botonVerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerMasActionPerformed(evt);
            }
        });

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaSalidas);

        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE SALIDAS");

        tipoSalidaButtonGroup.add(salidasPendientes);
        salidasPendientes.setSelected(true);
        salidasPendientes.setText("Salidas pendientes");
        salidasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidasPendientesActionPerformed(evt);
            }
        });

        tipoSalidaButtonGroup.add(salidasRealizadas);
        salidasRealizadas.setText("Salidas realizadas");
        salidasRealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidasRealizadasActionPerformed(evt);
            }
        });

        tipoSalidaButtonGroup.add(todasLasSalidas);
        todasLasSalidas.setText("Todas las Salidas");
        todasLasSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasLasSalidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)
                        .addComponent(botonVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(salidasPendientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salidasRealizadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(todasLasSalidas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salidasPendientes)
                            .addComponent(salidasRealizadas)
                            .addComponent(todasLasSalidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonVerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerMasActionPerformed
        (new GestionarSalidasGrande(usuario)).setVisible(true);
    }//GEN-LAST:event_botonVerMasActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        int fila = tablaSalidas.getSelectedRow();
        
        if (fila < 0){
            JOptionPane.showMessageDialog(this, "Seleccione un elemento", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String fechaFin = JOptionPane.showInputDialog((new JFrame("CERRAR SALIDA")), "Escriba la fecha yyyy-mm-dd");
            
            if (fechaFin != null || !(fechaFin.equals(""))){
                ConjuntoSalida.instancia().cerrarSalida(Integer.parseInt(tablaSalidas.getValueAt(fila, 0).toString()), fechaFin);
                tablaSalidas.clearSelection();
                if (salidasPendientes.isSelected()){
                    dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPreviaPendientes(usuario),cabecera);
                } else if (salidasRealizadas.isSelected()){
                    dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPreviaRealizadas(usuario),cabecera);
                } else {
                    dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPrevia(usuario),cabecera);
                }
                tablaSalidas.setModel(dtm);
            } else {
                JOptionPane.showMessageDialog(this, "La fecha no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void salidasRealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidasRealizadasActionPerformed
        botonCerrar.setText("<html>Modificar<br/>hora fin</html>");
        dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPreviaRealizadas(usuario),cabecera);
        tablaSalidas.setModel(dtm);
    }//GEN-LAST:event_salidasRealizadasActionPerformed

    private void salidasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidasPendientesActionPerformed
        botonCerrar.setText("<html>Cerrar<br/>salida</html>");
        dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPreviaPendientes(usuario),cabecera);
        tablaSalidas.setModel(dtm);
    }//GEN-LAST:event_salidasPendientesActionPerformed

    private void todasLasSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasLasSalidasActionPerformed
        botonCerrar.setText("<html>Modificar<br/>hora fin</html>");
        dtm = new DefaultTableModel(ConjuntoSalida.instancia().obtenerDatosTablaPrevia(usuario),cabecera);
        tablaSalidas.setModel(dtm);
    }//GEN-LAST:event_todasLasSalidasActionPerformed

    public void cerrarSalida(String ff){
        //ConjuntoSalida.instancia().buscarSalida(e, p, ff);
    }
    
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
            java.util.logging.Logger.getLogger(GestionarSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarSalidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonVerMas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton salidasPendientes;
    private javax.swing.JRadioButton salidasRealizadas;
    private javax.swing.JTable tablaSalidas;
    private javax.swing.ButtonGroup tipoSalidaButtonGroup;
    private javax.swing.JRadioButton todasLasSalidas;
    // End of variables declaration//GEN-END:variables
}
