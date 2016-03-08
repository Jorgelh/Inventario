/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.Familia;
import java.sql.SQLException;
import Class.Producto;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */


public abstract class BDProducto {
    
    public void setFoto(FileInputStream foto, int longitudBytes) {
            setFoto(foto, longitudBytes);
    }

    public static void insertarProducto(Producto p) throws SQLException {

        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into Producto (codigo,fam_id,id_presentacion,id_medida,id_proce,Descripcion,nota,ubicacion,foto,cantidadminima)values(?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, p.getCodigo());
        ps.setInt(2, p.getFam_Id());
        ps.setInt(3, p.getId_Presentacion());
        ps.setInt(4, p.getId_Medida());
        ps.setInt(5, p.getId_Proce());
        ps.setString(6, p.getDescripcion());
        ps.setString(7, p.getNota());
        ps.setString(8, p.getUbicacion());
        ps.setBinaryStream(9, p.getFoto(),p.getLongitudBytes());
        ps.setInt(10, p.getCantidadminima());
        ps.executeUpdate();
        cnn.close();
        ps.close();

    }
    
    

    public static ArrayList<Producto> ListarProductos(int p) {
        return consultarSQL("select codigo,descripcion,ubicacion from producto where fam_id="+p);
    }

    private static ArrayList<Producto> consultarSQL(String sql) {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Connection cn = BD.getConnection();
        try {
            Producto p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Producto();
                p.setCodigo(rs.getInt("codigo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setUbicacion(rs.getString("ubicacion"));
                list.add(p);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Consulta con JOin" + e);
            return null;
        }
        return list;
    }

    public static Producto buscarProducto(int id) throws SQLException {
        return buscarProducto(id, null);
    }

    public static Producto buscarProducto(int id, Producto p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select descripcion,ubicacion,nota,cantidad,cantidadminima from producto where codigo = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Producto() {
                };
            }
            p.setDescripcion(rs.getString("Descripcion"));
            p.setUbicacion(rs.getString("ubicacion"));
            p.setNota(rs.getString("nota"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setCantidadminima(rs.getInt("cantidadminima"));
          //  p.setId_Medida(rs.getInt("id_medida"));
            //p.setId_Presentacion(rs.getInt("id_presentacion"));     
        }
        cnn.close();
        ps.close();
        return p;
    }
    
    public static boolean actualizarProducto(Producto p) throws SQLException{
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("Update producto set descripcion=?,ubicacion=?,nota=?,foto=?,cantidadminima=? where codigo=" +p.getCodigo());
        ps.setString(1, p.getDescripcion());
        ps.setString(2, p.getUbicacion());
        ps.setString(3, p.getNota());
        ps.setBinaryStream(4, p.getFoto(),p.getLongitudBytes());
        ps.setInt(5, p.getCantidadminima());

        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0){ return true;}
        else {return false;}
        
    }

            
    

}



