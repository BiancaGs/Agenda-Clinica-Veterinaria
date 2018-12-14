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
 * @author Pietro
 * @author Bianca
 */
public class AgendamentoTest {
    


    @Test
    public void testToBRFormat() {
        String data = "2019-01-12";
        Agendamento instance = new Agendamento();
        String expResult = "12/01/2019";
        String result = instance.toBRFormat(data);
        assertEquals(expResult, result);
    }


    @Test
    public void testToUSFormat() {
        String data = "24/08/2019";
        Agendamento instance = new Agendamento();
        String expResult = "2019-08-24";
        String result = instance.toUSFormat(data);
        assertEquals(expResult, result);
    }


    @Test
    public void testBRtoLocalDate() {
        String data = "18/02/2019";
        Agendamento instance = new Agendamento();
        LocalDate result = instance.BRtoLocalDate(data);
        assertNotNull(result);
    }


    @Test
    public void testUStoLocalDate() {
        String data = "2018-12-25";
        Agendamento instance = new Agendamento();
        LocalDate result = instance.UStoLocalDate(data);
        assertNotNull(result);
    }


    @Test
    public void testToTime() {
        String horario = "15:20";
        Agendamento instance = new Agendamento();
        Time result = instance.toTime(horario);
        assertNotNull(result);
    }


    @Test
    public void testVerificarExpediente() {
        String horario = "15:00:00";
        Agendamento instance = new Agendamento();
        boolean result = instance.verificarExpediente(instance.toTime(horario)  );
        assertEquals(true, result);
    }

}
