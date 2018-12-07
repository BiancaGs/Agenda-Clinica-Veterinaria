/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author Bianca
 */
public class Agendamento {
    
    // Variáveis
    private LocalDate dataAgendamento;
    private Time horarioAgendamento;
    

    // Construtor
    public Agendamento(LocalDate dataAgendamento, Time horarioAgendamento) {
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
    }

    // Getters
    public Time getHorarioAgendamento() {
        return horarioAgendamento;
    }
    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    // Setters
    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    public void setHorarioAgendamento(Time horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }
    
}
