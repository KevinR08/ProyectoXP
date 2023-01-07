package ec.epn.edu;

import com.sun.org.apache.xpath.internal.objects.XNull;
import org.junit.Before;
import org.junit.Test;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SalaTestCargar {

    Sala sala;
    Conexion conn;
    @Before
    public void setUp(){
        System.out.println("PruebaCargarSala()");
        sala=new Sala();
        conn = new Conexion();
        conn.initConn();
    }

    @Test(expected = AssertionError.class)
    public void given_anyJudge_when_check_then_2Roles() {
        System.out.println("Test 1");
        sala.cargarSala(1);
    }
}