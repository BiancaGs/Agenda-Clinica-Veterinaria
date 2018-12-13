/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class OperacoesBDTest {
    
    public OperacoesBDTest() {
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
     * Test of inserirAgendamento method, of class OperacoesBD.
     */
    @Test
    public void testInserirAgendamento() throws Exception {
        System.out.println("inserirAgendamento");
        Connection conn = null;
        Cliente c = null;
        Paciente p = null;
        Agendamento a = null;
        Veterinario v = null;
        OperacoesBD instance = new OperacoesBD();
        instance.inserirAgendamento(conn, c, p, a, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVeterinario method, of class OperacoesBD.
     */
    @Test
    public void testBuscarVeterinario() throws Exception {
        System.out.println("buscarVeterinario");
        Connection conn = null;
        String CRMVVeterinario = "";
        OperacoesBD instance = new OperacoesBD();
        ResultSet expResult = null;
        ResultSet result = instance.buscarVeterinario(conn, CRMVVeterinario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPaciente method, of class OperacoesBD.
     */
    @Test
    public void testBuscarPaciente() throws Exception {
        System.out.println("buscarPaciente");
        Connection conn = null;
        String nomePaciente = "";
        OperacoesBD instance = new OperacoesBD();
        ResultSet expResult = null;
        ResultSet result = instance.buscarPaciente(conn, nomePaciente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class OperacoesBD.
     */
    @Test
    public void testBuscarCliente() throws Exception {
        System.out.println("buscarCliente");
        Connection conn = null;
        String CPFCliente = "";
        OperacoesBD instance = new OperacoesBD();
        ResultSet expResult = null;
        ResultSet result = instance.buscarCliente(conn, CPFCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarDisponibilidade method, of class OperacoesBD.
     */
    @Test
    public void testVerificarDisponibilidade() throws Exception {
        System.out.println("verificarDisponibilidade");
        Connection conn = null;
        String dataAgendamento = "";
        String horarioAgendamento = "";
        String CRMV = "";
        OperacoesBD instance = new OperacoesBD();
        boolean expResult = false;
        boolean result = instance.verificarDisponibilidade(conn, dataAgendamento, horarioAgendamento, CRMV);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerAgendamento method, of class OperacoesBD.
     */
    @Test
    public void testRemoverAgendamento() throws Exception {
        System.out.println("removerAgendamento");
        Connection conn = null;
        Agendamento a = null;
        String CPFCliente = "";
        OperacoesBD instance = new OperacoesBD();
        instance.removerAgendamento(conn, a, CPFCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarAgendamento method, of class OperacoesBD.
     */
    @Test
    public void testAtualizarAgendamento() throws Exception {
        System.out.println("atualizarAgendamento");
        Connection conn = null;
        Agendamento antigo = null;
        Agendamento novo = null;
        Cliente c = null;
        Veterinario v = null;
        Paciente p = null;
        OperacoesBD instance = new OperacoesBD();
        instance.atualizarAgendamento(conn, antigo, novo, c, v, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
