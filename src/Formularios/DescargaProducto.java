/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDDescargaProducto;
import BD.DBCargaPro;
import Class.CargaP;
import Class.Descarga;
import java.awt.Color;
//import java.nio.charset.CodingErrorAction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class DescargaProducto extends javax.swing.JInternalFrame {

    DefaultTableModel temp;
    int cantidadminima;
    int NoDepto;
    /**
     * Creates new form DescargaProducto
     */
    public DescargaProducto() {
        initComponents();
        notas.setLineWrap(true);
        limpiarlabel();
        limpiartabla15();
        activartxt(false);
        BoDescargar.setEnabled(false);
        CantidadMinima.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }

    public void llenarBalance() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sum(cantidad) from ingreso where codigo =" + TxCodigo.getText() + "and bodega = 1");
            while (rs.next()) {
                this.txtcantBodega.setText(String.valueOf(rs.getInt("sum(cantidad)")));
            }
            ResultSet r = stmt.executeQuery("select sum(ingreso.cantidad) from ingreso where codigo =" + TxCodigo.getText() + "and bodega = 2");
            //ResultSet r = stmt.executeQuery("select sum(ingreso.cantidad),producto.cantidadminima from ingreso inner join producto on  ingreso.codigo = producto.codigo where ingreso.codigo = "+ TxCodigo.getText() +" and bodega = 2 GROUP BY (producto.CANTIDADMINIMA)");
            while (r.next()) { 
                if (String.valueOf(r) == null)
                {
                txttotalBodeguita.setText("0");
                }else{
                this.txttotalBodeguita.setText(String.valueOf(r.getInt("sum(ingreso.cantidad)")));
                }
              //  this.cantidadminima = (r.getInt("cantidadminima"));
            }
            ResultSet rd = stmt.executeQuery("select cantidadminima from producto where codigo = "+ TxCodigo.getText());
            while (rd.next()) {
                //this.txttotalBodeguita.setText(String.valueOf(rd.getInt("sum(ingreso.cantidad)")));
                this.cantidadminima = (rd.getInt("cantidadminima"));
            }
            rs.close();
            r.close();
            rd.close();
            stmt.close();
        } catch (SQLException error) {
            System.out.println("NO ERROR DE unidad medida" + error);
            
        }

        int bode = Integer.parseInt(txtcantBodega.getText());
        int bodegui = Integer.parseInt(txttotalBodeguita.getText());
        txtSumas.setText(String.valueOf(bode + bodegui));
        if(cantidadminima < Integer.parseInt(txtSumas.getText()))
        {
           CantidadMinima.setText(String.valueOf(cantidadminima));
           CantidadMinima.setBackground(Color.GREEN);
        }else{    
            CantidadMinima.setText(String.valueOf(cantidadminima));
            CantidadMinima.setBackground(Color.RED);
        }

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
        LaFechaVen.setText("");
        LaLote.setText("");
        LaPN.setText("");
        LaPO.setText("");
        laCantidad.setText("");
        TxCodigo.setText("");
        txtcantBodega.setText("");
        txtcantidad.setText("");
        txttotalBodeguita.setText("");
        TxCodigo.requestFocus();
        txtNoingreso.setText("");
        txtSumas.setText("");
        txtentregado.setText("");
        txtNota.setText("");
        fechaEntrega.setDate(null);
        txtbodega.setText("");
        unidadMedida.setText("");
        pn1.setText("");
        lote.setText("");
        trabajo.setText("");
        documento.setText("");
        serie.setText("");
        txtubicacion.setText("");
        notas.setText("");
        CantidadMinima.setText("");
        CantidadMinima.setBackground(Color.WHITE);
    }

    public void activartxt(boolean b) {

        txtentregado.setEnabled(b);
        txtcantidad.setEnabled(b);
        txtNota.setEnabled(b);
        pn1.setEnabled(b);
        lote.setEnabled(b);
        trabajo.setEnabled(b);
        documento.setEnabled(b);
        serie.setEnabled(b);
        fechaEntrega.setEnabled(b);
        Depto.setEnabled(b);

    }
    
    public void FechasJdate() {
      
        Calendar c2 = new GregorianCalendar();
        fechaEntrega.setCalendar(c2);
}

    public  void obtenerdescripcion() {
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select producto.descripcion,UNIDAD_MEDIDA.DESCRIPCION as \"descmedida\" from producto inner join UNIDAD_MEDIDA on producto.id_medida = UNIDAD_MEDIDA.ID_MEDIDA where codigo=" + TxCodigo.getText());
            rs.next();
            LaDescrip.setText(rs.getString("descripcion"));
            unidadMedida.setText(rs.getString("descmedida"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }
    }
    
    public void obtenerDepto(){
    
    String Departamento;
    Departamento = Depto.getSelectedValue();
   
    
    if(Departamento == "Chips"){ NoDepto = 1;} 
    else if(Departamento == "Transformadores"){ NoDepto = 2;}
    else if(Departamento == "Solder Dip Strip y Potting"){ NoDepto = 3;} 
    else if(Departamento == "Testing"){ NoDepto = 4;} 
    else if(Departamento == "Taller"){ NoDepto = 5;}
    else if(Departamento == "Direccion de Operaciones"){ NoDepto = 6;} 
    else if(Departamento == "Ingenieria"){ NoDepto = 7;}
    else if(Departamento == "Recursos Humanos"){ NoDepto = 8;}
    else if(Departamento == "Calidad y Seguridad"){ NoDepto = 9;} 
    else if(Departamento == "Bodega"){ NoDepto = 10;} 
    else if(Departamento == "IT Mantenimiento"){ NoDepto = 11;}
    else if(Departamento == "Gerencia General"){ NoDepto = 12;} 
    else if(Departamento == "Contabilidad"){ NoDepto = 13;}    
    
    
    /*
            Chips = 1
            Transformadores = 2
            Solder Dip Strip y Potting = 3
            Testing  = 4
            Taller  = 5
            Direccion de Operaciones = 6
            Ingenieria = 7
            Recursos Humanos = 8
            Calidad y Seguridad = 9
            Bodega = 10
            IT Mantenimiento = 11
            Gerencia General = 12
            Contabilidad = 13
    */
    
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
        jPanel2 = new javax.swing.JPanel();
        txtNoingreso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fechaEntrega = new com.toedter.calendar.JDateChooser();
        txtNota = new javax.swing.JTextField();
        BoDescargar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        documento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        serie = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pn1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        trabajo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lote = new javax.swing.JTextField();
        txtentregado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Depto = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LaPN = new javax.swing.JTextField();
        laCantidad = new javax.swing.JTextField();
        LaFechaVen = new javax.swing.JTextField();
        LaPO = new javax.swing.JTextField();
        LaLote = new javax.swing.JTextField();
        txtbodega = new javax.swing.JTextField();
        LaDescrip = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtubicacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        notas = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cosulta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcantBodega = new javax.swing.JTextField();
        txttotalBodeguita = new javax.swing.JTextField();
        txtSumas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        unidadMedida = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CantidadMinima = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Descargas de Producto");

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Descarga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        txtNoingreso.setEditable(false);
        txtNoingreso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoingresoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("No. Ingreso");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Nota");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha Entrega");

        fechaEntrega.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaActionPerformed(evt);
            }
        });

        BoDescargar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Download.png"))); // NOI18N
        BoDescargar.setText("  Descargar");
        BoDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoDescargarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cantidad");

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtcantidad.setForeground(new java.awt.Color(255, 0, 0));
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(54, 54, 54))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));

        documento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("No. Documento");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Serie");

        serie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serieActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("P/N");

        pn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(documento)
                    .addComponent(serie)
                    .addComponent(pn1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("No. Trabajo");

        trabajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Lote");

        lote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteActionPerformed(evt);
            }
        });

        txtentregado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtentregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtentregadoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Entregado A");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trabajo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lote)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel10))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addComponent(txtentregado))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtentregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        Depto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        Depto.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Chips", "Transformadores", "Solder Dip Strip y Potting", "Testing", "Taller", "Direccion de Operaciones", "Ingenieria", "Recursos Humanos", "Calidad y Seguridad", "Bodega", "IT Mantenimiento", "Gerencia General", "Contabilidad" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Depto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeptoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Depto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNota)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNoingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoDescargar, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNoingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(BoDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Ingreso", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Lote:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Vencimiento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("P.O:");

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Descripcion.setText("P/N:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Bodega");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));

        LaPN.setEditable(false);
        LaPN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LaPN.setForeground(new java.awt.Color(0, 0, 255));

        laCantidad.setEditable(false);
        laCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        laCantidad.setForeground(new java.awt.Color(0, 0, 255));

        LaFechaVen.setEditable(false);
        LaFechaVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LaFechaVen.setForeground(new java.awt.Color(0, 0, 255));

        LaPO.setEditable(false);
        LaPO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LaPO.setForeground(new java.awt.Color(0, 0, 255));

        LaLote.setEditable(false);
        LaLote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LaLote.setForeground(new java.awt.Color(0, 0, 255));

        txtbodega.setEditable(false);
        txtbodega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtbodega.setForeground(new java.awt.Color(0, 0, 255));

        LaDescrip.setEditable(false);
        LaDescrip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LaDescrip.setForeground(new java.awt.Color(0, 0, 255));
        LaDescrip.setFocusTraversalPolicyProvider(true);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Ubicacion");

        txtubicacion.setEditable(false);
        txtubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtubicacion.setForeground(new java.awt.Color(0, 0, 255));

        notas.setEditable(false);
        notas.setColumns(20);
        notas.setForeground(new java.awt.Color(0, 0, 255));
        notas.setRows(5);
        jScrollPane2.setViewportView(notas);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Notas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LaDescrip)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(351, 351, 351)
                        .addComponent(jLabel16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(LaPO, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LaLote, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Descripcion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(laCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(LaFechaVen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtubicacion)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(Descripcion)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LaFechaVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LaPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LaLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        Cosulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Ingreso", "P.O", "Fecha Ingreso", "No. Invoice", "P/N"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
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
        jScrollPane1.setViewportView(Cosulta);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Bodega");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Bodeguita");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Total");

        txtcantBodega.setEditable(false);
        txtcantBodega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcantBodega.setForeground(new java.awt.Color(0, 0, 255));
        txtcantBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantBodegaActionPerformed(evt);
            }
        });

        txttotalBodeguita.setEditable(false);
        txttotalBodeguita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalBodeguita.setForeground(new java.awt.Color(0, 0, 255));

        txtSumas.setEditable(false);
        txtSumas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSumas.setForeground(new java.awt.Color(255, 0, 51));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Cantidad en:");

        unidadMedida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        unidadMedida.setForeground(new java.awt.Color(255, 0, 0));
        unidadMedida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unidadMedida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("Cantidad Minima");

        CantidadMinima.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unidadMedida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSumas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtcantBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(txttotalBodeguita))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CantidadMinima))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(5, 5, 5)
                .addComponent(unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txttotalBodeguita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtSumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from ingreso where codigo=" + TxCodigo.getText() + "and cantidad > 0");
            rs.next();
            int codigo = rs.getInt("count(codigo)");
            if (codigo > 0) {
                activartxt(true);
                TxCodigo.setEnabled(false);
                actualizarTablaconsulta();
                obtenerdescripcion();
                documento.requestFocus();
                llenarBalance();
                FechasJdate();

            } else {
                JOptionPane.showMessageDialog(null, "Producto " + TxCodigo.getText() + " No Contiene Existencias o Producto no Existe");
                limpiarlabel();
                limpiartabla15();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }

    }//GEN-LAST:event_TxCodigoActionPerformed

    private void BoDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoDescargarActionPerformed
        obtenerDepto();
        if (txtcantidad.getText().compareTo("") != 0 && txtentregado.getText().compareTo("") != 0 && NoDepto > 0) 
        {

            int A = Integer.parseInt(txtcantidad.getText());
            int B = Integer.parseInt(laCantidad.getText());
            if (B >= A) {
                obtenerDepto();
                try {
                    Descarga d = new Descarga();
                    d.setCantidad(Integer.parseInt(txtcantidad.getText()));
                    d.setEntregadoA(Integer.parseInt(txtentregado.getText()));
                    d.setId_ingreso(Integer.parseInt(txtNoingreso.getText()));
                    d.setNota(txtNota.getText());
                    d.setCodigo(Integer.parseInt(TxCodigo.getText()));
                    d.setFecha(fechaEntrega.getDate());
                    d.setDocumento(documento.getText());
                    d.setSerie(serie.getText());
                    d.setPn(pn1.getText());
                    d.setLote(trabajo.getText());
                    d.setTrabajo(lote.getText());
                    d.setDepto(NoDepto);
                    BDDescargaProducto.insertarDescarga(d);
                    JOptionPane.showMessageDialog(null, "Descarga Realizada...");
                    BoDescargar.setEnabled(false);
                    limpiartabla15();
                    limpiarlabel();
                    activartxt(false);
                    TxCodigo.setEnabled(true);
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMAaa"+e);
                }
            }
            else{ JOptionPane.showMessageDialog(null, "NO POSER LA CANTIDAD NECESARIA PARA REALIZAR LA DESCARGA");}
            
            
        }
        else {JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");}
        
        
        
        
    }//GEN-LAST:event_BoDescargarActionPerformed

    private void CosultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CosultaMouseClicked

        try {
            documento.requestFocus();
            BoDescargar.setEnabled(true);

            CargaP ca = BDDescargaProducto.buscarDescarga(Integer.parseInt(String.valueOf(Cosulta.getModel().getValueAt(Cosulta.getSelectedRow(), 0))));
            //LaDescrip.setText(ca.getDescripcion());
            //unidadMedida.setText(ca.getPresentacion());
            LaFechaVen.setText(ca.getReturnFechaIgre());
            LaLote.setText(ca.getLote());
            LaPN.setText(ca.getPN());
            LaPO.setText(ca.getPO());
            laCantidad.setText(String.valueOf(ca.getCantidad()));
            txtNoingreso.setText(String.valueOf(ca.getId_ingreso()));
            if(ca.getBodeda()==1){txtbodega.setText("Bodega");} else{txtbodega.setText("Bodeguita");}
            txtubicacion.setText(ca.getUbicacion());
            notas.setText(ca.getNota());
            

        } catch (Exception e) {

            System.out.println("ERROR REPORTE AL ADMINISTRADOR DE SISTEMA" + e);
        }


    }//GEN-LAST:event_CosultaMouseClicked

    private void txtNoingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoingresoActionPerformed
    }//GEN-LAST:event_txtNoingresoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiartabla15();
        limpiarlabel();
        activartxt(false);
        TxCodigo.setEnabled(true);
        BoDescargar.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TxCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxCodigoKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }

    }//GEN-LAST:event_TxCodigoKeyTyped

    private void txtcantBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantBodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantBodegaActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed

          BoDescargar.requestFocus();
      
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void CosultaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CosultaMouseDragged
       
        
    }//GEN-LAST:event_CosultaMouseDragged

    private void txtentregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtentregadoActionPerformed

        txtNota.requestFocus();
        
    }//GEN-LAST:event_txtentregadoActionPerformed

    private void txtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaActionPerformed
      
        Depto.requestFocus();
        
    }//GEN-LAST:event_txtNotaActionPerformed

    private void documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentoActionPerformed
       serie.requestFocus();
    }//GEN-LAST:event_documentoActionPerformed

    private void serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serieActionPerformed
       pn1.requestFocus();
    }//GEN-LAST:event_serieActionPerformed

    private void trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajoActionPerformed

        lote.requestFocus();
    }//GEN-LAST:event_trabajoActionPerformed

    private void loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteActionPerformed
       txtentregado.requestFocus();
    }//GEN-LAST:event_loteActionPerformed

    private void pn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pn1ActionPerformed

       trabajo.requestFocus();
        
    }//GEN-LAST:event_pn1ActionPerformed

    private void DeptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptoMouseClicked
     txtcantidad.requestFocus();
    }//GEN-LAST:event_DeptoMouseClicked

    private void actualizarTablaconsulta() {

        ArrayList<CargaP> result = DBCargaPro.ListarProductoIngresado(Integer.parseInt(TxCodigo.getText()));
        recagarTabla(result);
    }

    private void recagarTabla(ArrayList<CargaP> list) {

        Object[][] dato = new Object[list.size()][6];
        int f = 0;
        for (CargaP a : list) {
            dato[f][0] = a.getId_ingreso();
            dato[f][1] = a.getPO();
            dato[f][2] = a.getReturnFecha();
            dato[f][3] = a.getInvoce();
            dato[f][4] = a.getPN();
            dato[f][5] = a.getPrecio();
            f++;
        }
        Cosulta.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "No. Ingreso","P.O","Fecha Ingreso","No. Invoice","P/N","Precio"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column){
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
            java.util.logging.Logger.getLogger(DescargaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescargaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescargaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescargaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescargaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoDescargar;
    private javax.swing.JTextField CantidadMinima;
    private javax.swing.JTable Cosulta;
    private javax.swing.JList<String> Depto;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JTextField LaDescrip;
    private javax.swing.JTextField LaFechaVen;
    private javax.swing.JTextField LaLote;
    private javax.swing.JTextField LaPN;
    private javax.swing.JTextField LaPO;
    private javax.swing.JTextField TxCodigo;
    private javax.swing.JTextField documento;
    private com.toedter.calendar.JDateChooser fechaEntrega;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField laCantidad;
    private javax.swing.JTextField lote;
    private javax.swing.JTextArea notas;
    private javax.swing.JTextField pn1;
    private javax.swing.JTextField serie;
    private javax.swing.JTextField trabajo;
    private javax.swing.JTextField txtNoingreso;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtSumas;
    private javax.swing.JTextField txtbodega;
    private javax.swing.JTextField txtcantBodega;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtentregado;
    private javax.swing.JTextField txttotalBodeguita;
    private javax.swing.JTextField txtubicacion;
    private javax.swing.JLabel unidadMedida;
    // End of variables declaration//GEN-END:variables

}
