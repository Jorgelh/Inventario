/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Vencimientos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public abstract class DBMaterialesPorVencer {
    
    
    
    public static ArrayList<Vencimientos> ListarVencimientosproximos() {

      /*  return consultaVencimientos("select ingreso.codigo,"
                                    + "producto.descripcion,"
                                    + "ingreso.fecha_ven,"
                                    + "ingreso.cantidad,"
                                    + "ingreso.fecha_ingreso,"
                                    + "ingreso.po,"
                                    + "ingreso.notas from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fecha_ven between to_date(sysdate,'dd/mm/yy') and to_date(sysdate+30,'dd/mm/yy') and estado = 'A'");
        */
      return consultaVencimientos("select ingreso.codigo,producto.descripcion,ingreso.fecha_ven,ingreso.cantidad,ingreso.fecha_ingreso, ingreso.po,ingreso.notas from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fecha_ven < to_date(sysdate+30,'dd/mm/yy') and ingreso.cantidad > 0");
    }
    
    private static ArrayList<Vencimientos> consultaVencimientos(String sql2) {
        ArrayList<Vencimientos> list = new ArrayList<Vencimientos>();
        Connection cn = BD.getConnection();
        try {
            Vencimientos c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                c = new Vencimientos();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaVen(rs.getString("fecha_ven"));
                c.setFechaIngreso(rs.getString("fecha_ingreso"));
                c.setNotas(rs.getString("notas"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setPo(rs.getString("po"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    
    public static ArrayList<Vencimientos> ListarVencidos() {

        return consultaVencimientos("select ingreso.codigo,"
                                    + "producto.descripcion,"
                                    + "ingreso.fecha_ven,"
                                    + "ingreso.cantidad,"
                                    + "ingreso.fecha_ingreso,"
                                    + "ingreso.po,"
                                    + "ingreso.notas from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fecha_ven is not null and fecha_ven < to_date(sysdate,'dd/mm/yy')");
    }
    
    private static ArrayList<Vencimientos> consultaVencidos(String sql2) {
        ArrayList<Vencimientos> list = new ArrayList<Vencimientos>();
        Connection cn = BD.getConnection();
        try {
            Vencimientos c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                c = new Vencimientos();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaVen(rs.getString("fecha_ven"));
                c.setFechaIngreso(rs.getString("fecha_ingreso"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setNotas(rs.getString("notas"));
                c.setPo(rs.getString("po"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    
    
}
