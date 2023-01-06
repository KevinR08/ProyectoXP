package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registro {
    Sala sala;
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
        this.participante = participante;sala=new Sala();
    }

    public Registro( int id_participante, int id_rol, int id_sala) {
        this.id_participante = id_participante;
        this.id_rol = id_rol;
        this.id_sala = id_sala;
    }

    public boolean elegirRol(int limit){
        boolean escogido=false;
        rol=new Rol();
        System.out.println("Limite"+ limit);
        rol.mostrarRol(limit);
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

    public int getId_rol() {
        return id_rol;
    }

    public int getId_sala(){
        return id_sala;
    }

    @Override
    public String toString() {
        return
                "ID Participante: " + id_participante +
                "\t ID Rol: " + id_rol +
                "\t ID Sala:" + id_sala;
    }
}
