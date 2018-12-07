/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    
}
