package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Participante {
    private int id_participante;
    private String nombre;
    private String _nickname;
    private String sociedad_debate;
    private String contrasenia;

    public void mostrarParticipantes() {
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM PARTICIPANTE");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_participante=result.getInt("id_participante");
                this.nombre=result.getString("nombre");
                this._nickname =result.getString("nickname");
                this.sociedad_debate=result.getString("sociedad_debate");
                this.contrasenia=result.getString("contrasenia");
                System.out.println(id_participante+"\t|"+ nombre + "\t|"+ _nickname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void registrarParticipante(String nombre, String nickname, String sociedad_debate, String contrasenia){
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
}
