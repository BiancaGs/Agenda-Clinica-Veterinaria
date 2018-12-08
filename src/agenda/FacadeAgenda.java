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
        
        if (!agendamento.verificarExpediente(agendamento.getHorarioAgendamento())) {
            JOptionPane.showMessageDialog(null, "Horário fora do Expediente!");
            return;
        }
        
        conn = Conexao.getConnection();
        OperacoesBD op = new OperacoesBD();              

        ResultSet rsV = null;
        try {
            rsV = op.buscarVeterinario(conn, this.veterinario.getCRMV());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veterinario nao Cadastrado!");
        }
                       
        try {
            if (!rsV.next()) {
                JOptionPane.showMessageDialog(null, "Veterinario nao Cadastrado!");    
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacadeAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            op.inserirAgendamento(conn, this.cliente, this.paciente, this.agendamento, this.veterinario);
            JOptionPane.showMessageDialog(null, "Agendamento Realizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Agendamento Não Realizado!");
        }
    
    }
            
            
}
