/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDMedida;
import BD.BDprocedencia;
import Class.Medida;
import Class.Procedencia;
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
 * @author Jorge Luis
 */
public class MProcedencia extends javax.swing.JInternalFrame {

     String accion = "";
    /**
     * Creates new form Procedencia
     */
    public MProcedencia() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }        
        initComponents();
        obtenerUltimoIdpro();
        actualizarBusquedapro();
       // this.setLocationRelativeTo(null);
        activarBotonespro(true);
    }


public void obtenerUltimoIdpro() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id_proce) from id_procedencia");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtIdpro.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
}
    public void limpiarCajaTextopro() {
        txtIdpro.setText("");
        txtDescripcionpro.setText("");
        
    }

    public void activarCajaTextopro(boolean b) {
        
        txtIdpro.setEnabled(!b);
        txtDescripcionpro.setEnabled(b);
    }

    public void activarBotonespro(boolean b) {
        Bnuevopro.setEnabled(b);
        Bguardarpro.setEnabled(!b);
        Beditarpro.setEnabled(b);
        Bcancelarpro.setEnabled(!b);
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
        jtprocedencia = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Bnuevopro = new javax.swing.JButton();
        Bguardarpro = new javax.swing.JButton();
        Beditarpro = new javax.swing.JButton();
        Bcancelarpro = new javax.swing.JButton();
        txtDescripcionpro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdpro = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setTitle("Procedencia de Material");
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jtprocedencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jtprocedencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtprocedenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtprocedencia);

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

        Bnuevopro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        Bnuevopro.setText("Nuevo");
        Bnuevopro.setToolTipText("");
        Bnuevopro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnuevoproActionPerformed(evt);
            }
        });

        Bguardarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        Bguardarpro.setText("Guardar");
        Bguardarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BguardarproActionPerformed(evt);
            }
        });

        Beditarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        Beditarpro.setText("Editar");
        Beditarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditarproActionPerformed(evt);
            }
        });

        Bcancelarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Bcancelarpro.setText("Cancelar");
        Bcancelarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarproActionPerformed(evt);
            }
        });

        txtDescripcionpro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        txtIdpro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                            .addComponent(txtDescripcionpro, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtIdpro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Bnuevopro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bguardarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Beditarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bcancelarpro)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcionpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Bcancelarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Beditarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Bguardarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Bnuevopro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtprocedenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtprocedenciaMouseClicked

        try {
            Procedencia pro = BDprocedencia.buscarProcedencia(Integer.parseInt(String.valueOf(jtprocedencia.getModel().getValueAt(jtprocedencia.getSelectedRow(),0))));

            txtIdpro.setText(String.valueOf(pro.getId_proce())); 
            txtDescripcionpro.setText(pro.getDescripcion());

        } catch (Exception e) {
            System.out.println("Erro de Seleccion:"+e);
        }
    }//GEN-LAST:event_jtprocedenciaMouseClicked

    private void BnuevoproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnuevoproActionPerformed
        // TODO add your handling code here:
        limpiarCajaTextopro();
        activarCajaTextopro(true);
        activarBotonespro(false);
        obtenerUltimoIdpro();
        accion = "Guardar";
    }//GEN-LAST:event_BnuevoproActionPerformed

    private void BguardarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BguardarproActionPerformed

        if(accion.equalsIgnoreCase("Guardar")){

            if (txtIdpro.getText().compareTo("")!=0 && txtDescripcionpro.getText().compareTo("")!=0){
                try {
                    Procedencia m = new Procedencia();
                    m.setDescripcion(txtDescripcionpro.getText().toUpperCase());
                    m.setId_proce(Integer.parseInt(txtIdpro.getText()));
                    BDprocedencia.insertarProcedencia(m);
                    JOptionPane.showMessageDialog(null,"Registro Guardado");

                } catch (Exception e) {
                    System.out.println("Error BD:"+e.getMessage());
                }
                limpiarCajaTextopro();
                obtenerUltimoIdpro();
                actualizarBusquedapro();
            }else {
                JOptionPane.showMessageDialog(null,"Llene Todos Los Campos...");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Procedencia p;
            try {
                p= BDprocedencia.buscarProcedencia(Integer.parseInt(txtIdpro.getText()));
                p.setDescripcion(txtDescripcionpro.getText());
                BDprocedencia.actualizarProcedencia(p);
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
                limpiarCajaTextopro();
                obtenerUltimoIdpro();
                activarBotonespro(true);
                actualizarBusquedapro();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_BguardarproActionPerformed

    private void BeditarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditarproActionPerformed
        accion = "Actualizar";
        activarCajaTextopro(true);
        Bnuevopro.setEnabled(false);
        Bguardarpro.setEnabled(true);
        Beditarpro.setEnabled(false);
        Bcancelarpro.setEnabled(true);
    }//GEN-LAST:event_BeditarproActionPerformed

    private void BcancelarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarproActionPerformed
        // TODO add your handling code here:
        limpiarCajaTextopro();
        obtenerUltimoIdpro();
        activarBotonespro(true);
    }//GEN-LAST:event_BcancelarproActionPerformed
 private void actualizarBusquedapro() {
        ArrayList<Procedencia> result = BDprocedencia.ListarProcedencia();
        recargarTable(result);
    }
    
    public void recargarTable(ArrayList<Procedencia> list) {
        Object[][] datos = new Object[list.size()][2];
        int i = 0;
        for (Procedencia m : list)
        {
            datos[i][0] = m.getId_proce();
            datos[i][1] = m.getDescripcion();
            i++;
        }
        jtprocedencia.setModel(new javax.swing.table.DefaultTableModel(
                datos,
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
            java.util.logging.Logger.getLogger(MProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MProcedencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcancelarpro;
    private javax.swing.JButton Beditarpro;
    private javax.swing.JButton Bguardarpro;
    private javax.swing.JButton Bnuevopro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtprocedencia;
    private javax.swing.JTextField txtDescripcionpro;
    private javax.swing.JTextField txtIdpro;
    // End of variables declaration//GEN-END:variables
}
