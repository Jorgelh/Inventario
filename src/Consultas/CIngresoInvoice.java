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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jorge Luis
 */
public class CIngresoInvoice extends javax.swing.JInternalFrame {
           DefaultTableModel temp;

    /**
     * Creates new form ConsultaPN
     */
    public CIngresoInvoice() {
        initComponents();
         txtInvoice.requestFocus();
       
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtInvoice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCon = new javax.swing.JTable();
        Bnueva = new javax.swing.JButton();
        bodegaselect2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA POR INVOICE");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        txtInvoice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoiceActionPerformed(evt);
            }
        });
        txtInvoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInvoiceKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("#Invoice");

        tablaCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Fecha de Entrega", "P/N", "Trabajo", "Lote ", "P.O", "Precio", "Cantidad Bodega", "Cantidad Ingresada", "Proveedor", "Notas", "Ingresado Por"
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
        bodegaselect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodegaselect2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Bodega");

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
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 327, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Bnueva)
                .addGap(450, 450, 450))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bodegaselect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnueva, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void txtInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoiceActionPerformed
          
        //int Enviacodigo = Integer.parseInt(txtPN.getText());
        txtInvoice.requestFocus();
        if(txtInvoice.getText().compareTo("") !=0)
        {
            
             
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from ingreso  where  NO_INVOICE = '"+txtInvoice.getText().toUpperCase()+"'");
            rs.next();
            int codigo = rs.getInt("count(*)");
            if (codigo > 0) {
                actualizarTablaInvoice();
                txtInvoice.setEnabled(false);
               
            } else {
                JOptionPane.showMessageDialog(null, "El #invoice" + txtInvoice.getText() + " No Existe");
                txtInvoice.setText("");

            }

        } catch (Exception e) {
            System.out.println("Editar Error" + e);

        }
       
        }else {
                JOptionPane.showMessageDialog(null, "Ingreso #Invoice");
                txtInvoice.setText("");
        }
    }//GEN-LAST:event_txtInvoiceActionPerformed

    private void txtInvoiceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInvoiceKeyTyped
        
            
        
            }//GEN-LAST:event_txtInvoiceKeyTyped

    private void BnuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnuevaActionPerformed
                
        limpiartabla();
        txtInvoice.setText("");
        txtInvoice.requestFocus();
        txtInvoice.setEnabled(true);
        bodegaselect2.setSelectedItem("Todos");


    }//GEN-LAST:event_BnuevaActionPerformed

    private void BnuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BnuevaKeyPressed

        limpiartabla();
        txtInvoice.setText("");
        txtInvoice.requestFocus();


    }//GEN-LAST:event_BnuevaKeyPressed

    private void bodegaselect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodegaselect2ActionPerformed
        txtInvoice.requestFocus();
    }//GEN-LAST:event_bodegaselect2ActionPerformed

    private void actualizarTablaInvoice() {
        
        int b1;
        int b2;
        
        if (bodegaselect2.getSelectedItem() == "Bodega"){ b1 = 1; b2 = 0; }
        else if(bodegaselect2.getSelectedItem() == "Bodeguita"){b1 = 0; b2 = 2;}
        else{b1=1;b2=2;}
      

        ArrayList<consultanp> result = BDConsultas.ListaringreInvoice(txtInvoice.getText().toUpperCase(),b1,b2);
        recagarTabla(result);
    }

    private void recagarTabla(ArrayList<consultanp> list) {

        Object[][] dato = new Object[list.size()][15];
        int f = 0;
        for (consultanp a : list) {
            dato[f][0] = a.getCodigo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getFechaingre();
            dato[f][3] = a.getPN();
            dato[f][4] = a.getNo_trabajo();
            dato[f][5] = a.getLote();
            dato[f][6] = a.getPO();
            dato[f][7] = a.getPrecio();
            dato[f][8] = a.getCantidad();
            dato[f][9] = a.getCantidad2();
            dato[f][10] = a.getCantInicial();
            dato[f][11] = a.getProveedor();
            dato[f][12] = a.getInvoice();
            dato[f][13] = a.getNota();
            dato[f][14] = a.getIngrepor();
            

            f++;
        }
        tablaCon.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "Codigo", "Descripcion", "Fecha de Ingreso", "P/N", "Trabajo", "Lote","P.O","Precio","Cantidad Bodega","Cantidad Bodega2","Cantidad Ingresada","Proveedor","Factura","Notas","Ingresado por"

                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                });
            TableColumn columna1 = tablaCon.getColumn("Codigo");
            columna1.setPreferredWidth(15);
            TableColumn columna2 = tablaCon.getColumn("Descripcion");
            columna2.setPreferredWidth(100);
            TableColumn columna3 = tablaCon.getColumn("Proveedor");
            columna3.setPreferredWidth(50);
            TableColumn columna4 = tablaCon.getColumn("Notas");
            columna4.setPreferredWidth(30);
            TableColumn columna5 = tablaCon.getColumn("P/N");
            columna5.setPreferredWidth(7);
            TableColumn columna6 = tablaCon.getColumn("Trabajo");
            columna6.setPreferredWidth(5);
            TableColumn columna7 = tablaCon.getColumn("Lote");
            columna7.setPreferredWidth(5);
            TableColumn columna8 = tablaCon.getColumn("P.O");
            columna8.setPreferredWidth(5);
            TableColumn columna9 = tablaCon.getColumn("Ingresado Por");
            columna9.setPreferredWidth(10);
            TableColumn columna10 = tablaCon.getColumn("Cantidad Bodega");
            columna10.setPreferredWidth(15);
            TableColumn columna11 = tablaCon.getColumn("Cantidad Ingresada");
            columna11.setPreferredWidth(15);
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
            java.util.logging.Logger.getLogger(CIngresoInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CIngresoInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CIngresoInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CIngresoInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CIngresoInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bnueva;
    private javax.swing.JComboBox<String> bodegaselect2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCon;
    private javax.swing.JTextField txtInvoice;
    // End of variables declaration//GEN-END:variables
}
