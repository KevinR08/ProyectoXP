package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Participante {
    private int id_participante;
    private String nombre;
    private String _nickname;
    private String sociedad_debate;
    private String contrasenia;

    public void insertarParticipante(String nombre, String nickname, String sociedad_debate, String contrasenia){
        try{
                PreparedStatement stm = Conexion.connection.prepareStatement("INSERT INTO PARTICIPANTE(nombre, nickname, sociedad_debate, contrasenia)values(?,?,?,?)");
                stm.setString(1, nombre);
                stm.setString(2, nickname);
                stm.setString(3, sociedad_debate);
                stm.setString(4, contrasenia);
                stm.execute();
    } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public boolean cargarParticipante(String nickname) {
        boolean log = false;
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM PARTICIPANTE WHERE nickname='" + nickname + "'");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_participante = result.getInt("id_participante");
                this.nombre = result.getString("nickname");
                this._nickname = result.getString("nickname");
                this.sociedad_debate = result.getString("sociedad_debate");
            }
            }catch(SQLException e){
                System.out.println("Valores no encontrados");
                e.printStackTrace();
            }
        return log;
    }

    public boolean comprobarLogin(String nickname, String contrasenia){
        boolean log=false;
        try{
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM PARTICIPANTE WHERE nickname='"+nickname+"'");
            ResultSet result = stm.executeQuery();
            while (result.next()){
                this._nickname = result.getString("nickname");
                this.contrasenia = result.getString("contrasenia");
                if ((this._nickname.equals(nickname)) && (this.contrasenia.equals(contrasenia))) {
                    log = true;
                    System.out.println("Credenciales correctas");
                }
                if (!(this._nickname.equals(nickname))) {
                    log = false;
                    System.out.println("Nickname incorrecto");
                } else if (!(this.contrasenia.equals(contrasenia))) {
                    log = false;
                    System.out.println("Contraseña incorrecta");
                }
            }
        }catch (SQLException e) {
            System.out.println("Valores no encontrados");
            e.printStackTrace();
        }
        return log;
    }

    public boolean validarParametrosContrasenia(String contrasenia){
        Pattern pat = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        Matcher mat = pat.matcher(contrasenia);
        if (mat.matches()) {
            System.out.println("Contraseña válida");
            return true;
        } else {
            System.out.println("Contraseña invalida");
            return false;
        }
    }
    public String getNombre() {
        return nombre;
    }

    public int getId_participante(){
        return id_participante;
    }


    public String buscarParticipantePorID(int id_participante){
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT nombre FROM PARTICIPANTE where id_participante="+id_participante);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                String nombre=result.getString("nombre_rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }
    @Override
    public String toString() {
        return
                "ID=" + id_participante +
                "Nombre='" + nombre +
                "Nickname='" + _nickname +
                "S_Debate='" + sociedad_debate;
    }
}


