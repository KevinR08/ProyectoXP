package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registro {
    Participante participante;
    Rol rol;
    int id_participante;
    int id_rol;
    int id_sala;
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

    public boolean insertarRegistro(int id_sala){
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("INSERT INTO REGINDIVIDUAL(id_participante, id_rol, id_sala)values(?,?,?)");
            stm.setInt(1, this.participante.getId_participante());
            stm.setInt(2, this.id_rol);
            stm.setInt(3, id_sala);
            stm.execute();
            this.id_sala = id_sala;
            this.id_participante=this.participante.getId_participante();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean controlarRolJuez(){
        if(this.id_rol==2){
            return true;
        }else{
            return false;
        }
    }
}
