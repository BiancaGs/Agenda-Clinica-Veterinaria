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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Pietro
 * @author Bianca
 */
public class FrameVisualizarAgendamentos extends javax.swing.JFrame {

    public class DadosVisualizar {
        private String horarioAgendamento, CPFCliente, nomeCliente, nomePaciente, CRMV, nomeVeterinario;
        
        public void setHorarioAgendamento(String time) {
            horarioAgendamento = time;
        }
        public void setCPFCliente(String CPF) {
            CPFCliente = CPF;
        }
        public void setNomeCliente(String nome) {
            nomeCliente = nome;
        }
        public void setNomePaciente(String nome) {
            nomePaciente = nome;
        }
        public void setCRMV(String crmv) {
            CRMV = crmv;
        }        
        public void setNomeVeterinario(String nome) {
            nomeVeterinario = nome;
        }
        
        public String getHorarioAgendamento() {
            return this.horarioAgendamento;
        }
        public String getCPFCliente() {
            return this.CPFCliente;
        }
        public String getNomeCliente() {
            return this.nomeCliente;
        }
        public String getNomePaciente() {
            return this.nomePaciente;
        }
        public String getCRMV() {
            return this.CRMV;
        }
        public String getNomeVeterinario() {
            return this.nomeVeterinario;
        }

    }
    
    /**
     * Creates new form frameVisualizarAgendamentos
     */
    public FrameVisualizarAgendamentos() {
        initComponents();
        formatarData();
    }

    // Funcao para recuperar a lista com os Agendamentos, dada uma dada
    public List<DadosVisualizar> listarAgendamentos(String dataAgendamento){
        
               
        String visualizarSQL = "SELECT agendamento.horario_agendamento, agendamento.cpf_cliente, cliente.nome_cliente, agendamento.nome_paciente, agendamento.CRMV_veterinario, veterinario.nome_veterinario FROM agendamento JOIN veterinario ON agendamento.CRMV_veterinario = veterinario.CRMV_veterinario JOIN cliente ON agendamento.cpf_cliente = cliente.cpf_cliente WHERE agendamento.data_agendamento = ?;";
        
        List<DadosVisualizar> listaDados = new ArrayList<>();
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(visualizarSQL);
            stmt.setString(1, dataAgendamento);
            
            ResultSet rs = stmt.executeQuery();

            
            while(rs.next()){
                
                DadosVisualizar dados = new DadosVisualizar();
                dados.setHorarioAgendamento(rs.getString("horario_agendamento"));
                dados.setCPFCliente(rs.getString("cpf_cliente"));
                dados.setNomeCliente(rs.getString("nome_cliente"));
                dados.setNomePaciente(rs.getString("nome_paciente"));
                dados.setCRMV(rs.getString("CRMV_veterinario"));
                dados.setNomeVeterinario(rs.getString("nome_veterinario"));
                
                // Adiciona os dados na lista de DadosVisualizar
                listaDados.add(dados);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FrameVisualizarAgendamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return listaDados;
        
    }
    
    
    // Funcao para imprimir a lista de Agendamentos na jTable
    public void mostrarAgendamentos(String dataAgendamento) {
        
        List<DadosVisualizar> lista = listarAgendamentos(dataAgendamento);
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        modelo.setNumRows(0);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Agendamento Encontrado para o dia: '" + jFormattedTextFieldData.getText() + "'!");
            return;
        }

        Object rowData[] = new Object[6];
        
        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).horarioAgendamento;
            rowData[1] = lista.get(i).CPFCliente;
            rowData[2] = lista.get(i).nomeCliente;
            rowData[3] = lista.get(i).nomePaciente;
            rowData[4] = lista.get(i).CRMV;
            rowData[5] = lista.get(i).nomeVeterinario;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Visualizar Agendamentos");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Data:");

        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });

        jButtonConfirmar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonConfirmar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfirmarMouseClicked(evt);
            }
        });
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário", "CPF Cliente", "Nome Cliente", "Nome Paciente", "CRMV Veterinário", "Nome Veterinário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(125);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(175);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonConfirmar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(779, 582));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jButtonConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseClicked
        
        String dataAgendamento = jFormattedTextFieldData.getText();

        if (dataAgendamento.trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Existem Campos Invalidos!\nFavor preencher.");
            return;
        }
        
        Agendamento a = new Agendamento();
        try {
            a.setDataAgendamento(a.BRtoLocalDate(dataAgendamento));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        mostrarAgendamentos(a.getDataAgendamento().toString());


    }//GEN-LAST:event_jButtonConfirmarMouseClicked

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        new FrameOpcoesAgenda().setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

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
            java.util.logging.Logger.getLogger(FrameVisualizarAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameVisualizarAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameVisualizarAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameVisualizarAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameVisualizarAgendamentos().setVisible(true);
            }
        });
    }
    
    private void formatarData() {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.install(jFormattedTextFieldData);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo DATA");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
