/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaTestes;

import agenda.Agendamento;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;

/**
 *
 * @author pietr
 */
public class TesteAgendamento {
    
    private Agendamento a;
    
    @Before
    public void setup() {
        a = new Agendamento();        
        

    }
    
    @Test
    public void teste1Data() {
        assertEquals("2019-01-12", a.toLocalDate("12/01/2019").toString());
    }

    @Test
    public void teste2Data() {
        assertEquals("2019-01-12", a.toLocalDate("2019-01-12").toString());
    }

    @Test
    public void teste3Data() {
        assertEquals("12/01/2019", a.toLocalDate("12/01/2019").toString());
    }
    
    @Test
    public void teste1Horario() {
        assertEquals("13:30:00", a.toTime("13:30").toString());
    }

}
