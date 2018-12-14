package agenda;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bianca
 * @author Pietro
 */
public class FrameOpcoesAgenda extends javax.swing.JFrame {

    /**
     * Creates new form OpcoesAgenda
     */
    public FrameOpcoesAgenda() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoesOpcoes = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jRadioButtonNovoAgendamento = new javax.swing.JRadioButton();
        jRadioButtonBuscarAgendamento = new javax.swing.JRadioButton();
        jRadioButtonAlterarAgendamento = new javax.swing.JRadioButton();
        jRadioButtonExcluirAgendamento = new javax.swing.JRadioButton();
        jRadioButtonVisualizarAgendamentos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Opções Agendamento");

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
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        grupoBotoesOpcoes.add(jRadioButtonNovoAgendamento);
        jRadioButtonNovoAgendamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonNovoAgendamento.setText("Novo Agendamento");

        grupoBotoesOpcoes.add(jRadioButtonBuscarAgendamento);
        jRadioButtonBuscarAgendamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonBuscarAgendamento.setText("Buscar Agendamento");

        grupoBotoesOpcoes.add(jRadioButtonAlterarAgendamento);
        jRadioButtonAlterarAgendamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonAlterarAgendamento.setText("Alterar Agendamento");
        jRadioButtonAlterarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlterarAgendamentoActionPerformed(evt);
            }
        });

        grupoBotoesOpcoes.add(jRadioButtonExcluirAgendamento);
        jRadioButtonExcluirAgendamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonExcluirAgendamento.setText("Excluir Agendamento");

        grupoBotoesOpcoes.add(jRadioButtonVisualizarAgendamentos);
        jRadioButtonVisualizarAgendamentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonVisualizarAgendamentos.setText("Visualizar Agendamentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 181, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonNovoAgendamento)
                            .addComponent(jRadioButtonAlterarAgendamento)
                            .addComponent(jRadioButtonBuscarAgendamento)
                            .addComponent(jRadioButtonVisualizarAgendamentos)
                            .addComponent(jRadioButtonExcluirAgendamento))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonNovoAgendamento)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonBuscarAgendamento)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonAlterarAgendamento)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonVisualizarAgendamentos)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonExcluirAgendamento)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmarMouseClicked
        // TODO add your handling code here:
        if (jRadioButtonNovoAgendamento.isSelected()) {
            new FrameNovoAgendamento().setVisible(true);
            setVisible(false);
            dispose();
        }
        
        else if (jRadioButtonBuscarAgendamento.isSelected()) {
            new FrameBuscarAgendamento().setVisible(true);
            setVisible(false);
            dispose();
        }
        
        else if (jRadioButtonAlterarAgendamento.isSelected()) {
            new FrameAlterarAgendamento().setVisible(true);
            setVisible(false);
            dispose();
        }
        
        else if (jRadioButtonExcluirAgendamento.isSelected()) {
            new FrameExcluirAgendamento().setVisible(true);
            setVisible(false);
            dispose();
        }
        
        else if (jRadioButtonVisualizarAgendamentos.isSelected()) {
            new FrameVisualizarAgendamentos().setVisible(true);
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_jButtonConfirmarMouseClicked

    private void jRadioButtonAlterarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlterarAgendamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAlterarAgendamentoActionPerformed

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
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
            java.util.logging.Logger.getLogger(FrameOpcoesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameOpcoesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameOpcoesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameOpcoesAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameOpcoesAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotoesOpcoes;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonAlterarAgendamento;
    private javax.swing.JRadioButton jRadioButtonBuscarAgendamento;
    private javax.swing.JRadioButton jRadioButtonExcluirAgendamento;
    private javax.swing.JRadioButton jRadioButtonNovoAgendamento;
    private javax.swing.JRadioButton jRadioButtonVisualizarAgendamentos;
    // End of variables declaration//GEN-END:variables
}
