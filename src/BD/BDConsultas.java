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
    
    
    public static ArrayList<consultanp> ListarPN(String c) {

        return consultarSQL("select ingreso.codigo," +
"       ingreso.no_trabajo," +
"       ingreso.lote," +
"       producto.descripcion," +
"       descarga.fechades," +
"       descarga.cantidad," +
"       descarga.entregadoa" +
"       from ingreso inner join producto on ingreso.codigo = producto.codigo join DESCARGA on ingreso.id_ingreso = descarga.id_ingreso  where ingreso.P_N ="+c );

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
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta PN " + e);
            return null;
        }
        return list;
    }
    
    public static ArrayList<ConsultaFecha> ListarRangoFecha(String f, String a) {

        return consultaIngreSQLrango("select ingreso.codigo,producto.descripcion,ingreso.cantidad,ingreso.P_N,ingreso.notas,ingreso.fecha_ingreso from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fechasistema between '" + f + "' and '"+ a +"'");


    }
    
    public static ArrayList<ConsultaFecha> ListarIngresoFecha(String f) {

        return consultaIngreSQL("select ingreso.codigo,producto.descripcion,ingreso.cantidad,ingreso.P_N,ingreso.notas,ingreso.fecha_ingreso from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fechasistema = '" + f + "'" );

    }
    

    public static ArrayList<ConsultaFecha> ListarFecha(String f) {

        return consultaSQL("select descarga.codigo,producto.descripcion,descarga.cantidad,descarga.entregadoa,descarga.nota,descarga.fechades from DESCARGA INNER JOIN PRODUCTO on descarga.codigo=producto.codigo where DESCARGA.FECHADES = '" + f + "'" );

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

        return consultanombreSQL("select codigo,descripcion,ubicacion,cantidad from producto where descripcion like '"+f+"%'");

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
    
    
    
}
