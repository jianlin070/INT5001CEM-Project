/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author jianlin070
 */
public class VisitorRegisterPage extends javax.swing.JFrame {
    
    public static String ic_no, reason;
    public static Date visitDate;
    public static Time visitTime;
    
    
    /**
     * Creates new form LandingForm
     * @param ic
     */
    public VisitorRegisterPage(String ic, Date vDate, Time vTime, String r) {
        initComponents();
        ic_no = ic;
        visitDate = vDate;
        visitTime = vTime;
        reason = r;
        
        if (visitDate != null)
            date_visit.setDate(visitDate.toLocalDate());
        
        if (visitTime != null)
            time_visit.setTime(visitTime.toLocalTime());
        
        txt_reason.setText(reason);
    }
    
    //validate all the fiedls
    public boolean validateField(){
        
        String dateVisit = date_visit.getText();
        boolean validDateVisit =  date_visit.isTextFieldValid();
        String timeVisit = time_visit.getText();
        boolean validTimeVisit =  time_visit.isTextFieldValid();
        String r = txt_reason.getText();
        
        if (dateVisit.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter date of visit");
            return false;
        }
        
        if (!validDateVisit){
         JOptionPane.showMessageDialog(this, "Please enter valid date of visit");
         return false;
        }
        
        if (timeVisit.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter time of visit");
            return false;
        }
        
        if (!validTimeVisit){
         JOptionPane.showMessageDialog(this, "Please enter valid time of visit");
         return false;
        }
        
//      java.sql.Date sqlDate = java.sql.Date.valueOf(date_visit.getDate());
//      SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
//        String dt2 = df.format(sqlDate);
//        txt_reason.setText(sqlDate.toString());
        
        
        if (reason.equals("")){
         JOptionPane.showMessageDialog(this, "Please enter reason");
         return false;
        }
       
//        java.sql.Date sqlDate = java.sql.Date.valueOf(date_visit.getDate());
//        java.sql.Time sqlTime = java.sql.Time.valueOf(time_visit.getTime());
        
        return true;    
    }
    
    //method to insert values into request table
    public void insertSignupDetails(){
        java.sql.Date sqlVisitDate = java.sql.Date.valueOf(date_visit.getDate());
        java.sql.Time sqlVisitTime = java.sql.Time.valueOf(time_visit.getTime());
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Time sqlTime = new java.sql.Time(Calendar.getInstance().getTime().getTime());
        String r = txt_reason.getText();
        String ticketNumber = (ic_no + sqlDate.toString() + sqlTime.toString()).replaceAll("-", "").replaceAll(":","");
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into request(tic_no, visitor_ic, date_visit, time_visit, reason, date_register, time_register) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
  
            pst.setString(1, ticketNumber);
            pst.setString(2, ic_no);
            pst.setDate(3, sqlVisitDate);
            pst.setTime(4, sqlVisitTime);
            pst.setString(5, r);
            pst.setDate(6, sqlDate);
            pst.setTime(7, sqlTime);

            int updatedRowCount = pst.executeUpdate();
            
            if (updatedRowCount > 0){
                JOptionPane.showMessageDialog(this, "Please remember you ticket number! \nYour Ticket Number: " + ticketNumber, "Register successfully", JOptionPane.WARNING_MESSAGE);
           
            }
            else{
                JOptionPane.showMessageDialog(this, "Register fail! Please register again!");
            }
            
        } catch (Exception e){
            e.printStackTrace();
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

        rSCalendarBeanInfo1 = new rojeru_san.componentes.RSCalendarBeanInfo();
        rSCalendarBeanInfo2 = new rojeru_san.componentes.RSCalendarBeanInfo();
        testUtils1 = new com.mysql.cj.util.TestUtils();
        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_homepage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_register = new necesario.RSMaterialButtonCircle();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_reason = new javax.swing.JTextArea();
        date_visit = new com.github.lgooddatepicker.components.DatePicker();
        time_visit = new com.github.lgooddatepicker.components.TimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(950, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bangla Sangam MN", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register Ticket");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(382, 25));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 320, 60));

        btn_homepage.setBackground(new java.awt.Color(153, 153, 153));
        btn_homepage.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btn_homepage.setForeground(new java.awt.Color(255, 255, 255));
        btn_homepage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-register-homepage.png"))); // NOI18N
        btn_homepage.setText("Homepage");
        btn_homepage.setToolTipText("");
        btn_homepage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_homepage.setOpaque(true);
        btn_homepage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homepageMouseClicked(evt);
            }
        });
        btn_homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homepageActionPerformed(evt);
            }
        });
        jPanel1.add(btn_homepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(2000, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Time of Visit");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 140, 30));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-register-time.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, 50));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date of Visit");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 140, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reason");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 140, 30));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-register-date.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 50));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-register-reason.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 50));

        btn_register.setText("Register");
        btn_register.setBackground(new java.awt.Color(153, 153, 153));
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
        jPanel2.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 380, 70));

        txt_reason.setColumns(20);
        txt_reason.setRows(5);
        jScrollPane1.setViewportView(txt_reason);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 760, 140));
        jPanel2.add(date_visit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 220, 40));
        jPanel2.add(time_visit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 220, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 950, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homepageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homepageMouseClicked
        VisitorHomepage home = new VisitorHomepage(ic_no);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homepageMouseClicked

    private void btn_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homepageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homepageActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed

    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseClicked
        if(validateField()){
            insertSignupDetails();
        }
    }//GEN-LAST:event_btn_registerMouseClicked

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
            java.util.logging.Logger.getLogger(VisitorRegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitorRegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitorRegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitorRegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VisitorRegisterPage(ic_no, visitDate, visitTime, reason).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_homepage;
    private necesario.RSMaterialButtonCircle btn_register;
    private com.github.lgooddatepicker.components.DatePicker date_visit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo2;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private com.mysql.cj.util.TestUtils testUtils1;
    private com.github.lgooddatepicker.components.TimePicker time_visit;
    private javax.swing.JTextArea txt_reason;
    // End of variables declaration//GEN-END:variables
}
