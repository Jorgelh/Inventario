/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDProducto;
import Class.Familia;
import Class.Producto;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import oracle.net.aso.e;

/**
 *
 * @author jluis
 */
public class MProducto extends javax.swing.JInternalFrame {

    DefaultTableModel temp;
    int cfamilia = 0;
    int cproce = 0;
    int cpresentacion = 0;
    int cmedida = 0;        
    int crea = 0;
    int correlativo  = 0;
    int codigo = 1;
    int codgoBD;
    int bodega = 0;
    /**
     * Creates new form Producto
     */
    public MProducto() {
        initComponents();
        limpiarCajasProducto();
        //ButtonGuardar.setEnabled(false);
        
        

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from familia order by descripcion");
            while (rs.next()) {

                Combofamilia.addItem((String) rs.getObject(1));

            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
       // this.setLocationRelativeTo(null);

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from id_procedencia order by descripcion");
            while (rs.next()) {
                ComboProce.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
      //  this.setLocationRelativeTo(null);
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from unidad_medida order by descripcion");
            while (rs.next()) {
                ComboMedida.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
       // this.setLocationRelativeTo(null);
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from presentacion order by descripcion");
            while (rs.next()) {
                ComboPresentacion.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
    //    this.setLocationRelativeTo(null);
        
        
        
    }
       
    public void obtenerUltimoId() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery("select max(codigo) from producto where fam_id=1");
            ResultSet rs = stmt.executeQuery("select  MAX(SUBSTR(codigo, 5,8 )) from producto where FAM_ID =" + cfamilia);
            while (rs.next()) {
                int lastID = rs.getInt(1);
                correlativo = lastID + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }
     //   this.setLocationRelativeTo(null);

        if (cfamilia < 10) {
            crea = Integer.parseInt(Integer.toString(cproce) + "00" + Integer.toString(cfamilia));
        } else if (cfamilia < 100) {
            crea = Integer.parseInt(Integer.toString(cproce) + "0" + Integer.toString(cfamilia));
        } else if (cfamilia < 1000) {
            crea = Integer.parseInt(Integer.toString(cproce) + "" + Integer.toString(cfamilia));
        } else {
            System.out.println("no dispone de mas codigos para esta familia");
        }

        if (correlativo < 10) {
            codigo = Integer.parseInt(Integer.toString(crea) + "000" + Integer.toString(correlativo));
        } else if (correlativo < 100) {
            codigo = Integer.parseInt(Integer.toString(crea) + "00" + Integer.toString(correlativo));
        } else if (correlativo < 1000) {
            codigo = Integer.parseInt(Integer.toString(crea) + "0" + Integer.toString(correlativo));
        } else if (correlativo < 10000) {
            codigo = Integer.parseInt(Integer.toString(crea) + "" + Integer.toString(correlativo));
        }

        this.TxtCodigo.setText(String.valueOf(codigo));

    }
        
        public void limpiarCajasProducto() {
       
        Combofamilia.setSelectedItem("Seleccionar...");
        ComboProce.setSelectedItem("Seleccionar...");
        ComboMedida.setSelectedItem("Seleccionar...");
        ComboPresentacion.setSelectedItem("Seleccionar...");
        TxtCodigo.setText("");
        TxtDescripcion.setText("");
        TxtUbicacion2.setText("");
        TxtUbicacion.setText("");
        TxtNota.setText("");
        txtCantidadMinima.setText("");
           
    }
        
        public void limpiartabla15() {

        try {
            temp = (DefaultTableModel) jtproducto.getModel();
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

        jPanel2 = new javax.swing.JPanel();
        ComboMedida = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ComboPresentacion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCantidadMinima = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtUbicacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtUbicacion2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproducto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Combofamilia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ComboProce = new javax.swing.JComboBox<>();
        TxtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ButtonGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtNota = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setTitle("INGRESO DE PRODUCTOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Bold ITC", 0, 24), new java.awt.Color(0, 51, 204))); // NOI18N

        ComboMedida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboMedida.setNextFocusableComponent(ComboPresentacion);
        ComboMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMedidaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Presentacion");

        ComboPresentacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPresentacionActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cantidad minima en Bodega");

        txtCantidadMinima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidadMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadMinimaActionPerformed(evt);
            }
        });
        txtCantidadMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadMinimaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ubiación Bodega");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Ubiación Bodeguita");

        TxtUbicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtUbicacion.setNextFocusableComponent(TxtNota);
        TxtUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUbicacionActionPerformed(evt);
            }
        });
        TxtUbicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtUbicacionKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Unidad de Medida");

        TxtUbicacion2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtUbicacion2.setNextFocusableComponent(TxtNota);
        TxtUbicacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUbicacion2ActionPerformed(evt);
            }
        });
        TxtUbicacion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtUbicacion2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtUbicacion2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboMedida, javax.swing.GroupLayout.Alignment.LEADING, 0, 233, Short.MAX_VALUE)
                            .addComponent(ComboPresentacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidadMinima, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtUbicacion, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUbicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jtproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Ubicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtproducto);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generar Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Bold ITC", 1, 24), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 51, 204));
        jPanel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Familia");

        Combofamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Combofamilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        Combofamilia.setNextFocusableComponent(ComboProce);
        Combofamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombofamiliaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Procedencia de Material");

        ComboProce.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboProce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboProce.setNextFocusableComponent(TxtDescripcion);
        ComboProce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProceActionPerformed(evt);
            }
        });

        TxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TxtCodigo.setForeground(new java.awt.Color(255, 0, 0));
        TxtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TxtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TxtCodigo.setFocusable(false);
        TxtCodigo.setNextFocusableComponent(TxtDescripcion);
        TxtCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtCodigoMouseClicked(evt);
            }
        });
        TxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodigoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Codigo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCodigo)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(ComboProce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Combofamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addGap(0, 89, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combofamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(ComboProce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        ButtonGuardar.setText("   Guardar");
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDescripcionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Descripcion:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Nota:");

        TxtNota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtDescripcion)
                    .addComponent(TxtNota, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CombofamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombofamiliaActionPerformed

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select fam_id from familia where descripcion ='" + this.Combofamilia.getSelectedItem() + "'");
            while (rs.next())
            {
            //this.TxtCodigo.setText(String.valueOf(rs.getInt("fam_id"))); 
            cfamilia = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA"+e);
        }
        obtenerUltimoId();
        actulizarBusquedaProducto();
        ComboProce.requestFocus();

        //   this.TxtCodigo.setText(String.valueOf(cfamilia));

    }//GEN-LAST:event_CombofamiliaActionPerformed

    private void TxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigoActionPerformed

    }//GEN-LAST:event_TxtCodigoActionPerformed

    private void TxtUbicacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUbicacion2ActionPerformed
       TxtDescripcion.requestFocus();
        
    }//GEN-LAST:event_TxtUbicacion2ActionPerformed

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
        
             actulizarBusquedaProducto();
             
        
        if (TxtCodigo.getText().compareTo("")!=0 && TxtDescripcion.getText().compareTo("")!=0  
            && !Combofamilia.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboProce.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !ComboMedida.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboPresentacion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") 
            && txtCantidadMinima.getText().compareTo("") !=0
            /*&& LabelFoto.getText().compareTo("")!=0&& TxtNota.getText().compareTo("")!=0*/)
           {
               try {
                     Producto p = new Producto();
                     p.setCodigo(Integer.parseInt(TxtCodigo.getText()));
                     p.setDescripcion(TxtDescripcion.getText());
                     p.setUbicacion(TxtUbicacion.getText());
                     p.setUbicacion2(TxtUbicacion2.getText());                     
                     p.setNota(TxtNota.getText());
                     p.setFam_Id(cfamilia);
                     p.setId_Medida(cmedida);
                     p.setId_Presentacion(cpresentacion);
                     p.setId_Proce(cproce);          
                     BDProducto.insertarProducto(p);
                     JOptionPane.showMessageDialog(null,"Producto Agregado");  
                   
                  } 
                  catch (Exception e) 
                  {
                      System.err.println("ErrorBD Producto"+e.getMessage());
                  }    
               limpiarCajasProducto();
               actulizarBusquedaProducto();
           }
        else 
           {
               JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS..!!"); 
           }
        
    }//GEN-LAST:event_ButtonGuardarActionPerformed

    private void ComboProceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProceActionPerformed
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id_proce from id_procedencia where descripcion ='" + this.ComboProce.getSelectedItem() + "'");
            while (rs.next()){
            //this.TxtCodigo.setText(String.valueOf(rs.getInt("fam_id"))); 
            cproce = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException error) {
            System.out.println("NO ERROR DE PROCEDENCIA"+error);
        }
         obtenerUltimoId();
         ComboMedida.requestFocus();
    }//GEN-LAST:event_ComboProceActionPerformed

    private void TxtCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtCodigoMouseClicked

    }//GEN-LAST:event_TxtCodigoMouseClicked

    private void ComboPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPresentacionActionPerformed
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id_presentacion from presentacion where descripcion ='" + this.ComboPresentacion.getSelectedItem() + "'");
            while (rs.next())
            {
            //this.TxtCodigo.setText(String.valueOf(rs.getInt("fam_id"))); 
            cpresentacion = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException error) {
            System.out.println("NO ERROR DE FAMILIAS"+error);
        }
        txtCantidadMinima.requestFocus();
    }//GEN-LAST:event_ComboPresentacionActionPerformed

    private void ComboMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMedidaActionPerformed
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id_medida from unidad_medida where descripcion ='" + this.ComboMedida.getSelectedItem() + "'");
            while (rs.next())
            {
            //this.TxtCodigo.setText(String.valueOf(rs.getInt("fam_id"))); 
            cmedida = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException error) {
            System.out.println("NO ERROR DE unidad medida"+error);
        }
        ComboPresentacion.requestFocus();
    }//GEN-LAST:event_ComboMedidaActionPerformed

    private void TxtUbicacion2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUbicacion2KeyPressed
       
    }//GEN-LAST:event_TxtUbicacion2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         limpiarCajasProducto();
         limpiartabla15();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCantidadMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadMinimaActionPerformed
      TxtUbicacion.requestFocus();
    }//GEN-LAST:event_txtCantidadMinimaActionPerformed

    private void txtCantidadMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadMinimaKeyTyped
         char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadMinimaKeyTyped

    private void TxtUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUbicacionActionPerformed
        TxtUbicacion2.requestFocus();
    }//GEN-LAST:event_TxtUbicacionActionPerformed

    private void TxtUbicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUbicacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUbicacionKeyPressed

    private void TxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDescripcionActionPerformed
        TxtNota.requestFocus();
    }//GEN-LAST:event_TxtDescripcionActionPerformed

    private void TxtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNotaActionPerformed
       ButtonGuardar.requestFocus();

    }//GEN-LAST:event_TxtNotaActionPerformed

    private void actulizarBusquedaProducto(){
      
        ArrayList<Producto> result =BDProducto.ListarProductos(cfamilia);
        recargarTablaProducto(result);
    
    }
    
    public void recargarTablaProducto(ArrayList<Producto>list)
      {
          Object[][] dato = new Object[list.size()][4];
          int i = 0;
          for (Producto p : list)
              
          {
               dato[i][0] = p.getCodigo();
               dato[i][1] = p.getDescripcion();
               dato[i][2] = p.getUbicacion();
               i++;
          }
          jtproducto.setModel(new javax.swing.table.DefaultTableModel(
          
          dato,
          new String[]{
                 
                     "Codigo","Descripcion","Ubicacion"
                    }){
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
            java.util.logging.Logger.getLogger(MProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JComboBox<String> ComboMedida;
    private javax.swing.JComboBox<String> ComboPresentacion;
    private javax.swing.JComboBox<String> ComboProce;
    private javax.swing.JComboBox<String> Combofamilia;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtNota;
    private javax.swing.JTextField TxtUbicacion;
    private javax.swing.JTextField TxtUbicacion2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproducto;
    private javax.swing.JTextField txtCantidadMinima;
    // End of variables declaration//GEN-END:variables
}
