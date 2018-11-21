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
//import com.sun.corba.se.spi.orb.ParserData;
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
                + "bodega,fechasistema,estado,cantidad2,conta) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,0)");
        ps.setInt(1,c.getId_ingreso());
        ps.setInt(2,c.getCodigo());
        ps.setString(3,c.getPN());
        ps.setDate(4, new java.sql.Date(c.getFechaIngre().getTime()));
        ps.setString(5,c.getPO());
        ps.setInt(6,c.getCantidad());
        if (c.getFechaVencimiento()== null){ps.setString(7, null);} else {ps.setDate(7, new java.sql.Date(c.getFechaVencimiento().getTime()));}
        ps.setDouble(8, c.getPrecio());
        ps.setString(9, c.getLote());
        ps.setString(10, c.getNTrabajo());
        ps.setString(11, c.getInvoce());
        ps.setString(12, c.getNoDocumento());
        ps.setString(13, c.getNoserie());
        ps.setInt(14,c.getIngresadoPor());
        ps.setString(15, c.getProveedor());
        ps.setString(16, c.getNota());
        ps.setInt(17, c.getBodeda());
        ps.setString(18, c.getEstado());
        ps.setInt(19, c.getCantidad2());
       
        ps.execute();
        cnn.close();
        ps.close();
    }
    
    
    public static void insertarProductoNuevoContable(CargaP c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into ingreso" 
                + "(id_ingreso,codigo,P_N,fecha_ingreso,"
                + "PO,cantidad,fecha_ven,precio,"
                + "lote,no_trabajo,no_invoice,no_documento,"
                + "no_serie,ingresadopor,proveedor,notas,"
                + "bodega,fechasistema,estado,cantidad2,conta) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,1)");
       // ps.setInt(1,c.getId_ingreso());
        ps.setInt(1,c.getId_ingreso());
        ps.setInt(2,c.getCodigo());
        ps.setString(3,c.getPN());
        ps.setDate(4, new java.sql.Date(c.getFechaIngre().getTime()));
        ps.setString(5,c.getPO());
        ps.setInt(6,c.getCantidad());
        if (c.getFechaVencimiento()== null){ps.setString(7, null);} else {ps.setDate(7, new java.sql.Date(c.getFechaVencimiento().getTime()));}
        ps.setDouble(8, c.getPrecio());
        ps.setString(9, c.getLote());
        ps.setString(10, c.getNTrabajo());
        ps.setString(11, c.getInvoce());
        ps.setString(12, c.getNoDocumento());
        ps.setString(13, c.getNoserie());
        ps.setInt(14,c.getIngresadoPor());
        ps.setString(15, c.getProveedor());
        ps.setString(16, c.getNota());
        ps.setInt(17, c.getBodeda());
        ps.setString(18, c.getEstado());
        ps.setInt(19, c.getCantidad2());
        //ps.setString(18, c.getEstado());
        ps.execute();
        cnn.close();
        ps.close();
    }
    
    
    
    public static ArrayList<CargaP> ListarProductoIngresadoporBodega(int c , int b1, int b2) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,cantidad,no_invoice,fecha_ven,lote from ingreso where (ingreso.bodega = "+b1+" or ingreso.bodega = "+b2+" ) and codigo=" + c + "and  estado = 'A' order by id_ingreso" );

    }
    

    public static ArrayList<CargaP> ListarProductoIngresado(int c) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,decode(ingreso.bodega,1,cantidad,2,cantidad2) as  \"cantidad\" ,no_invoice,fecha_ven,lote,precio from ingreso where codigo=" + c + "and (cantidad > 0 or cantidad2 > 0) and estado = 'A' order by id_ingreso" );

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
                c.setPrecio(rs.getDouble("precio"));
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
