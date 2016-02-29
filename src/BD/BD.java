/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public abstract class BD {
     public static Connection getConnection() {
        Connection cn = null;
        try {
           Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "Inventario";
            String password = "admin";
            cn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            cn=null;
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        } catch (SQLException e) {
            cn=null;
            System.out.println("Error no se establecer la conexion:" + e.getMessage());
        }
        return cn;
    }
}