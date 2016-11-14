/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P;

import BD.BD;
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
public class agotados {
    
    
    
    public static ArrayList<Vencimientos> ListarProductoporAgotar() {
       return consultaagotados("select p.codigo,p.descripcion,p.CANTIDADMINIMA, sum(i.CANTIDAD) as \"total\" from  producto p inner join ingreso i on p.codigo = i.CODIGO where p.CANTIDADMINIMA > 0 group by (p.codigo,p.descripcion,p.CANTIDADMINIMA)  having sum(i.CANTIDAD)< p.CANTIDADMINIMA and sum(i.CANTIDAD) > 0 order by p.codigo");
       
    }
    private static ArrayList<Vencimientos> consultaagotados(String sql2) {
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
                c.setCantidadminima(rs.getInt("cantidadminima"));
                c.setCantidad(rs.getInt("total"));
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
