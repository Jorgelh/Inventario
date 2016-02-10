/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

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
        ps = cn.prepareStatement("inser into descarga(id_descarga,id_ingreso,codigo,cantidad,entregadoa,nota,fechades) values(descarga.nextval,?,?,?,?,?,?,?,?");
        ps.setInt(1, ca.getId_descarga());
        ps.setInt(2, ca.getId_ingreso());
        ps.setInt(3, ca.getCodigo());
        ps.setInt(4, ca.getCantidad());
        ps.setInt(5, ca.getEntregadoA());
        ps.setDouble(6, ca.getNota());
        ps.setDate(7, new java.sql.Date(ca.getFecha().getTime()));
        ps.executeUpdate();
        cn.close();
        ps.close();            
    }
    
    public static ArrayList<Descarga> ListarIngresos (int d){
        
        return consultaSQL("");
        
    
    
    }

    private static ArrayList<Descarga> consultaSQL(String string) {
        return null;

    }
    
    
    
    
    
    
    
    
    
    
}
