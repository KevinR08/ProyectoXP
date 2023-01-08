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
public class TablaHashEnlazadaEmpleados {

    private final int tamaño = 4;
    private NodoEmpleado[] tabla;

    public TablaHashEnlazadaEmpleados() {
        tabla = new NodoEmpleado[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = null;
        }
    }
    
    public TablaHashEnlazadaEmpleados(int tamaño){
        tabla = new NodoEmpleado[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = null;
        }
    }
    
    public int aritmeticaModular(int clave){
        return clave%this.tamaño;
    }

    public void insertar(String codigo) {
        int numCodigo = Integer.parseInt(codigo.substring(3, 7));
        int numSucursal = aritmeticaModular(numCodigo);
        NodoEmpleado nuevoNodo = new NodoEmpleado(codigo);
        nuevoNodo.enlace = this.tabla[numSucursal];
        this.tabla[numSucursal] = nuevoNodo;
    }
    
    public void insertar(int posicion, String codigo) {
        int numSucursal = posicion;
        NodoEmpleado nuevoNodo = new NodoEmpleado(codigo);
        nuevoNodo.enlace = this.tabla[numSucursal];
        this.tabla[numSucursal] = nuevoNodo;
    }
    
    public void inicializar(String codigo, String numeroSucursal) {
        int numSucursal = Integer.parseInt(numeroSucursal);
        NodoEmpleado nuevoNodo = new NodoEmpleado(codigo);
        nuevoNodo.enlace = this.tabla[numSucursal];
        this.tabla[numSucursal] = nuevoNodo;
    }
    
    public void insertarEmpleadoTabla(String codigo, String numeroSucursal) {
        int numSucursal = Integer.parseInt(numeroSucursal);
        NodoEmpleado nuevoNodo = new NodoEmpleado(codigo);
        nuevoNodo.enlace = this.tabla[numSucursal];
        this.tabla[numSucursal] = nuevoNodo;
    }

    public void eliminarEmpleado(int numSucursal, String valor) {
        if (this.tabla[numSucursal - 1] != null) {
            //Se hace uso de dos nodos, para poder eliminar al solocitado
            NodoEmpleado anterior = null;
            NodoEmpleado actual = tabla[numSucursal - 1];
            //El siguiente bucle hará que los nodos vayan haciendo un recorrido
            //hacia adelante hasta encontrar al que se quiere eliminar
            while ((actual.enlace != null) && !actual.codigo.equals(valor)) {
                anterior = actual;
                actual = actual.enlace;
            }
            if (!actual.codigo.equals(valor)) {
                //En caso de no encontrar el nodo, se emite un mensaje 
                System.out.println("No existe registro del empleado" + valor);
            } else if (anterior == null) {
                //Si se encuentra al nodo en la primera posición, el nodo
                //siguiente toma su lugar e la lista de adyacencia
                this.tabla[numSucursal - 1] = actual.enlace;
            } else {
                //Si el nodo se encuentra en una posición intermedia, el enlace
                //del nodo anterior apuntará al enlace del nodo actual
                anterior.enlace = actual.enlace;
            }
            //Finalmente, se elimina al nodo actual
            actual = null;
        }
    }
    
    public NodoEmpleado obtenerPrimerNodo(int i){
        return this.tabla[i];
    }
    
    public void vaciarTabla(){
        for (int i = 0; i<tabla.length; i++){
            this.tabla[i] = null;
        }
    }
    
    public String mostrarEstructura(){
        String texto = "";
//Se hace uso de un bucle para recorrer las posiciones de la lista
        for(int i=0; i<this.tabla.length; i++){
            if(this.tabla[i] != null){ //Se realiza esta comparación en caso que
                                       //la posición esté vacía o se hayan elimi
                                       //nado todas las relaciones
            texto += "|Sucursal "+(i+1)+"|";
            NodoEmpleado aux = this.tabla[i];
            int salida = 0;
            while(salida == 0){
                if(aux.enlace != null){
                    texto += " -> "+aux.codigo;
                    aux = aux.enlace;
                    salida = 0;
                }else{
                    texto += " -> "+aux.codigo+" -> null";
                    aux = aux.enlace;
                    salida = 1;
                }
            }
            texto += "\n";
            }else{
                //Si la posición se encuentra vacía, esta tendrá el valor null
                texto += "|Sucursal "+(i+1)+"|"+"-> null\n";
            }
        }
        return texto;
    }
    
    public NodoEmpleado getNodoEmpleado(int i){
        return tabla[i];
    }

    
    
    
    
}
