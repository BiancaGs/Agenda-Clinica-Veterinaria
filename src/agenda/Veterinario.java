/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author pietr
 */
public class Veterinario {
    
    // Variáveis
    private String CRMV;
    private String nomeVeterinario;
    private String emailVeterinario;
    private String celularVeterinario;

    // Getters
    public String getCRMV() {
        return CRMV;
    }
    public String getNomeVeterinario() {
        return nomeVeterinario;
    }
    public String getEmailVeterinario() {
        return emailVeterinario;
    }
    public String getCelularVeterinario() {
        return celularVeterinario;
    }

    // Setters
    public void setCRMV(String CRMV) {
        this.CRMV = CRMV;
    }
    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }
    public void setEmailVeterinario(String emailVeterinario) {
        this.emailVeterinario = emailVeterinario;
    }
    public void setCelularVeterinario(String celularVeterinario) {
        this.celularVeterinario = celularVeterinario;
    }
    
}
