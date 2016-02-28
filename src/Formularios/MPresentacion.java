/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDPresentacion;
import Class.Presentacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jluis
 */
public class MPresentacion extends javax.swing.JInternalFrame {

    String accion = "";

    /**
     * Creates new form MPresentacion
     */
    public MPresentacion() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }        
        initComponents();
        obtenerUltimoIdpre();
        actualizarBusquedapre();
      //  this.setLocationRelativeTo(null);
        activarBotonespre(true);
    }

    public void obtenerUltimoIdpre() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id_presentacion) from presentacion");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtId.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.println("Error" + error);
        }
}
    public void limpiarCajaTextopre() {
        txtId.setText("");
        txtDescripcion.setText("");
        
    }

    public void activarCajaTextopre(boolean b) {
        
        txtId.setEnabled(!b);
        txtDescripcion.setEnabled(b);
    }

    public void activarBotonespre(boolean b) {
        Pnuevo.setEnabled(b);
        Pguardar.setEnabled(!b);
        Peditar.setEnabled(b);
        Pcancelar.setEnabled(!b);
    }



/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPresentacion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Pnuevo = new javax.swing.JButton();
        Pguardar = new javax.swing.JButton();
        Peditar = new javax.swing.JButton();
        Pcancelar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setTitle("PRESENTACION DE PRODUCTO");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jtPresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No.", "Descripcion"
            }
        ));
        jtPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPresentacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPresentacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        Pnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        Pnuevo.setText("Nuevo");
        Pnuevo.setToolTipText("");
        Pnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PnuevoActionPerformed(evt);
            }
        });

        Pguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        Pguardar.setText("Guardar");
        Pguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PguardarActionPerformed(evt);
            }
        });

        Peditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        Peditar.setText("Editar");
        Peditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeditarActionPerformed(evt);
            }
        });

        Pcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Pcancelar.setText("Cancelar");
        Pcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PcancelarActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtId))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Pnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Peditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pcancelar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Peditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Pnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPresentacionMouseClicked

        try {
           Presentacion pre = BDPresentacion.buscarPrecentacion(Integer.parseInt(String.valueOf(jtPresentacion.getModel().getValueAt(jtPresentacion.getSelectedRow(),0))));
            txtId.setText(String.valueOf(pre.getId_presentacion()));
            txtDescripcion.setText(pre.getDescripcion());

        } catch (Exception e) {
            System.out.println("Erro de Seleccion:" + e);
        }
    }//GEN-LAST:event_jtPresentacionMouseClicked

    private void PnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PnuevoActionPerformed
        // TODO add your handling code here:
        limpiarCajaTextopre();
        activarCajaTextopre(true);
        activarBotonespre(false);
        obtenerUltimoIdpre();
        accion = "Guardar";
    }//GEN-LAST:event_PnuevoActionPerformed

    private void PguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PguardarActionPerformed

        if (accion.equalsIgnoreCase("Guardar")) {

            if (txtId.getText().compareTo("") != 0 && txtDescripcion.getText().compareTo("") != 0) {
                try {
                    Presentacion p = new Presentacion();
                    p.setDescripcion(txtDescripcion.getText().toUpperCase());
                    p.setId_presentacion(Integer.parseInt(txtId.getText()));
                    BDPresentacion.insertarPresentacion(p);
                    JOptionPane.showMessageDialog(null, "Registro Guardado");

                } catch (Exception e) {
                    System.out.println("Error BD:" + e.getMessage());
                }
                limpiarCajaTextopre();
                obtenerUltimoIdpre();
                actualizarBusquedapre();
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Presentacion p;
            try {
                p = BDPresentacion.buscarPrecentacion(Integer.parseInt(txtId.getText()));
                p.setDescripcion(txtDescripcion.getText());
                BDPresentacion.actualizarPresentacion(p);
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
                limpiarCajaTextopre();
                obtenerUltimoIdpre();
                activarBotonespre(true);
                actualizarBusquedapre();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_PguardarActionPerformed

    private void PeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeditarActionPerformed
        accion = "Actualizar";
        activarCajaTextopre(true);
        Pnuevo.setEnabled(false);
        Pguardar.setEnabled(true);
        Peditar.setEnabled(false);
        Pcancelar.setEnabled(true);
    }//GEN-LAST:event_PeditarActionPerformed

    private void PcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PcancelarActionPerformed
        // TODO add your handling code here:
        limpiarCajaTextopre();
        obtenerUltimoIdpre();
        activarBotonespre(true);
    }//GEN-LAST:event_PcancelarActionPerformed

 private void actualizarBusquedapre() {
        ArrayList<Presentacion> result1 = BDPresentacion.ListarUnidadMedida();
        recargarTable(result1);
    }
    
    public void recargarTable(ArrayList<Presentacion> list) {
        Object[][] datos1 = new Object[list.size()][2];
        int i = 0;
        for (Presentacion p : list)
        {
            datos1[i][0] = p.getId_presentacion();
            datos1[i][1] = p.getDescripcion();
            i++;
        }
        jtPresentacion.setModel(new javax.swing.table.DefaultTableModel(
                datos1,
                new String[]{
                    "No.","Descripcion"
                }) {
                     @Override
        public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
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
            java.util.logging.Logger.getLogger(MPresentacion.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MPresentacion.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MPresentacion.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MPresentacion.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MPresentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pcancelar;
    private javax.swing.JButton Peditar;
    private javax.swing.JButton Pguardar;
    private javax.swing.JButton Pnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPresentacion;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
