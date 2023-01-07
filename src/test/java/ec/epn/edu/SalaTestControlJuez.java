package ec.epn.edu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SalaTestControlJuez {

    Sala sala;
    static ArrayList<Registro> registros, registros2;

    @Before
    public void setUp(){
        System.out.println("PruebaRolJuezSeteada()");
        sala=new Sala();
        registros = new ArrayList<>();
        registros.add(new Registro(50,1,100));
        registros.add(new Registro(51,1,100));
        registros.add(new Registro(52,1,100));
        registros.add(new Registro(53,1,100));
        registros2 = new ArrayList<>();
        registros2.add(new Registro(80,1,150));
        registros2.add(new Registro(80,1,150));
        registros2.add(new Registro(82,2,150));
        registros2.add(new Registro(83,1,150));
    }

    @Test
    public void given_anyJudge_when_check_then_2Roles(){
        System.out.println("Test 1");
        assertEquals(2, sala.controlarRolJuez(registros));
    }

    @Test
    public void given_aJudge_when_check_then_1Role(){
        System.out.println("Test 1");
        assertEquals(2, sala.controlarRolJuez(registros));
    }

}