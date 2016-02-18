/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.BDProducto;
import Class.Producto;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class EditProducto extends javax.swing.JInternalFrame {
     
     FileInputStream foto;
     int longitudBytes;
     ImageIcon foto1;
     InputStream is;
    /**
     * Creates new form EditProducto
     */
    public EditProducto() {
        initComponents();
        activarcajastexto(true);
        activarbotones(true);
    }

    public void limpiarTextos() {

        txtCodigoBus.setText("");
        txtDescripcion.setText("");
        txtNota.setText("");
        txtUbicacion.setText("");
        txtProveedor.setText("");

    }

    public void activarcajastexto(boolean b) {

        txtCodigoBus.setEnabled(b);
        txtDescripcion.setEnabled(!b);
        txtNota.setEnabled(!b);
        txtProveedor.setEnabled(!b);
        txtUbicacion.setEnabled(!b);
        txtCanti.setEditable(!b);

    }

    public void activarbotones(boolean b) {

        BCancelarPro.setEnabled(b);
        BGuardarPro.setEnabled(!b);
        BmodificarPro.setEnabled(b);
        CargarFoto.setEnabled(!b);
        

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
        txtCodigoBus = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        BmodificarPro = new javax.swing.JButton();
        BGuardarPro = new javax.swing.JButton();
        BCancelarPro = new javax.swing.JButton();
        LabelFoto = new javax.swing.JLabel();
        CargarFoto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCanti = new javax.swing.JTextField();

        setClosable(true);
        setTitle("EDITAR PRODUCTO");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Codigo");

        txtCodigoBus.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtCodigoBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBusActionPerformed(evt);
            }
        });
        txtCodigoBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBusKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBusKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Proveedor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ubicacion");

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtUbicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nota:");

        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        BmodificarPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BmodificarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        BmodificarPro.setLabel("Modificar");
        BmodificarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmodificarProActionPerformed(evt);
            }
        });

        BGuardarPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BGuardarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        BGuardarPro.setText("Guardar");
        BGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarProActionPerformed(evt);
            }
        });

        BCancelarPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BCancelarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        BCancelarPro.setText("Cancelar");
        BCancelarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarProActionPerformed(evt);
            }
        });
        BCancelarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BCancelarProKeyPressed(evt);
            }
        });

        LabelFoto.setBackground(new java.awt.Color(255, 255, 255));
        LabelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LabelFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CargarFoto.setText("Cargar Foto");
        CargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarFotoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad Minima");

        txtCanti.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(BmodificarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(BGuardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(BCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCanti, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CargarFoto)
                        .addGap(152, 152, 152))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CargarFoto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BmodificarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BGuardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCancelarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoBus, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBusActionPerformed

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from producto where codigo=" + txtCodigoBus.getText());
            rs.next();
            int codigo = rs.getInt("count(codigo)");
            if (codigo == 1) {
                Producto p = BDProducto.buscarProducto(Integer.parseInt(String.valueOf(txtCodigoBus.getText())));
                txtDescripcion.setText(p.getDescripcion());
                txtNota.setText(p.getNota());
                txtProveedor.setText(p.getProveedor());
                txtUbicacion.setText(p.getUbicacion());
                txtCanti.setText(String.valueOf(p.getCantidadminima()));
                is = p.getFoto();
                BufferedImage bi = ImageIO.read(is);
                foto1 = new ImageIcon(bi);
                Image img = foto1.getImage();
                Image newimg = img.getScaledInstance (200,200,java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                LabelFoto.setIcon(newicon);
                

            } else {
                JOptionPane.showMessageDialog(null, "Producto " + txtCodigoBus.getText() + " No Exixte");
                limpiarTextos();
                txtCodigoBus.requestFocus();
            }

        } catch (Exception e) {
            System.out.println("Editar este maldito Error" + e);
        }
        BCancelarPro.requestFocus();

    }//GEN-LAST:event_txtCodigoBusActionPerformed

    private void txtCodigoBusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBusKeyPressed

    private void BmodificarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmodificarProActionPerformed
        activarcajastexto(false);
        activarbotones(false);
    }//GEN-LAST:event_BmodificarProActionPerformed

    private void BCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarProActionPerformed
        limpiarTextos();
        txtCodigoBus.requestFocus();

    }//GEN-LAST:event_BCancelarProActionPerformed

    private void BCancelarProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BCancelarProKeyPressed
        limpiarTextos();
        txtCodigoBus.requestFocus();
    }//GEN-LAST:event_BCancelarProKeyPressed

    private void BGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarProActionPerformed

        Producto p;
        try {

            p = BDProducto.buscarProducto(Integer.parseInt(txtCodigoBus.getText()));
            p.setCodigo(Integer.parseInt(txtCodigoBus.getText()));
            p.setDescripcion(txtDescripcion.getText());
            p.setProveedor(txtProveedor.getText());
            p.setNota(txtNota.getText());
            p.setUbicacion(txtUbicacion.getText());
            p.setCantidadminima(Integer.parseInt(txtCanti.getText()));
            p.setFoto(foto);
            p.setLongitudBytes(longitudBytes);
            BDProducto.actualizarProducto(p);
            JOptionPane.showMessageDialog(null, "Datos de Producto Acutalizados");
            activarbotones(true);
            limpiarTextos();
            activarcajastexto(true);
            txtCodigoBus.requestFocus();

        } catch (Exception e) {
            System.out.println("Error UPdate" + e);
        }


    }//GEN-LAST:event_BGuardarProActionPerformed

    private void txtCodigoBusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBusKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoBusKeyTyped

    private void CargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarFotoActionPerformed

        LabelFoto.setIcon(null);
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION){
            try{
                foto=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                    (LabelFoto.getWidth(),LabelFoto.getHeight(),Image.SCALE_DEFAULT);
                    LabelFoto.setIcon(new ImageIcon(icono));
                    LabelFoto.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_CargarFotoActionPerformed

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
            java.util.logging.Logger.getLogger(EditProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelarPro;
    private javax.swing.JButton BGuardarPro;
    private javax.swing.JButton BmodificarPro;
    private javax.swing.JButton CargarFoto;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCanti;
    private javax.swing.JTextField txtCodigoBus;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
