/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.List;
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
public class FrameVisualizarAgendamentosTest {
    
    public FrameVisualizarAgendamentosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listarAgendamentos method, of class FrameVisualizarAgendamentos.
     */
    @Test
    public void testListarAgendamentos() {
        System.out.println("listarAgendamentos");
        String dataAgendamento = "";
        FrameVisualizarAgendamentos instance = new FrameVisualizarAgendamentos();
        List<FrameVisualizarAgendamentos.DadosVisualizar> expResult = null;
        List<FrameVisualizarAgendamentos.DadosVisualizar> result = instance.listarAgendamentos(dataAgendamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarAgendamentos method, of class FrameVisualizarAgendamentos.
     */
    @Test
    public void testMostrarAgendamentos() {
        System.out.println("mostrarAgendamentos");
        String dataAgendamento = "";
        FrameVisualizarAgendamentos instance = new FrameVisualizarAgendamentos();
        instance.mostrarAgendamentos(dataAgendamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FrameVisualizarAgendamentos.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrameVisualizarAgendamentos.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
