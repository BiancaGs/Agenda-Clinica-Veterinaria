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
public class FrameAlterarTest {
    
    public FrameAlterarTest() {
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
     * Test of listarAgendamentos method, of class FrameAlterar.
     */
    @Test
    public void testListarAgendamentos() {
        System.out.println("listarAgendamentos");
        String CPFCliente = "";
        FrameAlterar instance = new FrameAlterar();
        List<FrameAlterar.DadosAlterar> expResult = null;
        List<FrameAlterar.DadosAlterar> result = instance.listarAgendamentos(CPFCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarAgendamentos method, of class FrameAlterar.
     */
    @Test
    public void testMostrarAgendamentos() {
        System.out.println("mostrarAgendamentos");
        String CPF = "";
        FrameAlterar instance = new FrameAlterar();
        instance.mostrarAgendamentos(CPF);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FrameAlterar.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrameAlterar.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
