/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import arvore.*;
import java.util.Arrays;

/**
 *
 * @author Fernando
 */
public class TelaImagem extends javax.swing.JFrame {

    /**
     * Creates new form TelaImagem
     */
    public TelaImagem() {
        initComponents();
        inicializa();
        botoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botao1 = new javax.swing.JButton();
        botao2 = new javax.swing.JButton();
        botao3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(275, 320));
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        botao1.setToolTipText("");
        botao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1ActionPerformed(evt);
            }
        });
        getContentPane().add(botao1);

        botao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2ActionPerformed(evt);
            }
        });
        getContentPane().add(botao2);
        getContentPane().add(botao3);
        getContentPane().add(jButton1);
        getContentPane().add(jButton2);
        getContentPane().add(jButton3);
        getContentPane().add(jButton4);
        getContentPane().add(jButton5);

        jButton6.setText("Coringa");
        getContentPane().add(jButton6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao1ActionPerformed
        String txt = botao1.getIcon().toString();
        tree.trocar(n6);
        botoes();
    }//GEN-LAST:event_botao1ActionPerformed

    private void botao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao2ActionPerformed
        String txt = botao2.getIcon().toString();
        tree.trocar(n7);
        botoes();
    }//GEN-LAST:event_botao2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaImagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaImagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaImagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaImagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaImagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao1;
    private javax.swing.JButton botao2;
    private javax.swing.JButton botao3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    // End of variables declaration//GEN-END:variables

    public void botoes() {
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(n1.getIcone())));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(n2.getIcone())));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(n3.getIcone())));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource(n4.getIcone())));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource(n5.getIcone())));
        botao1.setIcon(new javax.swing.ImageIcon(getClass().getResource(n6.getIcone())));
        botao2.setIcon(new javax.swing.ImageIcon(getClass().getResource(n7.getIcone())));
        botao3.setIcon(new javax.swing.ImageIcon(getClass().getResource(n8.getIcone())));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource(n9.getIcone())));

    }
    static String vetor[] = {"/1.png", "/2.png", "/3.png", "/4.png", "/5.png", "/6.png", "/7.png", "/8.png"};
    
    Arvore tree = new Arvore();
    Node n1 = new Node(vetor[0]);
    Node n2 = new Node(vetor[1]);
    Node n3 = new Node(vetor[2]);
    Node n4 = new Node(vetor[3]);
    Node n5 = new Node(vetor[4]);
    Node n6 = new Node(vetor[5]);
    Node n7 = new Node(vetor[6]);
    Node n8 = new Node(vetor[7]);
    Node n9 = new Node("");

    public void inicializa() {
        Arrays.sort (vetor);
        tree.inserirSemRecursividade(n1);
        tree.inserirSemRecursividade(n2);
        tree.inserirSemRecursividade(n3);
        tree.inserirSemRecursividade(n4);
        tree.inserirSemRecursividade(n5);
        tree.inserirSemRecursividade(n6);
        tree.inserirSemRecursividade(n7);
        tree.inserirSemRecursividade(n8);
        tree.inserirSemRecursividade(n9);
        tree.setNulo(n9);
    }
}
