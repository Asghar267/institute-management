package school_management;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

//import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author asgha
 */
public class Add_Courses_page extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection Sqlconnection = Connect.ConnectDB();
    PreparedStatement prepared_statement = null;
    ResultSet result_set = null;

    /**
     * Creates new form updatecourse_page
     */
    public Add_Courses_page() {
        initComponents();
        setcourseTable();
    }

    public void deletecourse() {
        int courseid = Integer.parseInt(courseidtxt.getText());

        try {
            prepared_statement = Sqlconnection.prepareStatement("delete from courses where courseid = ?");
            prepared_statement.setInt(1, courseid);
//            rs = prepared_statement.executeUpdate();
            prepared_statement.executeUpdate();
            coursenametxt.setText("");
            courseidtxt.setText("");
            coursepricetxt.setText("");

        } catch (SQLException ex) {
        }

    }

    public void insertdata() {
        try {
            prepared_statement = Sqlconnection.prepareStatement("insert into courses(course_name,cost, duration ,courseid)"
                    + "values(?,?,?,?)");

            String coursename = coursenametxt.getText();
            int courseid = Integer.parseInt(courseidtxt.getText());
            String courseprice = coursepricetxt.getText();
            String duration = (String) jComboBox1.getSelectedItem();

            prepared_statement.setString(1, coursename);
            prepared_statement.setString(2, courseprice);
            prepared_statement.setString(3, duration);
            prepared_statement.setInt(4, courseid);

            prepared_statement.executeUpdate();

            coursenametxt.setText("");
            courseidtxt.setText("");
            coursepricetxt.setText("");

        } catch (NumberFormatException | SQLException ex) {
        }

    }

    public void cleartable() {
//        JOptionPane.showMessageDialog(null, "clear tabel");
        DefaultTableModel RecordTable = (DefaultTableModel) coursetable.getModel();
        model.setRowCount(0);
    }

    private void setcourseTable() {
        try {
            prepared_statement = Sqlconnection.prepareStatement("select * from courses");
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                String namesvar = result_set.getString("course_name");
                String costvar = result_set.getString("cost");
                String courseidvar = result_set.getString("courseid");
                String duration = result_set.getString("duration");

                Object obj[] = {courseidvar, namesvar, duration, costvar};
                model = (DefaultTableModel) coursetable.getModel();
                model.addRow(obj);
            }
        } catch (SQLException ex) {
        }
    }

    public void updatecourse() {
        try {
            int courseidt = Integer.parseInt(courseidtxt.getText());
//          String courseidt = courseidtxt.getText();
            String duration = (String) jComboBox1.getSelectedItem();

            prepared_statement = Sqlconnection.prepareStatement("UPDATE courses SET course_name ="
                    + coursenametxt.getText() + "," + "cost=" + coursepricetxt.getText() + ","
                    + "duration= " + duration + " where courseid =" + courseidt);

            prepared_statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        panelsidebar = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        coursenametxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        courseidtxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        coursepricetxt = new javax.swing.JTextField();
        deletebtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursetable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Duration:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 100, -1));

        coursenametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(coursenametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/edit2.png"))); // NOI18N
        jLabel10.setText(" Courses");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 260, 90));

        courseidtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(courseidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 180, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Coures Price:");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 30));

        coursepricetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        coursepricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursepricetxtActionPerformed(evt);
            }
        });
        jPanel9.add(coursepricetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 180, -1));

        deletebtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel9.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 120, 30));

        addbtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addbtn.setText("Add");
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel9.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 120, 30));

        updatebtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel9.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));

        coursetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course name", "Duration", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        coursetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(coursetable);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 490, 540));
        jPanel9.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 280, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Course ID:");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Months", "6 Months", "1 Year", "2 Year" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 270, 180, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Course Name:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        panelsidebar.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 920));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/left-arrow.png"))); // NOI18N
        jLabel7.setText("  Back");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 70));

        panelsidebar.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, 330, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/home.png"))); // NOI18N
        jLabel6.setText("  Home");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 70));

        panelsidebar.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/view all record.png"))); // NOI18N
        jLabel33.setText(" View All Records");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 70));

        panelsidebar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 430, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/logout.png"))); // NOI18N
        jLabel1.setText("  Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelsidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 630, 330, -1));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/list_1.png"))); // NOI18N
        jLabel32.setText("  Course List");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 70));

        panelsidebar.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/edit2.png"))); // NOI18N
        jLabel31.setText("  Edit Courses");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 70));

        panelsidebar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/search2.png"))); // NOI18N
        jLabel17.setText("  Search Records");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 70));

        panelsidebar.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, -1, -1));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 1000));

        setSize(new java.awt.Dimension(2037, 975));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        insertdata();
        cleartable();
        setcourseTable();
        JOptionPane.showMessageDialog(null, "Course Added");
    }//GEN-LAST:event_addbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        updatecourse();
        cleartable();
        setcourseTable();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void coursetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursetableMouseClicked
        // TODO add your handling code here:

        int SelectedRow = coursetable.getSelectedRow();
        courseidtxt.setText(model.getValueAt(SelectedRow, 0).toString());
        coursenametxt.setText(model.getValueAt(SelectedRow, 1).toString());
        coursepricetxt.setText(model.getValueAt(SelectedRow, 3).toString());
    }//GEN-LAST:event_coursetableMouseClicked

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
        // TODO add your handling code here:
        insertdata();
        cleartable();
        setcourseTable();
        JOptionPane.showMessageDialog(null, "Course Added");
    }//GEN-LAST:event_addbtnMouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed

        int deleteItem = JOptionPane.showConfirmDialog(null, "do you want delelte it", "Warning", JOptionPane.YES_NO_OPTION);
        if (deleteItem == JOptionPane.YES_OPTION) {
            deletecourse();
            cleartable();
            setcourseTable();
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void coursepricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursepricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursepricetxtActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        viewRecordsall_page viewrecods = new viewRecordsall_page();
        viewrecods.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        login_page lg = new login_page();
        lg.setVisible(rootPaneCheckingEnabled);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        Add_Courses_page editcourse = new Add_Courses_page();
        editcourse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        searchrecords_page srch = new searchrecords_page();
        srch.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        home_pageAdmin home = new home_pageAdmin();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Courses_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Courses_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Courses_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Courses_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Add_Courses_page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField courseidtxt;
    private javax.swing.JTextField coursenametxt;
    private javax.swing.JTextField coursepricetxt;
    private javax.swing.JTable coursetable;
    private javax.swing.JButton deletebtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
