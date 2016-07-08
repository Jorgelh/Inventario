/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Class.Producto;
import BD.BD;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jorge Luis
 */
public class Cproducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cproducto
     */
    Image foto;
    Vector imagenes;
    int index = 0;
    String folder = "";

    public Cproducto() {
        initComponents();
        this.imagenes = new Vector();
        this.imagenes = new Vector();

    }

    

    void cargarAlbum() {

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                if (name.endsWith(".jpg")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        imagenes.clear();
        index = 0;

        String album = ("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\" + txtcodigo.getText());
        System.out.println(album);
        File albumCarpeta = new File(album);

        folder = albumCarpeta.getName();
        //System.out.println(albumCarpeta.getName());
        File[] fotos = albumCarpeta.listFiles(filter);
        if(fotos != null){
        if (fotos.length != 0) {

            adelante.requestFocus();
            for (int i = 0;
                    i < fotos.length;
                    i++) {
                if (fotos[i].isFile()) {
                    imagenes.add(fotos[i].getName());
                }
            }
            lafoto.setIcon(new ImageIcon(((new ImageIcon("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\" + folder + "\\" + (String) imagenes.elementAt(0)).getImage()).getScaledInstance(413, 324, java.awt.Image.SCALE_SMOOTH))));
        } else {
            lafoto.setIcon(new ImageIcon(((new ImageIcon("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\imagen.jpg").getImage()).getScaledInstance(413, 324, java.awt.Image.SCALE_SMOOTH))));
        }
         }
    
        else {
            lafoto.setIcon(new ImageIcon(((new ImageIcon("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\imagen.jpg").getImage()).getScaledInstance(413, 324, java.awt.Image.SCALE_SMOOTH))));
        }
        

    }

    void fotoAdelante() {
        if ((index + 1) < imagenes.size()) {
            index++;
            ImageIcon imagen = (new ImageIcon(((new ImageIcon("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\" + folder + "\\" + (String) imagenes.elementAt(index)).getImage()).getScaledInstance(413, 324, java.awt.Image.SCALE_SMOOTH))));
            lafoto.setIcon(imagen);
            //System.out.println(index + " : " + folder + "\\" + (String) imagenes.elementAt(index));
        } else {
            atras.requestFocus();
            JOptionPane.showMessageDialog(null, "Fin de las Fotos del Album", "Atencion", JOptionPane.OK_OPTION);
        }
    }

    void fotoAtras() {
        if ((index - 1) > -1) {
            index--;
            ImageIcon imagen = (new ImageIcon(((new ImageIcon("\\\\192.168.0.2\\Compartida Produccion\\Fotos de Bodega\\" + folder + "\\" + (String) imagenes.elementAt(index)).getImage()).getScaledInstance(413, 324, java.awt.Image.SCALE_SMOOTH))));
            lafoto.setIcon(imagen);
            //*System.out.println(index + " : " + folder + "\\" + (String) imagenes.elementAt(index));
        } else {
            adelante.requestFocus();
            JOptionPane.showMessageDialog(null, "Fin de las Fotos del Album", "Atencion", JOptionPane.OK_OPTION);
        }
    }

    public void llenarBalance() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sum(cantidad) from ingreso where codigo =" + txtcodigo.getText() + "and bodega = 1");
            while (rs.next()) {
                this.txtcantBodega.setText(String.valueOf(rs.getInt("sum(cantidad)")));
            }
            ResultSet r = stmt.executeQuery("select sum(cantidad) from ingreso where codigo =" + txtcodigo.getText() + "and bodega = 2");
            while (r.next()) {
                this.txttotalBodeguita.setText(String.valueOf(r.getInt("sum(cantidad)")));
            }

            rs.close();
            r.close();
            stmt.close();
        } catch (SQLException error) {
            System.out.println("NO ERROR DE unidad medida" + error);
        }

        int bode = Integer.parseInt(txtcantBodega.getText());
        int bodegui = Integer.parseInt(txttotalBodeguita.getText());
        txtSumas.setText(String.valueOf(bode + bodegui));

    }

    public void limpiartxt() {

        desc.setText("");
        canti.setText("");
        nota.setText("");
        txtcodigo.setText("");
        canti.setText("");
        ubica.setText("");
        lafoto.setIcon(null);
        lafoto.setText("");
        cantidad.setText("");
        txtcodigo.requestFocus();
        txtcodigo.setEnabled(true);
        txtcantBodega.setText("");
        txttotalBodeguita.setText("");
        txtSumas.setText("");
        ubica1.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        ubica = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        nota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ubica1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lafoto = new javax.swing.JLabel();
        BotoNuevo = new javax.swing.JButton();
        adelante = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcantBodega = new javax.swing.JTextField();
        txttotalBodeguita = new javax.swing.JTextField();
        txtSumas = new javax.swing.JTextField();
        canti = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setTitle("CONSULTA DE PRODUCTO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Descripcion:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad en Bodega:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ubicacion Bodega");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nota:");

        desc.setEditable(false);
        desc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        desc.setForeground(new java.awt.Color(0, 102, 255));

        ubica.setEditable(false);
        ubica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ubica.setForeground(new java.awt.Color(0, 102, 255));

        cantidad.setEditable(false);
        cantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cantidad.setForeground(new java.awt.Color(0, 102, 255));

        nota.setEditable(false);
        nota.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nota.setForeground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ubicacion Bodeguita");

        ubica1.setEditable(false);
        ubica1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ubica1.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addComponent(desc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nota, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(ubica, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ubica1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addGap(20, 20, 20))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ubica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)))
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        BotoNuevo.setText("Nueva Busqueda");
        BotoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoNuevoActionPerformed(evt);
            }
        });
        BotoNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BotoNuevoKeyPressed(evt);
            }
        });

        adelante.setText(">>");
        adelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adelanteActionPerformed(evt);
            }
        });
        adelante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adelanteKeyPressed(evt);
            }
        });

        atras.setText("<<");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        atras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atrasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(BotoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adelante)
                .addContainerGap())
            .addComponent(lafoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lafoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adelante)
                    .addComponent(atras))
                .addGap(18, 18, 18)
                .addComponent(BotoNuevo)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Codigo");
        jLabel7.setFocusTraversalPolicyProvider(true);

        txtcodigo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Bodega");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Bodeguita");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Total");

        txtcantBodega.setEditable(false);
        txtcantBodega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcantBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantBodegaActionPerformed(evt);
            }
        });

        txttotalBodeguita.setEditable(false);
        txttotalBodeguita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSumas.setEditable(false);
        txtSumas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSumas.setForeground(new java.awt.Color(255, 0, 51));

        canti.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        canti.setForeground(new java.awt.Color(0, 102, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad Minima");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtSumas))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotalBodeguita)
                            .addComponent(txtcantBodega))))
                .addGap(71, 71, 71)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(canti, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcantBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(canti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txttotalBodeguita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtSumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed

         if(txtcodigo.getText().compareTo("") !=0)
         {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from producto where codigo=" + txtcodigo.getText());
            rs.next();
            int codigo = rs.getInt("count(codigo)");
            if (codigo > 0) {

                consulta();
                llenarBalance();
                cargarAlbum();
                BotoNuevo.requestFocus();
                txtcodigo.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO EXITES...");
                txtcodigo.setText("");
                txtcodigo.requestFocus();
            }

        } catch (Exception e) {
            System.out.println("Editar Error" + e);
        }
         }
         else{JOptionPane.showMessageDialog(null, "Ingrese Codigo..."); }

    }//GEN-LAST:event_txtcodigoActionPerformed

    private void BotoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoNuevoActionPerformed
        limpiartxt();

    }//GEN-LAST:event_BotoNuevoActionPerformed

    private void BotoNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BotoNuevoKeyPressed
        limpiartxt();
    }//GEN-LAST:event_BotoNuevoKeyPressed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtcantBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantBodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantBodegaActionPerformed

    private void adelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adelanteActionPerformed
        fotoAdelante();
    }//GEN-LAST:event_adelanteActionPerformed

    private void adelanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adelanteKeyPressed
        fotoAdelante();
    }//GEN-LAST:event_adelanteKeyPressed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        fotoAtras();
    }//GEN-LAST:event_atrasActionPerformed

    private void atrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atrasKeyPressed
        fotoAtras();
    }//GEN-LAST:event_atrasKeyPressed

    public void consulta() {

        int cod = Integer.parseInt(txtcodigo.getText());
        ImageIcon foto;
        InputStream is;

        try {

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion,ubicacion,ubicacion2,nota,cantidad,cantidadminima,foto from producto where codigo =" + cod);

            while (rs.next()) {
                desc.setText(rs.getString("descripcion"));
                ubica.setText(rs.getString("ubicacion"));
                nota.setText(rs.getString("nota"));
                cantidad.setText(rs.getString("cantidad"));
                canti.setText(rs.getString("cantidadminima"));
                ubica1.setText(rs.getString("ubicacion2"));
                con.close();
            }
           

        } catch (Exception e) {
           
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
            java.util.logging.Logger.getLogger(Cproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cproducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cproducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoNuevo;
    private javax.swing.JButton adelante;
    private javax.swing.JButton atras;
    private javax.swing.JTextField canti;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lafoto;
    private javax.swing.JTextField nota;
    private javax.swing.JTextField txtSumas;
    private javax.swing.JTextField txtcantBodega;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txttotalBodeguita;
    private javax.swing.JTextField ubica;
    private javax.swing.JTextField ubica1;
    // End of variables declaration//GEN-END:variables
}
