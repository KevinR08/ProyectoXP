package ec.epn.edu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion conn = new Conexion();
        conn.initConn();

        int opc = 9, opc2 = 9, opc3=9;
        int id_sala = 0, limit = 0;

        Participante participante;
        Registro registro;
        Sala sala = new Sala();

        while (opc != 0) {
            System.out.println("******MENÚ 1*****" +
                    "\n1. Registrar Participante" +
                    "\n2. Login" +
                    "\n0. Salir");
            System.out.print("\n\tElegir opción: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    participante = new Participante();
                    System.out.println("Ingresar datos del participante");
                    System.out.println("Nombre - nickname - sociedad - contraseña");
                    String nombre = sc.next();
                    String nickname = sc.next();
                    String sociedad = sc.next();
                    String contrasenia = sc.next();
                    if (participante.validarParametrosContrasenia(contrasenia)) {
                        participante.insertarParticipante(nombre, nickname, sociedad, contrasenia);
                    }
                    break;
                case 2:
                    participante = new Participante();
                    System.out.print("Ingresar nickname: ");
                    String nickname_ = sc.next();
                    System.out.print("Ingresar contraseña: ");
                    String contrasenia_ = sc.next();
                    if (participante.comprobarLogin(nickname_, contrasenia_)) {
                        participante.cargarParticipante(nickname_);
                        while (opc2 != 0) {
                            //System.out.println(participante.toString());
                            System.out.println("***MENÚ 2***" +
                                    "\nBienvenido " + participante.getNombre() +
                                    "\n1. Registrarse en sala" +
                                    "\n0. Salir");
                            System.out.print("\n\tElegir opción: ");
                            opc2 = sc.nextInt();
                            switch (opc2) {
                                case 1:
                                    registro = new Registro(participante);
                                    System.out.println("Seleccionar número de sala");
                                    sala.mostrarSalas();
                                    id_sala = sc.nextInt();
                                    System.out.println("Seleccionar número de rol");
                                    registro.elegirRol(sala.limit);
                                    registro.insertarRegistro(id_sala);

                                    sala.cargarSala(id_sala);
                                    sala.actualizarNumEstado();
                                    registro.cargarRegistro();

                                    if (registro.getId_rol() == 1) {
                                        System.out.println("\n***************SALA DE ESPERA********************");
                                        //sala.mostrarRegistros(id_sala);
                                        while (opc3 != 0) {
                                            //System.out.println(participante.toString());
                                            System.out.println("*****VISUALIZACIÓN DE RESULTADOS******" +
                                                    "\n1. Visualizar listado de posiciones finales" +
                                                    "\n2. Visualizar speakerpoints" +
                                                    "\n3. Visualizar ganador de la sala");
                                            System.out.print("\n\tElegir opción: ");
                                            opc3 = sc.nextInt();
                                            switch (opc3) {
                                                case 1:
                                                    sala.mostrarRegistros(id_sala);
                                                    break;
                                                case 2:
                                                    System.out.println("Speakers obtenidos: "+registro.getSpeakerPoints());
                                                    break;
                                                case 3:
                                                    sala.mostrarGanador();
                                            }
                                        }
                                    } else if (registro.getId_rol() == 2) {
                                        sala.dividirPorCamaras();
                                        sala.mostrarRegistros(id_sala);
                                        sala.asignarMeetsyMocion();//*borrar*/
                                        System.out.println(sala.toString());
                                        /*Calificación de debate*/
                                        sala.calificarCamaras("CAO");
                                        sala.calificarCamaras("CBO");
                                        sala.calificarCamaras("CAG");
                                        sala.calificarCamaras("CBG");
                                        sala.mostrarRegistros(id_sala);

                                    }
                            }
                        }
                    }
            }
        }
    }

}