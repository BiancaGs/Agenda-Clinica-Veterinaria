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
 * @author Pietro
 * @author Bianca
 */
public class OperacoesBDTest {

    
    @Test
    public void testBuscarVeterinarioEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String CRMVVeterinario = "12325";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarVeterinario(conn, CRMVVeterinario);
        assertEquals(true, resultado.next());
    }


    @Test
    public void testBuscarVeterinarioINEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String CRMVVeterinario = "9999";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarVeterinario(conn, CRMVVeterinario);
        assertEquals(false, resultado.next());
    }


    @Test
    public void testBuscarPacienteEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String nomePaciente = "Pipoca";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarPaciente(conn, nomePaciente);
        assertEquals(true, resultado.next());
    }


    @Test
    public void testBuscarPacienteINEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String nomePaciente = "Bolinha";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarPaciente(conn, nomePaciente);
        assertEquals(false, resultado.next());
    }


    @Test
    public void testBuscarClienteEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String CPFCliente = "444.618.208-07";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarCliente(conn, CPFCliente);
        assertEquals(true, resultado.next());
    }


    @Test
    public void testBuscarClienteINEXISTENTE() throws Exception {
        Connection conn = Conexao.getConnection();
        String CPFCliente = "124.617.456-08";
        OperacoesBD instancia = new OperacoesBD();
        ResultSet resultado = instancia.buscarCliente(conn, CPFCliente);
        assertEquals(false, resultado.next());
    }


    @Test
    public void testVerificarDisponibilidade() throws Exception {
        Connection conn = Conexao.getConnection();
        String dataAgendamento = "2019-12-25";
        String horarioAgendamento = "10:00:00";
        String CRMV = "12325";
        OperacoesBD instancia = new OperacoesBD();
        boolean resultado = instancia.verificarDisponibilidade(conn, dataAgendamento, horarioAgendamento, CRMV);
        assertEquals(true, resultado);
    }

    @Test
    // Verifica datas que ja passaram
    public void testVerificarDisponibilidade2() throws Exception {
        Connection conn = Conexao.getConnection();
        String dataAgendamento = "2018-08-20";
        String horarioAgendamento = "10:00:00";
        String CRMV = "12325";
        OperacoesBD instancia = new OperacoesBD();
        boolean resultado = instancia.verificarDisponibilidade(conn, dataAgendamento, horarioAgendamento, CRMV);
        assertEquals(false, resultado);
    }
    
}
