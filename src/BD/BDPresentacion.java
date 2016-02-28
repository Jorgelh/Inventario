/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Presentacion;
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
public abstract class BDPresentacion {
    
    public static void insertarPresentacion (Presentacion med) throws SQLException{
    Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into presentacion (id_presentacion,Descripcion) Values(?,?)");
    ps.setInt(1,med.getId_presentacion());
    ps.setString(2, med.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }
    
  /*  public static ArrayList<Medida> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "like");
    }*/
    public static boolean actualizarPresentacion(Presentacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update presentacion set Descripcion=? where id_presentacion=" + p.getId_presentacion());
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
    
    
    public static Presentacion buscarPrecentacion(int id) throws SQLException {
      return buscarPresentacion(id, null);
    }
    public static Presentacion buscarPresentacion(int id, Presentacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        //ps = cnn.prepareStatement("select cProNombre,nProvCodigo,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto where nProCodigo=?");
        ps = cnn.prepareStatement("select descripcion from presentacion where id_presentacion=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Presentacion(){
                };
            }
            p.setId_presentacion(id);
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
    public static ArrayList<Presentacion> ListarUnidadMedida(){
        
         return consultarSQL("select id_presentacion,descripcion from presentacion");   
    }
   
    
private static ArrayList<Presentacion> consultarSQL(String sql) {
        ArrayList<Presentacion> list = new ArrayList<Presentacion>();
        Connection cn = BD.getConnection();
        try {
            Presentacion p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Presentacion();
                p.setId_presentacion(rs.getInt("id_presentacion"));
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
