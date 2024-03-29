/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import BD.BDConsultas;
import Class.consultanp;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class CDescargasJOB extends javax.swing.JInternalFrame {

    /**
     * Creates new form CIngresoNombre
     */
    public CDescargasJOB() {
        initComponents();
        actualizarTablaJOB();
        Desc.requestFocus();
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
        TablaNombre = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Desc = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA DESCARGAS POR JOB");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        TablaNombre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Fecha Ingreso", "P/N", "Trabajo", "Lote", "P.O", "Cantidad Bodega", "Cantidad Bodeguita", "Cantidad Ingresada", "Proveedor", "Notas"
            }
        ));
        jScrollPane1.setViewportView(TablaNombre);

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel1.setText("JOB");

        Desc.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        Desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(773, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescKeyReleased
      actualizarTablaJOB();
    }//GEN-LAST:event_DescKeyReleased

     private void actualizarTablaJOB() {
        

        ArrayList<consultanp> result = BDConsultas.ListarDescargaJOB(Desc.getText().toUpperCase());
        recagarTabla(result);
    }

    private void recagarTabla(ArrayList<consultanp> list) {

        Object[][] dato = new Object[list.size()][14];
        int f = 0;
        for (consultanp a : list) {
            dato[f][0] = a.getCodigo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getCantidad();
            dato[f][3] = a.getFechades();
            dato[f][4] = a.getPN();
            dato[f][5] = a.getPO();
            dato[f][6] = a.getNo_trabajo();
            dato[f][7] = a.getLote();
            dato[f][8] = a.getEntregadoa();
            dato[f][9] = a.getNota();
            dato[f][10] = a.getDocumento();
            dato[f][11] = a.getCantInicial();
            dato[f][12] = a.getCantidadbodega();
            dato[f][13] = a.getCantidad2();
            f++;
        }
        TablaNombre.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "Codigo", "Descripcion", "Cantidad Entregada", "Fecha descarga","P/N","P.O.","No. Trabajo","Lote","Entregado a","Notas","Documento","Cantidad Ingreso","Cantidad Bodega","Cantidad Bodeguita"
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
            java.util.logging.Logger.getLogger(CDescargasJOB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CDescargasJOB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CDescargasJOB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CDescargasJOB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CDescargasJOB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Desc;
    private javax.swing.JTable TablaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
