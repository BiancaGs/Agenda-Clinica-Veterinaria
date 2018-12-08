package agenda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bianca
 */
public class FacadeAgenda {
    
    // Variáveis de Instância
    Cliente cliente = null;
    Paciente paciente = null;
    Veterinario veterinario = null;
    Agendamento agendamento = null;
    
    private Connection conn;
    
    // Construtor
    public FacadeAgenda(Cliente c, Paciente p, Veterinario v, Agendamento a) {
        this.agendamento = a;
        this.cliente = c;
        this.paciente = p;
        this.veterinario = v;
    }
    
    public static void main(String[] args){
        new FrameOpcoesAgenda().setVisible(true);
    }
    
    public void agendarAgendamento() {
        
        // Verifica se o agendamento está no expediente da Clínica
        if (!agendamento.verificarExpediente(agendamento.getHorarioAgendamento())) {
            JOptionPane.showMessageDialog(null, "Horário fora do Expediente!");
            return;
        }
        

        // Recupera a conexão
        conn = Conexao.getConnection();
        OperacoesBD op = new OperacoesBD();              


        // Busca se existe o Veterinário
        ResultSet rsV = null;
        try {
            rsV = op.buscarVeterinario(conn, this.veterinario.getCRMV());
            if (!rsV.next()) {
                JOptionPane.showMessageDialog(null, "Veterinario Inexistente!");    
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veterinario Inexistente!");
        }
        
        //Busca se existe o Paciente
        try {
            rsV = op.buscarPaciente(conn, this.paciente.getNomePaciente());
            if (!rsV.next()) {
                JOptionPane.showMessageDialog(null, "Paciente Inexistente!");    
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente Inexistente!");
        }
        
        // Prossegue com a Inserção
        try {
            op.inserirAgendamento(conn, this.cliente, this.paciente, this.agendamento, this.veterinario);
            JOptionPane.showMessageDialog(null, "Agendamento Realizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Agendamento Não Realizado!");
        }
    
    }
            
            
}
