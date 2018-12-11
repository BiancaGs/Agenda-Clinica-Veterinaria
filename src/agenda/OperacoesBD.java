/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pietr
 * 
 */
public class OperacoesBD {
    
    public void inserirAgendamento(Connection conn, Cliente c, Paciente p, Agendamento a, Veterinario v) throws SQLException {
        
        // INSERT SQL
        String insertSQL = "INSERT INTO agendamento (data_agendamento, horario_agendamento, cpf_cliente, nome_paciente, CRMV_veterinario) VALUES (?, ?, ?, ?, ?);";
        
        // Prepara o comando de INSERT
        PreparedStatement stmt = conn.prepareStatement(insertSQL);
        stmt.setString(1, a.getDataAgendamento().toString());
        stmt.setString(2, a.getHorarioAgendamento().toString());
        stmt.setString(3, c.getCPFCliente());
        stmt.setString(4, p.getNomePaciente());
        stmt.setString(5, v.getCRMV());
        
        // Executa a SQL
        stmt.execute();
        
        stmt.close();
        
    }

    public ResultSet buscarVeterinario(Connection conn, String CRMVVeterinario) throws SQLException {
        
        String selectSQL = "SELECT * FROM veterinario WHERE crmv_veterinario = ?;";
        
        PreparedStatement stmt = conn.prepareStatement(selectSQL);
        stmt.setString(1, CRMVVeterinario);
        
        ResultSet rs = stmt.executeQuery();
                
        return rs;
    }
    
    public ResultSet buscarPaciente(Connection conn, String nomePaciente) throws SQLException {
        
        String selectSQL = "SELECT * FROM paciente WHERE nome_paciente = ?;";
        
        PreparedStatement stmt = conn.prepareStatement(selectSQL);
        stmt.setString(1, nomePaciente);
        
        ResultSet rs = stmt.executeQuery();
                
        return rs;
    }
    
    public ResultSet buscarCliente(Connection conn, String CPFCliente) throws SQLException {
        
        String selectSQL = "SELECT * FROM cliente WHERE cpf_cliente = ?;";
        
        PreparedStatement stmt = conn.prepareStatement(selectSQL);
        stmt.setString(1, CPFCliente);
        
        ResultSet rs = stmt.executeQuery();
                
        return rs;
    }
    
    public boolean verificarDisponibilidade(Connection conn, String dataAgendamento, String horarioAgendamento, String CRMV) throws SQLException {

        String verificaSQL = "SELECT * FROM agendamento WHERE data_agendamento = ? AND horario_agendamento = ? AND CRMV_veterinario = ?;";

        PreparedStatement stmt = conn.prepareStatement(verificaSQL);
        stmt.setString(1, dataAgendamento);
        stmt.setString(2, horarioAgendamento);
        stmt.setString(3, CRMV);

        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return true;
        }

        return false;

    }
    
}
