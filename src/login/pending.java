/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static login.trainerDashboard.btnTrainer;
import static login.trainerDashboard.lblTrainerID;

/**
 *
 * @author lulli
 */
public class pending extends javax.swing.JFrame {

    /**
     * Creates new form pending
     */
    public pending() {
        initComponents();
        fetchData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPending = new javax.swing.JTable();
        btnAccept = new javax.swing.JLabel();
        btnDecline = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(650, 350));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Name", "User ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPending);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 540, 300));

        btnAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcceptMouseClicked(evt);
            }
        });
        getContentPane().add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 50, 30));

        btnDecline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDecline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeclineMouseClicked(evt);
            }
        });
        getContentPane().add(btnDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 60, 30));

        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pending.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnAcceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcceptMouseClicked
        Connection dbconn = DBConnection.connectDB();
        int selectedRow = tblPending.getSelectedRow();
        String requestID = tblPending.getValueAt(selectedRow, 0).toString();
        String userID = tblPending.getValueAt(selectedRow, 2).toString(); // Assuming user ID is in the third column
        Date currentDate = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        
        calendar.add(Calendar.MONTH, 1);
        
        Date updatedDate = calendar.getTime();
        SimpleDateFormat dFormat = new SimpleDateFormat("MMM d, yyyy");
        String dates = dFormat.format(updatedDate);
            try {
                String trainerID = lblTrainerID.getText();
                String trainerName = btnTrainer.getText();

                PreparedStatement st = dbconn.prepareStatement("UPDATE request SET status = ?, expiration = ? WHERE request_id = ? AND user_id = ? AND trainer_id = ?");
                st.setString(1, "accepted");
                st.setString(2, dates);
                st.setString(3, requestID);
                st.setString(4, userID);
                st.setString(5, trainerID);
                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    // Charge the client
                    PreparedStatement ct = dbconn.prepareStatement("UPDATE balance SET amount = amount + ? WHERE id = ?");
                    ct.setInt(1, 500);
                    ct.setString(2, userID);
                    int rowsUpdatedBalance = ct.executeUpdate();

                    PreparedStatement updateUserStmt = dbconn.prepareStatement("UPDATE users SET trainer = ? WHERE id = ?");
                    updateUserStmt.setString(1, trainerName);
                    updateUserStmt.setString(2, userID);
                    int rowsUpdatedUser = updateUserStmt.executeUpdate();
                    
                    PreparedStatement salary = dbconn.prepareStatement("UPDATE trainers SET salary = salary + ? WHERE id = ?");
                    salary.setInt(1, 500);
                    salary.setString(2, trainerID);
                    int rowsUpdatedSalary = salary.executeUpdate();

                    if (rowsUpdatedBalance > 0 && rowsUpdatedUser > 0 && rowsUpdatedSalary > 0) {
                        JOptionPane.showMessageDialog(this, "Request accepted, client charged, and trainer name updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        fetchData(); // Refresh the table data
                    }
                }

                st.close();
                dbconn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnAcceptMouseClicked

    private void btnDeclineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeclineMouseClicked
            int selectedRow = tblPending.getSelectedRow();
            String requestID = tblPending.getValueAt(selectedRow, 0).toString();
            Connection dbconn = DBConnection.connectDB();
                try {
                    PreparedStatement st = dbconn.prepareStatement("UPDATE request SET status = ? WHERE request_id = ?");
                    st.setString(1, "rejected");
                    st.setString(2, requestID);
                    int rowsAffected = st.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Request rejected successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        fetchData(); // Refresh the table data
                    }

                    st.close();
                    dbconn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }//GEN-LAST:event_btnDeclineMouseClicked

    /**
     * @param args the command line arguments
     */

    private void fetchData() {
        Connection dbconn = DBConnection.connectDB();
            try {
                String trainerID = lblTrainerID.getText();

                PreparedStatement st = dbconn.prepareStatement("SELECT * FROM request WHERE trainer_id = ? AND status = ?");
                st.setString(1, trainerID);
                st.setString(2, "pending");
                ResultSet resultSet = st.executeQuery();
                DefaultTableModel model = (DefaultTableModel) tblPending.getModel();
                model.setRowCount(0); // Clear existing table data
                while (resultSet.next()) {
                    int requestID = resultSet.getInt("request_id");
                    String name = resultSet.getString("name");
                    String userID = resultSet.getString("user_id");
                    String status = resultSet.getString("status");
                    String trainer = resultSet.getString("trainer_id");

                    if (trainer.equals(trainerID)) {
                        model.addRow(new Object[]{requestID, name, userID, status});
                    }
                }
                st.close();
                resultSet.close();
                dbconn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
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
            java.util.logging.Logger.getLogger(pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pending().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAccept;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnDecline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPending;
    // End of variables declaration//GEN-END:variables
}
