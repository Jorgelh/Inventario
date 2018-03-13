/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import BD.BD;
import BD.BDConsultas;
import BD.DBCargaPro;
import Class.CargaP;
import Class.consultanp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jorge Luis
 */
public class CIngresoPN extends javax.swing.JInternalFrame {
           DefaultTableModel temp;

    /**
     * Creates new form ConsultaPN
     */
    public CIngresoPN() {
        initComponents();
        txtPN.requestFocus();
    }
    
    public void limpiartabla() {

        try {
            temp = (DefaultTableModel) tablaCon.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }

    }
    
    
    public void validar(){
        if (txtPN.getText().compareTo("") != 0){
    
    try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from ingreso  where upper(P_N) like upper('" + txtPN.getText()+"%')");
            rs.next();
            int codigo = rs.getInt("count(*)");
            if (codigo > 0) {
                actualizarTablaPN();
                txtPN.setEnabled(false);
                Bnueva.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "El P/N " + txtPN.getText() + " No Contiene Ingresos");
                txtPN.setText("");

            }

        } catch (Exception e) {
            System.out.println("Editar Error" + e);

        }
        }else{JOptionPane.showMessageDialog(null,"INGRESER P/N...");}
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCon = new javax.swing.JTable();
        Bnueva = new javax.swing.JButton();
        bodegaselect2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA POR P/N");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        txtPN.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNActionPerformed(evt);
            }
        });
        txtPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPNKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("P/N");

        tablaCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Fecha de Entrega", "P/N", "Trabajo", "Lote ", "P.O", "Cantidad Bodega", "Cantidad Ingresada", "Proveedor", "Notas", "Ingresado Por"
            }
        ));
        jScrollPane1.setViewportView(tablaCon);

        Bnueva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Bnueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        Bnueva.setText("Nueva Consulta");
        Bnueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnuevaActionPerformed(evt);
            }
        });
        Bnueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BnuevaKeyPressed(evt);
            }
        });

        bodegaselect2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bodegaselect2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Bodega", "Bodeguita" }));
        bodegaselect2.setFocusable(false);
        bodegaselect2.setName(""); // NOI18N
        bodegaselect2.setRequestFocusEnabled(false);
        bodegaselect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodegaselect2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Bodega");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bodegaselect2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPN, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 339, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Bnueva)
                .addGap(485, 485, 485))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bodegaselect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnueva, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNActionPerformed
       validar();  
    }//GEN-LAST:event_txtPNActionPerformed

    private void txtPNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPNKeyTyped
        
            
        
            }//GEN-LAST:event_txtPNKeyTyped

    private void BnuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnuevaActionPerformed
                
        limpiartabla();
        txtPN.setText("");
        txtPN.setEnabled(true);
        bodegaselect2.setSelectedItem("Todos");
        txtPN.requestFocus();


    }//GEN-LAST:event_BnuevaActionPerformed

    private void BnuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BnuevaKeyPressed

        limpiartabla();
        txtPN.setText("");
        txtPN.requestFocus();


    }//GEN-LAST:event_BnuevaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       validar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bodegaselect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodegaselect2ActionPerformed
      txtPN.requestFocus();
    }//GEN-LAST:event_bodegaselect2ActionPerformed

    private void actualizarTablaPN() {
        
        int b1;
        int b2;
        
        if (bodegaselect2.getSelectedItem() == "Bodega"){ b1 = 1; b2 = 0; }
        else if(bodegaselect2.getSelectedItem() == "Bodeguita"){b1 = 0; b2 = 2;}
        else{b1=1;b2=2;}
      

        ArrayList<consultanp> result = BDConsultas.ListaringrePN(txtPN.getText(),b1,b2);
        recagarTabla(result);
    }

    private void recagarTabla(ArrayList<consultanp> list) {

        Object[][] dato = new Object[list.size()][13];
        int f = 0;
        for (consultanp a : list) {
            dato[f][0] = a.getCodigo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getFechaingre();
            dato[f][3] = a.getPN();
            dato[f][4] = a.getNo_trabajo();
            dato[f][5] = a.getLote();
            dato[f][6] = a.getPO();
            dato[f][7] = a.getCantidad();
            dato[f][8] = a.getCantidad2();
            dato[f][9] = a.getCantInicial();
            dato[f][10] = a.getProveedor();
            dato[f][11] = a.getNota();
            dato[f][12] = a.getIngrepor();
            f++;
        }
        tablaCon.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "Codigo","Descripcion","Fecha de Ingreso","P/N","Trabajo","Lote","P.O","Cantidad Bodega","Cantidad Bodega2","Cantidad de Ingreso","Proveedor","Notas","Ingresado por"

                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                });
        
         TableColumn columna1 = tablaCon.getColumn("Trabajo");
            columna1.setPreferredWidth(5);
          TableColumn columna2 = tablaCon.getColumn("Lote");
            columna2.setPreferredWidth(5);   
         TableColumn columna3 = tablaCon.getColumn("P/N");
            columna3.setPreferredWidth(5);  
         TableColumn columna4 = tablaCon.getColumn("Codigo");
            columna4.setPreferredWidth(15);
         TableColumn columna5 = tablaCon.getColumn("Fecha Ingreso");
            columna5.setPreferredWidth(5);  
         TableColumn columna6 = tablaCon.getColumn("P.O");
            columna6.setPreferredWidth(5);   
         TableColumn columna7 = tablaCon.getColumn("Descripcion");
            columna7.setPreferredWidth(150);      
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
            java.util.logging.Logger.getLogger(CIngresoPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CIngresoPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CIngresoPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CIngresoPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CIngresoPN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bnueva;
    private javax.swing.JComboBox<String> bodegaselect2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCon;
    private javax.swing.JTextField txtPN;
    // End of variables declaration//GEN-END:variables
}
