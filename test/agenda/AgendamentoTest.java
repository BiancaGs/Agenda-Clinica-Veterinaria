/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Time;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class AgendamentoTest {
    
    @Before
    public void setUp() {
        Agendamento a = new Agendamento();    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toBRFormat method, of class Agendamento.
     */
    @Test
    public void testToBRFormat() {
        System.out.println("toBRFormat");
        String data = "2019-01-12";
        Agendamento instance = new Agendamento();
        String expResult = "12/01/2019";
        String result = instance.toBRFormat(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of toUSFormat method, of class Agendamento.
     */
    @Test
    public void testToUSFormat() {
        System.out.println("toUSFormat");
        String data = "24/08/2019";
        Agendamento instance = new Agendamento();
        String expResult = "2019-08-24";
        String result = instance.toUSFormat(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of BRtoLocalDate method, of class Agendamento.
     */
    @Test
    public void testBRtoLocalDate() {
        System.out.println("BRtoLocalDate");
        String data = "";
        Agendamento instance = new Agendamento();
        LocalDate expResult = null;
        LocalDate result = instance.BRtoLocalDate(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UStoLocalDate method, of class Agendamento.
     */
    @Test
    public void testUStoLocalDate() {
        System.out.println("UStoLocalDate");
        String data = "";
        Agendamento instance = new Agendamento();
        LocalDate expResult = null;
        LocalDate result = instance.UStoLocalDate(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toTime method, of class Agendamento.
     */
    @Test
    public void testToTime() {
        System.out.println("toTime");
        String horario = "";
        Agendamento instance = new Agendamento();
        Time expResult = null;
        Time result = instance.toTime(horario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarExpediente method, of class Agendamento.
     */
    @Test
    public void testVerificarExpediente() {
        System.out.println("verificarExpediente");
        Time timeAgendamento = null;
        Agendamento instance = new Agendamento();
        boolean expResult = false;
        boolean result = instance.verificarExpediente(timeAgendamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarDisponibilidade method, of class Agendamento.
     */
    @Test
    public void testVerificarDisponibilidade() {
        System.out.println("verificarDisponibilidade");
        LocalDate dateAgendamento = null;
        Time timeAgendamento = null;
        Agendamento instance = new Agendamento();
        boolean expResult = false;
        boolean result = instance.verificarDisponibilidade(dateAgendamento, timeAgendamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
