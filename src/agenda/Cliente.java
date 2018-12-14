/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Pietro
 * @author Bianca
 */
public class Cliente {
 
    // Variáveis
    private String CPFCliente;
    private String nomeCliente;
    private String emailCliente;
    private String celularCliente;
    
    
    // Getters
    public String getCPFCliente() {
        return this.CPFCliente;
    }
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    public String getEmailCliente() {
        return this.emailCliente;
    }
    public String getCelularCliente() {
        return this.celularCliente;
    }

    // Setters
    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }
    
}
