/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author jluis
 */
public class Vencimientos {
    
private int Codigo;
private String Descripcion;
private String fechaVen;
private String fechaIngreso;
private String notas;
private int Cantidad;
private int Cantidadminima;
private String po;

    public int getCantidadminima() {
        return Cantidadminima;
    }

    public void setCantidadminima(int Cantidadminima) {
        this.Cantidadminima = Cantidadminima;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(String fechaVen) {
        this.fechaVen = fechaVen;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
  
    
    
}
