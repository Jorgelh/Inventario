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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class MProducto extends javax.swing.JFrame {

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
        ButtonGuardar.setEnabled(false);
        
        

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from familia");
            while (rs.next()) {

                Combofamilia.addItem((String) rs.getObject(1));

            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
        this.setLocationRelativeTo(null);

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from id_procedencia");
            while (rs.next()) {
                ComboProce.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
        this.setLocationRelativeTo(null);
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from unidad_medida");
            while (rs.next()) {
                ComboMedida.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
        this.setLocationRelativeTo(null);
        
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from presentacion");
            while (rs.next()) {
                ComboPresentacion.addItem((String) rs.getObject(1));
            }
            rs.close();
            stmt.close();

        } catch (SQLException error) {
            System.out.println(error);
        }
        this.setLocationRelativeTo(null);
        
        
        
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
        } catch (SQLException error) {
            System.out.print("que es " + error);
        }
        this.setLocationRelativeTo(null);

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
        comboBodega.setSelectedItem("Seleccionar...");
        TxtCodigo.setText("");
        TxtDescripcion.setText("");
        TxtProveedor.setText(""); 
        TxtUbicacion.setText("");
        TxtNota.setText("");
        LabelFoto.setText("");
        
               
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Combofamilia = new javax.swing.JComboBox<>();
        ComboProce = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtProveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ComboMedida = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ComboPresentacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtNota = new javax.swing.JTextArea();
        TxtUbicacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelFoto = new javax.swing.JLabel();
        ButtonCargarFoto = new javax.swing.JButton();
        comboBodega = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproducto = new javax.swing.JTable();
        ButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO DE PRODUCTOS");
        setBackground(new java.awt.Color(0, 51, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Bold ITC", 0, 24), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Procedencia de Material");

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

        ComboProce.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboProce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        ComboProce.setNextFocusableComponent(TxtDescripcion);
        ComboProce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Codigo");

        TxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TxtCodigo.setEnabled(false);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Descripcion");

        TxtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtDescripcion.setNextFocusableComponent(TxtProveedor);
        TxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDescripcionActionPerformed(evt);
            }
        });
        TxtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtDescripcionKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Proveedor");

        TxtProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtProveedor.setNextFocusableComponent(ComboMedida);
        TxtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtProveedorKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Unidad de Medida");

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
        ComboPresentacion.setNextFocusableComponent(comboBodega);
        ComboPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPresentacionActionPerformed(evt);
            }
        });

        TxtNota.setColumns(20);
        TxtNota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtNota.setRows(5);
        TxtNota.setNextFocusableComponent(ButtonCargarFoto);
        TxtNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtNotaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(TxtNota);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText(" Ubiación");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Nota");

        LabelFoto.setBackground(new java.awt.Color(255, 255, 255));
        LabelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LabelFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButtonCargarFoto.setText("Cargar Foto");
        ButtonCargarFoto.setNextFocusableComponent(ButtonGuardar);
        ButtonCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCargarFotoActionPerformed(evt);
            }
        });

        comboBodega.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Bodega", "Bodeguita" }));
        comboBodega.setNextFocusableComponent(TxtUbicacion);
        comboBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBodegaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bodega");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ComboPresentacion, 0, 235, Short.MAX_VALUE)
                        .addComponent(ComboMedida, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TxtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ComboProce, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Combofamilia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel8))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(TxtUbicacion)
                        .addComponent(jLabel10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addComponent(ButtonCargarFoto)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                    .addComponent(comboBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combofamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboProce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(ComboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(ComboPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonCargarFoto)
                        .addGap(18, 18, 18)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Ubicacion", "Familia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtproducto);

        ButtonGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        ButtonGuardar.setText("   Guardar");
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(ButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

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
        } catch (SQLException error) {
            System.out.println("NO ERROR DE FAMILIAS"+error);
        }
        obtenerUltimoId();
        actulizarBusquedaProducto();

        //   this.TxtCodigo.setText(String.valueOf(cfamilia));

    }//GEN-LAST:event_CombofamiliaActionPerformed

    private void TxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodigoActionPerformed

    }//GEN-LAST:event_TxtCodigoActionPerformed

    private void TxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDescripcionActionPerformed
      
    }//GEN-LAST:event_TxtDescripcionActionPerformed

    private void TxtUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUbicacionActionPerformed

        
    }//GEN-LAST:event_TxtUbicacionActionPerformed

    private void ButtonCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCargarFotoActionPerformed
       
    }//GEN-LAST:event_ButtonCargarFotoActionPerformed

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
        
             actulizarBusquedaProducto();
        
        if (TxtCodigo.getText().compareTo("")!=0 && TxtDescripcion.getText().compareTo("")!=0 && TxtUbicacion.getText().compareTo("")!=0 
            && TxtProveedor.getText().compareTo("")!=0 && !Combofamilia.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboProce.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !ComboMedida.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboPresentacion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !comboBodega.getSelectedItem().toString().equalsIgnoreCase("Seleccionar..."))
           {
               try {
                     Producto p = new Producto();
                     p.setCodigo(Integer.parseInt(TxtCodigo.getText()));
                     p.setDescripcion(TxtDescripcion.getText());
                     p.setProveedor(TxtProveedor.getText());
                     p.setUbicacion(TxtUbicacion.getText());
                     p.setNota(TxtNota.getText());
                     p.setFam_Id(cfamilia);
                     p.setId_Medida(cmedida);
                     p.setId_Presentacion(cpresentacion);
                     p.setId_Proce(cproce);
                     p.setBodega(bodega);
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
    }//GEN-LAST:event_ComboProceActionPerformed

    private void TxtCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtCodigoMouseClicked

    }//GEN-LAST:event_TxtCodigoMouseClicked

    private void comboBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBodegaActionPerformed
  
        if (comboBodega.getSelectedItem().toString().equalsIgnoreCase("Bodega")) {
            bodega = 1;

        } else {
            bodega = 2;
        }
        
       
    }//GEN-LAST:event_comboBodegaActionPerformed

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
    }//GEN-LAST:event_ComboMedidaActionPerformed

    private void TxtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescripcionKeyPressed
      
    }//GEN-LAST:event_TxtDescripcionKeyPressed

    private void TxtProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtProveedorKeyPressed
    }//GEN-LAST:event_TxtProveedorKeyPressed

    private void TxtUbicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUbicacionKeyPressed
       
    }//GEN-LAST:event_TxtUbicacionKeyPressed

    private void TxtNotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtNotaFocusLost
      
        if (TxtCodigo.getText().compareTo("")!=0 && TxtDescripcion.getText().compareTo("")!=0 && TxtUbicacion.getText().compareTo("")!=0 
            && TxtProveedor.getText().compareTo("")!=0 && !Combofamilia.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboProce.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !ComboMedida.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
            && !ComboPresentacion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...") && !comboBodega.getSelectedItem().toString().equalsIgnoreCase("Seleccionar..."))
           {
               ButtonGuardar.setEnabled(true);
           }
    }//GEN-LAST:event_TxtNotaFocusLost

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
    private javax.swing.JButton ButtonCargarFoto;
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JComboBox<String> ComboMedida;
    private javax.swing.JComboBox<String> ComboPresentacion;
    private javax.swing.JComboBox<String> ComboProce;
    private javax.swing.JComboBox<String> Combofamilia;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextArea TxtNota;
    private javax.swing.JTextField TxtProveedor;
    private javax.swing.JTextField TxtUbicacion;
    private javax.swing.JComboBox<String> comboBodega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtproducto;
    // End of variables declaration//GEN-END:variables
}
