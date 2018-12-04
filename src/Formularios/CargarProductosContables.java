/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDProducto;
import BD.DBCargaPro;
import Class.CargaP;
import Class.Producto;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class CargarProductosContables extends javax.swing.JInternalFrame {

    int Enviacodigo;
    int bodega;
    int presentacion;
    int id_ingreso;
    int ididentificador;
    int cantidaddeingreso = 0;
    Double nuevoprecio = 0.00;
    Double precioanterior = 0.00;
    DefaultTableModel temp;
    String fecha1;
    

    /**
     */
    public CargarProductosContables() {

        initComponents();
        limpiartxt();
        activarTxt(false);
        

    }
    
    public void executeStorePrecio(){
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarprecio(NCodigo=>"+txtCodigo.getText()+",NPrecio=>"+TxtPrecio.getText()+",NBodega=>"+bodega+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public void Ultimoprecio(){
    
        
            
            if(presentacion == 0){
            
                try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardex where id =(select MAX(id) from kardex where codigo = "+txtCodigo.getText()+") and codigo = "+txtCodigo.getText());
                while (rs.next()) {
                Double precio = rs.getDouble(1);
                precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
                } catch (SQLException error) {
                    System.out.print(error+" ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
                }
            }else{
            
                try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardex where id =(select MAX(id) from kardex where codigo = "+txtCodigo.getText()+") and codigo = "+txtCodigo.getText()+" and presentacion ="+presentacion);
                while (rs.next()) {
                Double precio = rs.getDouble(1);
                precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
                } catch (SQLException error) {
                System.out.print(error+" ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
                }
                }
                }
    
    public void ProcedimientoKardex(){
    try {
            /*System.out.print("ID = "+id_ingreso+"\n");
            System.out.print("CODIGO = "+Integer.parseInt(txtCodigo.getText())+"\n");
            System.out.print("NO DOC = "+txtNoDoc.getText()+"\n");
            System.out.print("cantidad = "+Integer.parseInt(txtCantidad.getText())+"\n");
            System.out.print("PRECIO = "+Double.parseDouble(TxtPrecio.getText())+"\n");
            System.out.print("CANTIDAD saldo = "+cantidaddeingreso+"\n");
            System.out.print("NUEVO PRECIO = "+nuevoprecio+"\n");*/
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarkardex(IDKardex=>"+id_ingreso+","
                            + "NCodigo=>"+Integer.parseInt(txtCodigo.getText())+","
                            + "NDocumento=>'"+txtNoDoc.getText()+"',"
                            + "Fecha_ingreso=>'"+fecha1+"',"
                            + "Ncantidad=>"+Integer.parseInt(txtCantidad.getText())+","
                            + "Nprecio=>"+Double.parseDouble(TxtPrecio.getText())+","
                            + "CantidadSaldo=>"+cantidaddeingreso+","
                            + "precioSaldo=>"+nuevoprecio+","
                            + "Ididen=>"+ididentificador+","
                            + "Presentacion=>"+presentacion+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e+" ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }
    
    public void ultimoidingreso(){
    try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id_ingreso) from ingreso");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                id_ingreso = lastID+1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error+" ERROR QUE OBTIENE EL ULTIMO ID DE INGRESO ");
        }
    }
    
    public void sumaingresos(){
    
        if(presentacion == 0){
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = "+txtCodigo.getText()+" and conta = 1");
            while (rs.next()) {
                int cantidad = rs.getInt(1);
                cantidaddeingreso = cantidad;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
 
    }else{
        
            try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = "+txtCodigo.getText()+" and conta = 1 and presentacion = "+presentacion);
            while (rs.next()) {
                int cantidad = rs.getInt(1);
                cantidaddeingreso = cantidad;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

}


    
    public void ididentificador(){
    try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from kardex");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                ididentificador = lastID+1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error+" ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }
    
    
    
    public  void obtenerdescripcion() {
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from producto where codigo=" + txtCodigo.getText());
            rs.next();
            descripcion.setText(rs.getString("descripcion"));
//            Fecha1.setDate(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }

    }

    public void activarTxt(boolean b) {

        txtCantidad.setEnabled(b);
        txtEmpleado.setEnabled(b);
        Fecha.setEnabled(b);
        txtfechavenci.setEnabled(b);
        txtInvoice.setEnabled(b);
        txtJob.setEnabled(b);
        txtLote.setEnabled(b);
        txtNoDoc.setEnabled(b);
        txtNota.setEnabled(b);
        txtPO.setEnabled(b);
        txtParte.setEnabled(b);
        txtSerie.setEnabled(b);
        TxtProveedor.setEnabled(b);
        TxtPrecio.setEnabled(b);
        ComboBoxBodega.setEnabled(b);
        BagregarProdu.setEnabled(b);
        Bcancelar.setEnabled(b);
        Combpresentacion.setEnabled(b);
      

    }

    public void limpiartabla15() {

        try {
            temp = (DefaultTableModel) tablaIngreso.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

        }

    }

    public void limpiartxt() {

        txtCodigo.setText("");
        txtCantidad.setText("");
        txtEmpleado.setText("");
        txtInvoice.setText("");
        txtJob.setText("");
        txtLote.setText("");
        txtNoDoc.setText("");
        txtNota.setText("");
        txtPO.setText("");
        txtParte.setText("");
        txtSerie.setText("");
        TxtProveedor.setText("");
        TxtPrecio.setText("0.00");
        //SimpleDateFormat("dd-MM-yy");
        //Date date = new Date();
        Date date = null;   
        Fecha.setDate(date);
        txtfechavenci.setDate(date);
        descripcion.setText("");
        ComboBoxBodega.setSelectedItem("Seleccionar....");
        Combpresentacion.setSelectedItem("Seleccionar...");

    }
    
    
    
    public void FechasJdate() {
      
        Calendar c2 = new GregorianCalendar();
        Fecha.setCalendar(c2);
        
        
    }
    
    public void fechaingresokardex(){
    Date date = Fecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        fecha1 = sdf.format(date);
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        TxtProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        txtNoDoc = new javax.swing.JTextField();
        Fecha = new com.toedter.calendar.JDateChooser();
        obligatorio = new javax.swing.JLabel();
        obligatorio1 = new javax.swing.JLabel();
        obligatorio4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtParte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtJob = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxBodega = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtfechavenci = new com.toedter.calendar.JDateChooser();
        obligatorio3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtEmpleado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        obligatorio2 = new javax.swing.JLabel();
        obligatorio5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Combpresentacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        txtCodigo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngreso = new javax.swing.JTable();
        descripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        transito = new javax.swing.JCheckBox();
        Bcancelar = new javax.swing.JButton();
        BagregarProdu = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO PRODUCTOS CONTABLE");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE INGRESO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14)))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha Ingreso");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("No. Invoice");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("No. Documento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("No. Serie");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Proveedor");

        txtInvoice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoiceActionPerformed(evt);
            }
        });
        txtInvoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInvoiceKeyPressed(evt);
            }
        });

        txtSerie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
        });

        TxtProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProveedorActionPerformed(evt);
            }
        });
        TxtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtProveedorKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Precio");

        TxtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioActionPerformed(evt);
            }
        });
        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyTyped(evt);
            }
        });

        txtNoDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoDocActionPerformed(evt);
            }
        });
        txtNoDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoDocKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoDocKeyTyped(evt);
            }
        });

        obligatorio.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio.setText("(*)");

        obligatorio1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio1.setText("(*)");

        obligatorio4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio4.setText("(*)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInvoice)
                    .addComponent(txtSerie)
                    .addComponent(TxtProveedor)
                    .addComponent(TxtPrecio)
                    .addComponent(txtNoDoc)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obligatorio1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(obligatorio4))
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obligatorio))
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(obligatorio4)
                        .addGap(18, 18, 18)))
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addComponent(txtNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(obligatorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(obligatorio1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Codigo");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("P/N");

        txtParte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParteActionPerformed(evt);
            }
        });
        txtParte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtParteKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Job");

        txtJob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobActionPerformed(evt);
            }
        });
        txtJob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJobKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Lote");

        txtLote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoteActionPerformed(evt);
            }
        });
        txtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoteKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("P.O");

        txtPO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOActionPerformed(evt);
            }
        });
        txtPO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPOKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Vencimiento");

        ComboBoxBodega.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboBoxBodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar....", "Bodega", "Bodeguita" }));
        ComboBoxBodega.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxBodegaItemStateChanged(evt);
            }
        });
        ComboBoxBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxBodegaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Bodega");

        txtfechavenci.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        obligatorio3.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio3.setText("(*)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtParte)
                    .addComponent(txtLote, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPO)
                    .addComponent(txtJob)
                    .addComponent(ComboBoxBodega, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obligatorio3)))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(txtfechavenci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfechavenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(obligatorio3))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANTIDAD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 0, 0));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Ingresado Por");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Nota");

        obligatorio2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio2.setText("(*)");

        obligatorio5.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio5.setText("(*)");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Presentacion");

        Combpresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "1 Galon", "1/4 Galon", "1 Libra", "2 Libras", "8 Onzas", "6 Onzas", "4 Onzas", "2 Onzas", " " }));
        Combpresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombpresentacionActionPerformed(evt);
            }
        });

        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obligatorio2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obligatorio5))
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel14)
                            .addComponent(Combpresentacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(obligatorio5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Combpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(obligatorio2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Descripcion:");

        tablaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Ingreso", "P/N", "Fecha Ingreso", "P.O", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tablaIngreso);
        tablaIngreso.getAccessibleContext().setAccessibleName("");

        descripcion.setEditable(false);
        descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descripcion.setForeground(new java.awt.Color(0, 102, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setText("Campos Obligarorios = (*)");

        transito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transito.setText("EN INSPECCION");

        Bcancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Bcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Bcancelar.setText("Cancelar");
        Bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarActionPerformed(evt);
            }
        });

        BagregarProdu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BagregarProdu.setText("Agregar Producto");
        BagregarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagregarProduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transito)
                            .addComponent(jLabel19)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(BagregarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(transito)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BagregarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jLabel19)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BagregarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagregarProduActionPerformed
     
        
        

        if (txtCodigo.getText().compareTo("") != 0 
                && txtCantidad.getText().compareTo("") != 0 
                && txtEmpleado.getText().compareTo("") != 0
                && TxtPrecio.getText().compareTo("0.00") !=0.00 
                && TxtPrecio.getText().compareTo("") != 0 
                //&& txtLote.getText().compareTo("") != 0
                && txtNoDoc.getText().compareTo("") != 0 
                //&& txtNota.getText().compareTo("") != 0 
                //&& txtPO.getText().compareTo("") != 0
                //&& txtParte.getText().compareTo("") != 0 
                //&& txtSerie.getText().compareTo("") != 0 
                && !ComboBoxBodega.getSelectedItem().toString().equalsIgnoreCase("Seleccionar....")) {
            
            
            fechaingresokardex();
            actulizartabla();
            ultimoidingreso();
            Ultimoprecio();
            sumaingresos();
            ididentificador();
             nuevoprecio =((Double.parseDouble(TxtPrecio.getText())*Integer.parseInt(txtCantidad.getText()))+(cantidaddeingreso*precioanterior))/(Integer.parseInt(txtCantidad.getText())+(cantidaddeingreso));   
            //if(precio != 0){nuevoprecio = Double.parseDouble(TxtPrecio.getText());}else{nuevoprecio = precio;}
            try {
                CargaP c = new CargaP();
                c.setCodigo(Integer.parseInt(txtCodigo.getText()));
                c.setId_ingreso(id_ingreso);
                c.setBodeda(bodega);
                if(ComboBoxBodega.getSelectedItem().toString().equalsIgnoreCase("Bodega")){
                c.setCantidad(Integer.parseInt(txtCantidad.getText()));}
                else{c.setCantidad2(Integer.parseInt(txtCantidad.getText()));}
                if(transito.isSelected()){c.setEstado("B");}else{c.setEstado("A");}
                c.setFechaIngre(Fecha.getDate());
                c.setFechaVencimiento(txtfechavenci.getDate());
                c.setIngresadoPor(Integer.parseInt(txtEmpleado.getText()));
                c.setInvoce(txtInvoice.getText());
                c.setLote(txtLote.getText());
                c.setNTrabajo(txtJob.getText());
                c.setNoDocumento(txtNoDoc.getText());
                c.setNoserie(txtSerie.getText());
                c.setNota(txtNota.getText());
                c.setPO(txtPO.getText());
                c.setPN(txtParte.getText());
                c.setProveedor(TxtProveedor.getText());
                c.setPrecio(Double.parseDouble(TxtPrecio.getText()));
                c.setPresent(presentacion);
                DBCargaPro.insertarProductoNuevoContable(c);
                obligatorio.setForeground(Color.BLACK);
                obligatorio1.setForeground(Color.BLACK);
                obligatorio2.setForeground(Color.BLACK);
                obligatorio3.setForeground(Color.BLACK);
                obligatorio4.setForeground(Color.BLACK);
                obligatorio5.setForeground(Color.BLACK);
                JOptionPane.showMessageDialog(null, "Producto Cargado...");
                executeStorePrecio();
                ProcedimientoKardex();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
            }
            actulizartabla();
            limpiartxt();
            activarTxt(false);
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
            obligatorio.setForeground(Color.red);
            obligatorio1.setForeground(Color.red);
            obligatorio2.setForeground(Color.red);
            obligatorio3.setForeground(Color.red);
            obligatorio4.setForeground(Color.red);
            obligatorio5.setForeground(Color.red);
        }
    }//GEN-LAST:event_BagregarProduActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
      
        BagregarProdu.requestFocus();
        
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked


    }//GEN-LAST:event_txtFechaMouseClicked

    private void txtNoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoDocActionPerformed
       txtInvoice.requestFocus();
    }//GEN-LAST:event_txtNoDocActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

        Enviacodigo = Integer.parseInt(txtCodigo.getText());
       
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from producto where codigo=" + txtCodigo.getText());
            rs.next();
            int codigo = rs.getInt("count(codigo)");
            if (codigo == 1) {
                activarTxt(true);
                actulizartabla();
                FechasJdate();
                obtenerdescripcion();
                txtNoDoc.requestFocus();

            } else {
                JOptionPane.showMessageDialog(null, "Producto " + txtCodigo.getText() + " No Existe");
                limpiartxt();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void ComboBoxBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxBodegaActionPerformed

          if (ComboBoxBodega.getSelectedItem().toString().equalsIgnoreCase("Bodega")) {
             bodega = 1;
        }else if (ComboBoxBodega.getSelectedItem().toString().equalsIgnoreCase("Bodeguita")){
             bodega = 2;
        }
    }//GEN-LAST:event_ComboBoxBodegaActionPerformed

    private void BcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarActionPerformed
        limpiartxt();
        limpiartabla15();
        activarTxt(false);
        txtCodigo.requestFocus();
    }//GEN-LAST:event_BcancelarActionPerformed

    private void txtNoDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoDocKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '.' || c > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoDocKeyTyped

    private void TxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioActionPerformed
              txtParte.requestFocus();
    }//GEN-LAST:event_TxtPrecioActionPerformed

    private void TxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '.' || c > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtPrecioKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
       
     
        
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtNoDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoDocKeyPressed
        
        
    }//GEN-LAST:event_txtNoDocKeyPressed

    private void txtInvoiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInvoiceKeyPressed
    
        
        
    }//GEN-LAST:event_txtInvoiceKeyPressed

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        
        
        
    }//GEN-LAST:event_txtSerieKeyPressed

    private void TxtProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtProveedorKeyPressed
      
       
        
    }//GEN-LAST:event_TxtProveedorKeyPressed

    private void TxtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyPressed
       
       
    }//GEN-LAST:event_TxtPrecioKeyPressed

    private void txtParteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParteKeyPressed

     
       
    }//GEN-LAST:event_txtParteKeyPressed

    private void txtJobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJobKeyPressed
        
        
        
    }//GEN-LAST:event_txtJobKeyPressed

    private void txtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyPressed
        
        
    }//GEN-LAST:event_txtLoteKeyPressed

    private void txtPOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPOKeyPressed
        
    }//GEN-LAST:event_txtPOKeyPressed

    private void txtInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoiceActionPerformed
        txtSerie.requestFocus();
    }//GEN-LAST:event_txtInvoiceActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
       
        TxtProveedor.requestFocus();
        
    }//GEN-LAST:event_txtSerieActionPerformed

    private void TxtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProveedorActionPerformed
        
         TxtPrecio.requestFocus();
        
    }//GEN-LAST:event_TxtProveedorActionPerformed

    private void txtParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParteActionPerformed
       
          txtJob.requestFocus();
        
    }//GEN-LAST:event_txtParteActionPerformed

    private void txtJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobActionPerformed
       
        txtLote.requestFocus();
        
    }//GEN-LAST:event_txtJobActionPerformed

    private void txtLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoteActionPerformed
      
          txtPO.requestFocus();
    }//GEN-LAST:event_txtLoteActionPerformed

    private void txtPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPOActionPerformed
       
        Fecha.requestFocus();
        
    }//GEN-LAST:event_txtPOActionPerformed

    private void txtfechavenciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfechavenciMouseExited
        ComboBoxBodega.requestFocus();
    }//GEN-LAST:event_txtfechavenciMouseExited

    private void ComboBoxBodegaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxBodegaItemStateChanged
        txtEmpleado.requestFocus();
    }//GEN-LAST:event_ComboBoxBodegaItemStateChanged

    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
        
        txtNota.requestFocus();
        
    }//GEN-LAST:event_txtEmpleadoActionPerformed

    private void CombpresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombpresentacionActionPerformed
        
        
         if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")) {
             presentacion = 0;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1 Galon")){
             presentacion = 1;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1/4 Galon")){
             presentacion = 2;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1 Libra")){
             presentacion = 3;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("2 Libras")){
             presentacion = 4;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("8 Onzas")){
             presentacion = 5;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("6 Onzas")){
             presentacion = 6;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("4 Onzas")){
             presentacion = 7;
        }else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("2 Onzas")){
             presentacion = 8;
        }
        
    }//GEN-LAST:event_CombpresentacionActionPerformed

    private void actulizartabla() {

        ArrayList<CargaP> result = DBCargaPro.ListarProductoIngresado(Integer.parseInt(txtCodigo.getText()));
        recargarTabla(result);

    }

    private void recargarTabla(ArrayList<CargaP> list) {
        Object[][] dato = new Object[list.size()][5];
        int f = 0;
        for (CargaP a : list) {
            dato[f][0] = a.getId_ingreso();
            dato[f][1] = a.getPN();
            dato[f][2] = a.getReturnFecha();
            dato[f][3] = a.getPO();
            dato[f][4] = a.getCantidad();
            f++;
        }
        tablaIngreso.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "No. Ingreso", "P/N", "Fecha Ingreso", "P.O", "Cantidad"

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
            java.util.logging.Logger.getLogger(CargarProductosContables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarProductosContables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BagregarProdu;
    private javax.swing.JButton Bcancelar;
    private javax.swing.JComboBox<String> ComboBoxBodega;
    private javax.swing.JComboBox<String> Combpresentacion;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtProveedor;
    private javax.swing.JTextField descripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel obligatorio;
    private javax.swing.JLabel obligatorio1;
    private javax.swing.JLabel obligatorio2;
    private javax.swing.JLabel obligatorio3;
    private javax.swing.JLabel obligatorio4;
    private javax.swing.JLabel obligatorio5;
    private javax.swing.JTable tablaIngreso;
    private javax.swing.JCheckBox transito;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNoDoc;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtPO;
    private javax.swing.JTextField txtParte;
    private javax.swing.JTextField txtSerie;
    private com.toedter.calendar.JDateChooser txtfechavenci;
    // End of variables declaration//GEN-END:variables


}