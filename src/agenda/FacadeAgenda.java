package agenda;

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
    
    
    public static void main(String[] args){
        new FrameOpcoesAgenda().setVisible(true);
    }
}
