package ec.epn.edu;

import java.net.ConnectException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion conn = new Conexion();
        conn.initConn();

        int opc = 9;
        boolean logged=false;

        Participante participante = new Participante();
        participante.mostrarParticipantes();

        while(opc!=0){
            System.out.println("***MENÚ 1**" +
                    "\n1. Registrar Participante" +
                    "\n2. Login" +
                    "\n3. Crear sala" +
                    "\n0. Salir");
            System.out.println("\n\tElegir opción: ");
            opc=sc.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Ingresar datos del participante");
                    System.out.println("Nombre - nickname - sociedad - contraseña");
                    String nombre= sc.next();
                    String nickname=sc.next();
                    String sociedad=sc.next();
                    String contrasenia = sc.next();
                    if(participante.validarParametrosContrasenia(contrasenia)){
                    participante.registrarParticipante(nombre, nickname, sociedad, contrasenia);
                    }

                    break;
                case 2:
                    System.out.println("Ingresar nickname");
                    String nickname_ = sc.next();
                    System.out.println("Ingresar contraseña");
                    String contrasenia_= sc.next();
                    participante.comprobarLogin(nickname_, contrasenia_);
                    break;
                case 3:
                    System.out.println("Seleccionar su rol");

            }
        }
    }
}