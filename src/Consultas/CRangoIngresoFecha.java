/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import BD.*;
import Class.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;
import oracle.net.aso.f;

/**
 *
 * @author Jorge Luis
 */
public class CRangoIngresoFecha extends javax.swing.JInternalFrame {
               
    DefaultTableModel temp;
 
   
    /**
     * Creates new form CDescargaporFecha
     */
    public CRangoIngresoFecha() {
        initComponents();
    }
    
    public void limpiartabla() {

        try {
            temp = (DefaultTableModel) tablaFecha.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }

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
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFecha = new javax.swing.JTable();
        Nbusqueda = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfecha1 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("CONSULTA FECHA INGRESO");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        txtFecha.setDateFormatString("d/MM/yy");
        txtFecha.setDoubleBuffered(false);
        txtFecha.setFocusable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFecha.setMaxSelectableDate(new java.util.Date(253370790061000L));
        txtFecha.setMinSelectableDate(new java.util.Date(-62135744339000L));
        txtFecha.setMinimumSize(new java.awt.Dimension(35, 45));
        txtFecha.setPreferredSize(new java.awt.Dimension(90, 20));
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Desde");

        tablaFecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad Ingresada", "P/N", "Notas", "Fecha de Ingreso"
            }
        ));
        jScrollPane1.setViewportView(tablaFecha);

        Nbusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        Nbusqueda.setText("Nueva Busqueda");
        Nbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbusquedaActionPerformed(evt);
            }
        });
        Nbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NbusquedaKeyPressed(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("hasta");

        txtfecha1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(buscar)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(Nbusqueda)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nbusqueda)
                .addGap(0, 18, Short.MAX_VALUE))
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

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed

   


    }//GEN-LAST:event_txtFechaKeyPressed

    private void NbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbusquedaActionPerformed
           
        limpiartabla();
        txtFecha.setDate(null);
        txtFecha.setEnabled(true);
        txtfecha1.setDate(null);
        txtfecha1.setEnabled(true);
        

    }//GEN-LAST:event_NbusquedaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        
        actualizarTablaFecha();
        
        Nbusqueda.requestFocus(); 
        
        /*
        Date date = txtFecha.getDate();
        Date date1 = txtfecha1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
        String fecha2 = sd.format(date);
        String fecha1 = sdf.format(date);
    
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(id_ingreso) from ingreso where fechasistema='"+ fecha1 + "'" );
            rs.next();
            int codigo = rs.getInt("count(id_ingreso)");
            if (codigo > 0) {
                actualizarTablaFecha();
                txtFecha.setEnabled(false);
                Nbusqueda.requestFocus(); 

            } else {
                JOptionPane.showMessageDialog(null, "NO TIENE INGRESOS DE FECHA SELECCIONADA...");
                txtFecha.setDate(null);
            }

        } catch (Exception e) {
            System.out.println("Editar Error" + e);
        }
               
        */

    }//GEN-LAST:event_buscarActionPerformed

    private void NbusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NbusquedaKeyPressed
            
        



    }//GEN-LAST:event_NbusquedaKeyPressed

    private void actualizarTablaFecha() {

        Date date = txtFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha = sdf.format(date);
        
        Date date2 = txtfecha1.getDate();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
        String fecha1 = sd.format(date2);

        ArrayList<ConsultaFecha> result = BDConsultas.ListarRangoFecha(fecha , fecha1);
        recargarIngreFecha(result);
    }

    private void recargarIngreFecha(ArrayList<ConsultaFecha> list) {

        Object[][] dato = new Object[list.size()][6];
        if (list.size() > 0){
        int f = 0;
        for (ConsultaFecha a : list) {
            dato[f][0] = a.getCodigo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getCantidad();
            dato[f][3] = a.getPN();
            dato[f][4] = a.getNota();
            dato[f][5] = a.getFecha();
            f++;
        }
        tablaFecha.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "Codigo", "Descripcion", "Cantidad Ingresada", "P/N", "Notas", "Fecha de Ingreso"

                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                });
        txtFecha.setEnabled(false);
        txtfecha1.setEnabled(false);
    }
    
    else
    {
       JOptionPane.showMessageDialog(null,"NO TIENE INGRESOS DEL RANGO DE FECHA SELECCIONADO..."); 
        limpiartabla();
        txtFecha.setDate(null);
        txtFecha.setEnabled(true);
        txtfecha1.setDate(null);
        txtfecha1.setEnabled(true);
    }
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
            java.util.logging.Logger.getLogger(CRangoIngresoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRangoIngresoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRangoIngresoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRangoIngresoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRangoIngresoFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nbusqueda;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFecha;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtfecha1;
    // End of variables declaration//GEN-END:variables
}
