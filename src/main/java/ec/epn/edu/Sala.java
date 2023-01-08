package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala {
    Mocion mocion_;
    private int id_sala;
    ArrayList<Registro> registros = new ArrayList<>();
    private String nombreSala;
    private String horario;
    private int numDebatientes;
    private int quorum;
    private String estado;
    /*Nuevos*/
    String meets;
    int id_mocion;
    String ganador;



    /*Extras*/
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
                this.id_mocion=result.getInt("id_mocion");
                this.meets=result.getString("meets");
                this.ganador=result.getString("ganador");
                verificarQuorum(this.numDebatientes, this.quorum);
                System.out.println(id_sala+"\t|"+ nombreSala + "\t|"+ horario+"\t|N°Participantes:"+ numDebatientes+ "\t|Quorum:"+ quorum+ "\t|"+ANSI_RED +estado +ANSI_RESET);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                this.estado=result.getString("estado");
                this.id_mocion = result.getInt("id_mocion");
                this.meets = result.getString("meets");
                this.ganador = result.getString("ganador");
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




    public void mostrarRegistros(int id_sala) {
        registros.clear();
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM REGINDIVIDUAL WHERE id_sala='" + id_sala + "' ORDER BY camara");
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
                if(registros.get(i).getId_rol()==1){
                    System.out.println(registros.get(i));
                }

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
        System.out.println("\n*************LISTADO DE DEBATIENTES**********************");
        mostrarRegistros(id_sala);
        System.out.println("\n*************SELECCIÓN DE CÁMARAS**************");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< registros.size(); i++){
            if (registros.get(i).getId_rol()==1) {
                System.out.println("\n---PARTICIPANTE-->  " + registros.get(i));
                System.out.print("Ingrese la cámara a la que pertenece (CAO CBO CAG CBG): ");
                String camara = sc.next();
                int id_participante = registros.get(i).getId_participante();
                try {
                    PreparedStatement stm = Conexion.connection.prepareStatement("UPDATE REGINDIVIDUAL SET camara=? where id_sala='" + id_sala + "' and id_participante='" + id_participante + "'and id_rol=1");
                    stm.setString(1, camara);
                    stm.execute();
                } catch (SQLException e) {
                    System.out.println("Valores no encontrados");
                    e.printStackTrace();
                }
            }
        }
    }
    public void asignarMeetsyMocion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\tESCOJA EL NÚMERO DE MOCIÓN: ");
        elegirMocion();
        this.id_mocion = sc.nextInt();
        System.out.print("\tINGRESE EL LINK DE MEETS: ");
        this.meets = sc.next();
            try {
                PreparedStatement stm = Conexion.connection.prepareStatement("UPDATE SALA SET meets=?, id_mocion=? where id_sala='" + id_sala +"'");
                stm.setString(1, meets);
                stm.setInt(2, id_mocion);
                stm.execute();
            }catch(SQLException e){
                System.out.println("Valores no encontrados");
                e.printStackTrace();
            }
            mostrarSalas();
    }

    public void elegirMocion(){
        mocion_ = new Mocion();
        mocion_.mostrarMocion();
    }

    public void calificarCamaras(String camara){
        System.out.println("\n*************CALIFICACIÓN DE CÁMARA "+camara+"**************");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< registros.size(); i++) {
            if (registros.get(i).getId_rol() == 1 && registros.get(i).getCamara() == camara) {
                System.out.println("\n---PARTICIPANTE-->  " + registros.get(i));
            }
        }
                System.out.println("INGRESE SU POSICIÓN FINAL - RETROALIMENTACIÓN - SPEAKERPOINTS :");
                int posicion_final = sc.nextInt();
                String retroalimentacion = sc.next();
                int speakerpoints = sc.nextInt();
                boolean victoria = verificarVictoria(posicion_final);

                //int id_participante = registros.get(i).getId_participante();
                for(int i=0; i<2; i++) {
                    try {
                        PreparedStatement stm = Conexion.connection.prepareStatement("UPDATE REGINDIVIDUAL SET posicion_final=?, retroalimentacion=?, victoria=?, speakerpoints=? where id_sala='" + id_sala + "' and camara='" + camara + "'and id_rol=1");
                        stm.setInt(1, posicion_final);
                        stm.setString(2, retroalimentacion);
                        stm.setBoolean(3, victoria);
                        stm.setInt(4, speakerpoints);
                        stm.execute();
                    } catch (SQLException e) {
                        System.out.println("Valores no encontrados");
                        e.printStackTrace();
                    }
                }
    }

    public boolean verificarVictoria(int posicion_final){
        if(posicion_final==1){
            return true;
        }else{
            return false;
        }
    }

    public void mostrarGanador(){
        for(int i=0; i< registros.size();i++){
            if(registros.get(i).isVictoria()==true){
                int id_participante = registros.get(i).getId_participante();
                System.out.println("Ganador de la sala: "+registros.get(i).participante.buscarParticipantePorID(id_participante));
            }
        }
    }


    @Override
    public String toString(){
        System.out.println("\n******************RESUMEN******************");
        return id_sala+"\t|"+ nombreSala + "\t|"+ horario+"\t|N°Participantes:"+ numDebatientes+ "\t|Quorum:"+ quorum+ "\t|"+ANSI_RED +estado +ANSI_RESET
                +"\nMOCIÓN DEFINIDA: "+mocion_.buscarMocionporID(id_mocion)
                +"\nLINK DE MEETS:"+this.meets
                +"\n******************RESUMEN******************";
    }
}


