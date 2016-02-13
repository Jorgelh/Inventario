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
