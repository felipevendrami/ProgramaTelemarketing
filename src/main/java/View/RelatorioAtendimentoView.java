/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Colaborador;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class RelatorioAtendimentoView extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioAtendimentoView
     */
    public RelatorioAtendimentoView() {
        initComponents();
    }
    
    public void preencheRelatorio(String informacao){
        taAtendimentos.append(informacao);
    }
    
    public void limpaTextArea(){
        taAtendimentos.setText("");
    }
    
    public void adicionarAcaoFechar(ActionListener acao){
        btFechar.addActionListener(acao);
    }
    
    public void adicionarAcaoOrdenarPrioridade(ActionListener acao){
        btOrdenarPrioridade.addActionListener(acao);
    }
    
    public void adicionarAcaoFiltroResponsavel(ActionListener acao){
        btFiltroResponsavel.addActionListener(acao);
    }
    
    public void fecharTela(){
        setVisible(false);
    }
    
    public void carregaComboboxColaborador(Colaborador colaborador){
        cbResponsavel.addItem(colaborador);
    }
    
    public Colaborador getResponsavel(){
        return cbResponsavel.getItemAt(cbResponsavel.getSelectedIndex());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btFiltroResponsavel = new javax.swing.JButton();
        btOrdenarPrioridade = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAtendimentos = new javax.swing.JTextArea();
        btFechar = new javax.swing.JButton();
        cbResponsavel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Atendimentos");

        jLabel3.setText("Atendimento > Relatório de Atendimentos");

        jLabel1.setText("Responsável:");

        btFiltroResponsavel.setText("Filtrar Responsável");

        btOrdenarPrioridade.setText("Ordenar por Prioridade");

        taAtendimentos.setEditable(false);
        taAtendimentos.setColumns(20);
        taAtendimentos.setRows(5);
        jScrollPane1.setViewportView(taAtendimentos);

        btFechar.setText("Fechar");

        cbResponsavel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFiltroResponsavel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btOrdenarPrioridade)))
                        .addGap(0, 266, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOrdenarPrioridade)
                    .addComponent(jLabel1)
                    .addComponent(btFiltroResponsavel)
                    .addComponent(cbResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void exibirTelaRelatorioAtendimento(){
        setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(RelatorioAtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioAtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioAtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioAtendimentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioAtendimentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btFiltroResponsavel;
    private javax.swing.JButton btOrdenarPrioridade;
    private javax.swing.JComboBox<Colaborador> cbResponsavel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taAtendimentos;
    // End of variables declaration//GEN-END:variables
}
