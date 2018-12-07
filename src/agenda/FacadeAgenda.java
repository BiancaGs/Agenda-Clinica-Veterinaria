package agenda;

import java.time.LocalDate;

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
    Agenda agenda = null;
    
    // Construtor
    public FacadeAgenda(Cliente c, Paciente p, Veterinario v, Agenda a) {
        this.agenda = a;
        this.cliente = c;
        this.paciente = p;
        this.veterinario = v;
    }
    
    
    public static void main(String[] args){
        new FrameOpcoesAgenda().setVisible(true);
    }
    
    public void agendarAgendamento(Cliente c, Paciente p, Veterinario v, LocalDate d) {

        
        OperacoesBD op = new OperacoesBD();
        op.inserirAgendamento(conn, c, p, v, a);
    }
            
            
}
