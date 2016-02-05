/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Familia;
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
public abstract class DBFamilia {
    
    public static void insertarFamilia (Familia fam) throws SQLException{
    Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into familia (fam_id,Descripcion) Values(familia1.nextval,?)");
    ps.setString(1, fam.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }
    
  /*  public static ArrayList<Medida> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "like");
    }*/
    public static boolean actualizarFamilia(Familia f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update familia set Descripcion=? where fam_id =" + f.getFam_id());
        ps.setString(1, f.getDescripcion());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static Familia buscarFamilia(int id) throws SQLException {
      return buscarFamilia(id, null);
    }
    public static Familia buscarFamilia(int id, Familia p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        //ps = cnn.prepareStatement("select cProNombre,nProvCodigo,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto where nProCodigo=?");
        ps = cnn.prepareStatement("select descripcion from familia where fam_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Familia(){
                };
            }
            p.setFam_id(id);
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
    public static ArrayList<Familia> ListarFamilias(){
        
         return consultarSQL("select fam_id,descripcion from familia");   
    }
   
    
private static ArrayList<Familia> consultarSQL(String sql) {
        ArrayList<Familia> list = new ArrayList<Familia>();
        Connection cn = BD.getConnection();
        try {
            Familia f;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                f = new Familia();
                f.setFam_id(rs.getInt("fam_id"));
                f.setDescripcion(rs.getString("Descripcion"));
                list.add(f);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }


    
}
