/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDMedida;
import BD.DBFamilia;
import Class.Familia;
import Class.Medida;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jluis
 */
public class MIngresoFamilia extends javax.swing.JFrame {
    
    String accion = "";

    /**
     * Creates new form IngresoFamilia
     */
    public MIngresoFamilia() {
    try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        obtenerUltimoIdfam();
        actualizarBusquedafam();
        this.setLocationRelativeTo(null);
        activarBotones(true);
    }
    
    public void obtenerUltimoIdfam() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(fam_id) from familia");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                 txtFId.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }
    
    public void limpiarCajaTextofam() {
        txtFId.setText("");
        txtFDescripcion.setText("");
    }

    public void activarCajaTextofam(boolean b) {
        txtFId.setEditable(!b);
        txtFDescripcion.setEditable(b);
    }
    
    public void activarBotones(boolean b){
        BFNuevo.setEnabled(b);
        BFguardar.setEnabled(!b);
        BFeditar.setEnabled(b);
        BFcancelar.setEnabled(!b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        BFNuevo = new javax.swing.JButton();
        BFguardar = new javax.swing.JButton();
        BFeditar = new javax.swing.JButton();
        BFcancelar = new javax.swing.JButton();
        txtFDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFId = new javax.swing.JTextField();
        jcprueba = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFMedida = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO DE FAMILIAS");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        BFNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        BFNuevo.setText("Nuevo");
        BFNuevo.setToolTipText("");
        BFNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFNuevoActionPerformed(evt);
            }
        });

        BFguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        BFguardar.setText("Guardar");
        BFguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFguardarActionPerformed(evt);
            }
        });

        BFeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        BFeditar.setText("Editar");
        BFeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFeditarActionPerformed(evt);
            }
        });

        BFcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        BFcancelar.setText("Cancelar");
        BFcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFcancelarActionPerformed(evt);
            }
        });

        txtFDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        txtFId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jcprueba.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(BFNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BFguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BFeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BFcancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcprueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(txtFId)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jcprueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BFcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BFeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BFguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BFNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jtFMedida.setModel(new javax.swing.table.DefaultTableModel(
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
        jtFMedida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFMedidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFMedida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtFMedidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFMedidaMouseClicked

        try {
            Familia med = DBFamilia.buscarFamilia(Integer.parseInt(String.valueOf(jtFMedida.getModel().getValueAt(jtFMedida.getSelectedRow(),0))));

            txtFId.setText(String.valueOf(med.getFam_id()));
            txtFDescripcion.setText(med.getDescripcion());

        } catch (Exception e) {
            System.out.println("Erro de Seleccion:"+e);
        }
    }//GEN-LAST:event_jtFMedidaMouseClicked

    private void BFNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCajaTextofam();
        activarCajaTextofam(true);
        activarBotones(false);
        obtenerUltimoIdfam();
        accion = "Guardar";
    }//GEN-LAST:event_BFNuevoActionPerformed

    private void BFguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFguardarActionPerformed
        
        if(accion.equalsIgnoreCase("Guardar")){

            if (txtFId.getText().compareTo("")!=0 && txtFDescripcion.getText().compareTo("")!=0){
                try {
                    Familia m = new Familia();
                    m.setDescripcion(txtFDescripcion.getText().toUpperCase());
                    DBFamilia.insertarFamilia(m);
                    JOptionPane.showMessageDialog(null,"Registro Guardado");

                } catch (Exception e) {
                    System.out.println("Error BD:"+e.getMessage());
                }
                limpiarCajaTextofam();
                obtenerUltimoIdfam();
                actualizarBusquedafam();
            }else {
                JOptionPane.showMessageDialog(null,"Llene Todos Los Campos...");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Familia p;
            try {
                p= DBFamilia.buscarFamilia(Integer.parseInt(txtFId.getText()));
                p.setDescripcion(txtFDescripcion.getText());
                DBFamilia.actualizarFamilia(p);
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
                limpiarCajaTextofam();
                obtenerUltimoIdfam();
                activarBotones(true);
                actualizarBusquedafam();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_BFguardarActionPerformed

    private void BFeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFeditarActionPerformed
        accion = "Actualizar";
        activarCajaTextofam(true);
        BFNuevo.setEnabled(false);
        BFguardar.setEnabled(true);
        BFeditar.setEnabled(false);
        BFcancelar.setEnabled(true);
    }//GEN-LAST:event_BFeditarActionPerformed

    private void BFcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFcancelarActionPerformed
        limpiarCajaTextofam();
        obtenerUltimoIdfam();
        activarBotones(true);
    }//GEN-LAST:event_BFcancelarActionPerformed

     private void actualizarBusquedafam() {
        ArrayList<Familia> result = DBFamilia.ListarFamilias();
        recargarTablefam(result);
    }
    
    public void recargarTablefam(ArrayList<Familia> list) {
        Object[][] datos = new Object[list.size()][2];
        int i = 0;
        for (Familia f : list)
        {
            datos[i][0] = f.getFam_id();
            datos[i][1] = f.getDescripcion();
            i++;
        }
        jtFMedida.setModel(new javax.swing.table.DefaultTableModel(
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
            java.util.logging.Logger.getLogger(MIngresoFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MIngresoFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MIngresoFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MIngresoFamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       // </editor-fold>
       // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MIngresoFamilia().setVisible(true);
            }
        });
}
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFNuevo;
    private javax.swing.JButton BFcancelar;
    private javax.swing.JButton BFeditar;
    private javax.swing.JButton BFguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcprueba;
    private javax.swing.JTable jtFMedida;
    private javax.swing.JTextField txtFDescripcion;
    private javax.swing.JTextField txtFId;
    // End of variables declaration//GEN-END:variables
}