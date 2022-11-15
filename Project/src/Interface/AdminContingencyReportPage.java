/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import static Interface.DBConnection.con;
import static Interface.GuardPage.tic_no;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;


/**
 *
 * @author jianlin070
 */
public class AdminContingencyReportPage extends javax.swing.JFrame {
    
    public static String ic_no;
    DefaultTableModel model;

    /**
     * Creates new form LandingForm
     * @param ic
     */
    public AdminContingencyReportPage(String ic) {
        initComponents();
        ic_no = ic;
    }
    
    
    
    //fetch data to the table
    public void fetchDataToTable(java.sql.Date dateFilter, java.sql.Time timeFilter){
        
         PreparedStatement pst;
                 
         try{
            java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/access_control_ms","root","");
            
            if(dateFilter != null && timeFilter != null){
                String sql = "select R.date_visit, R.time_visit, R.tic_no, V.name, R.reason, R.checkin_time, R.checkout_time FROM request R INNER JOIN visitor V ON R.visitor_ic = V.ic WHERE R.date_visit = ? AND R.time_visit = ? AND R.turn_up = 1 ORDER BY R.date_register DESC, R.time_register DESC ";
                pst = con.prepareStatement(sql);

                pst.setDate(1, dateFilter);
                pst.setTime(2, timeFilter);
                
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    Date date_visit = rs.getDate("R.date_visit");
                    Date time_visit = rs.getTime("R.time_visit");
                    tic_no = rs.getString("R.tic_no");
                    String visitor_name = rs.getString("V.name");
                    String reason = rs.getString("R.reason");           
                    Date checkin_time = rs.getTime("R.checkin_time");
                    Date checkout_time = rs.getTime("R.checkout_time");

                    Object[] obj = {tic_no, visitor_name, reason, date_visit, time_visit, checkin_time, checkout_time};
                    model = (DefaultTableModel) tbl_request.getModel();
                    model.addRow(obj);
                }
            
            }
            else if(dateFilter != null &&  timeFilter == null){
                String sql = "select R.date_visit, R.time_visit, R.tic_no, V.name, R.reason, R.checkin_time, R.checkout_time FROM request R INNER JOIN visitor V ON R.visitor_ic = V.ic WHERE R.date_visit = ? AND R.turn_up = 1 ORDER BY R.date_register DESC, R.time_register DESC ";
                pst = con.prepareStatement(sql);

                pst.setDate(1, dateFilter);
                
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    Date date_visit = rs.getDate("R.date_visit");
                    Date time_visit = rs.getTime("R.time_visit");
                    tic_no = rs.getString("R.tic_no");
                    String visitor_name = rs.getString("V.name");
                    String reason = rs.getString("R.reason");               
                    Date checkin_time = rs.getTime("R.checkin_time");
                    Date checkout_time = rs.getTime("R.checkout_time");

                    Object[] obj = {tic_no, visitor_name, reason, date_visit, time_visit, checkin_time, checkout_time};
                    model = (DefaultTableModel) tbl_request.getModel();
                    model.addRow(obj);
                }
            
            }
            else if (timeFilter != null && dateFilter == null) {
                String sql = "select R.date_visit, R.time_visit, R.tic_no, V.name, R.reason, R.checkin_time, R.checkout_time FROM request R INNER JOIN visitor V ON R.visitor_ic = V.ic WHERE R.time_visit = ? AND R.turn_up = 1 ORDER BY R.date_register DESC, R.time_register DESC ";
                pst = con.prepareStatement(sql);

                pst.setTime(1, timeFilter);
                
                ResultSet rs = pst.executeQuery();
            
                while(rs.next()){
                    Date date_visit = rs.getDate("R.date_visit");
                    Date time_visit = rs.getTime("R.time_visit");
                    tic_no = rs.getString("R.tic_no");
                    String visitor_name = rs.getString("V.name");
                    String reason = rs.getString("R.reason");
                    Date checkin_time = rs.getTime("R.checkin_time");
                    Date checkout_time = rs.getTime("R.checkout_time");

                    Object[] obj = {tic_no, visitor_name, reason, date_visit, time_visit, checkin_time, checkout_time};
                    model = (DefaultTableModel) tbl_request.getModel();
                    model.addRow(obj);
                }
            
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
        rSYearDateBeanInfo1 = new rojeru_san.componentes.RSYearDateBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_homepage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_request = new rojerusan.RSTableMetro();
        date_filter = new com.github.lgooddatepicker.components.DatePicker();
        btn_turnup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        time_filter = new com.github.lgooddatepicker.components.TimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bangla Sangam MN", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Contingency Report");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(382, 25));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 440, 60));

        btn_homepage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/visitor-register-homepage.png"))); // NOI18N
        btn_homepage.setText("Homepage");
        btn_homepage.setBackground(new java.awt.Color(153, 153, 153));
        btn_homepage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_homepage.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btn_homepage.setForeground(new java.awt.Color(255, 255, 255));
        btn_homepage.setOpaque(true);
        btn_homepage.setToolTipText("");
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 90));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tic No", "Visitor", "Reason", "Visit Date", "Visit Time", "Entry Time", "Exit Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(tbl_request);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 970, 410));

        date_filter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                date_filterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                date_filterFocusLost(evt);
            }
        });
        date_filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date_filterMouseClicked(evt);
            }
        });
        date_filter.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                date_filterInputMethodTextChanged(evt);
            }
        });
        date_filter.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_filterPropertyChange(evt);
            }
        });
        jPanel2.add(date_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 220, 30));

        btn_turnup.setBackground(new java.awt.Color(102, 102, 102));
        btn_turnup.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_turnup.setForeground(new java.awt.Color(255, 255, 255));
        btn_turnup.setText("Generate to .txt");
        btn_turnup.setToolTipText("");
        btn_turnup.setActionCommand("");
        btn_turnup.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_turnup.setOpaque(true);
        btn_turnup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_turnupFocusGained(evt);
            }
        });
        btn_turnup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_turnupMouseClicked(evt);
            }
        });
        btn_turnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_turnupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_turnup, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 485, 210, 50));

        jLabel2.setFont(new java.awt.Font("Bangla Sangam MN", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Time:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(382, 25));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 15, 80, 40));

        jLabel3.setFont(new java.awt.Font("Bangla Sangam MN", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Date: ");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setPreferredSize(new java.awt.Dimension(382, 25));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, 80, 40));

        time_filter.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                time_filterPropertyChange(evt);
            }
        });
        jPanel2.add(time_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 2000, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homepageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homepageMouseClicked
        AdminHomepage home = new AdminHomepage(ic_no);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homepageMouseClicked

    private void btn_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homepageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homepageActionPerformed

    private void tbl_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requestMouseClicked

    }//GEN-LAST:event_tbl_requestMouseClicked

    private void btn_turnupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_turnupFocusGained

    }//GEN-LAST:event_btn_turnupFocusGained

    private void btn_turnupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_turnupMouseClicked

    }//GEN-LAST:event_btn_turnupMouseClicked

    private void btn_turnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_turnupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_turnupActionPerformed

    private void date_filterInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_date_filterInputMethodTextChanged
       
    }//GEN-LAST:event_date_filterInputMethodTextChanged

    private void date_filterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_filterFocusGained
        
    }//GEN-LAST:event_date_filterFocusGained

    private void date_filterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date_filterMouseClicked
 
    }//GEN-LAST:event_date_filterMouseClicked

    private void date_filterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_filterFocusLost
        
    }//GEN-LAST:event_date_filterFocusLost

    private void date_filterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_filterPropertyChange
        clearTable();
        java.sql.Date sqlDateFilter = null;
        java.sql.Time sqlTimeFilter = null;
        
        if(!date_filter.getText().equals(""))
            sqlDateFilter = java.sql.Date.valueOf(date_filter.getDate());
        
        if(!time_filter.getText().equals(""))
            sqlTimeFilter = java.sql.Time.valueOf(time_filter.getTime());
        
        fetchDataToTable(sqlDateFilter, sqlTimeFilter);
    }//GEN-LAST:event_date_filterPropertyChange

    private void time_filterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_time_filterPropertyChange
        clearTable();
        java.sql.Date sqlDateFilter = null;
        java.sql.Time sqlTimeFilter = null;
        
        if(!date_filter.getText().equals(""))
            sqlDateFilter = java.sql.Date.valueOf(date_filter.getDate());
        
        if(!time_filter.getText().equals(""))
            sqlTimeFilter = java.sql.Time.valueOf(time_filter.getTime());
        
        fetchDataToTable(sqlDateFilter, sqlTimeFilter);
    }//GEN-LAST:event_time_filterPropertyChange

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
            java.util.logging.Logger.getLogger(AdminContingencyReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminContingencyReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminContingencyReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminContingencyReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdminContingencyReportPage(ic_no).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_homepage;
    private javax.swing.JButton btn_turnup;
    private com.github.lgooddatepicker.components.DatePicker date_filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo2;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojeru_san.componentes.RSYearDateBeanInfo rSYearDateBeanInfo1;
    private rojerusan.RSTableMetro tbl_request;
    private com.mysql.cj.util.TestUtils testUtils1;
    private com.github.lgooddatepicker.components.TimePicker time_filter;
    // End of variables declaration//GEN-END:variables
}
