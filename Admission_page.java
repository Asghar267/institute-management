package school_management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Admission_page extends javax.swing.JFrame {

    Connection Sqlconnection = Connect.ConnectDB();
    ResultSet result_set = null;
    PreparedStatement prepared_statement = null;

    public Admission_page() {
        initComponents();
        coursecombobox();
    }

    private void coursecombobox() {
        try {
            prepared_statement = Sqlconnection.prepareStatement("select course_name from courses");
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                coursecombo.addItem(result_set.getString("course_name"));
            }
        } catch (SQLException e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        fatherNameField = new javax.swing.JTextField();
        fatherNameLabel = new javax.swing.JLabel();
        cnicLabel = new javax.swing.JLabel();
        cnicField = new javax.swing.JTextField();
        mobileLabel = new javax.swing.JLabel();
        mobileField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        dobLabel = new javax.swing.JLabel();
        PhoneLabel1 = new javax.swing.JLabel();
        emailAddressField = new javax.swing.JTextField();
        dataofdbd = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        Resetbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Student_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Hobbies = new javax.swing.JLabel();
        Hobies = new javax.swing.JTextField();
        last_class = new javax.swing.JTextField();
        studentIdLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doaLabel = new javax.swing.JLabel();
        lastClassLabel = new javax.swing.JLabel();
        datejoinfield = new com.toedter.calendar.JDateChooser();
        coursecombo = new javax.swing.JComboBox<>();
        QualificaCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Form");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1366, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 740));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 700));
        jPanel1.setName("Staff Details"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Basic Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        firstNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        firstNameLabel.setText("First Name:");
        jPanel2.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 88, 30));

        firstNameField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        firstNameField.setToolTipText("Enter First Name here");
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyTyped(evt);
            }
        });
        jPanel2.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 250, 30));

        lastNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setToolTipText("");
        jPanel2.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 108, 30));

        lastNameField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lastNameField.setToolTipText("Enter Last Name Here");
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        lastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameFieldKeyTyped(evt);
            }
        });
        jPanel2.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 260, 30));

        fatherNameField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fatherNameField.setToolTipText("Enter Father's Name here");
        fatherNameField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                fatherNameFieldCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        fatherNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherNameFieldActionPerformed(evt);
            }
        });
        fatherNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fatherNameFieldKeyTyped(evt);
            }
        });
        jPanel2.add(fatherNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 250, 30));

        fatherNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        fatherNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fatherNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        fatherNameLabel.setText("Father's Name:");
        jPanel2.add(fatherNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 99, -1, 30));

        cnicLabel.setBackground(new java.awt.Color(0, 0, 0));
        cnicLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cnicLabel.setForeground(new java.awt.Color(255, 255, 255));
        cnicLabel.setText("CNIC Number:");
        jPanel2.add(cnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 100, 30));

        cnicField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cnicField.setToolTipText("Enter Father's CNIC Number");
        cnicField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnicFieldKeyTyped(evt);
            }
        });
        jPanel2.add(cnicField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 260, 30));

        mobileLabel.setBackground(new java.awt.Color(0, 0, 0));
        mobileLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mobileLabel.setForeground(new java.awt.Color(255, 255, 255));
        mobileLabel.setText("Mobile Number: ");
        jPanel2.add(mobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, 30));

        mobileField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        mobileField.setToolTipText("Enter Father's Mobile Number here");
        mobileField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileFieldKeyTyped(evt);
            }
        });
        jPanel2.add(mobileField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 260, 30));

        addressLabel.setBackground(new java.awt.Color(0, 0, 0));
        addressLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address:");
        jPanel2.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 66, 30));

        addressField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        addressField.setToolTipText("EnterStudent's Address here");
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        jPanel2.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 860, 30));

        genderLabel.setBackground(new java.awt.Color(0, 0, 0));
        genderLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Gender:");
        jPanel2.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 118, 30));

        cmbGender.setBackground(new java.awt.Color(102, 102, 102));
        cmbGender.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmbGender.setForeground(new java.awt.Color(255, 255, 255));
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Male", "Female" }));
        jPanel2.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 290, 120, 30));

        dobLabel.setBackground(new java.awt.Color(0, 0, 0));
        dobLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(255, 255, 255));
        dobLabel.setText("Date of Birth:");
        jPanel2.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        PhoneLabel1.setBackground(new java.awt.Color(0, 0, 0));
        PhoneLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PhoneLabel1.setForeground(new java.awt.Color(255, 255, 255));
        PhoneLabel1.setText("Email Address:");
        jPanel2.add(PhoneLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 269, -1, 30));

        emailAddressField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        emailAddressField.setToolTipText("Enter Father's Phone Number here");
        emailAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAddressFieldActionPerformed(evt);
            }
        });
        jPanel2.add(emailAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 260, 30));
        jPanel2.add(dataofdbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 250, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1342, 350));

        jPanel4.setBackground(new java.awt.Color(10, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel4.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 10, 170, 30));

        Resetbtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Resetbtn.setText("Reset");
        Resetbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetbtnActionPerformed(evt);
            }
        });
        jPanel4.add(Resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(983, 10, 150, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 150, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 1342, 50));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Student_id.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Student_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student_idActionPerformed(evt);
            }
        });
        jPanel3.add(Student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 280, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Academic Qualification:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 107, -1, 15));

        Hobbies.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Hobbies.setForeground(new java.awt.Color(255, 255, 255));
        Hobbies.setText("Hobbies :");
        jPanel3.add(Hobbies, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 30));

        Hobies.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Hobies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HobiesActionPerformed(evt);
            }
        });
        jPanel3.add(Hobies, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 260, 30));

        last_class.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        last_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_classActionPerformed(evt);
            }
        });
        last_class.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                last_classKeyTyped(evt);
            }
        });
        jPanel3.add(last_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 230, 30));

        studentIdLabel.setBackground(new java.awt.Color(0, 0, 0));
        studentIdLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        studentIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentIdLabel.setText("Student ID:");
        jPanel3.add(studentIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Admission for :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, 30));

        doaLabel.setBackground(new java.awt.Color(0, 0, 0));
        doaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        doaLabel.setForeground(new java.awt.Color(255, 255, 255));
        doaLabel.setText("Date of Admission:");
        jPanel3.add(doaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 130, 30));

        lastClassLabel.setBackground(new java.awt.Color(0, 0, 0));
        lastClassLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lastClassLabel.setForeground(new java.awt.Color(255, 255, 255));
        lastClassLabel.setText("Last Class Attended:");
        jPanel3.add(lastClassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 150, 30));
        jPanel3.add(datejoinfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 102, 130, 30));

        coursecombo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        coursecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursecomboActionPerformed(evt);
            }
        });
        jPanel3.add(coursecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 260, 30));

        QualificaCombo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        QualificaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduate", "Undergraduate", "Intermediate", "Metric" }));
        jPanel3.add(QualificaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 280, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1342, 170));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                                   Student Admision Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1350, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 740));

        setSize(new java.awt.Dimension(1382, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void fatherNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherNameFieldActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void emailAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAddressFieldActionPerformed

//    void reset() {
//        firstNameField.setText("er tq");
//        lastNameField.setText("a sdca");
//        fatherNameField.setText("Nazar Ali");
//        emailAddressField.setText("azhaweasdcrali07@gmail.com");
//        mobileField.setText("03045803");
//        cnicField.setText("452020234");
//        Student_id.setText("12309");
////        aqField.setText("Intermediate");
//        last_class.setText("12");
//
//        addressField.setText("Nawabshah sindh");
//        cmbGender.setSelectedIndex(0);
//        Hobies.setText("Gaming");
//        dataofdbd.setDate(null);
//        datejoinfield.setDate(null);
//     }
    void reset() {
        firstNameField.setText("");
        lastNameField.setText("");
        fatherNameField.setText("");
        emailAddressField.setText("");
        mobileField.setText("");
        cnicField.setText("");
        Student_id.setText("");
//        aqField.setText("");
        last_class.setText("");

        addressField.setText("");
        cmbGender.setSelectedIndex(0);
        Hobies.setText("");
        dataofdbd.setDate(null);
        datejoinfield.setDate(null);

    }


    private void last_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_classActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_classActionPerformed

    private void cnicFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnicFieldKeyTyped
        char input = evt.getKeyChar();
        if ((input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Please enter digits!");
        }
    }//GEN-LAST:event_cnicFieldKeyTyped

    private void mobileFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileFieldKeyTyped
        char input = evt.getKeyChar();
        if ((input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Please enter digits!");
        }
    }//GEN-LAST:event_mobileFieldKeyTyped

    private void last_classKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_last_classKeyTyped
        char input = evt.getKeyChar();
        if ((input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "ID can not be accepted in Letters Please enter digits!");
        }
    }//GEN-LAST:event_last_classKeyTyped

    private void firstNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyTyped
        char input = evt.getKeyChar();
        if (!(input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Name does not contain any numbers!");
        }
    }//GEN-LAST:event_firstNameFieldKeyTyped

    private void fatherNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameFieldKeyTyped
        char input = evt.getKeyChar();
        if (!(input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Name does not contain any numbers!");
        }
    }//GEN-LAST:event_fatherNameFieldKeyTyped

    private void lastNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameFieldKeyTyped
        char input = evt.getKeyChar();
        if (!(input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Name does not contain any numbers!");
        }
    }//GEN-LAST:event_lastNameFieldKeyTyped

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        home_pageAdmin menu = new home_pageAdmin();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void Student_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Student_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Student_idActionPerformed

    private void ResetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetbtnActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_ResetbtnActionPerformed

    private void HobiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HobiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HobiesActionPerformed

    private void coursecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursecomboActionPerformed

    private void fatherNameFieldCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fatherNameFieldCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherNameFieldCaretPositionChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if ("".equals(Student_id.getText())) {
                JOptionPane.showMessageDialog(null, "Please Enter Student ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement st = Sqlconnection.createStatement();
            String sql1 = "select Student_id from student_addmision where Student_id='" + Student_id.getText() + "'";
            result_set = st.executeQuery(sql1);
            if (result_set.next()) {
                JOptionPane.showMessageDialog(null, "Student ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String dateofbd = dateformat.format(datejoinfield.getDate());
            String datejoin = dateformat.format(datejoinfield.getDate());

            prepared_statement = Sqlconnection.prepareStatement("INSERT INTO student_addmision (Student_id, CNIC, Firstname, LastName, FatherName, "
                    + "EmailAddress, ContactNo, course, hobbies, AcademicQualification, Address, Gender,"
                    + " last_class, DateOfBirth, DateOfJoinning)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            int id = Integer.parseInt(Student_id.getText());
            prepared_statement.setInt(1, id);
            prepared_statement.setString(2, cnicField.getText());
            prepared_statement.setString(3, firstNameField.getText());
            prepared_statement.setString(4, lastNameField.getText());
            prepared_statement.setString(5, fatherNameField.getText());
            prepared_statement.setString(6, emailAddressField.getText());
            prepared_statement.setString(7, mobileField.getText());
            prepared_statement.setString(8, (String) coursecombo.getSelectedItem());
            prepared_statement.setString(9, Hobies.getText());
            prepared_statement.setString(10, (String) QualificaCombo.getSelectedItem());
            prepared_statement.setString(11, addressField.getText());
            prepared_statement.setString(12, (String) cmbGender.getSelectedItem());
            prepared_statement.setString(13, last_class.getText());
            prepared_statement.setString(14, dateofbd);
            prepared_statement.setString(15, datejoin);
//                        prepared_statement.setString(16, );
//                        prepared_statement.setString(17, );

//            prepared_statement.execute();
//             prepared_statement.executeQuery();
            prepared_statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully Registered!");
            System.out.println("Successfully Registered!");
            reset();
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admission_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admission_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admission_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admission_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new Admission_page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hobbies;
    public javax.swing.JTextField Hobies;
    private javax.swing.JLabel PhoneLabel1;
    private javax.swing.JComboBox<String> QualificaCombo;
    public javax.swing.JButton Resetbtn;
    public javax.swing.JTextField Student_id;
    public javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton backButton;
    public javax.swing.JComboBox<String> cmbGender;
    public javax.swing.JTextField cnicField;
    private javax.swing.JLabel cnicLabel;
    private javax.swing.JComboBox<String> coursecombo;
    private com.toedter.calendar.JDateChooser dataofdbd;
    private com.toedter.calendar.JDateChooser datejoinfield;
    private javax.swing.JLabel doaLabel;
    private javax.swing.JLabel dobLabel;
    public javax.swing.JTextField emailAddressField;
    public javax.swing.JTextField fatherNameField;
    private javax.swing.JLabel fatherNameLabel;
    public javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lastClassLabel;
    public javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    public javax.swing.JTextField last_class;
    public javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JLabel studentIdLabel;
    // End of variables declaration//GEN-END:variables
}
