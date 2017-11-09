/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author jluis
 */
public class Descarga {
    
    
   private int id_descarga;
   private int id_ingreso;
   private int codigo;
   private Date fecha;
   private int Cantidad;
   private int EntregadoA;
   private String nota;
   private String documento;
   private String serie;
   private String pn;
   private String lote;
   private String trabajo;
   private String fechades;
   private int Bodega;
   private String descripcion;
   private String PO;
   private int cantidadin;
   private int cantidadbode;
   private int Depto;
   
    public int getDepto() {
        return Depto;
    }

    public void setDepto(int Depto) {
        this.Depto = Depto;
    }
   
   
     
     
    public int getCantidadin() {
        return cantidadin;
    }

    public void setCantidadin(int cantidadin) {
        this.cantidadin = cantidadin;
    }

    public int getCantidadbode() {
        return cantidadbode;
    }

    public void setCantidadbode(int cantidadbode) {
        this.cantidadbode = cantidadbode;
    }
    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
    public int getBodega() {
        return Bodega;
    }

    public void setBodega(int Bodega) {
        this.Bodega = Bodega;
    }
   

    public String getFechades() {
        return fechades;
    }

    public void setFechades(String fechades) {
        this.fechades = fechades;
    }
   
   
    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
   
   

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getId_descarga() {
        return id_descarga;
    }

    public void setId_descarga(int id_descarga) {
        this.id_descarga = id_descarga;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getEntregadoA() {
        return EntregadoA;
    }

    public void setEntregadoA(int EntregadoA) {
        this.EntregadoA = EntregadoA;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
