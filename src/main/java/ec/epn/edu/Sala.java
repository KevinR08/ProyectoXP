package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public int limit=2;
    public Sala() {
    }

    public Sala(String nombreSala, String horario, int numDebatientes, int quorum) {
        this.nombreSala = nombreSala;
        this.horario = horario;
        this.numDebatientes = numDebatientes;
        this.quorum = quorum;
    }

    public void mostrarSalas(){
        actualizarNumEstado();
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
                verificarQuorum(this.numDebatientes, this.quorum);
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

    public void actualizarNumEstado(){
        for(int i=0; i<5;i++) {
            try {
                PreparedStatement stm = Conexion.connection.prepareStatement("select count(*) as num from regindividual where id_sala='" + i + "'");
                ResultSet result = stm.executeQuery();
                while (result.next()) {
                    this.numDebatientes = result.getInt("num");
                }
                PreparedStatement stm2 = Conexion.connection.prepareStatement("UPDATE SALA SET numDebatientes=?, estado=? where id_sala='" + i + "'");
                stm2.setInt(1, numDebatientes);
                stm2.setString(2, estado);
                stm2.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String verificarQuorum(int numDebatientes, int quorum){
        if(numDebatientes>=quorum){
            this.estado="No disponible";
        }else{
            this.estado="Disponible";
        }
        return this.estado;
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
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM REGINDIVIDUAL WHERE id_sala='" + id_sala + "'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                registros.add(new Registro(
                        result.getInt("id_participante"),
                        result.getInt("id_rol"),
                        result.getInt("id_sala"),
                        result.getString("camara"),
                        result.getInt("posicion_final"),
                        result.getString("retroalimentacion"),
                        result.getBoolean("victoria"),
                        result.getInt("speakerpoints")));
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

    public void dividirPorCamaras(){
        registros.clear();
        mostrarRegistros(id_sala);
        System.out.println("SELECCIÓN DE CÁMARAS");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< registros.size(); i++){
            System.out.println("---Participante"+registros.get(i));
            System.out.println("Ingrese la cámara a la que pertenece: (CAO CBO CAG CBG)");
            String camara = sc.next();
            int id_participante= registros.get(i).getId_participante();
                try {
                    PreparedStatement stm = Conexion.connection.prepareStatement("UPDATE REGINDIVIDUAL SET camara=? where id_sala='" + id_sala + "' and id_participante='"+id_participante+"'and id_rol=1");
                    stm.setString(1, camara);
                    stm.execute();
                }catch(SQLException e){
                    System.out.println("Valores no encontrados");
                    e.printStackTrace();
                }
        }
        //verTodosRegistros();
    }


    public int getId_sala() {
        return id_sala;
    }
}


