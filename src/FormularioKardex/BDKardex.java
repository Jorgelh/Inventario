/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormularioKardex;

import BD.BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public class BDKardex {
    
    
    
     public static ArrayList<ClassKardex> ListarProductoIngresado(int c) {

        return consultarSQL("select decode(tipo,1,'INGRESO',2,'DESCARGA') AS TIPO,to_char(fecha,'dd/mm/yy') as fecha,cantidadin,valorin,totalin,cantidadout,valorout,totalout,cantidadsaldo,valorsaldo,totalsaldo from kardex where codigoint = "+c+" order by idkardex");

    }
     
     public static ArrayList<ClassKardex> ListarProductoIngresado2(int c) {

        return consultarSQL("select decode(tipo,1,'INGRESO',2,'DESCARGA') AS TIPO,to_char(fecha,'dd/mm/yy') as fecha,cantidadin,valorin,totalin,cantidadout,valorout,totalout,cantidadsaldo,valorsaldo,totalsaldo from kardexout where codigoint = "+c+" order by idkardex");

    }

    private static ArrayList<ClassKardex> consultarSQL(String sql) {
        ArrayList<ClassKardex> list = new ArrayList<ClassKardex>();
        Connection cn = BD.getConnection();
        try {
            ClassKardex c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ClassKardex();
                c.setTipo(rs.getString("tipo"));
                c.setFecha(rs.getString("fecha"));
                c.setCantidadin(rs.getInt("cantidadin"));
                c.setPrecioin(rs.getDouble("valorin"));
                c.setTotalin(rs.getDouble("totalin"));
                
                c.setCantidadout(rs.getInt("cantidadout"));
                c.setPrecioout(rs.getDouble("valorout"));
                c.setTotalout(rs.getDouble("totalout"));
                
                c.setCantidadsaldo(rs.getInt("cantidadsaldo"));
                c.setPreciosaldo(rs.getDouble("valorsaldo"));
                c.setTotalsaldo(rs.getDouble("totalsaldo"));
                
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
