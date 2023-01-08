package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registro {
    Sala sala;
    Participante participante;
    Rol rol;
    int id_participante;
    int id_rol;
    int id_sala;
    String camara;
    int posicionFinal;
    String retroalimentacion;
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
    public Registro( int id_participante, int id_rol, int id_sala, String camara, int posicionFinal, String retroalimentacion, boolean victoria, int speakerPoints) {
        this.id_participante = id_participante;
        this.id_rol = id_rol;
        this.id_sala = id_sala;
        this.camara=camara;
        this.posicionFinal=posicionFinal;
        this.retroalimentacion=retroalimentacion;
        this.victoria=victoria;
        this.speakerPoints=speakerPoints;
    }

    public void insertarRegistro(int id_sala){
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("INSERT INTO REGINDIVIDUAL(id_participante, id_rol, id_sala, camara, posicion_final, retroalimentacion, victoria, speakerpoints)values(?,?,?,?,?,?,?,?)");
            stm.setInt(1, participante.getId_participante());
            stm.setInt(2, id_rol);
            stm.setInt(3, id_sala);
            stm.setString(4, camara);
            stm.setInt(5, posicionFinal);
            stm.setString(6, retroalimentacion);
            stm.setBoolean(7, victoria);
            stm.setInt(8,speakerPoints);
            stm.execute();
            this.id_sala = id_sala;
            this.id_participante=this.participante.getId_participante();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargarRegistro() {
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM REGINDIVIDUAL WHERE id_participante='" + id_participante + "' AND id_sala='"+id_sala+"'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_participante = result.getInt("id_participante");
                this.id_rol = result.getInt("id_rol");
                this.id_sala = result.getInt("id_sala");
                this.camara = result.getString("camara");
                this.posicionFinal = result.getInt("posicion_final");
                this.retroalimentacion = result.getString("retroalimentacion");
                this.victoria = result.getBoolean("victoria");
                this.speakerPoints = result.getInt("speakerpoints");
            }
        }catch(SQLException e){
            System.out.println("Valores no encontrados");
            e.printStackTrace();
        }
    }

    public void elegirRol(int limit){
        rol=new Rol();
        //System.out.println("Limite"+ limit);
        rol.mostrarRol(2);
        System.out.println("Escoja el número del rol");
        this.id_rol = sc.nextInt();
        System.out.println("Ha escogido ser "+rol.buscarRolporID(this.id_rol));
    }

    public int getId_rol() {
        return id_rol;
    }

    public int getId_sala(){
        return id_sala;
    }

    public int getId_participante() {
        return id_participante;
    }

    public int getSpeakerPoints() {
        return speakerPoints;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public String getCamara() {
        return camara;
    }
    @Override
    public String toString() {
        return
                "ID Participante: " + id_participante +
                "\t ID Rol: " + id_rol +
                "\t ID Sala:" + id_sala+
                "\t Camara:" + camara+
                "\t Pos:" + posicionFinal+
                "\t Retro:" + retroalimentacion+
                "\t Victoria:" + victoria+
                "\t Speakerpoints:" + speakerPoints;
    }


}
