/*:
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import static Interface.DBConnection.con;
import java.sql.*; 
import javax.swing.JOptionPane;


/**
 *
 * @author jianlin070
 */
public class VisitorSignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public VisitorSignupPage() {
        initComponents();
    }
    
    //method to insert values into visitor table
    public void insertSignupDetails(){
        String ic_no =  txt_ic_no.getText();
        String password = txt_password.getText();
        String full_name = txt_full_name.getText();
        String contact = txt_contact.getText();
        String company = txt_company.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into visitor(ic,password,name,contact,company) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            
            pst.setString(1, ic_no);
            pst.setString(2, password);
            pst.setString(3, full_name);
            pst.setString(4, contact);
            pst.setString(5, company);
            
            int updatedRowCount = pst.executeUpdate();
            
            if (updatedRowCount > 0){
                JOptionPane.showMessageDialog(this, "Signup successfully! You may prcoeed to login.");
                VisitorLoginPage login = new VisitorLoginPage();
                login.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Signup fail! Please try again!");
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }           
    }
    
    //validation for Signup
    public boolean validateSignup(){
        String ic_no =  txt_ic_no.getText();
        String password = txt_password.getText();
        String full_name = txt_full_name.getText();
        String contact = txt_contact.getText();
        String company = txt_company.getText();
        
        if (ic_no.equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter IC Number");
            return false;
        }
        
        if (!ic_no.matches("^\\d{6}[-]?\\d{2}[-]?\\d{4}$") ){
            JOptionPane.showMessageDialog(this, "Please enter valid IC number");
            return false;
        }
        
        if (password.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter password");
            return false;
        }
        
        if (full_name.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter full name");
            return false;
        }
        
        if (contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter contact number");
            return false;
        }
        
        if (company.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter company");
            return false;
        }
        
        return true;    
    }
    
    //check duplicate visitors(IC)
    public boolean checkDuplicateVisitor(){
        String ic_no = txt_ic_no.getText();
        boolean isExist = false;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/access_control_ms","root","");
            
            PreparedStatement pst = con.prepareStatement("select * from visitor where ic = ?");
            pst.setString(1, ic_no);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                isExist = true;
            }else{
                isExist = false;
            }
            
            
        }catch (Exception e){
            
        }
        
        return isExist;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        evaluatorByte1 = new org.jdesktop.core.animation.timing.evaluators.EvaluatorByte();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        txt_ic_no = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_full_name = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_company = new app.bolivia.swing.JCTextField();
        btn_login = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        btn_signup = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signup-login-access.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 250, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 70)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ACMS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 710));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        txt_ic_no.setBackground(new java.awt.Color(102, 153, 255));
        txt_ic_no.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_ic_no.setPlaceholder("Enter IC Number ...");
        txt_ic_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ic_noFocusLost(evt);
            }
        });
        txt_ic_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ic_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_ic_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 310, 30));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Create New Account Here");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-signup.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 50));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IC Number");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password-signup.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 50));

        txt_password.setBackground(new java.awt.Color(102, 153, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setPlaceholder("Enter Password ...");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 310, 30));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Full Name");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ic-signup.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, 50));

        txt_full_name.setBackground(new java.awt.Color(102, 153, 255));
        txt_full_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_full_name.setPlaceholder("Enter Full Name ...");
        txt_full_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_full_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 310, 30));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact Number");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contact-signup.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, 50));

        txt_contact.setBackground(new java.awt.Color(102, 153, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setPlaceholder("Enter Contact Number ...");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 310, 30));

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Company");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, -1));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/company-signup.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, 50));

        txt_company.setBackground(new java.awt.Color(102, 153, 255));
        txt_company.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_company.setPlaceholder("Enter Company ...");
        txt_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_companyActionPerformed(evt);
            }
        });
        jPanel2.add(txt_company, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 310, 30));

        btn_login.setBackground(new java.awt.Color(51, 51, 51));
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 240, 70));

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Visitor Signup");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 30, -1, -1));

        btn_signup.setBackground(new java.awt.Color(255, 0, 51));
        btn_signup.setText("Signup");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 240, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 600, 710));

        setSize(new java.awt.Dimension(960, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ic_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ic_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ic_noActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_full_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_full_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_full_nameActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void txt_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_companyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_companyActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        VisitorLoginPage login = new VisitorLoginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
       if(validateSignup() == true){
           if(checkDuplicateVisitor() == false){
                insertSignupDetails();
           }
           else{
               JOptionPane.showMessageDialog(this, "IC Number already exist");
           }
       }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        LandingPage landing = new LandingPage();
        landing.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void txt_ic_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ic_noFocusLost
       if(checkDuplicateVisitor() == true){
           JOptionPane.showMessageDialog(this, "IC Number already exist");
       }
    }//GEN-LAST:event_txt_ic_noFocusLost

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
            java.util.logging.Logger.getLogger(VisitorSignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitorSignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitorSignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitorSignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new VisitorSignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private necesario.RSMaterialButtonCircle btn_login;
    private necesario.RSMaterialButtonCircle btn_signup;
    private org.jdesktop.core.animation.timing.evaluators.EvaluatorByte evaluatorByte1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField txt_company;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_full_name;
    private app.bolivia.swing.JCTextField txt_ic_no;
    private app.bolivia.swing.JCTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
