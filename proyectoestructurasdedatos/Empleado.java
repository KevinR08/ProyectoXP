/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructurasdedatos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santiago
 */
public class Empleado {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String cargo;
    private String ultimaSucursal;
    private String direccion;
    private String correo;
    private String numTelf;
    
    public Empleado(String codigo, String nombres, String apellidos, 
            String cargo, String ultimaSucursal, String direccion, 
            String correo, String numTelf){
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.ultimaSucursal = ultimaSucursal;
        this.direccion = direccion;
        this.correo = correo;
        this.numTelf = numTelf;
    }

    public Empleado() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUltimaSucursal() {
        return ultimaSucursal;
    }

    public void setUltimaSucursal(String ultimaSucursal) {
        this.ultimaSucursal = ultimaSucursal;
    }
   
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }
    
    public static boolean esCodigoValido(String codigo) {
        return codigo.matches("[GG|VD|CT|EB]\\-([0-9]{5})");
    }

    public int generarDigitos(){
        return (int)(10000 * Math.random());
    }
    
    public boolean esNombreValido(String nombre){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,254}");// puede ser una letra o 254 digitos
        Matcher m = p.matcher(nombre);
        return m.matches();
    }
    
    public boolean esApellidoValido(String apellido){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,254}");// puede ser una letra o 254 digitos
        Matcher m = p.matcher(apellido);
        return m.matches();
    }
    
    public boolean esDireccionValido(String direccion){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,254}");// puede ser una letra o 254 digitos
        Matcher m = p.matcher(direccion);
        return m.matches();
    }
    
    public boolean esCorreoValido(String correo) {
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(correo);
        return m.matches();
    }
    public boolean esTelefonoValido(String telefono) {
        Pattern p = Pattern.compile("(^[09|08])[0-9]{9}");// valida el 09 o 08 mas 9 digitos de 0 al 9
        Matcher m = p.matcher(telefono);
        return m.matches();
    }

    @Override
    public String toString() {
        return "Empleado: "+nombres+" "+apellidos+"\n"+
               "Código: "+codigo+"\n"+
               "Cargo: "+cargo+"\n"+
               "Última Sucursal: "+ultimaSucursal+"\n"+
               "Dirección: "+direccion+"\n"+
               "Correo: "+correo+"\n"+
               "Número de teléfono: "+numTelf+"\n";
    }
    
    
}
