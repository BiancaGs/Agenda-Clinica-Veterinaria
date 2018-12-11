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
    
    // Setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
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
        
        
        // Verifica a disponibilidade do Veterinario
        try {
            if (!op.verificarDisponibilidade(conn, this.agendamento.getDataAgendamento().toString(), this.agendamento.getHorarioAgendamento().toString(), this.veterinario.getCRMV())) {
                JOptionPane.showMessageDialog(null, "Horário Indisponivel nos Agendamentos do Veterinario!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacadeAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rsV = null;
        ResultSet rsC = null;
        ResultSet rsP = null;
        Cliente c = new Cliente();
        Paciente p = new Paciente();
        Veterinario v = new Veterinario();


        // Busca se existe o Veterinário
        try {
            rsV = op.buscarVeterinario(conn, this.veterinario.getCRMV());
            if (!rsV.next()) {
                JOptionPane.showMessageDialog(null, "Veterinario Inexistente!");    
                return;
            }
            else {
                rsV.first();
                v.setNomeVeterinario(rsV.getString("nome_veterinario"));
                v.setCRMV(rsV.getString("CRMV_veterinario"));
                v.setCelularVeterinario(rsV.getString("celular_veterinario"));
                v.setEmailVeterinario(rsV.getString("email_veterinario"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veterinario Inexistente!");
        }
        
        //Busca se existe o Paciente
        try {
            rsP = op.buscarPaciente(conn, this.paciente.getNomePaciente());
            if (!rsP.next()) {
                JOptionPane.showMessageDialog(null, "Paciente Inexistente!");    
                return;
            }
            else {
                rsP.first();
                p.setNomePaciente(rsP.getString("nome_paciente"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente Inexistente!");
        }
        
        //Busca se existe o Cliente
        try {
            rsC = op.buscarCliente(conn, this.cliente.getCPFCliente());
            if (!rsC.next()) {
                JOptionPane.showMessageDialog(null, "Cliente Inexistente!");    
                return;
            }
            else {
                rsC.first();
                c.setNomeCliente(rsC.getString("nome_cliente"));
                c.setCPFCliente(rsC.getString("cpf_cliente"));
                c.setCelularCliente(rsC.getString("celular_cliente"));
                c.setEmailCliente(rsC.getString("email_cliente"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente Inexistente!");
        }
        
        new FrameConfirmarAgendamento(c, p, v, this.agendamento).setVisible(true);
    
    }
            
            
}
