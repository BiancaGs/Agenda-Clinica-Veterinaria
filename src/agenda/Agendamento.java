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
 * @author Pietro
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

    public String toBRFormat(String data) {
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);

        String dataBR = dia + "/" + mes + "/" + ano;
        return dataBR;
    }

    public String toUSFormat(String data) {
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);

        String dataUS = ano + "-" + mes + "-" + dia;
        return dataUS;
    }

    public LocalDate BRtoLocalDate(String data) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatador);
        return localDate;
    }
    
    public LocalDate UStoLocalDate(String data) {
        LocalDate localDate = LocalDate.parse(data);
        return localDate; 
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
        String fimExpediente = "19:00:00";
        
        String time = timeAgendamento.toString();
        if( time.compareTo(inicioExpediente)>=0 && time.compareTo(fimExpediente)<0 ){
            return true;
        }
        
        return false;
    }

}
