package ec.epn.edu;

import java.net.ConnectException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion conn = new Conexion();
        conn.initConn();

        int opc = 9, opc2=9;
        boolean logged=false;

        Participante participante;
        Registro registro;

        while(opc!=0){
            System.out.println("***MENÚ 1**" +
                    "\n1. Registrar Participante" +
                    "\n2. Login" +
                    "\n0. Salir");
            System.out.print("\n\tElegir opción: ");
            opc=sc.nextInt();
            switch (opc){
                case 1:
                    participante = new Participante();
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
                    participante = new Participante();
                    System.out.print("Ingresar nickname: ");
                    String nickname_ = sc.next();
                    System.out.print("Ingresar contraseña: ");
                    String contrasenia_= sc.next();
                    if(participante.comprobarLogin(nickname_, contrasenia_)) {
                        participante.cargarParticipante(nickname_);
                        while (opc2 != 0) {
                            System.out.println("***MENÚ 2**" +
                                    "\nBienvenido "+participante.getNombre()+
                                    "\n1. Crear sala" +
                                    "\n0. Salir");
                            System.out.print("\n\tElegir opción: ");
                            opc2 = sc.nextInt();
                            switch (opc2){
                                case 1:
                                    registro = new Registro(participante);
                                    System.out.println("Seleccionar su rol");
                                    registro.elegirRol();
                                    registro.insertarRegistro();
                                    break;
                            }

                        }
                    }
                    break;


            }
        }
    }
}