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
public class ProyectoEstructurasDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String numero = "VD-4567";
        int numCodigo = Integer.parseInt(numero.substring(3, 6));
        System.out.println(numCodigo);
        /*
        String codigo = "10-0001";
        String nombres = "Cristopher Santiago";
        String apellidos = "Pérez Nieto";
        String direccion = "Pepito Delgado xd";
        String correo = "cristopher.perez@epn.edu.ec";
        String numTelf = "0998516975";
        
        
        Empleado emp = new Empleado(codigo, nombres, apellidos, direccion, correo, numTelf);
        
        boolean esCodigoValido = Empleado.esCodigoValido(emp.getCodigo());
        if(esCodigoValido){
            System.out.println("El código es válido");
        }else{
            System.out.println("El código no es válido");
        }
*/
        /*
        ArregloEmpleados sucursal1 = new ArregloEmpleados(1);
        
        sucursal1.insertarEmpleado("Cristopher Santiago Pérez Nieto");
        sucursal1.insertarEmpleado("Ariel Thomás Rosero Peñaherrera");
        sucursal1.insertarEmpleado("Bryan Fernando Cedeño Mendoza");
        
        sucursal1.mostrarEstructura();
*/
        /*
        TablaHashEnlazadaEmpleados tabla = new TablaHashEnlazadaEmpleados();
        
        tabla.insertar(1, "10-0001");
        tabla.insertar(2, "10-0002");
        tabla.insertar(3, "10-0003");
        tabla.insertar(4, "10-0004");
        
        System.out.println(tabla.getNodoEmpleado(0));
        
        TablaHashEnlazadaEmpleados tablaAuxiliar = new TablaHashEnlazadaEmpleados();
        
        for(int i = 0; i < 4; i++){
            NodoEmpleado aux = tabla.getNodoEmpleado(i);
            int salida = 1;
            do{
                if(aux.enlace != null){
                    String codAux = aux.getCodigo();
                    int posicion = i+1;
                    tablaAuxiliar.insertar(posicion, codAux);
                    aux = aux.getEnlace();
                }else{
                    String codAux = aux.getCodigo();
                    int posicion = i+1;
                    tablaAuxiliar.insertar(posicion, codAux);
                    aux = aux.getEnlace();
                    salida = 0;
                }
                
            }while(salida == 1);
            
        }
        
        System.out.println(tablaAuxiliar.mostrarEstructura());
        
        tabla.vaciarTabla();
        
        System.out.println(tabla.mostrarEstructura());
        
        System.out.println(tablaAuxiliar.mostrarEstructura());
        
        /*
        System.out.println(tabla.mostrarEstructura());
        
        System.out.println(tabla.getNodoEmpleado(0));
        
        tabla.vaciarTabla();
        
        System.out.println(tabla.mostrarEstructura());
        
        
        
        System.out.println("Tabla2: \n"+tabla.mostrarEstructura());
*/      
        /*
        String codigo = "VV-0001";
        String nombres = "Cristopher Santiago";
        String apellidos = "Pérez Nieto";
        String cargo = "Vendedor";
        String direccion = "Pepito Delgado xd";
        String correo = "cristopher.perez@epn.edu.ec";
        String numTelf = "0998516975";
        
        
        Empleado emp = new Empleado(codigo, nombres, apellidos, cargo, direccion, correo, numTelf);
        //NodoEmpleadoLista nuevoNodo = new NodoEmpleadoLista();
        //nuevoNodo.crearNodo(emp);
        
        ListaDEnlazada nuevaLista = new ListaDEnlazada();
        nuevaLista.insertarOrdenado(emp);
        
        String codigo2 = "VV-0002";
        
        Empleado emp2 = new Empleado(codigo2, nombres, apellidos, cargo, direccion, correo, numTelf);
        
        String codigo3 = "VV-0003";
        
        Empleado emp3 = new Empleado(codigo3, nombres, apellidos, cargo, direccion, correo, numTelf);
        
        String codigo4 = "GG-0000";
        
        Empleado emp4 = new Empleado(codigo4, nombres, apellidos, cargo, direccion, correo, numTelf);
        
        String codigo5 = "EB-0010";
        
        Empleado emp5 = new Empleado(codigo5, nombres, apellidos, cargo, direccion, correo, numTelf);
        
        nuevaLista.insertarOrdenado(emp2);
        nuevaLista.insertarOrdenado(emp3);
        nuevaLista.insertarOrdenado(emp4);
        nuevaLista.insertarOrdenado(emp5);
        
        System.out.println(nuevaLista.mostrar());
        
        String prueba = "VD-0003";
        int Iprueba = Integer.parseInt(prueba.substring(3, 7));
        System.out.println(Iprueba);
        
        
        
    }*/
    
}
}
