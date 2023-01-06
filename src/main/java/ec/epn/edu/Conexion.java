package ec.epn.edu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class Conexion {
    private static String user = "postgres";
    private static String pass = "Kevincraft54";
    public static Connection connection;

    public static void initConn() {
        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/debate", user, pass);
            //System.out.println("Conectado correctamente");
        } catch (Exception e) {
            System.out.println("**ERROR*****");
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getCause();
            e.getLocalizedMessage();
            System.out.println(e.toString());
        }

    }
}
