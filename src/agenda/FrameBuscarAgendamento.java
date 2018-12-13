/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class FrameBuscarAgendamento extends javax.swing.JFrame {
    
    public class Dados {
        private String dataAgendamento, horarioAgendamento, CPFCliente, nomeCliente, nomePaciente, CRMV, nomeVeterinario;
        
        public void setDataAgendamento(String data) {
            dataAgendamento = data;
        }
        public void setHorarioAgendamento(String horario) {
            horarioAgendamento = horario;
        }
        public void setNomeCliente(String nome) {
            nomeCliente = nome;
        }
        public void setNomePaciente(String nome) {
            nomePaciente = nome;
        }       
        public void setNomeVeterinario(String nome) {
            nomeVeterinario = nome;
        }
        
        public String getDataAgendamento() {
            return this.dataAgendamento;
        }
        public String getHorarioAgendamento() {
            return this.horarioAgendamento;
        }
        public String getNomeCliente() {
            return this.nomeCliente;
        }
        public String getNomePaciente() {
            return this.nomePaciente;
        }
        public String getNomeVeterinario() {
            return this.nomeVeterinario;
        }
    }
    /**
     * Creates new form FrameOpcoesBuscar
     */
    public FrameBuscarAgendamento() {
        initComponents();
        formatarCPF();
    }
    
    public List<Dados> listarAgendamentos(String CPFCliente){
        
               
        String visualizarSQL = "SELECT agendamento.data_agendamento, agendamento.horario_agendamento, agendamento.nome_paciente, veterinario.nome_veterinario FROM agendamento JOIN veterinario ON agendamento.CRMV_veterinario = veterinario.CRMV_veterinario JOIN cliente ON agendamento.cpf_cliente = cliente.cpf_cliente WHERE agendamento.cpf_cliente = ?;";
        
        List<Dados> listaDados = new ArrayList<>();
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(visualizarSQL);
            stmt.setString(1, CPFCliente);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Dados dados = new Dados();
                dados.setDataAgendamento(rs.getString("data_agendamento"));
                dados.setHorarioAgendamento(rs.getString("horario_agendamento"));
                //dados.setNomeCliente(rs.getString("nome_cliente"));
                dados.setNomePaciente(rs.getString("nome_paciente"));
                dados.setNomeVeterinario(rs.getString("nome_veterinario"));
              
                // Adiciona os dados na lista de DadosVisualizar
                listaDados.add(dados);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaDados;
    }
    
    // Funcao para imprimir a lista de Agendamentos na jTable
    public void mostrarAgendamentos(String CPF) {
        
        List<Dados> lista = listarAgendamentos(CPF);
        DefaultTableModel modelo = (DefaultTableModel) jTableBusca.getModel();
        modelo.setNumRows(0);

        // Pega o nome do cliente com o CPF dado
        String nomeSQL = "SELECT nome_cliente FROM cliente WHERE cpf_cliente = ?;";
        ResultSet rs = null;
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(nomeSQL);
            stmt.setString(1, CPF);
            
            rs = stmt.executeQuery();
            rs.first();
            jLabelCPF.setText(rs.getString("nome_cliente"));
            
        } catch (SQLException ex) {
            Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Imprime os dados da lista na tabela
        Object rowData[] = new Object[4];
        
        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).dataAgendamento;
            rowData[1] = lista.get(i).horarioAgendamento;
            rowData[2] = lista.get(i).nomePaciente;
            rowData[3] = lista.get(i).nomeVeterinario;
            modelo.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextFieldCPFCliente = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jFormattedTextFieldCPFCliente1 = new javax.swing.JFormattedTextField();
        jButtonBuscarCPF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBusca = new javax.swing.JTable();
        jLabelCPF = new javax.swing.JLabel();

        jFormattedTextFieldCPFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFClienteActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Buscar Agendamento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("CPF Cliente:");

        jButtonVoltar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVoltarMouseClicked(evt);
            }
        });
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jFormattedTextFieldCPFCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFCliente1ActionPerformed(evt);
            }
        });

        jButtonBuscarCPF.setBackground(new java.awt.Color(153, 153, 153));
        jButtonBuscarCPF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonBuscarCPF.setText("Buscar");
        jButtonBuscarCPF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarCPF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuscarCPFMouseClicked(evt);
            }
        });
        jButtonBuscarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCPFActionPerformed(evt);
            }
        });

        jTableBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Horário", "Paciente", "Veterinário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBusca);
        if (jTableBusca.getColumnModel().getColumnCount() > 0) {
            jTableBusca.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableBusca.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldCPFCliente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldCPFCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarCPF)
                            .addComponent(jButtonVoltar))))
                .addGap(18, 18, 18)
                .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldCPFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCPFClienteActionPerformed

    private void jFormattedTextFieldCPFCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCPFCliente1ActionPerformed

    private void jButtonBuscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarCPFActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonBuscarCPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarCPFMouseClicked
        String CPF = jFormattedTextFieldCPFCliente1.getText();
        
        mostrarAgendamentos(CPF);
    }//GEN-LAST:event_jButtonBuscarCPFMouseClicked

    private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVoltarMouseClicked
        new FrameOpcoesAgenda().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonVoltarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBuscarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBuscarAgendamento().setVisible(true);
            }
        });
    }
    
    private void formatarCPF() {
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.install(jFormattedTextFieldCPFCliente1);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo CPF");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarCPF;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPFCliente;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPFCliente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBusca;
    // End of variables declaration//GEN-END:variables
}
