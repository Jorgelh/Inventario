/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Dimension;
import javax.swing.JFrame;
import Consultas.*;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import java.awt.Color;

/**
 *
 * @author Jorge Luis
 */
public class PrincipalInventario extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalInventario
     */
    public PrincipalInventario() {
      Color b=new Color(0,150,255);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        menubar.setForeground(Color.GREEN);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mProcedencia1 = new Formularios.MProcedencia();
        mProcedencia2 = new Formularios.MProcedencia();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        NUEVOPRO = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CARGAPRO = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        EDITARPRO = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        familias = new javax.swing.JMenuItem();
        unidadmedida = new javax.swing.JMenuItem();
        presentacion = new javax.swing.JMenuItem();
        PROCEDENCIA = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        DESCARGAPRO = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        CONSULTAPN = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE INVENTARIO DE BODEGA");
        setLocation(new java.awt.Point(0, 0));
        setMaximizedBounds(getMaximizedBounds());
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jInternalFrame1.setVisible(false);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Anatek Electronics, S.A.");

        jDesktopPane1.setLayer(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(683, 683, 683)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        menubar.setBorder(null);
        menubar.setBorderPainted(false);
        menubar.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        menubar.setPreferredSize(new java.awt.Dimension(109, 40));
        menubar.setRequestFocusEnabled(false);

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(0, 51, 255));
        jMenu1.setText("INGRESOS");
        jMenu1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(100, 30));
        jMenu1.setRequestFocusEnabled(false);
        jMenu1.setVerifyInputWhenFocusTarget(false);

        jMenu7.setForeground(new java.awt.Color(0, 51, 255));
        jMenu7.setText("PRODUCTOS");
        jMenu7.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(139, 35));

        NUEVOPRO.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        NUEVOPRO.setForeground(new java.awt.Color(0, 51, 255));
        NUEVOPRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        NUEVOPRO.setText("NUEVO PRODUCTOS");
        NUEVOPRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUEVOPROActionPerformed(evt);
            }
        });
        jMenu7.add(NUEVOPRO);
        jMenu7.add(jSeparator1);

        CARGAPRO.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        CARGAPRO.setForeground(new java.awt.Color(0, 51, 255));
        CARGAPRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Next.png"))); // NOI18N
        CARGAPRO.setText("CARGAR PRODUCTOS");
        CARGAPRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAPROActionPerformed(evt);
            }
        });
        jMenu7.add(CARGAPRO);
        jMenu7.add(jSeparator2);

        EDITARPRO.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        EDITARPRO.setForeground(new java.awt.Color(0, 51, 255));
        EDITARPRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit2.png"))); // NOI18N
        EDITARPRO.setText("EDITAR PRODUCTO");
        EDITARPRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITARPROActionPerformed(evt);
            }
        });
        jMenu7.add(EDITARPRO);

        jMenu1.add(jMenu7);

        jMenu6.setForeground(new java.awt.Color(0, 51, 255));
        jMenu6.setText("COMPONENTES DE PRODUCTO");
        jMenu6.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(271, 35));

        familias.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        familias.setForeground(new java.awt.Color(0, 51, 255));
        familias.setText("FAMILIAS");
        familias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familiasActionPerformed(evt);
            }
        });
        jMenu6.add(familias);

        unidadmedida.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        unidadmedida.setForeground(new java.awt.Color(0, 51, 255));
        unidadmedida.setText("UNIDAD DE MEDIDA");
        unidadmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadmedidaActionPerformed(evt);
            }
        });
        jMenu6.add(unidadmedida);

        presentacion.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        presentacion.setForeground(new java.awt.Color(0, 51, 255));
        presentacion.setText("PRESENTACION");
        presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentacionActionPerformed(evt);
            }
        });
        jMenu6.add(presentacion);

        PROCEDENCIA.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        PROCEDENCIA.setForeground(new java.awt.Color(0, 51, 255));
        PROCEDENCIA.setText("PROCEDENCIA");
        PROCEDENCIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROCEDENCIAActionPerformed(evt);
            }
        });
        jMenu6.add(PROCEDENCIA);

        jMenu1.add(jMenu6);

        menubar.add(jMenu1);

        jMenu3.setForeground(new java.awt.Color(0, 51, 255));
        jMenu3.setText("  DESCARGAS");
        jMenu3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(110, 19));

        DESCARGAPRO.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        DESCARGAPRO.setForeground(new java.awt.Color(0, 51, 255));
        DESCARGAPRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Download.png"))); // NOI18N
        DESCARGAPRO.setText("Descarga de Producto");
        DESCARGAPRO.setPreferredSize(new java.awt.Dimension(197, 35));
        DESCARGAPRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESCARGAPROActionPerformed(evt);
            }
        });
        jMenu3.add(DESCARGAPRO);

        menubar.add(jMenu3);

        jMenu2.setForeground(new java.awt.Color(0, 51, 255));
        jMenu2.setText("  CONSULTAS");
        jMenu2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(110, 19));
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem10.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem10.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem10.setText("BALANCE DE PRODUCTO");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        CONSULTAPN.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        CONSULTAPN.setForeground(new java.awt.Color(0, 51, 255));
        CONSULTAPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        CONSULTAPN.setText("DESCARGAS POR P/N");
        CONSULTAPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONSULTAPNActionPerformed(evt);
            }
        });
        jMenu2.add(CONSULTAPN);

        jMenuItem1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem1.setText("LISTAR PRODUCTOS POR NOMBRE");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem2.setText("LISTAR PRODUCTOS POR CODIGO");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem3.setText("CODIGO PRODUCTO");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenu8.setForeground(new java.awt.Color(0, 51, 255));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenu8.setText("POR FECHAS");
        jMenu8.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem4.setText("INGRESOS POR RANGO DE FECHAS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuItem12.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem12.setText("DESCARGAS DE PRODUCTO POR FECHA ");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem12);

        jMenuItem11.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        jMenuItem11.setText("INGRESOS DE PRODUCTO POR FECHA ");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenu2.add(jMenu8);

        menubar.add(jMenu2);

        jMenu4.setForeground(new java.awt.Color(0, 51, 255));
        jMenu4.setText("   REPORTES");
        jMenu4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(110, 19));
        menubar.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(0, 51, 255));
        jMenu5.setText("       SALIR");
        jMenu5.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(110, 19));
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(0, 51, 255));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jMenuItem5.setText("SALIR");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(85, 35));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        menubar.add(jMenu5);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NUEVOPROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUEVOPROActionPerformed
        MProducto pro = new MProducto();
        jDesktopPane1.add(pro); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = pro.getSize();
        pro.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        pro.show();

    }//GEN-LAST:event_NUEVOPROActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        salir();    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void familiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familiasActionPerformed
        
         MIngresoFamilia f = new MIngresoFamilia();
        jDesktopPane1.add(f); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = f.getSize();
        f.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        f.show();
        
        
        
    }//GEN-LAST:event_familiasActionPerformed

    private void EDITARPROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITARPROActionPerformed
        EditProducto EP = new EditProducto();
        jDesktopPane1.add(EP); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = EP.getSize();
        EP.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        EP.show();
    }//GEN-LAST:event_EDITARPROActionPerformed

    private void DESCARGAPROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESCARGAPROActionPerformed
        DescargaProducto DP = new DescargaProducto();
        jDesktopPane1.add(DP); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = DP.getSize();
        DP.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        DP.show();
    }//GEN-LAST:event_DESCARGAPROActionPerformed

    private void CARGAPROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAPROActionPerformed
       CargarProductos CP = new CargarProductos();
        jDesktopPane1.add(CP); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = CP.getSize();
        CP.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        CP.show();
    }//GEN-LAST:event_CARGAPROActionPerformed

    private void CONSULTAPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONSULTAPNActionPerformed

        ConsultaPN M = new ConsultaPN();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();




    }//GEN-LAST:event_CONSULTAPNActionPerformed

    private void unidadmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadmedidaActionPerformed
                 
         MUnidad_Medida M = new MUnidad_Medida();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
    }//GEN-LAST:event_unidadmedidaActionPerformed

    private void presentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentacionActionPerformed

         MPresentacion P = new MPresentacion();
        jDesktopPane1.add(P); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = P.getSize();
        P.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        P.show();


    }//GEN-LAST:event_presentacionActionPerformed

    private void PROCEDENCIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROCEDENCIAActionPerformed
        
         MProcedencia M = new MProcedencia();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
        
    }//GEN-LAST:event_PROCEDENCIAActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
                   
             Cproducto CP = new Cproducto();
        jDesktopPane1.add(CP); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = CP.getSize();
        CP.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        CP.show();


    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       
        CDesporFecha M = new CDesporFecha();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        CIngresoFecha M = new CIngresoFecha();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        CNombre M = new CNombre();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        
         CCodigo M = new CCodigo();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
         
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        CodigoFoto M = new CodigoFoto();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       
        CRangoIngresoFecha M = new CRangoIngresoFecha();
        jDesktopPane1.add(M); 
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = M.getSize();
        M.setLocation((desktopSize.width - FrameSize.width)/2 , (desktopSize.height - FrameSize.height)/2);
        M.show();
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(PrincipalInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CARGAPRO;
    private javax.swing.JMenuItem CONSULTAPN;
    private javax.swing.JMenuItem DESCARGAPRO;
    private javax.swing.JMenuItem EDITARPRO;
    private javax.swing.JMenuItem NUEVOPRO;
    private javax.swing.JMenuItem PROCEDENCIA;
    private javax.swing.JMenuItem familias;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private Formularios.MProcedencia mProcedencia1;
    private Formularios.MProcedencia mProcedencia2;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem presentacion;
    private javax.swing.JMenuItem unidadmedida;
    // End of variables declaration//GEN-END:variables

    private void salir() {

        System.exit(1);
    }
}
