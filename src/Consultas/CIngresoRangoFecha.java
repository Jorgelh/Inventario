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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.bind.DatatypeConverter;
//import oracle.net.aso.f;

/**
 *
 * @author Jorge Luis
 */
public class CIngresoRangoFecha extends javax.swing.JInternalFrame {
               
    DefaultTableModel temp;
 
   
    /**
     * Creates new form CDescargaporFecha
     */
    public CIngresoRangoFecha() {
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
        jLabel3 = new javax.swing.JLabel();
        bodegaselect = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("CONSULTA FECHA INGRESO");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        txtFecha.setDateFormatString("dd/MM/yy");
        txtFecha.setDoubleBuffered(false);
        txtFecha.setFocusCycleRoot(true);
        txtFecha.setFocusable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                "Codigo", "Descripcion", "Fecha de Ingreso", "P/N", "Trabajo", "Lote", "P.O", "Cantidad Bodega", "Cantidad Ingreso", "Proveedor", "Ingresado por", "Notas"
            }
        ));
        tablaFecha.setMinimumSize(new java.awt.Dimension(50, 0));
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
        jLabel2.setText("Hasta");

        txtfecha1.setDateFormatString("dd/MM/yy");
        txtfecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Bodega");

        bodegaselect.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bodegaselect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Bodega", "Bodeguita" }));
        bodegaselect.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(bodegaselect, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(buscar)
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addComponent(Nbusqueda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(bodegaselect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nbusqueda)
                .addContainerGap())
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
        
        if (txtFecha.getDate() != null && txtfecha1.getDate() != null) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = txtFecha.getDate();
            Date fec2 = txtfecha1.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
            try {
                Date f1 = formato.parse(fe1);
                Date f2 = formato.parse(fe2);

                if (f1.before(f2)) {
                    actualizarTablaFecha();
                    txtFecha.setEnabled(false);
                    Nbusqueda.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "LA PRIMERA FECHA NO PUEDE SER MAYOR A LA SEGUNDA FECHA");
                }

            } catch (ParseException ex) {
                Logger.getLogger(CIngresoRangoFecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE LAS FECHAS...");
        
            
            /*try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(id_ingreso) from ingreso where fechasistema='"+ fecha1 + "'" );
            rs.next();
            int codigo = rs.getInt("count(id_ingreso)");
            if (codigo > 0) {*/
               
            /*
            } else {
                JOptionPane.showMessageDialog(null, "NO TIENE INGRESOS DE FECHA SELECCIONADA...");
                txtFecha.setDate(null);
            }

        } catch (Exception e) {
            System.out.println("Editar Error" + e);
        }*/
       
}

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
        int b1;
        int b2;
              
        if (bodegaselect.getSelectedItem() == "Bodega"){ b1 = 1; b2 = 0; }
        else if(bodegaselect.getSelectedItem() == "Bodeguita"){b1 = 0; b2 = 2;}
        else{b1=1;b2=2;}
        
        
        

        ArrayList<ConsultaFecha> result = BDConsultas.ListarRangoFecha(fecha,fecha1,b1,b2);
        recargarIngreFecha(result);
    }

    private void recargarIngreFecha(ArrayList<ConsultaFecha> list) {

        Object[][] dato = new Object[list.size()][15];
        if (list.size() > 0){
        int f = 0;
        for (ConsultaFecha a : list) {
            dato[f][0] = a.getCodigo();
            dato[f][1] = a.getDescripcion();
            dato[f][2] = a.getFechaIngre();
            dato[f][3] = a.getPN();
            dato[f][4] = a.getTrabajo();
            dato[f][5] = a.getLote();
            dato[f][6] = a.getPo();
            dato[f][7] = a.getPrecio();
            dato[f][8] = a.getCantidad();
            dato[f][9] = a.getCantidad2();
            dato[f][10] = a.getCantidadIngre();
            dato[f][11] = a.getProveedor();
            dato[f][12] = a.getInvoice();
            dato[f][13] = a.getNota();
            dato[f][14] = a.getIngrepor();
            f++;
        }
        //tablaFecha.getColumnModel().getColumn(1).setPreferredWidth(5); 
        tablaFecha.setModel(new javax.swing.table.DefaultTableModel
        
        (
                
                dato,
                new String[]{
                    "Codigo","Descripcion","Fecha Ingreso","P/N","Trabajo","Lote","P.O","Precio","Cantidad Bodega","Cantidad Bodega2","Cantidad Ingreso","Proveedor","Factura","Notas","Ingresado Por"

                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                });
            TableColumn columna1 = tablaFecha.getColumn("Codigo");
            columna1.setPreferredWidth(10);
            TableColumn columna2 = tablaFecha.getColumn("Descripcion");
            columna2.setPreferredWidth(200);
            TableColumn columna3 = tablaFecha.getColumn("Fecha Ingreso");
            columna3.setPreferredWidth(25);
            TableColumn columna4 = tablaFecha.getColumn("P/N");
            columna4.setPreferredWidth(5);
            TableColumn columna5 = tablaFecha.getColumn("Trabajo");
            columna5.setPreferredWidth(5);
            TableColumn columna6 = tablaFecha.getColumn("Lote");
            columna6.setPreferredWidth(5);
             TableColumn columna7 = tablaFecha.getColumn("P.O");
            columna7.setPreferredWidth(5);
             TableColumn columna8 = tablaFecha.getColumn("Cantidad Bodega");
            columna8.setPreferredWidth(35);
             TableColumn columna9 = tablaFecha.getColumn("Cantidad Ingreso");
            columna9.setPreferredWidth(35);
             TableColumn columna10 = tablaFecha.getColumn("Proveedor");
            columna10.setPreferredWidth(40);
            TableColumn columna11 = tablaFecha.getColumn("Notas");
            columna11.setPreferredWidth(120);
            TableColumn columna12 = tablaFecha.getColumn("Ingresado Por");
            columna12.setPreferredWidth(15);
        
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
            java.util.logging.Logger.getLogger(CIngresoRangoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CIngresoRangoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CIngresoRangoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CIngresoRangoFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CIngresoRangoFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nbusqueda;
    private javax.swing.JComboBox<String> bodegaselect;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFecha;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtfecha1;
    // End of variables declaration//GEN-END:variables
}
