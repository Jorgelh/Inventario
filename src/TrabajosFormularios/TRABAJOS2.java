/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosFormularios;

import BD.BD;
import TrabajosClases.consultas;
import TrabajosClases.insertartrabajo;
import TrabajosClases.trabajos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class TRABAJOS2 extends javax.swing.JInternalFrame {

    
    int noestandar = 0;
    int depto = 0;
    int id;
    int lotecanti;
    int lotecantidiv;
    int idcontrol;
    
    
    
    /**
     * Creates new form TRABAJOS
     */
    public TRABAJOS2() {
        initComponents();
        pn.requestFocus();
        listartrabajos();
    }

    public void limpiar()
    {
    pn.setText("");
    job.setText("");
    lote.setText("");
    cantidad.setText("");
    departamento.setText("");
    estandar.setText("");
    Date date = null;   
        fechaentrega.setDate(date);
        fecharecibi.setText("");
        fechavencimien.setText("");
        noestandar = 0;
        entregado.setText("");
        nota.setText("");
        pn.requestFocus();
   
     noestandar = 0;
     depto = 0;
     id = 0;
     lotecanti = 0;
     lotecantidiv = 0;
    }
    
    public void actualizarTrabajo(){   
        try {
             Connection cn = BD.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("UPDATE TRABAJONEW SET ESTADO = 2 WHERE IDTRABAJO="+id);
             ps.close();
             rs.close();
        } catch (Exception e) {
            System.out.println(e);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        job = new javax.swing.JTextField();
        fechaentrega = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        estandar = new javax.swing.JTextField();
        fecharecibi = new javax.swing.JTextField();
        fechavencimien = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lote = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        entregado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nota = new javax.swing.JTextArea();
        cantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        departamento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        trabajo = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        BPN = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BJOB = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO DE TRABAJOS");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("JOB");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ESTANDAR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("FECHA DE RECIBIDO EN BODEGA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("FECHA DE ENTREGA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("FECHA VENCIMIENTO DE TRABAJO");

        job.setEditable(false);
        job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobActionPerformed(evt);
            }
        });
        job.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jobKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jobKeyTyped(evt);
            }
        });

        fechaentrega.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("P/N");

        pn.setEditable(false);
        pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnActionPerformed(evt);
            }
        });
        pn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pnKeyTyped(evt);
            }
        });

        estandar.setEditable(false);

        fecharecibi.setEditable(false);

        fechavencimien.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(job)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(fechaentrega, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(estandar)
                            .addComponent(fecharecibi)
                            .addComponent(fechavencimien))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(job, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(estandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecharecibi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechavencimien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("LOTE");

        lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("DEPARTAMENTO");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ENTREGADO POR");

        entregado.setEditable(false);
        entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregadoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("NOTA");

        nota.setColumns(20);
        nota.setRows(5);
        jScrollPane1.setViewportView(nota);

        cantidad.setEditable(false);
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CANTIDAD");

        departamento.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entregado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(0, 197, Short.MAX_VALUE))
                            .addComponent(lote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departamento, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(8, 8, 8))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        trabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P/N", "JOB", "CANTIDAD", "FECHA RECIBIDO ", "ID"
            }
        ));
        trabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trabajoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(trabajo);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("P/N");

        BPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPNActionPerformed(evt);
            }
        });
        BPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BPNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BPNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BPNKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("JOB");

        BJOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJOBActionPerformed(evt);
            }
        });
        BJOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BJOBKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(guardar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BPN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BJOB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BJOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
      
        if(idcontrol == id){
         if( fecharecibi.getText().compareTo("")!=0 && fechavencimien.getText().compareTo("")!=0 
            && estandar.getText().compareTo("")!=0 && pn.getText().compareTo("") != 0 && job.getText().compareTo("") != 0 && 
                 lote.getText().compareTo("") != 0 && departamento.getText().compareTo("")!=0 && cantidad.getText().compareTo("")!=0
                 ) 
                 {
         
             for(int i=0; Integer.parseInt(lote.getText())>i;i++){        
        try {
            insertartrabajo m = new insertartrabajo();
            m.setPn(pn.getText().toUpperCase());
            m.setJob(job.getText().toUpperCase());
            if(estandar.getText().equals("FUJI")){noestandar = 1;}
            else if(estandar.getText().equals("INGENIERIA")){noestandar = 2;}
            else if(estandar.getText().equals("MIL-PRF-27")){noestandar = 3;}
            else if(estandar.getText().equals("MIL-STD-981")){noestandar = 4;}
            else if(estandar.getText().equals("MIL-STD-981 PRE-CAP")){noestandar = 5;}
            else if(estandar.getText().equals("MIL-STD-981 URGENTE")){noestandar = 6;}
            else if(estandar.getText().equals("MIL-STD-981-X RAY")){noestandar = 7;}
            else if(estandar.getText().equals("SAMPLE")){noestandar = 8;}
            m.setEstandarint(noestandar);
            m.setSfecharecibido(fecharecibi.getText());
            //m.setFechaentrega(null);
            m.setSfechavencimiento(fechavencimien.getText());
            m.setLote(i+1);
            if(departamento.getText().equals("CHIPS")){depto = 1;}
            else if(departamento.getText().equals("TRANSFORMADORES")){depto = 2;}
            m.setDepto(depto);
            //m.setEntregado(Integer.parseInt(entregado.getText()));
            m.setEntregado(0);
            m.setNota(nota.getText());
            m.setCantidad(Integer.parseInt(cantidad.getText()));
            insertartrabajo.InsertarTrabajo(m);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR  DE DONDE"+e);
        }
             }
             JOptionPane.showMessageDialog(null, "TRABAJO AGREGADO...");
             actualizarTrabajo();
             listartrabajos();
             limpiar();
             }else {JOptionPane.showMessageDialog(null, "LLene Los Campos necesario");}
        }else {JOptionPane.showMessageDialog(null, "Seleccionar el P/N");}
    }//GEN-LAST:event_guardarActionPerformed

    private void pnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnKeyReleased

         pn.setText(pn.getText().trim());

    }//GEN-LAST:event_pnKeyReleased

    private void pnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnKeyTyped

    }//GEN-LAST:event_pnKeyTyped

    private void jobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobKeyTyped
        

    }//GEN-LAST:event_jobKeyTyped

    private void jobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobKeyReleased

            job.setText(job.getText().trim());
    }//GEN-LAST:event_jobKeyReleased

    private void pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnActionPerformed

        job.requestFocus();
        
    }//GEN-LAST:event_pnActionPerformed

    private void jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobActionPerformed
         estandar.requestFocus();
    }//GEN-LAST:event_jobActionPerformed

    private void loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteActionPerformed
      
        lotecantidiv = Integer.parseInt(lote.getText());
        cantidad.setText(String.valueOf(lotecanti/lotecantidiv));
        guardar.requestFocus();
    }//GEN-LAST:event_loteActionPerformed

    private void entregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregadoActionPerformed
                        guardar.requestFocus();
    }//GEN-LAST:event_entregadoActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
       departamento.requestFocus();
    }//GEN-LAST:event_cantidadActionPerformed

    private void trabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajoMouseClicked
            
            lote.requestFocus();
            id = (Integer.parseInt(String.valueOf(trabajo.getModel().getValueAt(trabajo.getSelectedRow(),4))));
        try {
            
       insertartrabajo p = consultas.BuscarEntrega(Integer.parseInt(String.valueOf(trabajo.getModel().getValueAt(trabajo.getSelectedRow(),4))));
              System.out.println(p);
               pn.setText(p.getPn());
               job.setText(p.getJob());
               estandar.setText(String.valueOf(p.getEstandar()));
               fecharecibi.setText(p.getSfecharecibido());
               fechavencimien.setText(p.getSfechavencimiento());
               lotecanti = p.getCantidad();
               departamento.setText(p.getDeptostring());
               idcontrol = p.getId();
               
        } catch (Exception e) {
            System.out.println("Error de Seleccion:"+e);
        }
        System.out.println("resul "+idcontrol+" == "+id+"");
    }//GEN-LAST:event_trabajoMouseClicked

    private void BPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPNKeyReleased
       
    }//GEN-LAST:event_BPNKeyReleased

    private void BJOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJOBActionPerformed
      
    }//GEN-LAST:event_BJOBActionPerformed

    private void BPNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPNKeyTyped
            listartrabajos();
    }//GEN-LAST:event_BPNKeyTyped

    private void BJOBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BJOBKeyTyped
            listartrabajos();
    }//GEN-LAST:event_BJOBKeyTyped

    private void BPNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BPNKeyPressed

    }//GEN-LAST:event_BPNKeyPressed

    private void BPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BPNActionPerformed

    
     private void listartrabajos(){
        ArrayList<trabajos> result = consultas.ListarTrabajoNew(BPN.getText().toUpperCase(),BJOB.getText().toUpperCase());
        productos(result);
    }
    
    private void productos(ArrayList<trabajos> list){
        
         Object[][] datos = new Object[list.size()][5];
              int i = 0;
              for(trabajos t : list)
              {
                  datos[i][0] = t.getPn();
                  datos[i][1] = t.getJob();
                  datos[i][2] = t.getCantidad();
                  datos[i][3] = t.getFechareci();
                  datos[i][4] = t.getId_trabajo();
                  i++;
              }    
             trabajo.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "P/N","JOB","CANTIDAD","FECHA RECIBIDO","ID"
             })
             {  
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
            java.util.logging.Logger.getLogger(TRABAJOS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TRABAJOS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TRABAJOS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TRABAJOS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TRABAJOS2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BJOB;
    private javax.swing.JTextField BPN;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField departamento;
    private javax.swing.JTextField entregado;
    private javax.swing.JTextField estandar;
    private com.toedter.calendar.JDateChooser fechaentrega;
    private javax.swing.JTextField fecharecibi;
    private javax.swing.JTextField fechavencimien;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField job;
    private javax.swing.JTextField lote;
    private javax.swing.JTextArea nota;
    private javax.swing.JTextField pn;
    private javax.swing.JTable trabajo;
    // End of variables declaration//GEN-END:variables
}
