/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

/**
 *
 *
 */
public class frmBody extends javax.swing.JFrame {

    /**
     * Creates new form frmBody
     */
    public frmBody() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jmBodyCadastrar = new javax.swing.JMenu();
        jmiAluno = new javax.swing.JMenuItem();
        jmBodyListar = new javax.swing.JMenu();
        jmBodyProjetos = new javax.swing.JMenu();
        jmBodyRelarotio = new javax.swing.JMenu();
        jmBodyUsuario = new javax.swing.JMenu();
        jmBodySobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jmBodyCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jmBodyCadastrar.setText("Cadastrar");

        jmiAluno.setText("Aluno");
        jmiAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlunoActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiAluno);

        jMenuBar1.add(jmBodyCadastrar);

        jmBodyListar.setForeground(new java.awt.Color(255, 255, 255));
        jmBodyListar.setText("Listar");
        jMenuBar1.add(jmBodyListar);

        jmBodyProjetos.setForeground(new java.awt.Color(255, 255, 255));
        jmBodyProjetos.setText("Projetos");
        jMenuBar1.add(jmBodyProjetos);

        jmBodyRelarotio.setForeground(new java.awt.Color(255, 255, 255));
        jmBodyRelarotio.setText("Relatorios");
        jMenuBar1.add(jmBodyRelarotio);

        jmBodyUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmBodyUsuario.setText("Usuario");
        jMenuBar1.add(jmBodyUsuario);

        jmBodySobre.setForeground(new java.awt.Color(255, 255, 255));
        jmBodySobre.setText("Sobre");
        jMenuBar1.add(jmBodySobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlunoActionPerformed
        // TODO add your handling code here:
        ifrmAlunoCad janela = new ifrmAlunoCad();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_jmiAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(frmBody.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBody.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBody.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBody.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBody().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmBodyCadastrar;
    private javax.swing.JMenu jmBodyListar;
    private javax.swing.JMenu jmBodyProjetos;
    private javax.swing.JMenu jmBodyRelarotio;
    private javax.swing.JMenu jmBodySobre;
    private javax.swing.JMenu jmBodyUsuario;
    private javax.swing.JMenuItem jmiAluno;
    // End of variables declaration//GEN-END:variables
}
