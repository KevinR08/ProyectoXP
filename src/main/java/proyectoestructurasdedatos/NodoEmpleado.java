/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructurasdedatos;

import javax.lang.model.SourceVersion;

/**
 *
 * @author santiago
 */
public class NodoEmpleado {
    String codigo;
    NodoEmpleado enlace;
    
    public NodoEmpleado(String codigo){
        this.codigo = codigo;
        this.enlace = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public NodoEmpleado getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoEmpleado enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "Nodo: " + "codigo=" + codigo + ", enlace=" + enlace;
    }
    
    

}
