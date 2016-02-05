/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Medida;
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
public abstract class BDMedida {
    
    public static void insertarMedida (Medida m) throws SQLException{
    Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
    ps= cnn.prepareStatement("insert into unidad_medida (Id_medida,Descripcion) Values(medida.nextval,?)");
    ps.setString(1, m.getDescripcion());
    ps.executeUpdate();
    cnn.close();
    ps.close();
    
    }
    
  /*  public static ArrayList<Medida> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "like");
    }*/
    public static boolean actualizarmedida(Medida p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update unidad_medida set Descripcion=? where id_medida=" + p.getId_medidad());
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
    
    
    public static Medida buscarMedida(int id) throws SQLException {
      return buscarMedida(id, null);
    }
    public static Medida buscarMedida(int id, Medida p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        //ps = cnn.prepareStatement("select cProNombre,nProvCodigo,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cProEstado from producto where nProCodigo=?");
        ps = cnn.prepareStatement("select descripcion from unidad_medida where id_medida=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Medida(){
                };
            }
            p.setId_medidad(id);
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
    public static ArrayList<Medida> ListarUnidadMedida(){
        
         return consultarSQL("select id_medida,descripcion from unidad_medida");   
    }
   
    
private static ArrayList<Medida> consultarSQL(String sql) {
        ArrayList<Medida> list = new ArrayList<Medida>();
        Connection cn = BD.getConnection();
        try {
            Medida p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Medida();
                p.setId_medidad(rs.getInt("id_medida"));
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
