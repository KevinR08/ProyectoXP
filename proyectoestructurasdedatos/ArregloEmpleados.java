/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructurasdedatos;

/**
 *
 * @author santiago
 */
public class ArregloEmpleados {
    private final int tamaño=13;
    private int numSucursal;
    private String[] arreglo;
    
    public ArregloEmpleados(int numSucursal){
        this.numSucursal = numSucursal;
        arreglo = new String[tamaño];
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = "";
        }
    }

    public ArregloEmpleados() {
    }
    
    
    public void insertarCodigo(String codigo){
        for(int i = 0; i < this.arreglo.length; i++){
            if(this.arreglo[i].equals("")){
                arreglo[i] = codigo;
                break;
            }
        }
    }
    
    public void borrarCodigo(String info){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i].equals(info)){
                arreglo[i] = "";
                break;
            }
        }
    }
    
    public String consultarEmpleado(String info){
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i].equals(info)){
                return info; 
            }
        }
        return "El empleado "+info+" no se encuentra en la sucursal "+this.numSucursal;
    }
    
    public String mostrarEstructura(ListaDEnlazada lista){
        String texto = "";
        texto += "Los siguientes empleados trabajan en la sucursal "+this.numSucursal+"\n";
        for(int i = 0; i < this.arreglo.length; i++){
            if (!this.arreglo[i].equals("")){
                texto += "- " + this.arreglo[i] + ": " +lista.obtenerEmpleado(this.arreglo[i])+"\n";
            }
        }
        return texto;
    }
    
    public void vaciarArreglo(){
        for(int i = 0; i < 13; i++){
            this.arreglo[i] = "";
        }
    }
    
    public boolean estaVacio(){
        if(!this.arreglo[0].equals("")){
            return false;
        }
        return true;
    }
    
}
