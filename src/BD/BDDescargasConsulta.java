/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CargaP;
import Class.Descarga;
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
public class BDDescargasConsulta {
    
    
     public static ArrayList<CargaP> ListarProductoDescargado(int c , int b1, int b2) {

        return consultarDescarga("select id_descarga,pn,lote,no_trabajo,cantidad from descarga where codigo=" + c );
         //return consultarDescarga("select id_descarga,pn,lote,no_trabajo,cantidad from descarga where (ingreso.bodega = "+b1+" or ingreso.bodega = "+b2+" ) and codigo=" + c + "and  estado = 'A'" );

     }
        
        private static ArrayList<CargaP> consultarDescarga(String sql) {
        ArrayList<CargaP> list = new ArrayList<CargaP>();
        Connection cn = BD.getConnection();
        try {
            CargaP c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new CargaP();
                c.setId_ingreso(rs.getInt("id_descarga"));
                c.setPN(rs.getString("pn"));
                //c.setReturnFecha(rs.getString("fecha_ingreso"));
                //c.setPO(rs.getString("PO"));
                c.setCantidad(rs.getInt("cantidad"));
                //c.setInvoce(rs.getString("no_invoice"));
                //c.setReturnFechaIgre(rs.getString("fecha_ven"));
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
        
        
        
     public static Descarga buscarDescarga (int idc) throws SQLException{
    
        return buscarDescarga(idc, null);
        
    }
    
    public static Descarga buscarDescarga(int idc, Descarga c) throws SQLException{
        
        Connection cn = BD.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select descarga.documento,descarga.pn,descarga.lote,descarga.no_trabajo,descarga.fechades,descarga.cantidad,descarga.entregadoa,descarga.nota,ingreso.po,ingreso.bodega from descarga inner join ingreso on descarga.id_ingreso = ingreso.id_ingreso where descarga.ID_DESCARGA ="+idc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
             if (c == null){
             c = new Descarga(){
             };
        }
        //c.setId_ingreso(rs.getInt("id_ingreso"));
        c.setFechades(rs.getString("fechades"));
        c.setDocumento(rs.getString("documento"));
        c.setPn(rs.getString("pn"));
        c.setCantidad(rs.getInt("cantidad"));
        c.setPO(rs.getString("PO"));
        c.setLote(rs.getString("lote"));
        c.setTrabajo(rs.getString("no_trabajo"));
        c.setBodega(rs.getInt("bodega"));
        c.setEntregadoA(rs.getInt("entregadoa"));
        //c.setDescripcion(rs.getString("descripcion"));
        c.setNota(rs.getString("nota"));
        }
        cn.close();
        ps.close();
        return c;
    }
}
