/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Class.CargaP;
import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author jluis
 */
public abstract class DBCargaPro {

    public static void insertarProductoNuevo(CargaP c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into ingreso "
                + "id_ingreso,codigo,P_N,fecha_ingreso,"
                + "PO,cantidad,fecha_ven,precio,"
                + "lote,no_trabajo,no_invoice,no_documento,"
                + "no_serie,ingresadopor,proveedor,notas,"
                + "bodega,fechasistema,estado) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,c.getId_ingreso());
        ps.setInt(2,c.getCodigo());
        ps.setString(3,c.getPN());
        ps.setString(4,c.getFechaIngre());
        ps.setString(5,c.getPO());
        ps.setInt(6,c.getCantidad());
        ps.setString(7, c.getFechaVencimiento());
        ps.setDouble(8, c.getPrecio());
        ps.setString(9, c.getLote());
        ps.setString(10, c.getNTrabajo());
        ps.setString(11, c.getInvoce());
        ps.setString(12, c.getNoDocumento());
        ps.setString(13, c.getNoserie());
        ps.setInt(14,c.getIngresadoPor());
        ps.setString(14, c.getProveedor());
        ps.setString(16, c.getNota());
        ps.setInt(17, c.getBodeda());
        ps.setString(18, c.getEstado());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }

    public static ArrayList<CargaP> ListarProductoIngresado(int c) {

        return consultarSQL("select id_ingreso,p_n,fecha_ingreso,PO,cantidad from ingreso where codigo=" + c);

    }

    private static ArrayList<CargaP> consultarSQL(String sql) {
        ArrayList<CargaP> list = new ArrayList<CargaP>();
        Connection cn = BD.getConnection();
        try {
            CargaP c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new CargaP();
                c.setId_ingreso(rs.getInt("id_ingreso"));
                c.setPN(rs.getString("P_N"));
                c.setFechaIngre(rs.getString("fecha_ingreso"));
                c.setPO(rs.getString("PO"));
                c.setCantidad(rs.getInt("cantidad"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta Ingreso Productos " + e);
            return null;
        }
        return list;
    }

}
