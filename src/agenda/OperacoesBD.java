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
    
//    public Veterinario buscarVeterinario(Connection conn, String CRMVVeterinario) throws SQLException {
//        
//        String selectSQL = "SELECT * FROM veterinario WHERE crmv_veterinario = '?';";
//        Veterinario vet = null;
//
//        PreparedStatement stmt = conn.prepareStatement(selectSQL);
//        stmt.setString(1, CRMVVeterinario);
//        
//        ResultSet rs = null;
//        rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            vet = new Veterinario();
//            vet.setCRMV(rs.getString("crmv_veterinario"));
//            vet.setNomeVeterinario(rs.getString("nome_veterinario"));
//            vet.setCelularVeterinario(rs.getString("celular_veterinario"));
//            vet.setEmailVeterinario(rs.getString("email_veterinario"));
//        }
//
//        rs.close();
//        stmt.close();
//
//        return vet;        
//    }
    public ResultSet buscarVeterinario(Connection conn, String CRMVVeterinario) throws SQLException {
        
        String selectSQL = "SELECT * FROM veterinario WHERE crmv_veterinario = '?';";
        
        PreparedStatement stmt = conn.prepareStatement(selectSQL);
        stmt.setString(1, CRMVVeterinario);
        
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
    
    
}
