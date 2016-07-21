/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.FileInputStream;
import java.sql.Blob;

/**
 *
 * @author jluis
 */
public class Producto {
    
    private int Codigo;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getFam_Id() {
        return Fam_Id;
    }

    public void setFam_Id(int Fam_Id) {
        this.Fam_Id = Fam_Id;
    }

    public int getId_Presentacion() {
        return Id_Presentacion;
    }

    public void setId_Presentacion(int Id_Presentacion) {
        this.Id_Presentacion = Id_Presentacion;
    }

    public int getId_Medida() {
        return Id_Medida;
    }

    public void setId_Medida(int Id_Medida) {
        this.Id_Medida = Id_Medida;
    }

    public int getId_Proce() {
        return Id_Proce;
    }

    public void setId_Proce(int Id_Proce) {
        this.Id_Proce = Id_Proce;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getBodega() {
        return Bodega;
    }

    public void setBodega(int Bodega) {
        this.Bodega = Bodega;
    }

    public int getLongitudBytes() {
        return longitudBytes;
    }

    public void setLongitudBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }

    public int getCantidadminima() {
        return cantidadminima;
    }

    public void setCantidadminima(int cantidadminima) {
        this.cantidadminima = cantidadminima;
    }

    public String getBode() {
        return bode;
    }

    public void setBode(String bode) {
        this.bode = bode;
    }

    public String getUbicacion2() {
        return Ubicacion2;
    }

    public void setUbicacion2(String Ubicacion2) {
        this.Ubicacion2 = Ubicacion2;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getUmedida() {
        return Umedida;
    }

    public void setUmedida(String Umedida) {
        this.Umedida = Umedida;
    }

    private int Fam_Id;
    private int Id_Presentacion;
    private int Id_Medida;
    private int Id_Proce;
    private String Descripcion;
    private String Proveedor;
    private String Nota;
    private long Nota1;
    private String Ubicacion;
    private int Cantidad;
    private int Bodega;
    private FileInputStream foto;
    private int longitudBytes;
    private int cantidadminima;
    private String bode;
    private String Ubicacion2;
    private String presentacion;
    private String Umedida;
    private int cantidadingre;

    public int getCantidadingre() {
        return cantidadingre;
    }

    public void setCantidadingre(int cantidadingre) {
        this.cantidadingre = cantidadingre;
    }
    
    
    

    

}