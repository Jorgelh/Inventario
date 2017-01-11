/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jorge Luis
 */
public abstract class BDConsultas {
    
    
    public static ArrayList<consultanp> ListarPN(String d) {

        return consultarSQL("select descarga.PN,"
                                 + "descarga.no_trabajo,"
                                 + "descarga.lote,"
                                 + "descarga.cantidad,"
                                 + "descarga.entregadoa,"
                                 + "descarga.nota,"
                                 + "descarga.fechades,"
                                 + "descarga.documento,"
                                 + "descarga.serie,"
                                 + "descarga.codigo,"
                                 + "ingreso.PO,"
                                 + "bitacoraingreso.cantidad as \"cantidadbode\","
                                 + "ingreso.cantidad as \"cantidadin\","
                                 + "producto.descripcion from descarga inner join producto on descarga.codigo = producto.codigo join ingreso on ingreso.id_ingreso = descarga.id_ingreso join bitacoraingreso on descarga.id_ingreso = bitacoraingreso.id_ingreso where upper(descarga.PN) = upper('"+d+"') order by descarga.id_ingreso");
    }
    private static ArrayList<consultanp> consultarSQL(String sql1) {
        ArrayList<consultanp> list = new ArrayList<consultanp>();
        Connection cn = BD.getConnection();
        try {
            consultanp c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                c = new consultanp();
                c.setCodigo(rs.getInt("codigo"));
                c.setNo_trabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechades(rs.getString("fechades"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setEntregadoa(rs.getString("entregadoa"));
                c.setPN(rs.getString("PN"));
                c.setNota(rs.getString("nota"));
                c.setDocumento(rs.getString("documento"));
                c.setSerie(rs.getString("serie"));
                c.setPO(rs.getString("PO"));
                c.setCantInicial(rs.getInt("cantidadbode"));
                c.setCantidadbodega(rs.getInt("cantidadin"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error Consulta PN " + ex);
           // return null;
        }
        return list;
    }
    
    
    
    
    

    public static ArrayList<ConsultaFecha> ListarFecha(String t, int b1 , int b2) {

        return consultaSQL("select descarga.codigo,producto.descripcion,descarga.cantidad,descarga.entregadoa,descarga.nota,descarga.fechades from DESCARGA INNER JOIN PRODUCTO on descarga.codigo=producto.codigo join ingreso on ingreso.id_ingreso = descarga.id_ingreso where (ingreso.bodega ="+b1+" or ingreso.bodega = "+b2+") and DESCARGA.fechasistema = '" + t + "' order by descarga.codigo" );

    }

    private static ArrayList<ConsultaFecha> consultaSQL(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setEntregadoA(rs.getString("entregadoa"));
                c.setNota(rs.getString("nota"));
                c.setFechades(rs.getString("fechades"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    public static ArrayList<ConsultaFecha> ListarIngresoCodigo(int f, int b1, int b2 ) {

        return consultaIngreSQL("select ingreso.codigo,producto.descripcion,ingreso.fecha_ingreso,ingreso.P_N,ingreso.no_trabajo,ingreso.lote,bitacoraingreso.cantidad as \"cantiingre\",ingreso.cantidad,ingreso.ingresadopor,ingreso.notas,ingreso.po from Ingreso INNER JOIN PRODUCTO on ingreso.codigo = producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso where (ingreso.bodega ="+ b1 +" or ingreso.bodega = "+ b2 +") and ingreso.codigo = "+f);

    }
    
    public static ArrayList<ConsultaFecha> ListarIngresoFecha(String f, int b1, int b2 ) {

        return consultaIngreSQL("select ingreso.codigo,producto.descripcion,ingreso.fecha_ingreso,ingreso.P_N,ingreso.no_trabajo,ingreso.lote,bitacoraingreso.cantidad as \"cantiingre\",ingreso.cantidad,ingreso.ingresadopor,ingreso.notas from Ingreso INNER JOIN PRODUCTO on ingreso.codigo = producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso where (ingreso.bodega ="+ b1 +" or ingreso.bodega = "+ b2 +") and ingreso.fecha_ingreso = '" + f +"'" );

    }
    
    private static ArrayList<ConsultaFecha> consultaIngreSQL(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFecha(rs.getString("fecha_ingreso"));
                c.setPN(rs.getString("P_N"));
                c.setTrabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setCantidadIngre(rs.getInt("cantiingre"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setIngrepor(rs.getString("ingresadopor"));
                c.setNota(rs.getString("notas"));
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
    public static ArrayList<ConsultaFecha> ListarRangoFecha(String f, String a , int b1, int b2) {

        return consultaIngreSQLrango("select ingreso.codigo,"
                                    + "producto.descripcion,"
                                    + "ingreso.fecha_ingreso,"
                                    + "ingreso.P_N,"
                                    + "ingreso.no_trabajo,"
                                    + "ingreso.lote,"
                                    + "ingreso.po,"
                                    + "ingreso.notas,"
                                    + "ingreso.proveedor,"
                                    + "bitacoraingreso.cantidad as \"cantiingreso\","
                                    + "ingreso.cantidad,"                
                                    + "DECODE(ingreso.bodega, 1, 'Bodega 1', 2, 'Bodega 2')as \"bodega\",ingreso.ingresadopor from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso where ingreso.fechasistema between to_date('" + f + "','dd/mm/yy') and to_date('"+ a +"','dd/mm/yy') AND (ingreso.bodega ="+ b1 +" or ingreso.bodega = "+ b2 +") order by fechasistema");
    }
    private static ArrayList<ConsultaFecha> consultaIngreSQLrango(String sql) {
        ArrayList<ConsultaFecha> list = new ArrayList<ConsultaFecha>();
        Connection cn = BD.getConnection();
        try {
            ConsultaFecha c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new ConsultaFecha();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaIngre(rs.getString("fecha_ingreso"));
                c.setPN(rs.getString("P_N"));
                c.setTrabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setCantidadIngre(rs.getInt("cantiingreso"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setIngrepor(rs.getString("ingresadopor"));
                c.setProveedor(rs.getString("proveedor"));
                c.setBodega(rs.getString("bodega"));
                c.setPo(rs.getString("po"));
                c.setNota(rs.getString("notas"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    public static ArrayList<Producto> ListarCodigo(String c) {
        //return consultanombreSQL("select producto.codigo,producto.descripcion,producto.ubicacion,sum(ingreso.cantidad)as \"cantidad\"  from producto inner join ingreso on producto.codigo = ingreso.codigo where producto.codigo like '"+c+"%' GROUP BY producto.codigo,producto.descripcion,producto.ubicacion");
        return consultanombreSQL("select producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,unidad_medida.descripcion as umedida, sum(ingreso.cantidad) as \"cantidad\", sum(bitacoraingreso.cantidad) as \"cantidadingre\" from producto inner join presentacion on producto.id_presentacion = presentacion.id_presentacion join unidad_medida on producto.id_medida = unidad_medida.id_medida join INGRESO on producto.codigo = ingreso.codigo join BITACORAINGRESO on ingreso.id_ingreso = bitacoraingreso.id_ingreso where upper(ingreso.codigo) like upper('"+c+"%') group by INGRESO.CODIGO,producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,unidad_medida.descripcion,bitacoraingreso.cantidad");
    }
    
    
    
    public static ArrayList<Producto> ListarNombre(String f) {

        //return consultanombreSQL("select producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,presentacion.descripcion as \"presentacion\",unidad_medida.descripcion as \"umedida\"     from producto inner join presentacion on producto.id_presentacion = presentacion.id_presentacion join unidad_medida on producto.id_medida = unidad_medida.id_medida where  upper(producto.descripcion) like upper('"+f+"%')");
         //return consultanombreSQL("select producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,producto.cantidad,unidad_medida.descripcion as \"umedida\"     from producto inner join presentacion on producto.id_presentacion = presentacion.id_presentacion join unidad_medida on producto.id_medida = unidad_medida.id_medida where  upper(producto.descripcion) like upper('"+f+"%')");
         return consultanombreSQL("select producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,unidad_medida.descripcion as umedida, sum(ingreso.cantidad) as \"cantidad\", sum(bitacoraingreso.cantidad) as \"cantidadingre\" from producto inner join presentacion on producto.id_presentacion = presentacion.id_presentacion join unidad_medida on producto.id_medida = unidad_medida.id_medida join INGRESO on producto.codigo = ingreso.codigo join BITACORAINGRESO on ingreso.id_ingreso = bitacoraingreso.id_ingreso where upper(producto.descripcion) like upper('"+f+"%') group by INGRESO.CODIGO,producto.codigo,producto.descripcion,producto.ubicacion,producto.ubicacion2,unidad_medida.descripcion,bitacoraingreso.cantidad");
    }

    private static ArrayList<Producto> consultanombreSQL(String sql) {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Connection cn = BD.getConnection();
        try {
            Producto c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Producto();
                c.setCodigo(rs.getInt("codigo"));
                c.setDescripcion(rs.getString("descripcion")); 
                c.setUbicacion(rs.getString("ubicacion"));
                c.setUbicacion2(rs.getString("ubicacion2"));
                c.setCantidad(rs.getInt("CANTIDAD"));
                c.setUmedida(rs.getString("umedida"));
                c.setCantidadingre(rs.getInt("cantidadingre"));
                
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta producto por nombre " + e);
            return null;
        }
        return list;
    }
    
    public static ArrayList<consultanp> ListaringreInvoice(String d , int b1 , int b2) {

        return consultarinSQL("select ingreso.P_N,"
                                 + "ingreso.no_trabajo,"
                                 + "ingreso.lote,"
                                 + "ingreso.cantidad,"
                                 + "ingreso.ingresadopor,"
                                 + "ingreso.notas,"
                                 + "ingreso.fecha_ingreso,"
                                 + "ingreso.no_documento,"
                                 + "ingreso.no_serie,"
                                 + "ingreso.codigo,"
                                 + "ingreso.PO,"
                                 + "ingreso.notas,"
                                 + "ingreso.proveedor,"
                                 + "producto.descripcion,"
                                 + "bitacoraingreso.cantidad as \"Cin\" "
                                 + "from ingreso inner join producto on ingreso.codigo = producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso "
                                 + "where (ingreso.bodega ="+b1+" or ingreso.bodega = "+b2+") and NO_INVOICE like upper ('"+d+"%') order by fecha_ingreso");

    }
    
    public static ArrayList<consultanp> ListaringrePN(String d , int b1 , int b2) {

        return consultarinSQL("select ingreso.P_N,"
                                 + "ingreso.no_trabajo,"
                                 + "ingreso.lote,"
                                 + "ingreso.cantidad,"
                                 + "ingreso.ingresadopor,"
                                 + "ingreso.notas,"
                                 + "ingreso.fecha_ingreso,"
                                 + "ingreso.no_documento,"
                                 + "ingreso.no_serie,"
                                 + "ingreso.codigo,"
                                 + "ingreso.PO,"
                                 + "producto.descripcion,"
                                 + "ingreso.proveedor,"
                                 + "ingreso.notas,"
                                 + "bitacoraingreso.cantidad as \"Cin\" "
                                 + "from ingreso inner join producto on ingreso.codigo = producto.codigo join bitacoraingreso on ingreso.id_ingreso = bitacoraingreso.id_ingreso "
                                 + "where (ingreso.bodega ="+b1+" or ingreso.bodega = "+b2+") and P_N like upper('"+d+"%') order by fechasistema");

    }
   
    private static ArrayList<consultanp> consultarinSQL(String sql1) {
        ArrayList<consultanp> list = new ArrayList<consultanp>();
        Connection cn = BD.getConnection();
        try {
            consultanp c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                c = new consultanp();
                c.setCodigo(rs.getInt("codigo"));
                c.setNo_trabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaingre(rs.getString("fecha_ingreso"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setIngrepor(rs.getString("ingresadopor"));
                c.setPN(rs.getString("P_N"));
                c.setNota(rs.getString("notas"));
                c.setDocumento(rs.getString("no_documento"));
                c.setSerie(rs.getString("no_serie"));
                c.setCantInicial(rs.getInt("Cin"));
                c.setPO(rs.getString("PO"));
                c.setNota(rs.getString("notas"));
                c.setProveedor(rs.getString("proveedor"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error Consulta PN " + ex);
           // return null;
        }
        return list;
    }
    
    public static ArrayList<Vencimientos> ListarVencimientos() {

       /* return consultaVencimientos("select ingreso.codigo,"
                                    + "producto.descripcion,"
                                    + "ingreso.fecha_ven,"
                                    + "ingreso.cantidad from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fecha_ven between to_date(sysdate,'dd/mm/yy') and to_date(sysdate+30,'dd/mm/yy') and ingreso.cantidad >0");*/
       
       return consultaVencimientos("select ingreso.codigo,producto.descripcion,ingreso.fecha_ven,ingreso.cantidad from Ingreso INNER JOIN PRODUCTO on ingreso.codigo=producto.codigo where ingreso.fecha_ven < to_date(sysdate+90,'dd/mm/yy') and ingreso.cantidad > 0");
       
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
                c.setCantidad(rs.getInt("cantidad"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Fecha " + e);
            return null;
        }
        return list;
    }
    
    
    
    public static ArrayList<consultanp> ListarIngreDescripcion(String d) {

        return DescripcionLista("select producto.descripcion,"
                                + "ingreso.codigo,"
                                + "ingreso.FECHA_INGRESO,"
                                + "ingreso.P_N,"
                                + "ingreso.NO_TRABAJO,"
                                + "ingreso.lote,"
                                + "ingreso.po,"
                                + "ingreso.cantidad,"
                                + "bitacoraingreso.cantidad as \"cantidadbode\","
                                + "ingreso.proveedor,"
                                + "ingreso.notas,"                                                                                                                                                              
                                + "ingreso.ingresadopor from ingreso inner join PRODUCTO on ingreso.CODIGO = producto.codigo join BITACORAINGRESO on ingreso.ID_INGRESO = BITACORAINGRESO.ID_INGRESO  where upper(producto.descripcion) like upper('"+d+"%')");
    }
    private static ArrayList<consultanp> DescripcionLista(String sql1) {
        ArrayList<consultanp> list = new ArrayList<consultanp>();
        Connection cn = BD.getConnection();
        try {
            consultanp c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                c = new consultanp();
                c.setCodigo(rs.getInt("codigo"));
                c.setNo_trabajo(rs.getString("no_trabajo"));
                c.setLote(rs.getString("lote"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaingre(rs.getString("fecha_ingreso"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setPN(rs.getString("P_N"));
                c.setNota(rs.getString("notas"));
                c.setPO(rs.getString("PO"));
                c.setCantInicial(rs.getInt("cantidadbode"));
                c.setProveedor(rs.getString("proveedor"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error Consulta Descripcion " + ex);
           // return null;
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
}
