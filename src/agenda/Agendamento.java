/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bianca
 */
public class Agendamento {
    
    // Variáveis
    private LocalDate dataAgendamento;
    private Time horarioAgendamento;
    

    // Construtor
    public Agendamento() {
        
    }
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


    // Funcões Auxiliares
    public LocalDate toLocalDate(String data) {
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(data, formato);
        
        return dataFormatada;
    }
    
    public Time toTime(String horario) {
        
        SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm");
        Date dataHorario = new Date();
        try {
            dataHorario = formatoH.parse(horario);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        Time horarioFormatado = new Time(dataHorario.getTime());
        
        return horarioFormatado;
    }


    // Funções principais

    public boolean verificarExpediente(Time timeAgendamento){
        
        String inicioExpediente = "08:00:00";
        String fimExpediente = "17:00:00";
        
        String time = timeAgendamento.toString();
        if( time.compareTo(inicioExpediente)>=0 && time.compareTo(fimExpediente)<0 ){
            return true;
        }
        
        return false;
    }
    
    public boolean verificarDisponibilidade(LocalDate dateAgendamento, Time timeAgendamento){
        
        return false;
    }

}
