/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosClases;

/**
 *
 * @author jluis
 */
public class trabajos {
    
    private String pn;
    private String job;
    private String estandar;
    private int estandarint;
    private int lote;
    private String fechaVen;
    private String fechareci;
    private String fechaentre;
    private int id_trabajo;
    private int cantidad;
    private String nota;
    private int entregado;

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
 
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public String getFechareci() {
        return fechareci;
    }

    public void setFechareci(String fechareci) {
        this.fechareci = fechareci;
    }

    public String getFechaentre() {
        return fechaentre;
    }

    public void setFechaentre(String fechaentre) {
        this.fechaentre = fechaentre;
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

    public int getEstandarint() {
        return estandarint;
    }

    public void setEstandarint(int estandarint) {
        this.estandarint = estandarint;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(String fechaVen) {
        this.fechaVen = fechaVen;
    }

    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }
    
}
