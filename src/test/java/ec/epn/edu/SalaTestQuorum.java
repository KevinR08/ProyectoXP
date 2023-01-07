package ec.epn.edu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaTestQuorum {
    Sala sala;

    @Before
    public void setUp() {
        System.out.println("PruebaQuorumSeteada()");
        sala = new Sala();
    }

    @Test
    public void given_MinNumDeb_when_compare_quorum_then_Available() {
        System.out.println("Test 1");
        assertEquals("Disponible", sala.verificarQuorum(8, 9));
    }

    @Test
    public void given_EqNumDeb_when_compare_quorum_then_NotAvailable() {
        System.out.println("Test 2");
        assertEquals("No disponible", sala.verificarQuorum(9, 9));
    }

    @Test
    public void given_Null_when_compare_quorum_then_Available() {
        System.out.println("Test 3");
        assertEquals("Disponible", sala.verificarQuorum(0, 9));
    }

}


