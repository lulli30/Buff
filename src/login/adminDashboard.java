/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author lulli
 */
public class adminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public adminDashboard() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnList = new javax.swing.JLabel();
        btnListTrainer = new javax.swing.JLabel();
        btnAddTrainer = new javax.swing.JLabel();
        btnPayment = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdmin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(204, 204, 204));
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("ADMIN");
        getContentPane().add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 60, 20));

        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 30));

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 20));

        btnList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListMouseClicked(evt);
            }
        });
        getContentPane().add(btnList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 20));

        btnListTrainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListTrainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListTrainerMouseClicked(evt);
            }
        });
        btnListTrainer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnListTrainerKeyPressed(evt);
            }
        });
        getContentPane().add(btnListTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 190, 30));

        btnAddTrainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddTrainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTrainerMouseClicked(evt);
            }
        });
        btnAddTrainer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddTrainerKeyPressed(evt);
            }
        });
        getContentPane().add(btnAddTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, 30));

        btnPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentMouseClicked(evt);
            }
        });
        btnPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPaymentKeyPressed(evt);
            }
        });
        getContentPane().add(btnPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 30));

        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin dashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        new updateDelete().setVisible(true);
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to Logout", "Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new login().setVisible(true);
            }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListMouseClicked
        new listMember().setVisible(true);
    }//GEN-LAST:event_btnListMouseClicked

    private void btnPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPaymentKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentKeyPressed

    private void btnPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentMouseClicked
        new paymentListAdmin().setVisible(true);
    }//GEN-LAST:event_btnPaymentMouseClicked

    private void btnAddTrainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTrainerMouseClicked
        new addTrainer().setVisible(true);
    }//GEN-LAST:event_btnAddTrainerMouseClicked

    private void btnAddTrainerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddTrainerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTrainerKeyPressed

    private void btnListTrainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListTrainerMouseClicked
        new listTrainer().setVisible(true);
    }//GEN-LAST:event_btnListTrainerMouseClicked

    private void btnListTrainerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnListTrainerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListTrainerKeyPressed

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddTrainer;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnList;
    private javax.swing.JLabel btnListTrainer;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnPayment;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JLabel jLabel1;
    public static final javax.swing.JLabel lblAdmin = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
