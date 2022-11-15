/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;


/**
 *
 * @author jianlin070
 */
public class VisitorHomepage extends javax.swing.JFrame {
    
    public static String ic_no;

    /**
     * Creates new form LandingForm
     * @param ic
     */
    public VisitorHomepage(String ic) {
        initComponents();
        ic_no = ic;      
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_check_status = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setSize(new java.awt.Dimension(950, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Bangla Sangam MN", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Visitor Homepage");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(382, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(2000, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_check_status.setBackground(new java.awt.Color(153, 153, 255));
        btn_check_status.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_check_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ticket-icon.png"))); // NOI18N
        btn_check_status.setText("Check Status");
        btn_check_status.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_check_status.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_check_status.setIconTextGap(40);
        btn_check_status.setOpaque(true);
        btn_check_status.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_check_status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_check_statusMouseClicked(evt);
            }
        });
        btn_check_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_check_statusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_check_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 270, 260));

        btn_register.setBackground(new java.awt.Color(153, 153, 255));
        btn_register.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registered-icon.png"))); // NOI18N
        btn_register.setText("Register");
        btn_register.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_register.setIconTextGap(40);
        btn_register.setOpaque(true);
        btn_register.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registerMouseClicked(evt);
            }
        });
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        jPanel2.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 270, 260));

        btn_logout.setBackground(new java.awt.Color(153, 153, 153));
        btn_logout.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-homepage-logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_logout.setOpaque(true);
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel2.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 162, 950, 478));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_check_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_check_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_check_statusActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseClicked
        VisitorRegisterPage register = new VisitorRegisterPage(ic_no, null, null, null);
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_registerMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        VisitorLoginPage login = new VisitorLoginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_check_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_check_statusMouseClicked
        VisitorCheckStatusPage check = new VisitorCheckStatusPage(ic_no);
        check.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_check_statusMouseClicked

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
            java.util.logging.Logger.getLogger(VisitorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitorHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisitorHomepage(ic_no).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_check_status;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
