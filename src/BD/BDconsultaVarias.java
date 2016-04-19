/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CargaP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public abstract class BDconsultaVarias {
    
    
    public static CargaP buscarIngreso (int idc) throws SQLException{
    
        return buscarIngreso(idc, null);
        
    }
    
    public static CargaP buscarIngreso(int idc, CargaP c) throws SQLException{
        
        Connection cn = BD.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select id_ingreso,fecha_ven,"
                + "                      fecha_ingreso,"
                + "                      precio,"
                +"                       no_trabajo,"
                +"                       no_invoice,"
                +"                       no_documento,"
                +"                       no_serie,"
                +"                       ingresadopor,"
                +"                       proveedor,"
                + "                      P_N,"
                + "                      cantidad,"
                + "                      PO,"
                + "                      lote,"
                + "                      bodega,"
                + "                      notas "
                + "                      from "
                + "                      ingreso  where id_ingreso="+idc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new CargaP(){
             };
        
        }
        c.setReturnFecha(rs.getString("fecha_ven"));
        c.setReturnFechaIgre(rs.getString("fecha_ingreso"));
        c.setPrecio(rs.getInt("precio"));
        c.setNTrabajo(rs.getString("no_trabajo"));
        c.setInvoce(rs.getString("no_invoice"));
        c.setNoDocumento(rs.getString("no_documento"));
        c.setNoserie(rs.getString("no_serie"));
        c.setIngresadoPor(rs.getInt("ingresadopor"));
        c.setProveedor(rs.getString("proveedor"));
        c.setPN(rs.getString("P_N"));
        c.setCantidad(rs.getInt("cantidad"));
        c.setPO(rs.getString("PO"));
        c.setLote(rs.getString("lote"));
        c.setBodeda(rs.getInt("bodega"));
        c.setNota(rs.getString("notas")); 
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    
    
    public static ArrayList<CargaP> ListarProductoIngresadoEdit(int c) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,cantidad,no_invoice,fecha_ven,lote from ingreso where codigo=" + c  );

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