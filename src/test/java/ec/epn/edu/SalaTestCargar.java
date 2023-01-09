package ec.epn.edu;
import org.junit.Before;
import org.junit.Test;
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

    @Test
    public void given_aSala_when_load_then_true() {
        System.out.println("Test 1");
        boolean actual=sala.cargarSala(1);
        assertTrue(actual);
    }

    @Test
    public void given_aSala_when_load_then_false() {
        System.out.println("Test 2");
        boolean actual=sala.cargarSala(-1);
        assertTrue(actual);
    }
}