/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Historial;
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
public abstract class BDHistorialIn {
    
    public static ArrayList<Historial> ListarHistorialIn() {

        return consultaVencimientos("select ingreso.codigo,"
                                  + "descarga .cantidad,"
                                  + "ingreso.notas,"
                                  + "ingreso.fecha_ingreso,"
                                  + "ingreso.po,ingreso.FECHA_VEN,"
                                  + "ingreso.no_invoice,"
                                  + "ingreso.proveedor,"
                                  + "producto.descripcion,"
                                  + "descarga.entregadoa,"
                                  + "descarga.nota from  ingreso inner join producto on ingreso.codigo = producto.CODIGO join descarga on ingreso.CODIGO = descarga.codigo where ingreso.cantidad = 0 order by producto.descripcion");
    }
    
    private static ArrayList<Historial> consultaVencimientos(String sql2) {
        ArrayList<Historial> list = new ArrayList<Historial>();
        Connection cn = BD.getConnection();
        try {
            Historial c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                c = new Historial();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setFechaingre(rs.getString("fecha_ingreso"));
                c.setPo(rs.getString("po"));
                c.setFechaVen(rs.getString("fecha_ven"));
                c.setInvoice(rs.getString("no_invoice"));
                c.setProveedor(rs.getString("proveedor"));
                c.setNotain(rs.getString("notas"));                
                c.setEntregadoa(rs.getString("entregadoa"));
                c.setNotaDesc(rs.getString("nota"));
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
