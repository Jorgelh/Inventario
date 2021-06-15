/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import BD.BD;
import BD.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jluis
 */
public class ReporteCostos extends javax.swing.JInternalFrame {

    int no;
    String Fecha;

    /**
     * Creates new form ReporteCostos
     */
    public ReporteCostos() {
        initComponents();
        ListadePeriodos();
    }

    private void abrir() throws IOException {
      
    Desktop.getDesktop().open(new File("\\\\192.168.0.2\\Bases de Datos\\Sistema\\Bodega\\Inventario Vigente\\ReporteDeCostos.xlsx"));
       
    }

    private void ListadePeriodos() {

        ArrayList<ListarReporte> result = ListarReporte.ListarReporte();
        Tablarep(result);

    }

    public void Tablarep(ArrayList<ListarReporte> list) {
        Object[][] dato = new Object[list.size()][4];
        int i = 0;
        for (ListarReporte p : list) {
            dato[i][0] = p.getNo();
            dato[i][1] = p.getFecha();
            i++;
        }
        reportes.setModel(new javax.swing.table.DefaultTableModel(
                dato,
                new String[]{
                    "NO.", "PERIDO"
                }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void traerno() {

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(no) from costo");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                no = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }

    }

    public void executeStoreCosto() {
        try {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = inicio.getDate();
            Date fec2 = fin.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin calculode_costos(FechaInicio=>'" + fe1 + "',FechaFin=>'" + fe2 + "',NO=>" + no + ",FECHA=>'" + Fecha + "'); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
        }
    }

    private void ReporteCostos(int n) throws FileNotFoundException, IOException {

        System.out.println("entra");
        Workbook book = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Moviemiento Inventario Mensual");
        try {

            org.apache.poi.ss.usermodel.CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            org.apache.poi.ss.usermodel.Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 12);
            tituloEstilo.setFont(fuenteTitulo);

            org.apache.poi.ss.usermodel.Row filaTitulo = sheet.createRow(1);
            org.apache.poi.ss.usermodel.Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Productos");

            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 18));//posicion de titulo

            String[] cabecera = new String[]{"CODIGO", "DESCRIPCION", "COSTO", "CANTIDAD INICIAL", "CANTIDAD INGRESO", "CHIPS", "TRANSFORMADORES", "SOLDER", "TESTING", "TALLER", "INGENIERIA", "MOLDING", "RECIVING", "INSPECCION", "BODEGA", "MANTENIMIENTO", "GERENCIA", "CANTIDAD FINAL", "VALOR INVENTARIO", "CONSUMO"};

            org.apache.poi.ss.usermodel.CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            headerStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            headerStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            headerStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);

            org.apache.poi.ss.usermodel.Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 10);
            headerStyle.setFont(font);

            org.apache.poi.ss.usermodel.Row filaEncabezados = sheet.createRow(4); //empiezan encabezados
            for (int i = 0; i < cabecera.length; i++) {
                org.apache.poi.ss.usermodel.Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            PreparedStatement ps;
            ResultSet rs;
            Connection conn = BD.getConnection();

            int numFilaDatos = 5; //donde empieza a los registros

            org.apache.poi.ss.usermodel.CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            datosEstilo.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            datosEstilo.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);
            datosEstilo.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);

            ps = conn.prepareStatement("SELECT codigo,descricion,precio,qtyingresoinicial,qtyingreso,chips,transformadores,solder,testing,taller,ingenieria,molding,reciving,inspeccion,bodega,mantenimiento,gerencia,qtyfinal,v_inventario,c_materia FROM costo where no =" + n);
            rs = ps.executeQuery();

            int numCol = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                org.apache.poi.ss.usermodel.Row filaDatos = sheet.createRow(numFilaDatos);

                for (int a = 0; a < numCol; a++) {

                    org.apache.poi.ss.usermodel.Cell CeldaDatos = filaDatos.createCell(a);
                    CeldaDatos.setCellStyle(datosEstilo);

                    if (a == 2 || a == 3) {
                        CeldaDatos.setCellValue(rs.getDouble(a + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(a + 1));
                    }
                }

                /* org.apache.poi.ss.usermodel.Cell celdaImporte = filaDatos.createCell(5);//posicion de columna de resultado con formula y creacion de columna
                celdaImporte.setCellStyle(datosEstilo);
                celdaImporte.setCellFormula(String.format("D%d*E%d", numFilaDatos + 1, numFilaDatos + 1)); // formula de columna
                
                Cell celdaImporte1 = filaDatos.createCell(6);//posicion de columna de resultado con formula y creacion de columna
                celdaImporte1.setCellStyle(datosEstilo);
                celdaImporte1.setCellFormula(String.format("C%d*D%d", numFilaDatos + 1, numFilaDatos + 1)); // formula de columna*/
                numFilaDatos++;

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);
            sheet.autoSizeColumn(13);
            sheet.autoSizeColumn(14);
            sheet.autoSizeColumn(15);
            sheet.autoSizeColumn(16);
            sheet.autoSizeColumn(17);
            sheet.autoSizeColumn(18);
            sheet.autoSizeColumn(19);
            sheet.setZoom(100);

            FileOutputStream fileOut = new FileOutputStream("\\\\192.168.0.2\\Bases de Datos\\Sistema\\Bodega\\Inventario Vigente\\ReporteDeCostos.xlsx");
            book.write(fileOut);
            fileOut.close();

            /*} catch (FileNotFoundException ex) {
            Logger.getLogger(Class.ReporteCostos .class.getName()).log(Level.SEVERE, null, ex);*/
        } catch (SQLException ex) {
            System.err.println("ERROR = " + ex);
            Logger.getLogger(ReporteCostos.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*catch (IOException ex) {
            Logger.getLogger(Class.ReporteCostos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Class.ReporteCostos.class.getName()).log(Level.SEVERE, null, ex);
        }*/

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
        jButton1 = new javax.swing.JButton();
        inicio = new com.toedter.calendar.JDateChooser();
        fin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportes = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Next.png"))); // NOI18N
        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE COSTOS ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PERIODO DEL ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("AL");

        reportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO.", "PERIODO"
            }
        ));
        reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(reportes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(152, 152, 152)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (inicio.getDate() != null && fin.getDate() != null) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = inicio.getDate();
            Date fec2 = fin.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
            try {
                Date f1 = formato.parse(fe1);
                Date f2 = formato.parse(fe2);

                if (f1.before(f2)) {

                    Fecha = fe1 + " - " + fe2;
                    traerno();
                    executeStoreCosto();
                    JOptionPane.showMessageDialog(rootPane, "PERIODO GENERADO...");
                    inicio.setDate(null);
                    fin.setDate(null);
                    ListadePeriodos();
                    

                } else {
                    JOptionPane.showMessageDialog(null, "LA PRIMERA FECHA NO PUEDE SER MAYOR A LA SEGUNDA FECHA");
                }

            } catch (ParseException ex) {
                //Logger.getLogger(CIngresoRangoFecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE LAS FECHAS...");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesMouseClicked
        
         if (evt.getClickCount() > 1) {
        int d =  (Integer.parseInt(String.valueOf(reportes.getModel().getValueAt(reportes.getSelectedRow(), 0))));
        try {
            ReporteCostos(d);
            abrir();

        } catch (IOException ex) {
            Logger.getLogger(ReporteCostos.class.getName()).log(Level.SEVERE, null, ex);
        }

         }
    }//GEN-LAST:event_reportesMouseClicked

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
            java.util.logging.Logger.getLogger(ReporteCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteCostos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fin;
    private com.toedter.calendar.JDateChooser inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reportes;
    // End of variables declaration//GEN-END:variables
}
