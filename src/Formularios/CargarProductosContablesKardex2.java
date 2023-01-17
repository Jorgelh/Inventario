/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BD.BD;
import BD.DBCargaPro;
import Class.CargaP;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jluis
 */
public class CargarProductosContablesKardex2 extends javax.swing.JInternalFrame {

    int Enviacodigo;
    int bodega;
    int presentacion;
    int id_ingreso;
    int idkardex;
    int ididentificador;
    int tipodeconta;
    int cantidaddeingreso = 0;
    Double nuevoprecio = 0.00;
    Double precioanterior = 0.00;
    DefaultTableModel temp;
    String fecha1;

    /**
     */
    public CargarProductosContablesKardex2() {

        initComponents();
        limpiartxt();
        activarTxt(false);

    }

    public void executeStorePrecio() {
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarprecio(NCodigo=>" + txtCodigo.getText() + ",NPrecio=>" + nuevoprecio + ",NBodega=>" + bodega + "); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void UltimoprecioKardex() {

        if (presentacion == 0) {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardex where id =(select MAX(id) from kardex where codigo = '" + txtCodigo.getText() + "') and codigo = '" + txtCodigo.getText() + "'");
                while (rs.next()) {
                    Double precio = rs.getDouble(1);
                    precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
            }
        } else {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardex where id =(select MAX(id) from kardex where codigo = '" + txtCodigo.getText() + '-' + presentacion + "') and presentacion =" + presentacion);
                while (rs.next()) {
                    Double precio = rs.getDouble(1);
                    precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
            }
        }
    }

    public void UltimoprecioKardexOut() {

        if (presentacion == 0) {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardexout where id =(select MAX(id) from kardexout where codigo = '" + txtCodigo.getText() + "') and codigo = '" + txtCodigo.getText() + "'");
                while (rs.next()) {
                    Double precio = rs.getDouble(1);
                    precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
            }
        } else {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select valorsaldo from kardexout where id =(select MAX(id) from kardexout where codigo = '" + txtCodigo.getText() + '-' + presentacion + "') and presentacion =" + presentacion);
                while (rs.next()) {
                    Double precio = rs.getDouble(1);
                    precioanterior = precio;
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException error) {
                System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO PRECIO DE INGRESO");
            }
        }
    }

    public void ProcedimientoKardex() {
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarkardex(IDKardex=>" + idkardex + ","
                    + "NCodigo=>'" + txtCodigo.getText() + "',"
                    + "NDocumento=>'0',"
                    + "Fecha_ingreso=>'" + fecha1 + "',"
                    + "Ncantidad=>" + Integer.parseInt(txtCantidad.getText()) + ","
                    + "Nprecio=>" + Double.parseDouble(TxtPrecio.getText()) + ","
                    + "CantidadSaldo=>" + cantidaddeingreso + ","
                    + "precioSaldo=>" + nuevoprecio + ","
                    + "Ididen=>" + ididentificador + ","
                    + "Presentacion=>" + presentacion + ","
                    + "CodigoInt=>"+txtCodigo.getText()+","
                    + "Tipodeconta=>"+tipodeconta+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e + " ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }

    public void ProcedimientoKardex2() {      
        try {
            String codigo;
            codigo = txtCodigo.getText() + '-' + presentacion;
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarkardex(IDKardex=>" + idkardex + ","
                    + "NCodigo=>'" + codigo + "',"
                    + "NDocumento=>'0',"
                    + "Fecha_ingreso=>'" + fecha1 + "',"
                    + "Ncantidad=>" + Integer.parseInt(txtCantidad.getText()) + ","
                    + "Nprecio=>" + Double.parseDouble(TxtPrecio.getText()) + ","
                    + "CantidadSaldo=>" + cantidaddeingreso + ","
                    + "precioSaldo=>" + nuevoprecio + ","
                    + "Ididen=>" + ididentificador + ","
                    + "Presentacion=>" + presentacion + ","
                    + "CodigoInt=>" + txtCodigo.getText() +","
                    + "Tipoconta=>"+tipodeconta+"); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e + " ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }

    /*public void ProcedimientoKardexOut() { //SE UTILIZABA PARA INSERTAR EN KARDEXOUT
        try {
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarkardexout(IDKardex=>" + idkardex + ","
                    + "NCodigo=>'" + txtCodigo.getText() + "',"
                    + "NDocumento=>'0',"
                    + "Fecha_ingreso=>'" + fecha1 + "',"
                    + "Ncantidad=>" + Integer.parseInt(txtCantidad.getText()) + ","
                    + "Nprecio=>" + Double.parseDouble(TxtPrecio.getText()) + ","
                    + "CantidadSaldo=>" + cantidaddeingreso + ","
                    + "precioSaldo=>" + nuevoprecio + ","
                    + "Ididen=>" + ididentificador + ","
                    + "Presentacion=>" + presentacion + ","
                    + "CodigoInt=>" + txtCodigo.getText() + "); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e + " ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }

    public void ProcedimientoKardexOut2() {
        try {
            String codigo;
            codigo = txtCodigo.getText() + '-' + presentacion;
            Connection cn = BD.getConnection();
            Statement ps = cn.createStatement();
            ps.executeUpdate("begin actualizarkardexout(IDKardex=>" + idkardex + ","
                    + "NCodigo=>'" + codigo + "',"
                    + "NDocumento=>'0',"
                    + "Fecha_ingreso=>'" + fecha1 + "',"
                    + "Ncantidad=>" + Integer.parseInt(txtCantidad.getText()) + ","
                    + "Nprecio=>" + Double.parseDouble(TxtPrecio.getText()) + ","
                    + "CantidadSaldo=>" + cantidaddeingreso + ","
                    + "precioSaldo=>" + nuevoprecio + ","
                    + "Ididen=>" + ididentificador + ","
                    + "Presentacion=>" + presentacion + ","
                    + "CodigoInt=>" + txtCodigo.getText() + "); commit; end;");
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e + " ERROR DE LOS DATOS DE PROCEDIMIENTO");
        }
    }*/

    public void ultimoidingreso() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id_ingreso) from ingreso");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                id_ingreso = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + "ERROR QUE OBTIENE EL ULTIMO ID DE INGRESO");
        }
    }

    public void sumaingresos() {

        if (presentacion == 0) {
            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = " + txtCodigo.getText() + " and conta = 1 and presentacion = 0");
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

        } else {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = " + txtCodigo.getText() + " and conta = 1 and presentacion = " + presentacion);
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
       
    /*public void sumaingresosKardexOut() {

        if (presentacion == 0) {
            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = " + txtCodigo.getText() + " and conta = 2 and presentacion = 0");
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

        } else {

            try {
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select sum(cantidad) as cantidad from ingreso where codigo = " + txtCodigo.getText() + " and conta = 2 and presentacion = " + presentacion);
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
    }*/
    
    public void ididentificadorKardex() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from kardex");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                ididentificador = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }

    /* public void ididentificadorKardexOut() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from kardexout");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                ididentificador = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }*/
     
    public void id_kardex() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idkardex) from kardex");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                idkardex = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }
    
   /*  public void id_kardexOut() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idkardex) from kardexout");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                idkardex = lastID + 1;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error + " ERROR QUE OBTIENE EL ULTIMO ID DE KARDEX ");
        }
    }*/

    public void obtenerdescripcion() {

        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion from producto where codigo=" + txtCodigo.getText());
            rs.next();
            descripcion.setText(rs.getString("descripcion"));
//            Fecha1.setDate(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }

    }

    public void activarTxt(boolean b) {

        txtCantidad.setEnabled(b);
        txtEmpleado.setEnabled(b);
        //Fecha.setEnabled(b);
        txtfechavenci.setEnabled(b);
        //txtInvoice.setEnabled(b);
        txtJob.setEnabled(b);
        txtLote.setEnabled(b);
        //txtNoDoc.setEnabled(b);
        txtNota.setEnabled(b);
        txtPO.setEnabled(b);
        txtParte.setEnabled(b);
        //txtSerie.setEnabled(b);
        TxtProveedor.setEnabled(b);
        TxtPrecio.setEnabled(b);
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
        txtJob.setText("");
        txtLote.setText("");
        //txtNoDoc.setText("");
        txtNota.setText("");
        txtPO.setText("");
        txtParte.setText("");
        //txtSerie.setText("");
        TxtProveedor.setText("");
        TxtPrecio.setText("0.00");
        precioanterior = 0.00;
        nuevoprecio = 0.00;
        Date date = null;
        txtfechavenci.setDate(date);
        descripcion.setText("");
        Combpresentacion.setSelectedItem("Seleccionar...");
        obligatorio.setForeground(Color.BLACK);
        //obligatorio1.setForeground(Color.BLACK);
        obligatorio2.setForeground(Color.BLACK);
        obligatorio4.setForeground(Color.BLACK);
        obligatorio5.setForeground(Color.BLACK);
        obligatorio7.setForeground(Color.BLACK);

    }

    public void limpiarcancelar() {
        Date date = null;
        Fecha.setDate(date);
        fechapoliza.setDate(date);
        txtInvoice.setText("");
        limpiartxt();
    }

    public void FechasJdate() {

        Calendar c2 = new GregorianCalendar();
        Fecha.setCalendar(c2);

    }

    public void fechaingresokardex() {
        Date date = fechapoliza.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        fecha1 = sdf.format(date);
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public void CargarKardex1() {
        fechaingresokardex();
        actulizartabla();
        ultimoidingreso();
        UltimoprecioKardex();//hacer #2
        sumaingresos();//hacer #2
        id_kardex();//hacer #2
        ididentificadorKardex();//hacer #2
        nuevoprecio = ((Double.parseDouble(TxtPrecio.getText()) * Integer.parseInt(txtCantidad.getText())) + (cantidaddeingreso * precioanterior)) / (Integer.parseInt(txtCantidad.getText()) + (cantidaddeingreso));
        try {
            CargaP c = new CargaP();
            c.setCodigo(Integer.parseInt(txtCodigo.getText()));
            c.setId_ingreso(id_ingreso);
            c.setBodeda(1);
            c.setCantidad(Integer.parseInt(txtCantidad.getText()));
            c.setBitacora(Integer.parseInt(txtCantidad.getText()));
            c.setEstado("A");
            c.setFechaIngre(Fecha.getDate());
            c.setFechapoliza(fechapoliza.getDate());
            c.setFechaVencimiento(txtfechavenci.getDate());
            c.setIngresadoPor(Integer.parseInt(txtEmpleado.getText()));
            c.setInvoce(txtInvoice.getText());
            c.setLote(txtLote.getText());
            c.setNTrabajo(txtJob.getText());
            //c.setNoDocumento(txtNoDoc.getText());
           //c.setNoserie(txtSerie.getText());
            c.setNota(txtNota.getText());
            c.setPO(txtPO.getText());
            c.setPN(txtParte.getText());
            c.setProveedor(TxtProveedor.getText());
            c.setPrecio(Double.parseDouble(TxtPrecio.getText()));
            c.setPresent(presentacion);
            c.setConta(1);
            if (transito.isSelected()) {tipodeconta=2;} else {tipodeconta=1;}
            DBCargaPro.insertarProductoNuevoContable(c);
            JOptionPane.showMessageDialog(null, "Producto Cargado...");
            executeStorePrecio();
            if (presentacion == 0) {
                ProcedimientoKardex();
            } else {
                ProcedimientoKardex2();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
        actulizartabla();
        limpiartxt();
        activarTxt(false);
    }

   /* public void CargarKardex2() {

        fechaingresokardex();
        actulizartabla();
        ultimoidingreso();
        UltimoprecioKardexOut();
        sumaingresosKardexOut();
        id_kardexOut();
        ididentificadorKardexOut();
        nuevoprecio = ((Double.parseDouble(TxtPrecio.getText()) * Integer.parseInt(txtCantidad.getText())) + (cantidaddeingreso * precioanterior)) / (Integer.parseInt(txtCantidad.getText()) + (cantidaddeingreso));
        try {
            CargaP c = new CargaP();
            c.setCodigo(Integer.parseInt(txtCodigo.getText()));
            c.setId_ingreso(id_ingreso);
            c.setBodeda(1);
            c.setCantidad(Integer.parseInt(txtCantidad.getText()));
            c.setEstado("A");
            c.setFechaIngre(Fecha.getDate());
            c.setFechapoliza(fechapoliza.getDate());
            c.setFechaVencimiento(txtfechavenci.getDate());
            c.setIngresadoPor(Integer.parseInt(txtEmpleado.getText()));
            c.setInvoce(txtInvoice.getText());
            c.setLote(txtLote.getText());
            c.setNTrabajo(txtJob.getText());
           // c.setNoDocumento(txtNoDoc.getText());
            //c.setNoserie(txtSerie.getText());
            c.setNota(txtNota.getText());
            c.setPO(txtPO.getText());
            c.setPN(txtParte.getText());
            c.setProveedor(TxtProveedor.getText());
            c.setPrecio(Double.parseDouble(TxtPrecio.getText()));
            c.setPresent(presentacion);
            c.setConta(2);
            DBCargaPro.insertarProductoNuevoContable(c);
            JOptionPane.showMessageDialog(null, "Producto Cargado...");
            executeStorePrecio();
            if (presentacion == 0) {
                ProcedimientoKardexOut();
            } else {
                ProcedimientoKardexOut2();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
        actulizartabla();
        limpiartxt();
        activarTxt(false);

    }*/

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
        jLabel13 = new javax.swing.JLabel();
        TxtProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        obligatorio = new javax.swing.JLabel();
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
        txtfechavenci = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        obligatorio5 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        obligatorio2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Combpresentacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        Bcancelar = new javax.swing.JButton();
        BagregarProdu = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngreso = new javax.swing.JTable();
        descripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        transito = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        obligatorio4 = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        obligatorio7 = new javax.swing.JLabel();
        fechapoliza = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESO PRODUCTOS CONTABLE");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE INGRESO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14)))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Proveedor");

        TxtProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProveedorActionPerformed(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyTyped(evt);
            }
        });

        obligatorio.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio.setText("(*)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtProveedor)
            .addComponent(TxtPrecio)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obligatorio)))
                .addGap(0, 127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(obligatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Job");

        txtJob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("P.O");

        txtPO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPOActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Vencimiento");

        txtfechavenci.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Ingresado Por");

        obligatorio5.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio5.setText("(*)");

        txtEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoActionPerformed(evt);
            }
        });
        txtEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpleadoKeyTyped(evt);
            }
        });

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
                    .addComponent(txtfechavenci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmpleado)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(obligatorio5)))
                        .addGap(0, 112, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(obligatorio5))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfechavenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANTIDAD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Nota");

        obligatorio2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio2.setText("(*)");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Presentacion");

        Combpresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "5 Galones", "1 Galon", "1/4 Galon", "1 Libra", "2 Libras", "8 Onzas", "6 Onzas", "4 Onzas", "2 Onzas" }));
        Combpresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombpresentacionActionPerformed(evt);
            }
        });

        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        Bcancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Bcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        Bcancelar.setText("Cancelar");
        Bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarActionPerformed(evt);
            }
        });

        BagregarProdu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BagregarProdu.setText("Agregar Producto");
        BagregarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagregarProduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Combpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(BagregarProdu))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obligatorio2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel16)
                                .addContainerGap(94, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(BagregarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(obligatorio2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
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
        transito.setForeground(new java.awt.Color(0, 0, 255));
        transito.setText("DECRETO 2989");
        transito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transitoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Fecha Poliza");

        obligatorio4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio4.setText("(*)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("No. Invoice");

        txtInvoice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoiceActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 255));
        jLabel21.setText("Fecha Ingreso");
        jLabel21.setMaximumSize(new java.awt.Dimension(99, 10));
        jLabel21.setMinimumSize(new java.awt.Dimension(99, 10));

        obligatorio7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        obligatorio7.setText("(*)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtInvoice, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(obligatorio7))
                        .addComponent(fechapoliza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obligatorio4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obligatorio4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obligatorio7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechapoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(transito))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(transito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        if (txtCodigo.getText().compareTo("") != 0 && txtCantidad.getText().compareTo("") != 0 && txtEmpleado.getText().compareTo("") != 0
                && TxtPrecio.getText().compareTo("0.00") != 0.00 && TxtPrecio.getText().compareTo("") != 0
                && fechapoliza.getDate() != null) {
            CargarKardex1();
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
            obligatorio.setForeground(Color.red);
            //obligatorio1.setForeground(Color.red);
            obligatorio2.setForeground(Color.red);
            obligatorio4.setForeground(Color.red);
            obligatorio5.setForeground(Color.red);
            obligatorio7.setForeground(Color.red);
        }
    }//GEN-LAST:event_BagregarProduActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

        BagregarProdu.requestFocus();

    }//GEN-LAST:event_txtCantidadActionPerformed
    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked

    }//GEN-LAST:event_txtFechaMouseClicked
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
                obtenerdescripcion();
                TxtProveedor.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Producto " + txtCodigo.getText() + " No Existe");
                limpiartxt();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONTACTE AL ADMINISTRADOR DEL SISTEMA" + e);
        }
    }//GEN-LAST:event_txtCodigoActionPerformed
    private void BcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarActionPerformed
        limpiartxt();
        limpiartabla15();
        activarTxt(false);
        limpiarcancelar();
        txtCodigo.requestFocus();
    }//GEN-LAST:event_BcancelarActionPerformed
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
    private void txtInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoiceActionPerformed
        TxtProveedor.requestFocus();
    }//GEN-LAST:event_txtInvoiceActionPerformed
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

        txtEmpleado.requestFocus();

    }//GEN-LAST:event_txtPOActionPerformed
    private void txtfechavenciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfechavenciMouseExited
       
    }//GEN-LAST:event_txtfechavenciMouseExited
    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed

        txtCantidad.requestFocus();

    }//GEN-LAST:event_txtEmpleadoActionPerformed
    private void CombpresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombpresentacionActionPerformed

        if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")) {
            presentacion = 0;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1 Galon")) {
            presentacion = 1;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1/4 Galon")) {
            presentacion = 2;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("1 Libra")) {
            presentacion = 3;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("2 Libras")) {
            presentacion = 4;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("8 Onzas")) {
            presentacion = 5;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("6 Onzas")) {
            presentacion = 6;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("4 Onzas")) {
            presentacion = 7;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("2 Onzas")) {
            presentacion = 8;
        } else if (Combpresentacion.getSelectedItem().toString().equalsIgnoreCase("5 Galones")) {
            presentacion = 9;
        }

    }//GEN-LAST:event_CombpresentacionActionPerformed
    private void transitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transitoActionPerformed
    private void txtEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmpleadoKeyTyped
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
            java.util.logging.Logger.getLogger(CargarProductosContablesKardex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContablesKardex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContablesKardex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarProductosContablesKardex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarProductosContablesKardex2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BagregarProdu;
    private javax.swing.JButton Bcancelar;
    private javax.swing.JComboBox<String> Combpresentacion;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtProveedor;
    private javax.swing.JTextField descripcion;
    private com.toedter.calendar.JDateChooser fechapoliza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel obligatorio;
    private javax.swing.JLabel obligatorio2;
    private javax.swing.JLabel obligatorio4;
    private javax.swing.JLabel obligatorio5;
    private javax.swing.JLabel obligatorio7;
    private javax.swing.JTable tablaIngreso;
    private javax.swing.JCheckBox transito;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtPO;
    private javax.swing.JTextField txtParte;
    private com.toedter.calendar.JDateChooser txtfechavenci;
    // End of variables declaration//GEN-END:variables

}
