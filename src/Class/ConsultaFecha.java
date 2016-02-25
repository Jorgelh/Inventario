/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Date;

/**
 *
 * @author Jorge Luis
 */
public class ConsultaFecha {
    
    public int Codigo;
    public String Descripcion;
    public int Cantidad;
    public String PN;
    public String EntregadoA;
    public String Nota;
    public String fechades;
    public String fecha;

    public String getPN() {
        return PN;
    }

    public void setPN(String PN) {
        this.PN = PN;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getEntregadoA() {
        return EntregadoA;
    }

    public void setEntregadoA(String EntregadoA) {
        this.EntregadoA = EntregadoA;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public String getFechades() {
        return fechades;
    }

    public void setFechades(String fechades) {
        this.fechades = fechades;
    }

    public void getFecha(Date date) {
             
              
    }
    
    
    
    
    
}
