/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosClases;

import BD.BD;
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
public class consultas {
    
    public static ArrayList<Classp> ListarProductos(String a) {
        return SQL("select codigo,descripcion from producto WHERE UPPER(descripcion) LIKE UPPER('"+a+"%')");
    }
    
    private static ArrayList<Classp> SQL(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                 p.setCodigo(rs.getInt("codigo"));
                 p.setDescripcion(rs.getString("descripcion"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
        
        
    }   
        
         public static ArrayList<Classp> Listarpn(int a) {
        return SQLpn("select pn from pn WHERE codigo ="+a);
    }
    
    private static ArrayList<Classp> SQLpn(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                
                 p.setDescripcion(rs.getString("pn"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}
    
    
    public static ArrayList<trabajos> ListarTrabajoNew(String b,String c) {
        return SQLtrabajos("select pn,job,decode(ESTANDAR,1,'FUJI',2,'INGENIERIA',3,'MIL-PRF-27',4,'MIL-STD-981',5,'MIL-STD-981 PRE-CAP',6,'MIL-STD-981 URGENTE',7,'MIL-STD-981-X RAY',8,'SAMPLE') as estandar,lote,"
                + "TO_CHAR(FECHAVENCIMIENTO, 'DD/MM/YYYY') as fechavencimiento,TO_CHAR(fecharecibido, 'DD/MM/YYYY') as fecharecibido,TO_CHAR(fechaentrega, 'DD/MM/YYYY') as fechaentrega ,idtrabajo,cantidad,notas from TRABAJONEW WHERE fechaentrega is  null and estado = 1 and UPPER(pn) LIKE UPPER('"+b+"%') AND UPPER(JOB) LIKE UPPER('"+c+"%') ORDER BY FECHARECIBIDO");
    }
    
    public static ArrayList<trabajos> ListarTrabajo(String b,String c) {
        return SQLtrabajos("select pn,job,decode(ESTANDAR,1,'FUJI',2,'INGENIERIA',3,'MIL-PRF-27',4,'MIL-STD-981',5,'MIL-STD-981 PRE-CAP',6,'MIL-STD-981 URGENTE',7,'MIL-STD-981-X RAY',8,'SAMPLE') as estandar,lote,"
                + "TO_CHAR(FECHAVENCIMIENTO, 'DD/MM/YYYY') as fechavencimiento,TO_CHAR(fecharecibido, 'DD/MM/YYYY') as fecharecibido,TO_CHAR(fechaentrega, 'DD/MM/YYYY') as fechaentrega ,idtrabajo,cantidad,notas from TRABAJOS WHERE fechaentrega is not null and UPPER(pn) LIKE UPPER('"+b+"%') AND UPPER(JOB) LIKE UPPER('"+c+"%') ORDER BY FECHARECIBIDO");
    }
    
    public static ArrayList<trabajos> ListarTrabajonull(String b,String c) {
        return SQLtrabajos("select pn,job,decode(ESTANDAR,1,'FUJI',2,'INGENIERIA',3,'MIL-PRF-27',4,'MIL-STD-981',5,'MIL-STD-981 PRE-CAP',6,'MIL-STD-981 URGENTE',7,'MIL-STD-981-X RAY',8,'SAMPLE') as estandar,lote,"
                + "TO_CHAR(FECHAVENCIMIENTO, 'DD/MM/YYYY') as fechavencimiento,TO_CHAR(fecharecibido, 'DD/MM/YYYY') as fecharecibido,TO_CHAR(fechaentrega, 'DD/MM/YYYY') as fechaentrega ,idtrabajo,cantidad,notas from TRABAJOS WHERE fechaentrega is null and UPPER(pn) LIKE UPPER('"+b+"%') AND UPPER(JOB) LIKE UPPER('"+c+"%') ORDER BY FECHARECIBIDO");
    }
    
    public static ArrayList<trabajos> ListarTrabajotodo(String b,String c) {
        return SQLtrabajos("select pn,job,decode(ESTANDAR,1,'FUJI',2,'INGENIERIA',3,'MIL-PRF-27',4,'MIL-STD-981',5,'MIL-STD-981 PRE-CAP',6,'MIL-STD-981 URGENTE',7,'MIL-STD-981-X RAY',8,'SAMPLE') as estandar,lote,"
                + "TO_CHAR(FECHAVENCIMIENTO, 'DD/MM/YYYY') as fechavencimiento,TO_CHAR(fecharecibido, 'DD/MM/YYYY') as fecharecibido,TO_CHAR(fechaentrega, 'DD/MM/YYYY') as fechaentrega ,idtrabajo,cantidad,notas from TRABAJOS WHERE  UPPER(pn) LIKE UPPER('"+b+"%') AND UPPER(JOB) LIKE UPPER('"+c+"%') ORDER BY FECHARECIBIDO");
    }
    
    
    private static ArrayList<trabajos> SQLtrabajos(String sql1){
    ArrayList<trabajos> list = new ArrayList<trabajos>();
    Connection cn = BD.getConnection();
        try {
            trabajos t;
            Statement stmt = cn.createStatement();
            ResultSet r = stmt.executeQuery(sql1);
            while (r.next()){
                 t = new trabajos();
                 t.setPn(r.getString("pn"));
                 t.setJob(r.getString("job"));
                 t.setEstandar(r.getString("estandar"));
                 t.setLote(r.getInt("lote"));
                 t.setFechaVen(r.getString("fechavencimiento"));
                 t.setFechareci(r.getString("fecharecibido"));
                 t.setFechaentre(r.getString("fechaentrega"));
                 t.setId_trabajo(r.getInt("idtrabajo"));
                 t.setCantidad(r.getInt("cantidad"));
                 t.setNota(r.getString("notas"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}
      
    
    
    public static ArrayList<Classp> ListarProductosPN(String c) {
        return SQL2("select pn.idpn,pn.codigo,producto.descripcion from pn inner join producto on pn.CODIGO = producto.CODIGO WHERE PN ='"+c+"'");
    }
    
    private static ArrayList<Classp> SQL2(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                 p.setId_ingreso(rs.getInt("idpn"));
                 p.setCodigo(rs.getInt("codigo"));
                 p.setDescripcion(rs.getString("descripcion"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}

public static ArrayList<Classp> ListarProductosPO(int c) {
        return SQL3("select pn.codigo,producto.descripcion,ingreso.po,ingreso.FECHA_INGRESO,ingreso.id_ingreso from pn inner join producto on pn.CODIGO = producto.CODIGO join ingreso on ingreso.CODIGO = producto.CODIGO WHERE ingreso.codigo ="+c);
    }
    
    private static ArrayList<Classp> SQL3(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                 p.setCodigo(rs.getInt("codigo"));
                 p.setDescripcion(rs.getString("descripcion"));
                 p.setPO(rs.getString("PO"));
                 p.setFechaingreso(rs.getString("fecha_ingreso"));
                 p.setId_ingreso(rs.getInt("id_ingreso"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}
    
    public static void Entregas(InsertarEntregas p) throws SQLException{
        
        Connection cn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cn.prepareStatement("insert into entregas values(idingreso.nextval,?,?,1,?,?)");
        ps.setInt(1, p.getIdtrabajo());
        ps.setInt(2, p.getIdingreso());
        ps.setString(3, p.getNotas());
        ps.setInt(4, p.getCantidad());
        ps.executeUpdate();
        cn.close();
        ps.close();
    }
    
    
    
    public static ArrayList<Classp> ListarProductosPOentregados(int c) {
        return SQL4("select producto.descripcion,ingreso.po,ingreso.fecha_ingreso,entregas.notas,entregas.cantidad from ingreso inner join producto on ingreso.CODIGO = producto.codigo join entregas on ingreso.ID_INGRESO = entregas.ID_INGRESO where entregas.IDTRABAJO="+c);
    }
   
    
    private static ArrayList<Classp> SQL4(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                 p.setDescripcion(rs.getString("descripcion"));
                 p.setPO(rs.getString("PO"));
                 p.setFechaingreso(rs.getString("fecha_ingreso"));
                 p.setNotas(rs.getString("notas"));
                 p.setCantidad(rs.getInt("cantidad"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}
    
    
 public static ArrayList<Classp> ListarProductosdescargasentregados(String a) {
        return SQL5("select p.DESCRIPCION,i.PO,i.FECHA_INGRESO,d.CANTIDAD,d.NOTA from descarga d inner join producto p on d.CODIGO = p.CODIGO join INGRESO i on i.ID_INGRESO = d.ID_INGRESO  where d.NO_TRABAJO ='"+a+"'");
    }
    
    
    private static ArrayList<Classp> SQL5(String sql){
    ArrayList<Classp> list = new ArrayList<Classp>();
    Connection cn = BD.getConnection();
        try {
            Classp p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 p = new Classp();
                 p.setDescripcion(rs.getString("descripcion"));
                 p.setPO(rs.getString("PO"));
                 p.setFechaingreso(rs.getString("fecha_ingreso"));
                 p.setCantidad(rs.getInt("cantidad"));
                 p.setNota(rs.getString("nota"));
                 list.add(p);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}    
    
    
    public static insertartrabajo BuscarEntrega(int id) throws SQLException {
      return buscarEntrega(id, null);
    }
    public static insertartrabajo buscarEntrega(int id, insertartrabajo p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        //ps = cnn.prepareStatement("select cProNombre,nProvCodigo,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto where nProCodigo=?");
        ps = cnn.prepareStatement("select idtrabajo,PN,JOB,decode(ESTANDAR,1,'FUJI',2,'INGENIERIA',3,'MIL-PRF-27',4,'MIL-STD-981',5,'MIL-STD-981 PRE-CAP',6,'MIL-STD-981 URGENTE',7,'MIL-STD-981-X RAY',8,'SAMPLE') as \"ESTANDAR\",to_char(FECHARECIBIDO,'dd/mm/yy') as FECHARECIBIDO,to_char(FECHAVENCIMIENTO,'dd/mm/yy') as FECHAVENCIMIENTO,CANTIDAD,decode(DEPARTAMENTO,1,'CHIPS',2,'TRANSFORMADORES') as \"DEPARTAMENTO\" from trabajonew where estado = 1 and idtrabajo =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null){
                p = new insertartrabajo(){
                };
            }
            p.setPn(rs.getString("PN"));
            p.setJob(rs.getString("JOB"));
            p.setEstandar(rs.getString("ESTANDAR"));
            p.setSfecharecibido(rs.getString("FECHARECIBIDO"));
            p.setSfechavencimiento(rs.getString("FECHAVENCIMIENTO"));
            p.setCantidad(rs.getInt("CANTIDAD"));
            p.setDeptostring(rs.getString("DEPARTAMENTO"));
            p.setId(rs.getInt("idtrabajo"));
            }
        cnn.close();
        ps.close();
        return p;
    }
    
    
    
    
    
    
}
