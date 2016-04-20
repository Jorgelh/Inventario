/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.*;
import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.text.SimpleDateFormat;
import com.sun.corba.se.spi.orb.ParserData;
import java.util.Date;



/**
 *
 * @author jluis
 */
public abstract class DBCargaPro {
    
    //DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

        
    public static void insertarProductoNuevo(CargaP c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into ingreso" 
                + "(id_ingreso,codigo,P_N,fecha_ingreso,"
                + "PO,cantidad,fecha_ven,precio,"
                + "lote,no_trabajo,no_invoice,no_documento,"
                + "no_serie,ingresadopor,proveedor,notas,"
                + "bodega,fechasistema,estado) "
                + "values (ingreso1.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,'A')");
       // ps.setInt(1,c.getId_ingreso());
        ps.setInt(1,c.getCodigo());
        ps.setString(2,c.getPN());
        ps.setDate(3, new java.sql.Date(c.getFechaIngre().getTime()));
        ps.setString(4,c.getPO());
        ps.setInt(5,c.getCantidad());
        if (c.getFechaVencimiento()== null){ps.setString(6, null);} else {ps.setDate(6, new java.sql.Date(c.getFechaVencimiento().getTime()));}
        ps.setDouble(7, c.getPrecio());
        ps.setString(8, c.getLote());
        ps.setString(9, c.getNTrabajo());
        ps.setString(10, c.getInvoce());
        ps.setString(11, c.getNoDocumento());
        ps.setString(12, c.getNoserie());
        ps.setInt(13,c.getIngresadoPor());
        ps.setString(14, c.getProveedor());
        ps.setString(15, c.getNota());
        ps.setInt(16, c.getBodeda());
        //ps.setString(18, c.getEstado());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }
    

    public static ArrayList<CargaP> ListarProductoIngresado(int c) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,cantidad,no_invoice,fecha_ven,lote from ingreso where codigo=" + c + "and cantidad > 0 and estado = 'A'" );

    }

    private static ArrayList<CargaP> consultarSQL(String sql) {
        ArrayList<CargaP> list = new ArrayList<CargaP>();
        Connection cn = BD.getConnection();
        try {
            CargaP c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new CargaP();
                c.setId_ingreso(rs.getInt("id_ingreso"));
                c.setPN(rs.getString("P_N"));
                c.setReturnFecha(rs.getString("fecha_ingreso"));
                c.setPO(rs.getString("PO"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setInvoce(rs.getString("no_invoice"));
                c.setReturnFechaIgre(rs.getString("fecha_ven"));
                c.setLote(rs.getString("lote"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Ingreso Productos " + e);
            return null;
        }
        return list;
    }

}
