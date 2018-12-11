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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class FrameAlterar extends javax.swing.JFrame {

    private Agendamento agendamentoAntigo = null;
    private Paciente paciente = null;
    private Veterinario veterinario = null;



    /**
     * Creates new form FrameAlterar
     */
    public FrameAlterar() {
        initComponents();
        formatarData();
        formatarHorario();
        formatarCPF();
    }

    public class DadosAlterar {
        private String dataAgendamento, horarioAgendamento, nomeCliente, nomePaciente, CRMV, nomeVeterinario;
        
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
        public void setCRMV(String crmv) {
            CRMV = crmv;
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

    
    public List<DadosAlterar> listarAgendamentos(String CPFCliente){
        
               
        String visualizarSQL = "SELECT agendamento.data_agendamento, agendamento.horario_agendamento, agendamento.nome_paciente, veterinario.CRMV_veterinario, veterinario.nome_veterinario FROM agendamento JOIN veterinario ON agendamento.CRMV_veterinario = veterinario.CRMV_veterinario JOIN cliente ON agendamento.cpf_cliente = cliente.cpf_cliente WHERE agendamento.cpf_cliente = ?;";
        
        List<DadosAlterar> listaDados = new ArrayList<>();
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(visualizarSQL);
            stmt.setString(1, CPFCliente);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                DadosAlterar dados = new DadosAlterar();
                dados.setDataAgendamento(rs.getString("data_agendamento"));
                dados.setHorarioAgendamento(rs.getString("horario_agendamento"));
                dados.setNomePaciente(rs.getString("nome_paciente"));
                dados.setCRMV(rs.getString("CRMV_veterinario"));
                dados.setNomeVeterinario(rs.getString("nome_veterinario"));
              
                // Adiciona os dados na lista de DadosVisualizar
                listaDados.add(dados);

            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return listaDados;
    }


    // Funcao para imprimir a lista de Agendamentos na jTable
    public void mostrarAgendamentos(String CPF) {
        
        List<DadosAlterar> lista = listarAgendamentos(CPF);
        DefaultTableModel modelo = (DefaultTableModel) jTableAgendamentos.getModel();
        modelo.setNumRows(0);

        // Pega o nome do cliente com o CPF fornecido
        String nomeSQL = "SELECT nome_cliente FROM cliente WHERE cpf_cliente = ?;";
        ResultSet rs = null;
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(nomeSQL);
            stmt.setString(1, CPF);
            
            rs = stmt.executeQuery();
            rs.first();
            jLabelNomeCliente.setText(rs.getString("nome_cliente"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        // Imprime os dados da lista na tabela
        Object rowData[] = new Object[5];
        
        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).dataAgendamento;
            rowData[1] = lista.get(i).horarioAgendamento;
            rowData[2] = lista.get(i).nomePaciente;
            rowData[3] = lista.get(i).CRMV;
            rowData[4] = lista.get(i).nomeVeterinario;
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
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldHorario = new javax.swing.JFormattedTextField();
        jButtonBuscarCPF = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCPFCliente = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jButtonAtualizar = new javax.swing.JButton();
        jLabelNomeCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Alterar Agendamento");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Data:");

        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Horario:");

        jFormattedTextFieldHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldHorarioActionPerformed(evt);
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

        jButtonVoltar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("CPF Cliente: ");

        jFormattedTextFieldCPFCliente.setText("   .   .   -");

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Horário", "Paciente", "CRMV", "Veterinário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jFormattedTextFieldCPFCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jFormattedTextFieldData)
                        .addComponent(jFormattedTextFieldHorario))
                    .addComponent(jLabel1)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscarCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonBuscarCPF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAtualizar)
                            .addComponent(jButtonVoltar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarCPFActionPerformed

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jFormattedTextFieldHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldHorarioActionPerformed

    private void jButtonBuscarCPFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarCPFMouseClicked
        
        String CPF = jFormattedTextFieldCPFCliente.getText();
        
        mostrarAgendamentos(CPF);
        
    }//GEN-LAST:event_jButtonBuscarCPFMouseClicked

    private void jTableAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentosMouseClicked
       
        int posicao = jTableAgendamentos.getSelectedRow();
        TableModel modelo = jTableAgendamentos.getModel();

        String dataAgendamentoTabela = modelo.getValueAt(posicao, 0).toString();
        String horarioAgendamentoTabela = modelo.getValueAt(posicao, 1).toString();
        String nomePacienteTabela = modelo.getValueAt(posicao, 2).toString();
        String CRMVTabela = modelo.getValueAt(posicao, 3).toString();

        
        // Formata a data
        DateTimeFormatter formatoUS = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dataAgendamentoTabela, formatoUS);
        
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatoBR.format(date);


        // Converte o horário
        SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");
        Date dataHorario = new Date();
        try {
            dataHorario = formatoH.parse(horarioAgendamentoTabela);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        Time horarioFormatado = new Time(dataHorario.getTime());
        

        this.agendamentoAntigo = new Agendamento(date, horarioFormatado);
        
        this.paciente = new Paciente();
        this.paciente.setNomePaciente(nomePacienteTabela);

        this.veterinario = new Veterinario();
        this.veterinario.setCRMV(CRMVTabela);

        

        jFormattedTextFieldData.setText(dataFormatada);
        jFormattedTextFieldHorario.setText(horarioFormatado.toString());
        

    }//GEN-LAST:event_jTableAgendamentosMouseClicked

    private void jButtonAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtualizarMouseClicked

        
        Agendamento agendamentoNovo = new Agendamento();
        agendamentoNovo.setDataAgendamento(agendamentoNovo.toLocalDate(jFormattedTextFieldData.getText()));
        agendamentoNovo.setHorarioAgendamento(agendamentoNovo.toTime(jFormattedTextFieldHorario.getText()));


        Cliente cliente = new Cliente();
        cliente.setCPFCliente(jFormattedTextFieldCPFCliente.getText());

        

        OperacoesBD op = new OperacoesBD();
        try {
            Connection conn = Conexao.getConnection();

            System.out.println("Agendamento Antigo:");
            System.out.println(this.agendamentoAntigo.getDataAgendamento().toString());
            System.out.println(this.agendamentoAntigo.getHorarioAgendamento().toString());
            System.out.println("Agendamento Novo:");
            System.out.println(agendamentoNovo.getDataAgendamento().toString());
            System.out.println(agendamentoNovo.getHorarioAgendamento().toString());
            System.out.println("Paciente:");
            System.out.println(this.paciente.getNomePaciente());
            System.out.println("Cliente:");
            System.out.println(cliente.getCPFCliente());
            System.out.println("Veterinario:");
            System.out.println(this.veterinario.getCRMV());


            op.atualizarAgendamento(conn, this.agendamentoAntigo, agendamentoNovo, cliente, this.veterinario, this.paciente);
            
            JOptionPane.showMessageDialog(null, "Agendamento Alterado com Sucesso!");            

            new FrameOpcoesAgenda().setVisible(true);
            setVisible(false);
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na Alteração do Agendamento!");
        }


    }//GEN-LAST:event_jButtonAtualizarMouseClicked

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
            java.util.logging.Logger.getLogger(FrameAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAlterar().setVisible(true);
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
    
    private void formatarHorario() {
        try {
            MaskFormatter mask = new MaskFormatter("##:##:##");
            mask.install(jFormattedTextFieldHorario);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo HORARIO");
        }
    }
    
    private void formatarCPF() {
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.install(jFormattedTextFieldCPFCliente);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo CPF");
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonBuscarCPF;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPFCliente;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JFormattedTextField jFormattedTextFieldHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
