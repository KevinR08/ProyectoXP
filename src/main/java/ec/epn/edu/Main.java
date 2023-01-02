package ec.epn.edu;

import java.net.ConnectException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion conn = new Conexion();
        conn.initConn();

        int opc = 9;

        Participante participante = new Participante();
        participante.mostrarParticipantes();

        while(opc!=0){
            System.out.println("***MENÚ 1**" +
                    "\n1. Registrar Participante" +
                    "\n2. Login" +
                    "\n0. Salir");
            System.out.println("\n\tElegir opción: ");
            opc=sc.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Ingresar datos del participante");
                    System.out.println("Nombre - nickname - sociedad - contraseña");
                    participante.registrarParticipante(sc.next(),sc.next(),sc.next(),sc.next());
                    break;
                case 2:
                    System.out.println("Ingresar nickname");
                    String nickname = sc.next();
                    System.out.println("Ingresar contraseña");
                    String contrasenia= sc.next();
                    participante.comprobarLogin(nickname, contrasenia);
                    break;
            }
        }

    }
}