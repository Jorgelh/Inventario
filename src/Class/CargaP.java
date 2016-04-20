/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jluis
 */
public class CargaP {
  
    private int id_ingreso;
    private int codigo;
    private String PN;
    private Date fechaIngre;
    private String PO;
    private int cantidad;
    private Date fechaVencimiento;
    private double precio;
    private String Lote;
    private String NTrabajo;
    private String invoce;
    private String NoDocumento;
    private String Noserie;
    private int ingresadoPor;
    private String Proveedor;
    private String nota;
    private int Bodeda;
    private Date fechasistema;
    private String ReturnFecha;
    private String ReturnFechaIgre;
    private String descripcion;
    private String presentacion;

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getReturnFecha() {
        return ReturnFecha;
    }

    public void setReturnFecha(String ReturnFecha) {
        this.ReturnFecha = ReturnFecha;
    }

    public String getReturnFechaIgre() {
        return ReturnFechaIgre;
    }

    public void setReturnFechaIgre(String ReturnFechaIgre) {
        this.ReturnFechaIgre = ReturnFechaIgre;
    }
    
    

    
   

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    

    public String getLote() {
        return Lote;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public String getNTrabajo() {
        return NTrabajo;
    }

    public void setNTrabajo(String NTrabajo) {
        this.NTrabajo = NTrabajo;
    }

    public String getInvoce() {
        return invoce;
    }

    public void setInvoce(String invoce) {
        this.invoce = invoce;
    }

    public String getNoDocumento() {
        return NoDocumento;
    }

    public void setNoDocumento(String NoDocumento) {
        this.NoDocumento = NoDocumento;
    }

    public String getNoserie() {
        return Noserie;
    }

    public void setNoserie(String Noserie) {
        this.Noserie = Noserie;
    }

    public int getIngresadoPor() {
        return ingresadoPor;
    }

    public void setIngresadoPor(int ingresadoPor) {
        this.ingresadoPor = ingresadoPor;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    

    public int getBodeda() {
        return Bodeda;
    }

    public void setBodeda(int Bodeda) {
        this.Bodeda = Bodeda;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    private String Estado;

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechasistema() {
        return fechasistema;
    }

    public void setFechasistema(Date fechasistema) {
        this.fechasistema = fechasistema;
    }

   

    public Date getFechaIngre() {
        return fechaIngre;
    }

    public void setFechaIngre(Date fechaIngre) {
        this.fechaIngre = fechaIngre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

   
    
}

  