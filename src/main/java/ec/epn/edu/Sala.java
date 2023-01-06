package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sala {
    private int id_sala;
    ArrayList<Registro> registros = new ArrayList<>();
    private String nombreSala;
    private String horario;
    private int numDebatientes;
    private int quorum;
    private String estado;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public int limit;
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
                verificarQuorum();
                System.out.println(id_sala+"\t|"+ nombreSala + "\t|"+ horario+"\t|N° Participantes:"+ numDebatientes+ "\t|Quorum:"+ quorum+ "\t|"+ANSI_RED +estado +ANSI_RESET);
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

        //numDebatientes++;
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("select count(*) as num from regindividual where id_sala='" + id_sala + "'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.numDebatientes = result.getInt("num");
            }
            PreparedStatement stm2 = Conexion.connection.prepareStatement("UPDATE SALA SET numDebatientes=?, estado=? where id_sala='" + id_sala + "'");
            stm2.setInt(1, numDebatientes);
            stm2.setString(2, estado);
            stm2.execute();
            System.out.println("Estado prueba"+estado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void verificarQuorum(){
        if(this.numDebatientes>=this.quorum){
            this.estado="No disponible";
        }else{
            this.estado="Disponible";
        }
    }


    @Override
    public String toString() {
        System.out.println("PRUEBA*******");
        return "Sala{" +
                "id_sala=" + id_sala +
                ", nombreSala='" + nombreSala + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

    public void mostrarRegistros(int id_sala) {
        registros.clear();
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT id_participante, id_rol, id_sala FROM REGINDIVIDUAL WHERE id_sala='" + id_sala + "'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                registros.add(new Registro(result.getInt("id_participante"), result.getInt("id_rol"), result.getInt("id_sala")));
            }
            for(int i = 0; i< registros.size(); i++){
                System.out.println(registros.get(i));
            }
                controlarRolJuez(registros);
        }catch(SQLException e){
            System.out.println("Valores no encontrados");
            e.printStackTrace();
        }
    }

    public int controlarRolJuez(ArrayList<Registro> registros){
        this.limit=2;
        for(int i = 0; i< registros.size(); i++){

            if(registros.get(i).getId_rol()==2 && registros.get(i).getId_sala()==this.id_sala){
                limit=1;
            }else{
                limit=2;
            }
        }
        return limit;
    }

    public int getId_sala() {
        return id_sala;
    }
}


