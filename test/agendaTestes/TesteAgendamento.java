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

    //--------------------------- DATA -------------------------------    
    @Test
    public void teste1Data() {
        assertEquals("2019-01-12", a.toMysqlDate("12/01/2019").toString());
    }

    @Test
    public void teste2Data() {
        assertEquals("2019-10-25", a.toMysqlDate("25/10/2019").toString());
    }

    @Test
    public void teste3Data() {
        assertEquals("2018-12-30", a.toMysqlDate("30/12/2018").toString());
    }

    //------------------------------------------------------------------
    @Test
    public void teste4Data() {
        assertEquals("24/08/2019", a.toBRFormat("2019-08-24"));
    }

    @Test
    public void teste5Data() {
        assertEquals("12/01/2019", a.toBRFormat("2019-01-12"));
    }

    @Test
    public void teste6Data() {
        assertEquals("25/12/2018", a.toBRFormat("2018-12-25"));
    }

    //------------------------------------------------------------------
    @Test
    public void teste7Data() {
        assertEquals("2019-08-24", a.toUSFormat("24/08/2019"));
    }

    @Test
    public void teste8Data() {
        assertEquals("2019-01-12", a.toUSFormat("12/01/2019"));
    }

    @Test
    public void teste9Data() {
        assertEquals("2018-12-25", a.toUSFormat("25/12/2018"));
    }



    //------------------------- TIME ----------------------------------
    @Test
    public void teste1Horario() {
        assertEquals("13:30:00", a.toTime("13:30").toString());
    }

}
