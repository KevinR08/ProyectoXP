package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sala {
    private int id_sala;
    private String nombreSala;
    private String horario;
    private int numDebatientes;
    private int quorum;
    private String estado;

    public Sala() {
    }

    public Sala(String nombreSala, String horario, int numDebatientes, int quorum) {
        this.nombreSala = nombreSala;
        this.horario = horario;
        this.numDebatientes = numDebatientes;
        this.quorum = quorum;
    }

    public void mostrarSalas(){
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM SALA");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_sala=result.getInt("id_sala");
                this.nombreSala=result.getString("nombreSala");
                this.horario =result.getString("horario");
                this.numDebatientes=result.getInt("numDebatientes");
                this.quorum=result.getInt("quorum");
                this.estado=result.getString("estado");
                System.out.println(id_sala+"\t|"+ nombreSala + "\t|"+ horario+"\t|N° Participantes:"+ numDebatientes+ "\t|Quorum:"+ quorum+ "\t|"+ estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean cargarSala(int id_sala) {
        boolean log = false;
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM SALA WHERE id_sala='" + id_sala + "'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.nombreSala = result.getString("nombreSala");
                this.horario = result.getString("horario");
                this.numDebatientes = (result.getInt("numdebatientes"));
                this.quorum = result.getInt("quorum");
                this.id_sala=id_sala;
            }
        }catch(SQLException e){
            System.out.println("Valores no encontrados");
            e.printStackTrace();
        }
        return log;
    }

    public void ActualizarNumEstado(){
        verificarQuorum();
        numDebatientes++;
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("UPDATE SALA SET numDebatientes=? , estado=? where id_sala=?");
            stm.setInt(1, numDebatientes);
            stm.setString(2, estado);
            stm.setInt(3, id_sala);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void verificarQuorum(){
        if(this.numDebatientes==this.quorum-1){
            this.estado="No disponible";
        }
    }




}
