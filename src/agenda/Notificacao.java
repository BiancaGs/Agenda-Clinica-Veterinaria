/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author Bianca
 */
public class Notificacao {
    
    // Variaveis
    private String emailDestinatario;
    private String assunto;
    private String mensagem;
    
    // Getters
    public String getEmailDestinatario() {
        return emailDestinatario;
    }
    public String getAssunto() {
        return assunto;
    }
    public String getMensagem() {
        return mensagem;
    }

    // Setters
    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    public void enviarEmail() {
                    
        String  host        = "smtp.gmail.com";
        String  user        = "clinicaveterinaria132@gmail.com";
        String  senha       = "ClinicaVet123";

        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.host", host);
        propriedades.put("mail.smtp.socketFactory.port", "465");
        propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.port", "465");

        Session sessaoEmail = Session.getDefaultInstance(propriedades,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, senha);
                    }
                });

        // Envio da mensagem
        try {
            MimeMessage msg = new MimeMessage(sessaoEmail);
            msg.setFrom(new InternetAddress(user));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.emailDestinatario));
            msg.setSubject(this.assunto);
            msg.setContent(this.mensagem, "text/plain; charset=utf-8");
                    
            // Envia a mensagem
            Transport.send(msg);
                    
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    
}
