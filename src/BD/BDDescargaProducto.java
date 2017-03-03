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
        ps = cn.prepareStatement("insert into descarga(id_descarga,id_ingreso,codigo,cantidad,entregadoa,nota,fechades,fechasistema,documento,serie,lote,PN,no_trabajo,departamento) values (DESCARGA1.nextval,?,?,?,?,?,?,sysdate,?,?,?,?,?,?)");
        //ps.setInt(1, ca.getId_descarga());
        ps.setInt(1, ca.getId_ingreso());
        ps.setInt(2, ca.getCodigo());
        ps.setInt(3, ca.getCantidad());
        ps.setInt(4, ca.getEntregadoA());
        ps.setString(5, ca.getNota());
        ps.setDate(6, new java.sql.Date(ca.getFecha().getTime()));
        ps.setString(7, ca.getDocumento());
        ps.setString(8, ca.getSerie());
        ps.setString(9, ca.getLote());
        ps.setString(10, ca.getPn());
        ps.setString(11, ca.getTrabajo());
        ps.setInt(12, ca.getDepto());
        ps.execute();
        cn.close();
        ps.close();            
    }
    
    public static CargaP buscarDescarga (int idc) throws SQLException{
    
        return buscarDescarga(idc, null);
        
    }
    
    public static CargaP buscarDescarga(int idc, CargaP c) throws SQLException{
        
        Connection cn = BD.getConnection();
        PreparedStatement ps =null;
        ps = cn.prepareStatement("select ingreso.id_ingreso,"
                + "ingreso.fecha_ven,"
                + "ingreso.P_N,"
                + "ingreso.cantidad,"
                + "ingreso.PO,"
                + "ingreso.lote,"
                + "ingreso.bodega,"
                + "ingreso.notas,"
                + "producto.descripcion,"
                + "decode(ingreso.bodega,1,producto.ubicacion,2,producto.ubicacion2) as \"ubicacion\","
                + "unidad_medida.descripcion as \"desc\" from ingreso inner join producto on producto.codigo = ingreso.codigo join unidad_medida on producto.id_medida = unidad_medida.id_medida and ingreso.id_ingreso="+idc);
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
        c.setBodeda(rs.getInt("bodega"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setNota(rs.getString("notas"));
        c.setPresentacion(rs.getString("desc"));
        c.setUbicacion(rs.getString("ubicacion"));       
        }
        cn.close();
        ps.close();
        return c;
        
    }
    
    public static ArrayList<Descarga> ListarProductoDescargado(int c , int b1, int b2) {
//llena tabla de consulta de descargas por codigo
        return consultarSQL("select descarga.documento,"
                + "descarga.pn,"
                + "descarga.lote,"
                + "descarga.no_trabajo,"
                + "descarga.fechades,"
                + "descarga.cantidad,"
                + "descarga.entregadoa,"
                + "descarga.nota,"
                + "ingreso.po,"
                + "ingreso.bodega,"
                + "ingreso.cantidad as \"cantidadbode\","
                + "bitacoraingreso.cantidad as \"cantidadin\""
                + "from descarga inner join ingreso on descarga.id_ingreso = ingreso.id_ingreso join bitacoraingreso on bitacoraingreso.id_ingreso = descarga.id_ingreso where (ingreso.bodega = "+b1+" or ingreso.bodega = "+b2+" ) and descarga.codigo=" + c + "");

    }
    
    private static ArrayList<Descarga> consultarSQL(String sql) {
        ArrayList<Descarga> list = new ArrayList<Descarga>();
        Connection cn = BD.getConnection();
        try {
            Descarga c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Descarga();
                c.setDocumento(rs.getString("documento"));
                c.setPn(rs.getString("pn"));
                c.setLote(rs.getString("lote"));
                c.setTrabajo(rs.getString("no_trabajo"));
                c.setFechades(rs.getString("fechades"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setEntregadoA(rs.getInt("entregadoa"));
                c.setBodega(rs.getInt("bodega"));
                c.setPO(rs.getString("po"));
                c.setCantidadbode(rs.getInt("cantidadbode"));
                c.setCantidadin(rs.getInt("cantidadin"));
                c.setNota(rs.getString("nota"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Ingreso Productos " + e);
            return null;
        }
        return list;
    }
    
    
    public static ArrayList<Descarga> ListarRangoFecha(String f, String a ,int b1,int b2) {

        return consultaDescSQLrango("select ingreso.po,"
                + "descarga.codigo,"
                + "descarga.documento,"
                + "descarga.serie,"
                + "descarga.no_trabajo,"
                + "descarga.lote,"
                + "descarga.pn,"
                + "descarga.fechades,"
                + "descarga.entregadoa,"
                + "descarga.cantidad,"
                + "ingreso.cantidad as \"cantidadbode\","
                + "bitacoraingreso.cantidad as \"cantidadin\","
                + "producto.descripcion from descarga inner join producto on descarga.codigo = producto.codigo join ingreso on ingreso.id_ingreso = descarga.id_ingreso join bitacoraingreso on descarga.id_ingreso = bitacoraingreso.id_ingreso where descarga.fechades between to_date('"+f+"','dd/mm/yy') and to_date('"+a+"','dd/mm/yy') AND (ingreso.bodega ="+ b1 +" or ingreso.bodega = "+ b2 +") order by descarga.codigo");
    }
    
    private static ArrayList<Descarga> consultaDescSQLrango(String sql) {
        ArrayList<Descarga> list = new ArrayList<Descarga>();
        Connection cn = BD.getConnection();
        try {
            Descarga c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Descarga();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setFechades(rs.getString("fechades"));
                c.setTrabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setPO(rs.getString("po"));
                c.setPn(rs.getString("pn"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setSerie(rs.getString("serie"));
                c.setDocumento(rs.getString("documento"));
                c.setEntregadoA(rs.getInt("entregadoa"));
                c.setCantidadbode(rs.getInt("cantidadbode"));
                c.setCantidadin(rs.getInt("cantidadin"));
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
