package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registro {
    Participante participante;
    //Sala sala;
    Rol rol;
    int id_participante;
    int id_rol;
    int posiciónFinal;
    String retroalimentación;
    boolean victoria;
    int speakerPoints;

    Scanner sc = new Scanner(System.in);

    public Registro(Participante participante) {
        this.participante = participante;
    }

    public boolean elegirRol(){
        boolean escogido=false;
        rol=new Rol();
        rol.mostrarRol();
        System.out.println("Escoja el número del rol");
        this.id_rol = sc.nextInt();
        System.out.println("Ha escogido ser "+rol.buscarRolporID(this.id_rol));
        return escogido=true;
    }

    public boolean insertarRegistro(){
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("INSERT INTO REGINDIVIDUAL(id_participante, id_rol)values(?,?)");
            stm.setInt(1, this.participante.getId_participante());
            stm.setInt(2, this.id_rol);
            stm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
