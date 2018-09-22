/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import BD.BD;
import Class.Descarga;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public class ListarReporte {
    
     private int codigo;
     private String descripcion;
     private int cantidadin;
     private double valoringreso;
     private int cantidadout;
     private double valorout;
     private int cantidadsaldo;
     private double valortotal;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadin() {
        return cantidadin;
    }

    public void setCantidadin(int cantidadin) {
        this.cantidadin = cantidadin;
    }

    public double getValoringreso() {
        return valoringreso;
    }

    public void setValoringreso(double valoringreso) {
        this.valoringreso = valoringreso;
    }

    public int getCantidadout() {
        return cantidadout;
    }

    public void setCantidadout(int cantidadout) {
        this.cantidadout = cantidadout;
    }

    public double getValorout() {
        return valorout;
    }

    public void setValorout(double valorout) {
        this.valorout = valorout;
    }

    public int getCantidadsaldo() {
        return cantidadsaldo;
    }

    public void setCantidadsaldo(int cantidadsaldo) {
        this.cantidadsaldo = cantidadsaldo;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
     
    public static ArrayList<ListarReporte> ListarReporteFecha(String in, String out ) {

        return consultaDescSQLrango("select k.codigo,p.descripcion,(select sum(COALESCE(cantidadin,0))from kardex where to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy') and codigo = k.codigo  )-COALESCE((select sum(cantidadout)from kardex where  to_date(fecha,'dd/mm/yy') < to_date('"+in+"','dd/mm/yy') and codigo = k.codigo),0) as \"CANTIDAD INGRESO\",\n" +
"((select sum(COALESCE(cantidadin,0))from kardex where to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy') and codigo = k.codigo)-COALESCE((select sum(cantidadout)from kardex where  to_date(fecha,'dd/mm/yy') < to_date('"+in+"','dd/mm/yy') and codigo = k.codigo),0))*(select valorsaldo from kardex where idkardex =(select MAX(idkardex) from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy') and codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy'))) as \"VALOR TOTAL INGRESO\", \n" +
"sum(COALESCE(k.cantidadout,0)) as \"CANTIDAD SALIDA\",\n" +
"sum(COALESCE(k.cantidadout,0))*(select valorsaldo from kardex where idkardex =(select MAX(idkardex) from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy')) and codigo = k.codigo)  AS \"VALOR SALIDA\",\n" +
"COALESCE((select sum(cantidadin)from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy')),0)- COALESCE((select sum(cantidadout)from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+in+"','dd/mm/yy')),0)- COALESCE(sum(k.cantidadout),0) as \"CANTIDAD SALDO\",\n" +
"((select sum(COALESCE(cantidadin,0))from kardex where to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy') and codigo = k.codigo)-COALESCE((select sum(cantidadout)from kardex where  to_date(fecha,'dd/mm/yy') < to_date('"+in+"','dd/mm/yy') and codigo = k.codigo),0))*(select valorsaldo from kardex where idkardex =(select MAX(idkardex) from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy') and codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy'))) - sum(COALESCE(k.cantidadout,0))*(select valorsaldo from kardex where idkardex =(select MAX(idkardex) from kardex where codigo = k.codigo and to_date(fecha,'dd/mm/yy') < to_date('"+out+"','dd/mm/yy')) and codigo = k.codigo)  AS \"VALOR TOTAL\"\n" +
"from kardex k inner join producto p on p.codigo = k.codigo \n" +
"where k.fecha between to_date('"+in+"','dd/mm/yy') and to_date('"+out+"','dd/mm/yy') group BY k.codigo,p.descripcion");
    
    
    }
    
    private static ArrayList<ListarReporte> consultaDescSQLrango(String sql) {
        ArrayList<ListarReporte> list = new ArrayList<ListarReporte>();
        Connection cn = BD.getConnection();
        try {
            ListarReporte c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ListarReporte();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidadin(rs.getInt("CANTIDAD INGRESO"));
                c.setValoringreso(rs.getDouble("VALOR TOTAL INGRESO"));
                c.setCantidadout(rs.getInt("CANTIDAD SALIDA"));
                c.setValorout(rs.getDouble("VALOR SALIDA"));
                c.setCantidadsaldo(rs.getInt("CANTIDAD SALDO"));
                c.setValortotal(rs.getDouble("VALOR TOTAL"));
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
