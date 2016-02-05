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
public class Familia {

    public int getFam_id() {
        return Fam_id;
    }

    public void setFam_id(int Fam_id) {
        this.Fam_id = Fam_id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    private int Fam_id;
    private String Descripcion;
    
    
}
