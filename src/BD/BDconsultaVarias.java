/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CargaP;
import Class.Producto;
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
                + "                      ingreso  where id_ingreso="+idc+"and estado = 'A'");
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new CargaP(){
             };
        
        }
        c.setId_ingreso(rs.getInt("id_ingreso"));
        c.setReturnFecha(rs.getString("fecha_ven"));
        c.setReturnFechaIgre(rs.getString("fecha_ingreso"));
        c.setPrecio(rs.getDouble("precio"));
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
        c.setPreciotxt(rs.getString("precio"));
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    
    
    public static ArrayList<CargaP> ListarProductoIngresadoEdit(int c) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,cantidad,no_invoice,fecha_ven,lote from ingreso where codigo=" + c + "and estado = 'A'" );

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
    
    public static boolean actualizarIngreso(CargaP c) throws SQLException{
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("Update ingreso set "
                + "p_n=?,"
                + "po=?,"
                + "cantidad=?,"
                + "fecha_ven=?, "
                + "precio=?,"
                + "lote=?,"
                + "no_trabajo=?,"
                + "no_invoice=?,"
                + "no_documento=?,"
                + "no_serie=?,"
                + "ingresadopor=?,"
                + "proveedor=?,"
                + "notas=?,"
                + "bodega=?"
                + " where id_ingreso=" +c.getId_ingreso());
        ps.setString(1, c.getPN());
        ps.setString(2, c.getPO());
        ps.setInt(3, c.getCantidad());
        if (c.getFechaVencimiento()== null){ps.setString(4, null);} else {ps.setDate(4, new java.sql.Date(c.getFechaVencimiento().getTime()));}
        //ps.setDate(4, new java.sql.Date(c.getFechaVencimiento().getTime()));
        ps.setDouble(5, c.getPrecio());
        ps.setString(6, c.getLote());
        ps.setString(7, c.getNTrabajo());
        ps.setString(8, c.getInvoce());
        ps.setString(9, c.getNoDocumento());
        ps.setString(10, c.getNoserie());
        ps.setInt(11, c.getIngresadoPor());
        ps.setString(12, c.getProveedor());
        ps.setString(13, c.getNota());
        ps.setInt(14, c.getBodeda());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0){ return true;}
        else {return false;}
        
    }
    
    
    
}
