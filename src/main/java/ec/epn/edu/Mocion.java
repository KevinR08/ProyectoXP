package ec.epn.edu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mocion {
    int id_mocion;
    String descripcion;

    public Mocion() {

    }

    public void mostrarMocion(){
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT * FROM Mocion ");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.id_mocion = result.getInt("id_mocion");
                this.descripcion = result.getString("descripcion");
                System.out.println(id_mocion + "\t|\t" + descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String buscarMocionporID(int id_mocion){
        try {
            PreparedStatement stm = Conexion.connection.prepareStatement("SELECT descripcion FROM mocion where id_mocion="+id_mocion);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                this.descripcion=result.getString("descripcion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.descripcion;
    }
}
