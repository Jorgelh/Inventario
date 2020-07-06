/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Consultas.*;
import Formularios.*;
import BD.*;
import Class.CargaP;
import Class.Descarga;
import java.nio.charset.CodingErrorAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class EditarIngresos extends javax.swing.JInternalFrame {

    DefaultTableModel temp;
    int bodega;
    int id;
    int procedencia;

    /**
     * Creates new form DescargaProducto
     */
    public EditarIngresos() {
        initComponents();
        limpiarlabel();
        limpiartabla15();
        EditarTXT(false);
        Beliminar.setEnabled(false);
        Bguardar.setEnabled(false);
        Beditar.setEnabled(false);
        Bcancelar.setEnabled(false);
        //activartxt(false);

    }

    public void limpiartabla15() {

        try {
            temp = (DefaultTableModel) Cosulta.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }

    }

    public void limpiarlabel() {

        LaDescrip.setText("");
        txtpo.setText("");
        txtInvoice.setText("");
        txtDoc.setText("");
        Precio.setText("");
        TxCodigo.setText("");
        TxCodigo.requestFocus();
        txtPN.setText("");
        txtnotas.setText("");
        txtSerie.setText("");
        txtproveedor.setText("");
        txtjob.setText("");
        txtlote.setText("");
        ComboBode.setSelectedItem("");
        txtingresadopor.setText("");
        txtCantidad.setText("");
        txtfechaingreso.setDate(null);
        txtfechaven.setDate(null);

    }

    public void limpiar() {

        txtpo.setText("");
        txtInvoice.setText("");
        txtDoc.setText("");
        Precio.setText("");
        txtPN.setText("");
        txtnotas.setText("");
        txtSerie.setText("");
        txtproveedor.setText("");
        txtjob.setText("");
        txtlote.setText("");
        ComboBode.setSelectedItem("");
        txtingresadopor.setText("");
        txtCantidad.setText("");
        Cosulta.requestFocus();
        txtfechaingreso.setDate(null);
        txtfechaven.setDate(null);
        ComboBode.setSelectedItem("");

    }

    public void EditarTXT(boolean b) {

        //txtCantidad.setEditable(b);
        txtDoc.setEditable(b);
        txtInvoice.setEditable(b);
        txtPN.setEditable(b);
        Precio.setEditable(b);
        txtSerie.setEditable(b);
        txtingresadopor.setEditable(b);
        txtjob.setEditable(b);
        txtlote.setEditable(b);
        txtnotas.setEditable(b);
        txtpo.setEditable(b);
        txtproveedor.setEditable(b);
        ComboBode.setEnabled(b);
        txtfechaven.setEnabled(b);
        txtCantidad.setEnabled(b);

    }

    public void obtenerdescripcion() {

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion,id_proce from producto where codigo=" + TxCodigo.getText());
            rs.next();
            LaDescrip.setText(rs.getString("descripcion"));
            procedencia = rs.getInt("id_proce");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }
    
    

    public void FechasJdate() {

        Calendar c2 = new GregorianCalendar();
        txtfechaven.setCalendar(c2);
    }
    
    
    public void executeStore(){
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizar(Nid_ingreso=>"+id+",Ncantidad=>"+txtCantidad.getText()+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
        }
           }
 
    public void executeStorePrecio(){
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarprecio(NCodigo=>"+TxCodigo.getText()+",NPrecio=>"+Precio.getText()+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
        }
    }    
        
    
    public void editcondescargas(){
       
           
                if (TxCodigo.getText().compareTo("")!= 0
                && txtCantidad.getText().compareTo("")!= 0
                && Precio.getText().compareTo("")!= 0
                && txtingresadopor.getText().compareTo("")!= 0
                && !ComboBode.getSelectedItem().toString().equalsIgnoreCase("")) {

                if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodega")) {
                    bodega = 1;
                } else if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodeguita")){
                    bodega = 2;
                }

            try {
                CargaP c = new CargaP();
                c.setId_ingreso(id);
                c.setBodeda(bodega);
                if(ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodega")){c.setCantidad(Integer.parseInt(txtCantidad.getText()));}else{c.setCantidad2(Integer.parseInt(txtCantidad.getText()));}
                c.setFechaVencimiento(txtfechaven.getDate());
                c.setIngresadoPor(Integer.parseInt(txtingresadopor.getText()));
                c.setInvoce(txtInvoice.getText());
                c.setLote(txtlote.getText());
                c.setNTrabajo(txtjob.getText());
                c.setNoDocumento(txtDoc.getText());
                c.setNoserie(txtSerie.getText());
                c.setNota(txtnotas.getText());
                c.setPO(txtpo.getText());
                c.setPN(txtPN.getText());
                c.setProveedor(txtproveedor.getText());
                c.setPrecio(Double.parseDouble(Precio.getText()));
                BDconsultaVarias.actualizarIngreso(c);
                JOptionPane.showMessageDialog(null, "Ingreso Actualizado...");
                EditarTXT(false);
                executeStore();
                executeStorePrecio();
                Beliminar.setEnabled(false);
                Bguardar.setEnabled(false);
                Cosulta.setEnabled(true);
                NuevaC.setEnabled(true);
                Bcancelar.setEnabled(false);
                limpiar();
                actualizarTablaconsulta();
            } catch (SQLException a) {
                JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + a);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
        }
    }
    
    
    public void noeditcondescargas(){
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("select COUNT(id_ingreso) as \"desc\" from descarga where id_ingreso=" + id);
            rs1.next();
            int codigodes = rs1.getInt("desc");
            if(codigodes == 0){
                if (TxCodigo.getText().compareTo("")!= 0
                && txtCantidad.getText().compareTo("")!= 0
                && Precio.getText().compareTo("")!= 0
                && txtingresadopor.getText().compareTo("")!= 0
                && !ComboBode.getSelectedItem().toString().equalsIgnoreCase("")) {
                if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodega")) {
                    bodega = 1;
                } else if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodeguita")) {
                    bodega = 2;
                }

            try {
                CargaP c = new CargaP();
                c.setId_ingreso(id);
                c.setBodeda(bodega);
                if(ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodega")){c.setCantidad(Integer.parseInt(txtCantidad.getText()));}else{c.setCantidad2(Integer.parseInt(txtCantidad.getText()));}
                c.setFechaVencimiento(txtfechaven.getDate());
                c.setIngresadoPor(Integer.parseInt(txtingresadopor.getText()));
                c.setInvoce(txtInvoice.getText());
                c.setLote(txtlote.getText());
                c.setNTrabajo(txtjob.getText());
                c.setNoDocumento(txtDoc.getText());
                c.setNoserie(txtSerie.getText());
                c.setNota(txtnotas.getText());
                c.setPO(txtpo.getText());
                c.setPN(txtPN.getText());
                c.setProveedor(txtproveedor.getText());
                c.setPrecio(Double.parseDouble(Precio.getText()));
                BDconsultaVarias.actualizarIngreso(c);
                JOptionPane.showMessageDialog(null, "Ingreso Actualizado...");
                EditarTXT(false);
                executeStore();
                executeStorePrecio();
                Beliminar.setEnabled(false);
                Bguardar.setEnabled(false);
                Cosulta.setEnabled(true);
                NuevaC.setEnabled(true);
                Bcancelar.setEnabled(false);
                limpiar();
                actualizarTablaconsulta();
            } catch (SQLException a) {
                JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + a);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
        }}else{JOptionPane.showMessageDialog(null, "El ingreso contiene descargas No se puede Modificar Consulte al Administrador");
                    EditarTXT(false);
                    Beliminar.setEnabled(false);
                    Bguardar.setEnabled(false);
                    Cosulta.setEnabled(true);
                    NuevaC.setEnabled(true);
                    Bcancelar.setEnabled(false);
                    limpiar();
            }
           } catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR"+e);
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

        javax.swing.ButtonGroup Bodega = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TxCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LaDescrip = new java.awt.Label();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cosulta = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPN = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        txtjob = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Descripcion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        txtDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtproveedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtfechaingreso = new com.toedter.calendar.JDateChooser();
        NuevaC = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtnotas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtingresadopor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtfechaven = new com.toedter.calendar.JDateChooser();
        ComboBode = new javax.swing.JComboBox<>();
        Beditar = new javax.swing.JButton();
        Bguardar = new javax.swing.JButton();
        Bcancelar = new javax.swing.JButton();
        Beliminar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TxCodigo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        TxCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxCodigoActionPerformed(evt);
            }
        });
        TxCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxCodigoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Codigo de Producto");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion:");

        LaDescrip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LaDescrip.setForeground(new java.awt.Color(0, 102, 255));
        LaDescrip.setPreferredSize(new java.awt.Dimension(230, 21));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(427, 427, 427)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(LaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(61, 61, 61))
        );

        Cosulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Cosulta.setToolTipText("");
        Cosulta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                CosultaMouseDragged(evt);
            }
        });
        Cosulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CosultaMouseClicked(evt);
            }
        });
        Cosulta.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                CosultaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(Cosulta);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Precio");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("P/N");

        txtPN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPN.setForeground(new java.awt.Color(0, 102, 255));

        Precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Precio.setForeground(new java.awt.Color(0, 102, 255));
        Precio.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Job");

        txtpo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpo.setForeground(new java.awt.Color(0, 102, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Lote:");

        txtlote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtlote.setForeground(new java.awt.Color(0, 102, 255));

        txtjob.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtjob.setForeground(new java.awt.Color(0, 102, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("P.O.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtlote)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15)
                                .addComponent(jLabel7)
                                .addComponent(txtPN, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(Precio))
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtjob))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(226, 363));

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Descripcion.setText("Fecha Ingreso");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No. Documento");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("No. Invoice");

        txtInvoice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtInvoice.setForeground(new java.awt.Color(0, 102, 255));

        txtDoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDoc.setForeground(new java.awt.Color(0, 102, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("No. Serie");

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(0, 102, 255));

        txtproveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtproveedor.setForeground(new java.awt.Color(0, 102, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Proveedor");

        txtfechaingreso.setForeground(new java.awt.Color(0, 102, 255));
        txtfechaingreso.setDateFormatString("d/MM/yy");
        txtfechaingreso.setEnabled(false);
        txtfechaingreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInvoice)
                    .addComponent(txtDoc)
                    .addComponent(txtSerie)
                    .addComponent(txtproveedor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Descripcion)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addComponent(txtfechaingreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NuevaC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NuevaC.setText("Nueva Consulta");
        NuevaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaCActionPerformed(evt);
            }
        });

        txtnotas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnotas.setForeground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Notas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnotas, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha Vencimiento");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Bodega");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Ingresado por");

        txtingresadopor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtingresadopor.setForeground(new java.awt.Color(0, 102, 255));
        txtingresadopor.setEnabled(false);

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 0, 0));
        txtCantidad.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtCantidadComponentAdded(evt);
            }
        });
        txtCantidad.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                txtCantidadComponentShown(evt);
            }
        });
        txtCantidad.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCantidadInputMethodTextChanged(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Cantidad");

        txtfechaven.setForeground(new java.awt.Color(0, 102, 255));
        txtfechaven.setDateFormatString("d/MM/yy");
        txtfechaven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        ComboBode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBode.setForeground(new java.awt.Color(0, 102, 255));
        ComboBode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Bodega", "Bodeguita" }));
        ComboBode.setName(""); // NOI18N
        ComboBode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtingresadopor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel19)
                            .addComponent(txtCantidad)
                            .addComponent(txtfechaven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBode, 0, 206, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(txtfechaven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(ComboBode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtingresadopor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        Beditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Beditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        Beditar.setText("Editar");
        Beditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditarActionPerformed(evt);
            }
        });

        Bguardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        Bguardar.setText("Guardar");
        Bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BguardarActionPerformed(evt);
            }
        });

        Bcancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Bcancelar.setText("Cancelar");
        Bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarActionPerformed(evt);
            }
        });

        Beliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Beliminar.setText("Eliminar");
        Beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NuevaC)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Beditar)
                .addGap(57, 57, 57)
                .addComponent(Bcancelar)
                .addGap(48, 48, 48)
                .addComponent(Bguardar)
                .addGap(37, 37, 37)
                .addComponent(Beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(NuevaC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Beditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxCodigoActionPerformed

        int Enviacodigo = Integer.parseInt(TxCodigo.getText());

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from ingreso where codigo=" + TxCodigo.getText());
            rs.next();
            int codigo = rs.getInt("count(codigo)");
            if (codigo > 0) {
                actualizarTablaconsulta();
                obtenerdescripcion();
                Cosulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                Cosulta.requestFocus();
                TxCodigo.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Producto " + TxCodigo.getText() + " No Contiene Existencias o Producto no Existe");
                limpiarlabel();
                limpiartabla15();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }

    }//GEN-LAST:event_TxCodigoActionPerformed

    private void CosultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CosultaMouseClicked
    
       
        try {
            CargaP ca = BDconsultaVarias.buscarIngreso(Integer.parseInt(String.valueOf(Cosulta.getModel().getValueAt(Cosulta.getSelectedRow(), 0))));
            id = ca.getId_ingreso();
            txtjob.setText(ca.getNTrabajo());
            txtDoc.setText(ca.getNoDocumento());
            txtInvoice.setText(ca.getInvoce());
            txtSerie.setText(ca.getNoserie());
            txtproveedor.setText(ca.getProveedor());
            txtlote.setText(ca.getLote());
            txtPN.setText(ca.getPN());
            txtpo.setText(ca.getPO());
            Precio.setText(String.valueOf(ca.getPrecio()));
            txtnotas.setText(ca.getNota());
            txtingresadopor.setText(String.valueOf(ca.getIngresadoPor()));
            txtCantidad.setText(String.valueOf(ca.getCantidad()));
            if (ca.getReturnFecha() == null) {
                txtfechaven.setDate(null);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                Date date = sdf.parse(ca.getReturnFecha());
                txtfechaven.setDate(date);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date dateingre = sdf.parse(ca.getReturnFechaIgre());
            txtfechaingreso.setDate(dateingre);

            if (ca.getBodeda() == 1) {
                ComboBode.setSelectedItem("Bodega");
            } else {
                ComboBode.setSelectedItem("Bodeguita");
            }

        } catch (Exception e) {

            System.out.println("ERROR REPORTE AL ADMINISTRADOR DE SISTEMA" + e);
        }

        Beditar.setEnabled(true);
    }//GEN-LAST:event_CosultaMouseClicked

    private void TxCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxCodigoKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }

    }//GEN-LAST:event_TxCodigoKeyTyped

    private void CosultaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CosultaMouseDragged


    }//GEN-LAST:event_CosultaMouseDragged

    private void NuevaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCActionPerformed

        limpiarlabel();
        limpiartabla15();
        TxCodigo.setEnabled(true);
        TxCodigo.requestFocus();
        Beditar.setEnabled(false);
        procedencia = 0;


    }//GEN-LAST:event_NuevaCActionPerformed

    private void BeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditarActionPerformed

        EditarTXT(true);
        Beliminar.setEnabled(true);
        Bguardar.setEnabled(true);
        Beditar.setEnabled(false);
        Cosulta.setEnabled(false);
        NuevaC.setEnabled(false);
        Bcancelar.setEnabled(true);
        if(procedencia == 3){txtCantidad.setEnabled(true);Precio.setEnabled(true);}else{txtCantidad.setEnabled(false);Precio.setEnabled(false);}

    }//GEN-LAST:event_BeditarActionPerformed

    private void BcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarActionPerformed

        EditarTXT(false);
        Beliminar.setEnabled(false);
        Bguardar.setEnabled(false);
        Cosulta.setEnabled(true);
        NuevaC.setEnabled(true);
        Bcancelar.setEnabled(false);
        limpiar();


    }//GEN-LAST:event_BcancelarActionPerformed

    private void txtCantidadComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtCantidadComponentAdded


    }//GEN-LAST:event_txtCantidadComponentAdded

    private void txtCantidadInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCantidadInputMethodTextChanged


    }//GEN-LAST:event_txtCantidadInputMethodTextChanged

    private void txtCantidadComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtCantidadComponentShown


    }//GEN-LAST:event_txtCantidadComponentShown

    private void CosultaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CosultaCaretPositionChanged

    }//GEN-LAST:event_CosultaCaretPositionChanged

    private void BeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliminarActionPerformed

      /*  if (JOptionPane.showConfirmDialog(null, new Object[]{"Seguro que desea Eliminar el registro?"}, "VENTANA", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {

            Connection cnn = BD.getConnection();
            PreparedStatement ps = null;
            try {
                ps = cnn.prepareStatement("Update ingreso set estado='B' where id_ingreso=" + id);
                ps.executeUpdate();
                cnn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(EditarIngresos.class.getName()).log(Level.SEVERE, null, ex);
            }

            EditarTXT(false);
            Beliminar.setEnabled(false);
            Bguardar.setEnabled(false);
            Cosulta.setEnabled(true);
            NuevaC.setEnabled(true);
            Bcancelar.setEnabled(false);
            limpiar();
            actualizarTablaconsulta();

        } else {
            System.out.println("No");
        }
*/
    }//GEN-LAST:event_BeliminarActionPerformed

    private void BguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BguardarActionPerformed
    
        editcondescargas();
        
    }//GEN-LAST:event_BguardarActionPerformed

    private void ComboBodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBodeActionPerformed

        if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodega")) {
            bodega = 1;
        } else if (ComboBode.getSelectedItem().toString().equalsIgnoreCase("Bodeguita")) {
            bodega = 2;
        }
    }//GEN-LAST:event_ComboBodeActionPerformed

    private void actualizarTablaconsulta() {

        ArrayList<CargaP> result = BDconsultaVarias.ListarProductoIngresadoEdit(Integer.parseInt(TxCodigo.getText()));
        recagarTabla(result);
    }

    private void recagarTabla(ArrayList<CargaP> list) {

        Object[][] dato = new Object[list.size()][4];
        int f = 0;
        for (CargaP a : list) {
            dato[f][0] = a.getId_ingreso();
            dato[f][1] = a.getPO();
            dato[f][2] = a.getInvoce();
            dato[f][3] = a.getReturnFecha();
            f++;
        }
        Cosulta.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "No. Ingreso", "P.O", "No. Invoice","Fecha Ingreso"

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
            java.util.logging.Logger.getLogger(EditarIngresos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarIngresos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarIngresos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarIngresos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarIngresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcancelar;
    private javax.swing.JButton Beditar;
    private javax.swing.JButton Beliminar;
    private javax.swing.JButton Bguardar;
    private javax.swing.JComboBox<String> ComboBode;
    private javax.swing.JTable Cosulta;
    private javax.swing.JLabel Descripcion;
    private java.awt.Label LaDescrip;
    private javax.swing.JButton NuevaC;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextField TxCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtPN;
    private javax.swing.JTextField txtSerie;
    private com.toedter.calendar.JDateChooser txtfechaingreso;
    private com.toedter.calendar.JDateChooser txtfechaven;
    private javax.swing.JTextField txtingresadopor;
    private javax.swing.JTextField txtjob;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txtnotas;
    private javax.swing.JTextField txtpo;
    private javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables

    private String toString(double precio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
