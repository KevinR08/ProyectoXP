package ec.epn.edu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class ParticipanteTestPassword {

        Participante p;
        Conexion con;
        private String contrasenia;
        private boolean expected;
        @Before
        public void setUp(){
            System.out.println("PruebaPasswordSeteada()");
            p=new Participante();
        }

        @Parameterized.Parameters
        public static  Iterable<Object[]> parameters(){
            List<Object[]> objects = new ArrayList<Object[]>();
            objects.add(new Object[]{"Kev080808R",true});
            objects.add(new Object[]{"Juan565956L",true});
            objects.add(new Object[]{"CRIS262626V",false});
            objects.add(new Object[]{"Fer242424S",true});
            objects.add(new Object[]{"RodrigoF",false});
            objects.add(new Object[]{"Marce575757M",true});
            return  objects;
        }

        public ParticipanteTestPassword( String contrasenia, boolean expected){
            this.contrasenia=contrasenia;
            this.expected=expected;
        }

        @Test
        public void given_password_when_register_then_validate(){
            boolean actual=p.validarParametrosContrasenia(contrasenia);
            assertEquals(expected,actual);
        }

}