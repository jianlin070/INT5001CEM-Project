/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import static Interface.DBConnection.con;
import com.mysql.cj.xdevapi.Statement;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;


/**
 *
 * @author jianlin070
 */
public class OfficerPage extends javax.swing.JFrame {
    
    public static String ic_no;
    public static String declined_reason = "";
    DefaultTableModel model;
    public static String tic_no;
    public static String status;
    
    
    /**
     * Creates new form LandingForm
     * @param ic
     */
    public OfficerPage(String ic) {
        initComponents();
        ic_no = ic;
        fetchDataToTable();
    }
    
    //calculate difference of 2 dates in minute
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    //fetch data to the table
    public void fetchDataToTable(){
        
        int count = 0;
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/access_control_ms","root","");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select R.date_register, R.time_register, R.tic_no, V.name, R.date_visit, R.time_visit, R.reason, R.status, R.declined_reason, R.officer_name, R.date_verify, R.time_verify FROM request R INNER JOIN visitor V ON R.visitor_ic = V.ic WHERE R.status = 0 ORDER BY R.date_register DESC, R.time_register DESC");

 
            
            while(rs.next()){
                Date date_register = rs.getDate("R.date_register");
                Date time_register = rs.getTime("R.time_register");
                tic_no = rs.getString("R.tic_no");
                String visitor_name = rs.getString("V.name");
                Date date_visit = rs.getDate("R.date_visit");
                Date time_visit = rs.getTime("R.time_visit");
                String reason = rs.getString("R.reason");
                String status = rs.getString("R.status");
                String statusStr = "";
                if(status.equals("0")){
                    statusStr = "Pending";
                }
                else if(status.equals("1")){
                    statusStr = "Approved";
                }
                else {
                    statusStr = "Declined";
                }
                String declined_reason = rs.getString("R.declined_reason");
                String officer_name = rs.getString("R.officer_name");
                Date date_update = rs.getDate("R.date_verify");
                Date time_update = rs.getTime("R.time_verify");
                
                Object[] obj = {date_register, time_register, tic_no, visitor_name, date_visit, time_visit, reason, statusStr, declined_reason, officer_name, date_update, time_update};
                model = (DefaultTableModel) tbl_request.getModel();
                model.addRow(obj);
                
       
                java.sql.Date dateNow = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                
                 
                tbl_request.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        
                        java.sql.Date dateVisit =  java.sql.Date.valueOf(table.getValueAt(row, 4).toString());
                        long dateDiff = getDateDiff(dateNow,dateVisit,TimeUnit.DAYS);
                       
                        if(dateDiff<3){
                            c.setBackground(Color.red);
                            c.setFont(new java.awt.Font("Helvetica Neue", 1, 12));
                            c.setForeground(new java.awt.Color(0, 112, 192));
                        }
                        else{
                            c.setBackground(Color.white);
                            c.setFont(new java.awt.Font("Helvetica Neue", 1, 12));
                            c.setForeground(new java.awt.Color(0, 112, 192));
                        }
                    
                        return c;
                    }
                });
                
               
                

           
                
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
  
    //clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_request.getModel();
        model.setRowCount(0);
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
        btn_logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_approve = new javax.swing.JButton();
        btn_decline = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_request = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 660));
        setSize(new java.awt.Dimension(1000, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bangla Sangam MN", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Security Officer Page");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(382, 25));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 440, 60));

        btn_logout.setBackground(new java.awt.Color(153, 153, 153));
        btn_logout.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-homepage-logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.setToolTipText("");
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
        jPanel1.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 90));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_approve.setBackground(new java.awt.Color(0, 204, 0));
        btn_approve.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_approve.setForeground(new java.awt.Color(255, 255, 255));
        btn_approve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-monthly-report-page-approve.png"))); // NOI18N
        btn_approve.setText("Approve");
        btn_approve.setToolTipText("");
        btn_approve.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_approve.setOpaque(true);
        btn_approve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_approveMouseClicked(evt);
            }
        });
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 120, 80));

        btn_decline.setBackground(new java.awt.Color(255, 51, 51));
        btn_decline.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_decline.setForeground(new java.awt.Color(255, 255, 255));
        btn_decline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-monthly-report-page-cross.png"))); // NOI18N
        btn_decline.setText("Decline");
        btn_decline.setToolTipText("");
        btn_decline.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_decline.setOpaque(true);
        btn_decline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_declineMouseClicked(evt);
            }
        });
        btn_decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_declineActionPerformed(evt);
            }
        });
        jPanel2.add(btn_decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 120, 80));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Tic No", "Visitor", "Date Visit", "Time Visit", "Reason", "Status", "Declined Reason", "Last Update", "Date Update", "Time Update"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_request.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbl_request.setAutoscrolls(false);
        tbl_request.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_request.setColorSelBackgound(new java.awt.Color(0, 51, 204));
        tbl_request.setFont(new java.awt.Font("Helvetica Neue", 0, 9)); // NOI18N
        tbl_request.setFuenteHead(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        tbl_request.setRowHeight(40);
        tbl_request.setShowHorizontalLines(true);
        tbl_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_requestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_request);
        if (tbl_request.getColumnModel().getColumnCount() > 0) {
            tbl_request.getColumnModel().getColumn(1).setMaxWidth(90);
            tbl_request.getColumnModel().getColumn(2).setMinWidth(150);
            tbl_request.getColumnModel().getColumn(3).setMinWidth(60);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 970, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 2000, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        StaffLoginPage login = new StaffLoginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_approveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_approveMouseClicked
       
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure to approve?");

        if(confirmation == 0){
            
            String name = "-";
                    
            try{
                Connection con = DBConnection.getConnection();
                String sql = "select name from staff where ic = ?";
                PreparedStatement pst = con.prepareStatement(sql);
            
                pst.setString(1, ic_no);
                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){  
                    name = rs.getString("name");
                }
                
                java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                java.sql.Time sqlTime = new java.sql.Time(Calendar.getInstance().getTime().getTime());
                
               
                sql = "update request set status = ?, declined_reason = ?, officer_name = ?, date_verify = ?, time_verify = ? where tic_no = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, 1);
                pst.setString(2, "-");
                pst.setString(3, name);
                pst.setDate(4, sqlDate);
                pst.setTime(5, sqlTime);
                pst.setString(6, tic_no);
                int rowCount = pst.executeUpdate();
                
                if(rowCount > 0){
                    JOptionPane.showMessageDialog(this, "Status updated to Approaved");
                    clearTable();
                    fetchDataToTable();
                }else{
                    JOptionPane.showMessageDialog(this, "Status updation failed");
                }
                
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_btn_approveMouseClicked

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_approveActionPerformed

    private void btn_declineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_declineMouseClicked
        
        declined_reason = "";
                
        while (declined_reason.replaceAll("\\s", "").equals("")){
            declined_reason = JOptionPane.showInputDialog(this, "Please enter the reason of Declined");
        }
        
  
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure to decline?");
        
        if(confirmation == 0){
            String name = "-";
                    
            try{
                Connection con = DBConnection.getConnection();
                String sql = "select name from staff where ic = ?";
                PreparedStatement pst = con.prepareStatement(sql);
            
                pst.setString(1, ic_no);
                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){  
                    name = rs.getString("name");
                }
                
                java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                java.sql.Time sqlTime = new java.sql.Time(Calendar.getInstance().getTime().getTime());
               
                sql = "update request set status = ?, declined_reason = ?, officer_name = ?, date_verify = ?, time_verify = ? where tic_no = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, 2);
                pst.setString(2, declined_reason);
                pst.setString(3, name);
                pst.setDate(4, sqlDate);
                pst.setTime(5, sqlTime);
                pst.setString(6, tic_no);
                int rowCount = pst.executeUpdate();
                
                if(rowCount > 0){
                    JOptionPane.showMessageDialog(this, "Status updated to Declined");
                    clearTable();
                    fetchDataToTable();
                }else{
                    JOptionPane.showMessageDialog(this, "Status updation failed");
                }
                
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_btn_declineMouseClicked

    private void btn_declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_declineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_declineActionPerformed

    private void tbl_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requestMouseClicked

        btn_approve.setEnabled(true);
        btn_decline.setEnabled(true);
        
        int rowNo = tbl_request.getSelectedRow();
        TableModel model = tbl_request.getModel();
        
        tic_no = model.getValueAt(rowNo, 2).toString();
        status = model.getValueAt(rowNo, 6).toString();
        
        if (model.getValueAt(rowNo, 6).equals("Declined")){
            btn_decline.setEnabled(false);
        }
        
        if (model.getValueAt(rowNo, 6).equals("Approved")){
            btn_approve.setEnabled(false);
        }
        
        
       
        
    }//GEN-LAST:event_tbl_requestMouseClicked

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
            java.util.logging.Logger.getLogger(OfficerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfficerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfficerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfficerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new OfficerPage(ic_no).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_decline;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo2;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojerusan.RSTableMetro tbl_request;
    private com.mysql.cj.util.TestUtils testUtils1;
    // End of variables declaration//GEN-END:variables
}

class MyTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Color getBackground() {
        return super.getBackground();
    }
}
