package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rol {
    int id_rol;
    String nombre_rol;
    Registro registro;
    public Rol() {

    }
    public Rol(String nombre) {
        this.nombre_rol = nombre;
    }



    public void mostrarRol(int limite){
        try {
                PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM ROL limit "+limite);
                ResultSet result = stm.executeQuery();
                while (result.next()) {
                    this.id_rol = result.getInt("id_rol");
                    this.nombre_rol = result.getString("nombre_rol");
                    System.out.println(id_rol + "\t|\t" + nombre_rol);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String buscarRolporID(int id_rol){
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT nombre_rol FROM ROL where id_rol="+id_rol);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.nombre_rol=result.getString("nombre_rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.nombre_rol;
    }

    public void ocultarRolJuez() {
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT TOP 1 * FROM ROL");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_rol = result.getInt("id_rol");
                this.nombre_rol = result.getString("nombre_rol");
                System.out.println(id_rol + "\t|\t" + nombre_rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId_rol() {
        return id_rol;
    }
}
