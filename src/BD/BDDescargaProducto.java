/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CargaP;
import java.util.ArrayList;
import Class.Descarga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author jluis
 */
public abstract class BDDescargaProducto {
    
    public static void insertarDescarga(Descarga ca)  throws SQLException{
        Connection cn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into descarga(id_descarga,id_ingreso,codigo,cantidad,entregadoa,nota,fechades,fechasistema) values (descarga1.nextval,?,?,?,?,?,?,sysdate)");
        //ps.setInt(1, ca.getId_descarga());
        ps.setInt(1, ca.getId_ingreso());
        ps.setInt(2, ca.getCodigo());
        ps.setInt(3, ca.getCantidad());
        ps.setInt(4, ca.getEntregadoA());
        ps.setString(5, ca.getNota());
        ps.setDate(6, new java.sql.Date(ca.getFecha().getTime()));
        ps.executeUpdate();
        cn.close();
        ps.close();            
    }
    
    public static CargaP buscarDescarga (int idc) throws SQLException{
    
        return buscarDescarga(idc, null);
    }
    
    public static CargaP buscarDescarga(int idc, CargaP c) throws SQLException{
        
        Connection cn = BD.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select ingreso.id_ingreso,ingreso.fecha_ven,ingreso.P_N,ingreso.cantidad,ingreso.PO,ingreso.lote,producto.descripcion from ingreso inner join producto on producto.codigo = ingreso.codigo and ingreso.id_ingreso="+idc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new CargaP(){
             };
        
        }
        c.setId_ingreso(rs.getInt("id_ingreso"));
        c.setReturnFechaIgre(rs.getString("fecha_ven"));
        c.setPN(rs.getString("P_N"));
        c.setCantidad(rs.getInt("cantidad"));
        c.setPO(rs.getString("PO"));
        c.setLote(rs.getString("lote"));
        c.setDescripcion(rs.getString("descripcion"));
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
       
}
