/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosClases;
import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author jluis
 */
public class insertartrabajo {
    
    public String pn;
    public String job;
    public String estandar;
    public int estandarint;
    public Date fecharecibido;
    public Date fechaentrega;
    public Date fechavencimiento;
    public int lote;
    public int codigo;
    public int entregado;
    public String nota;
    public int depto;
    public int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public int getDepto() {
        return depto;
    }

    public void setDepto(int depto) {
        this.depto = depto;
    }
    

    public int getEntregado() {
        return entregado;
    }

    public void setEntregado(int entregado) {
        this.entregado = entregado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEstandar() {
        return estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Date getFecharecibido() {
        return fecharecibido;
    }

    public void setFecharecibido(Date fecharecibido) {
        this.fecharecibido = fecharecibido;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getEstandarint() {
        return estandarint;
    }

    public void setEstandarint(int estandarint) {
        this.estandarint = estandarint;
    }
    
    public static void InsertarTrabajo(insertartrabajo t) throws SQLException{
        Connection con = BD.getConnection();
        PreparedStatement ps = null;
        {     
        ps = con.prepareStatement("insert into trabajos values(idtrabajo.nextval,?,?,?,?,null,?,?,1,?,?,?,?)");
        ps.setString(1, t.getPn());
        ps.setString(2, t.getJob());
        ps.setInt(3, t.getEstandarint());
        ps.setDate(4, new java.sql.Date(t.getFecharecibido().getTime()));
        //ps.setDate(5, new java.sql.Date(t.getFechaentrega().getTime()));
        ps.setDate(5, new java.sql.Date(t.getFechavencimiento().getTime()));
        ps.setInt(6, t.getLote());
        ps.setInt(7, t.getEntregado());
        ps.setString(8, t.getNota());
        ps.setInt(9, t.getDepto());
        ps.setInt(10, t.getCantidad());
        ps.executeUpdate();
        }
        con.close();
        ps.close(); 
    }    
        
    public static void asignarMaterial(insertartrabajo e) throws SQLException{
        Connection con = BD.getConnection();
        PreparedStatement ps = null;
        {     
        ps = con.prepareStatement("insert into pn values(pnelement.nextval,?,?)");
        ps.setString(1, e.getPn());
        ps.setInt(2, e.getCodigo());
        ps.executeUpdate();
        }
        con.close();
        ps.close();     
    }
    
}
