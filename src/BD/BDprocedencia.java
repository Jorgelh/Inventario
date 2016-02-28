/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Procedencia;
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
public abstract class BDprocedencia {
    
    public static void insertarProcedencia (Procedencia med) throws SQLException{
    Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into id_procedencia (id_proce,Descripcion) Values(?,?)");
    ps.setInt(1,med.getId_proce());
    ps.setString(2, med.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }
    
  /*  public static ArrayList<Medida> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "like");
    }*/
    public static boolean actualizarProcedencia(Procedencia p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update id_procedencia set Descripcion=? where id_proce=" + p.getId_proce());
        ps.setString(1, p.getDescripcion());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static Procedencia buscarProcedencia(int id) throws SQLException {
      return buscarProcedencia(id, null);
    }
    public static Procedencia buscarProcedencia(int id, Procedencia p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        //ps = cnn.prepareStatement("select cProNombre,nProvCodigo,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto where nProCodigo=?");
        ps = cnn.prepareStatement("select descripcion from id_procedencia where id_proce=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Procedencia(){
                };
            }
            p.setId_proce(id);
            p.setDescripcion(rs.getString("Descripcion"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
    
    /*
    public static ArrayList<Medida> mostrarM() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Medida> lista = new ArrayList<Medida>();

        //ps = cnn.prepareStatement("select nProCodigo,cProNombre,nProCantidad,nProvCodigo,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto");
        ps = cnn.prepareStatement("select id_medida,Descripcion from unidad_medida");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Medida p = new Medida(){
            };
            p.setDescripcion(rs.getString("cProNombre"));
            p.setId_medidad(rs.getInt("nProCodigo"));
            lista.add(p);
        }
        cnn.close();
        ps.close();
        return lista;
    }
    
  
    */
    public static ArrayList<Procedencia> ListarProcedencia(){
        
         return consultarSQL("select id_proce,descripcion from id_procedencia");   
    }
   
    
private static ArrayList<Procedencia> consultarSQL(String sql) {
        ArrayList<Procedencia> list = new ArrayList<Procedencia>();
        Connection cn = BD.getConnection();
        try {
            Procedencia p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Procedencia();
                p.setId_proce(rs.getInt("id_proce"));
                p.setDescripcion(rs.getString("Descripcion"));
                list.add(p);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


    
}
