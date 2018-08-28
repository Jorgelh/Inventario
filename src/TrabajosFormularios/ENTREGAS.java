/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosFormularios;

import TrabajosClases.Classp;
import TrabajosClases.InsertarEntregas;
import TrabajosClases.trabajos;
import TrabajosClases.consultas;
//import com.sun.org.apache.xml.internal.serialize.Method;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class ENTREGAS extends javax.swing.JInternalFrame {

     DefaultTableModel temp;
     int idtrab;
     int idingre;
    /**
     * Creates new form ENTREGAS
     */
    public ENTREGAS() {
        initComponents();
        listartrabajos();
        agregar.setEnabled(false);
    }

    public void limpiar(){
       
        text.setText("");
        CANTIDAD.setText("");
         try {
            temp = (DefaultTableModel) ingresos.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }
    
         
         
         text.setText("");
         agregar.setEnabled(false);
         
         try {
            temp = (DefaultTableModel) materialpn.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }
         
         listartrabajos();
         
    
    
    }

    public void limpiartabla(){
       
        text.setText("");
         try {
            temp = (DefaultTableModel) ingresos.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }    
         agregar.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        trabajos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        entregado = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ingresos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        CANTIDAD = new javax.swing.JTextField();
        requerido = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        materialpn = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JOB = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ENTREGAS DE MATERIAL");

        trabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P/N", "JOB", "ESTANDAR", "LOTE", "FECHA VENCIMIENTO", "FECHA RECIBIDO", "FECHA ENTREGA"
            }
        ));
        trabajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trabajosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(trabajos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("P/N");

        pn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnKeyReleased(evt);
            }
        });

        entregado.setBackground(new java.awt.Color(153, 204, 255));

        ingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha Ingreso", "P.O"
            }
        ));
        ingresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ingresos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("INGRESOS DE MATERIALES");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOTAS");

        agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        agregar.setText("GUARDAR");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        text.setColumns(20);
        text.setRows(5);
        jScrollPane2.setViewportView(text);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CANTIDAD");

        CANTIDAD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CANTIDAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANTIDADActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout entregadoLayout = new javax.swing.GroupLayout(entregado);
        entregado.setLayout(entregadoLayout);
        entregadoLayout.setHorizontalGroup(
            entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entregadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entregadoLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(entregadoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entregadoLayout.createSequentialGroup()
                                .addGroup(entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entregadoLayout.createSequentialGroup()
                                .addComponent(agregar)
                                .addGap(41, 41, 41))
                            .addGroup(entregadoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(28, 28, 28))
                            .addGroup(entregadoLayout.createSequentialGroup()
                                .addComponent(CANTIDAD)
                                .addContainerGap())))))
        );
        entregadoLayout.setVerticalGroup(
            entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entregadoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(entregadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entregadoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(entregadoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        requerido.setBackground(new java.awt.Color(153, 204, 255));

        materialpn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION"
            }
        ));
        materialpn.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                materialpnComponentRemoved(evt);
            }
        });
        materialpn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                materialpnFocusLost(evt);
            }
        });
        materialpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialpnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(materialpn);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("MATERIAL UTILIZADO EN P/N");

        javax.swing.GroupLayout requeridoLayout = new javax.swing.GroupLayout(requerido);
        requerido.setLayout(requeridoLayout);
        requeridoLayout.setHorizontalGroup(
            requeridoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requeridoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(requeridoLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        requeridoLayout.setVerticalGroup(
            requeridoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requeridoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("JOB");

        JOB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JOBKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JOB, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(requerido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(JOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entregado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(requerido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnKeyReleased
            
        listartrabajos();
        pn.setText(pn.getText().trim());
        
    }//GEN-LAST:event_pnKeyReleased

    private void trabajosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajosMouseClicked
        
        listarproductospn();
        limpiartabla();
        
    }//GEN-LAST:event_trabajosMouseClicked

    private void materialpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialpnMouseClicked
    
         listarproductospo();
        
    }//GEN-LAST:event_materialpnMouseClicked

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
  
        idtrab = (Integer.parseInt(String.valueOf(trabajos.getModel().getValueAt(trabajos.getSelectedRow(),8))));
        idingre = (Integer.parseInt(String.valueOf(ingresos.getModel().getValueAt(ingresos.getSelectedRow(),4))));
        
           if(idtrab !=0 && idingre !=0 && CANTIDAD.getText().compareTo("") !=0 ){
        
            try {
                InsertarEntregas c = new InsertarEntregas();
                c.setIdingreso(idingre);
                c.setIdtrabajo(idtrab);
                c.setNotas(text.getText());
                c.setCantidad(Integer.parseInt(CANTIDAD.getText()));
                consultas.Entregas(c);
                JOptionPane.showMessageDialog(null, "Entrega Ingresada Con Exito..");
                limpiar();
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "ERROR AGREGAR ENTREGA"+e);
            }
              
           } else {JOptionPane.showMessageDialog(null,"Faltan Datos");}

    }//GEN-LAST:event_agregarActionPerformed

    private void ingresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresosMouseClicked
        
        agregar.setEnabled(true);
    }//GEN-LAST:event_ingresosMouseClicked

    private void materialpnComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_materialpnComponentRemoved
            limpiartabla();
    }//GEN-LAST:event_materialpnComponentRemoved

    private void materialpnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_materialpnFocusLost
      
    }//GEN-LAST:event_materialpnFocusLost

    private void CANTIDADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANTIDADActionPerformed
                
        agregar.requestFocus();

    }//GEN-LAST:event_CANTIDADActionPerformed

    private void JOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JOBKeyReleased
      
        listartrabajos();
        JOB.setText(JOB.getText().trim());
        
        
    }//GEN-LAST:event_JOBKeyReleased
   
    private void listartrabajos(){
        ArrayList<trabajos> result = consultas.ListarTrabajo(pn.getText().toUpperCase(),JOB.getText().toUpperCase());
        productos(result);
    }
    
    private void productos(ArrayList<trabajos> list){
        
         Object[][] datos = new Object[list.size()][10];
              int i = 0;
              for(trabajos t : list)
              {
                  datos[i][0] = t.getPn();
                  datos[i][1] = t.getJob();
                  datos[i][2] = t.getEstandar();
                  datos[i][3] = t.getLote();
                  datos[i][4] = t.getCantidad();
                  datos[i][5] = t.getFechareci();
                  datos[i][6] = t.getFechaentre();
                  datos[i][7] = t.getFechaVen();
                  datos[i][8] = t.getId_trabajo();
                  datos[i][9] = t.getNota();
                  i++;
              }    
             trabajos.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "P/N","JOB","ESTANDAR","LOTE","CANTIDAD","FECHA RECIBIDO","FECHA ENTREGA","FECHA VENCIMIENTO","ID","NOTA"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
             
            
    }
    
    private void listarproductospn(){
        String c = (String.valueOf(trabajos.getModel().getValueAt(trabajos.getSelectedRow(),0)));
        ArrayList<Classp> result = consultas.ListarProductosPN(c);
        productospn(result);
    }
    
    private void productospn(ArrayList<Classp> list){
        
         Object[][] datos = new Object[list.size()][4];
              int i = 0;
              for(Classp t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getDescripcion();
                  i++;
              }    
             materialpn.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
            
    }
    
    
    private void listarproductospo(){
        int c = (int) (materialpn.getModel().getValueAt(materialpn.getSelectedRow(),0));
        ArrayList<Classp> result = consultas.ListarProductosPO(c);
        productospo(result);
    }
    
    private void productospo(ArrayList<Classp> list){
        
         Object[][] datos = new Object[list.size()][5];
              int i = 0;
              for(Classp t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getDescripcion();
                  datos[i][2] = t.getPO();
                  datos[i][3] = t.getFechaingreso();
                  datos[i][4] = t.getId_ingreso();
                  i++;
              }    
             ingresos.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","DESCRIPCION","P.O","FECHA INGRESO","ID"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
            
    }
    
    
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
            java.util.logging.Logger.getLogger(ENTREGAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ENTREGAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ENTREGAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ENTREGAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ENTREGAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CANTIDAD;
    private javax.swing.JTextField JOB;
    private javax.swing.JButton agregar;
    private javax.swing.JPanel entregado;
    private javax.swing.JTable ingresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable materialpn;
    private javax.swing.JTextField pn;
    private javax.swing.JPanel requerido;
    private javax.swing.JTextArea text;
    private javax.swing.JTable trabajos;
    // End of variables declaration//GEN-END:variables
}
