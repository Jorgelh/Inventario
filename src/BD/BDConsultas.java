/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jorge Luis
 */
public abstract class BDConsultas {
    
    
    public static ArrayList<consultanp> ListarPN(String d) {

        return consultarSQL("select descarga.PN,"
                                 + "descarga.no_trabajo,"
                                 + "descarga.lote,"
                                 + "descarga.cantidad,"
                                 + "descarga.entregadoa,"
                                 + "descarga.nota,"
                                 + "descarga.fechades,"
                                 + "descarga.documento,"
                                 + "descarga.serie,"
                                 + "descarga.codigo,"
                                 + "producto.descripcion "
                                 + "from descarga inner join producto on descarga.codigo = producto.codigo "
                                 + "where upper(descarga.PN) = upper('"+d+"') order by fechasistema");

    }

    private static ArrayList<consultanp> consultarSQL(String sql1) {
        ArrayList<consultanp> list = new ArrayList<consultanp>();
        Connection cn = BD.getConnection();
        try {
            consultanp c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                c = new consultanp();
                c.setCodigo(rs.getInt("codigo"));
                c.setNo_trabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechades(rs.getString("fechades"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setEntregadoa(rs.getString("entregadoa"));
                c.setPN(rs.getString("PN"));
                c.setNota(rs.getString("nota"));
                c.setDocumento(rs.getString("documento"));
                c.setSerie(rs.getString("serie"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error Consulta PN " + ex);
           // return null;
        }
        return list;
    }
    
    public static ArrayList<ConsultaFecha> ListarRangoFecha(String f, String a) {

        return consultaIngreSQLrango("select ingreso.codigo,producto.descripcion,ingreso.cantidad,ingreso.P_N,ingreso.notas,ingreso.fecha_ingreso from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fechasistema between '" + f + "' and '"+ a +"' order by fechasistema");


    }
    
    public static ArrayList<ConsultaFecha> ListarIngresoFecha(String f, int b1, int b2 ) {

        return consultaIngreSQL("select ingreso.codigo,producto.descripcion,ingreso.cantidad,ingreso.P_N,ingreso.notas,ingreso.fecha_ingreso from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fechasistema = '" + f + "' and bodega ="+b1+" or bodega = "+b2+" order by ingreso.codigo" );

    }
    

    public static ArrayList<ConsultaFecha> ListarFecha(String t, int b1 , int b2) {

        return consultaSQL("select descarga.codigo,producto.descripcion,descarga.cantidad,descarga.entregadoa,descarga.nota,descarga.fechades from DESCARGA INNER JOIN PRODUCTO on descarga.codigo=producto.codigo join ingreso on ingreso.id_ingreso = descarga.id_ingreso where (ingreso.bodega ="+b1+" or ingreso.bodega = "+b2+") and DESCARGA.fechasistema = '" + t + "' order by descarga.codigo" );

    }

    private static ArrayList<ConsultaFecha> consultaSQL(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setEntregadoA(rs.getString("entregadoa"));
                c.setNota(rs.getString("nota"));
                c.setFechades(rs.getString("fechades"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    private static ArrayList<ConsultaFecha> consultaIngreSQL(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setPN(rs.getString("P_N"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setNota(rs.getString("notas"));
                c.setFecha(rs.getString("fecha_ingreso"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    
    private static ArrayList<ConsultaFecha> consultaIngreSQLrango(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setPN(rs.getString("P_N"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setNota(rs.getString("notas"));
                c.setFecha(rs.getString("fecha_ingreso"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    
    
    
    public static ArrayList<Producto> ListarCodigo(String c) {

        return consultanombreSQL("select codigo,descripcion,ubicacion,cantidad from producto where codigo like '"+c+"%'");

    }
    
    
    
    public static ArrayList<Producto> ListarNombre(String f) {

        return consultanombreSQL("select codigo,descripcion,ubicacion,cantidad from producto where upper(descripcion) like upper('"+f+"%')");

    }

    private static ArrayList<Producto> consultanombreSQL(String sql) {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Connection cn = BD.getConnection();
        try {
            Producto c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Producto();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion")); 
                c.setUbicacion(rs.getString("ubicacion"));
                c.setCantidad(rs.getInt("cantidad"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta producto por nombre " + e);
            return null;
        }
        return list;
    }
    
    
    public static ArrayList<consultanp> ListaringrePN(String d) {

        return consultarinSQL("select ingreso.P_N,"
                                 + "ingreso.no_trabajo,"
                                 + "ingreso.lote,"
                                 + "ingreso.cantidad,"
                                 + "ingreso.ingresadopor,"
                                 + "ingreso.notas,"
                                 + "ingreso.fecha_ingreso,"
                                 + "ingreso.no_documento,"
                                 + "ingreso.no_serie,"
                                 + "ingreso.codigo,"
                                 + "producto.descripcion,"
                                 + "bitacoraingreso.cantidad as \"Cin\" "
                                 + "from ingreso inner join producto on ingreso.codigo = producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso "
                                 + "where upper(ingreso.P_N) = upper('"+d+"') order by fechasistema");

    }
   

    private static ArrayList<consultanp> consultarinSQL(String sql1) {
        ArrayList<consultanp> list = new ArrayList<consultanp>();
        Connection cn = BD.getConnection();
        try {
            consultanp c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                c = new consultanp();
                c.setCodigo(rs.getInt("codigo"));
                c.setNo_trabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaingre(rs.getString("fecha_ingreso"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setIngrepor(rs.getString("ingresadopor"));
                c.setPN(rs.getString("P_N"));
                c.setNota(rs.getString("notas"));
                c.setDocumento(rs.getString("no_documento"));
                c.setSerie(rs.getString("no_serie"));
                c.setCantInicial(rs.getInt("Cin"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error Consulta PN " + ex);
           // return null;
        }
        return list;
    }
    
    
    
}
