package school_management;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author asgha
 */
public class updatefeesDetails extends javax.swing.JFrame {

    Connection Sqlconnection = Connect.ConnectDB();
    PreparedStatement prepared_statement = null;
    ResultSet Result_set = null;

    public updatefeesDetails() {
        initComponents();
        displayfirst();
        setrecord();
        coursecombobox();

        SimpleDateFormat dateformat = new SimpleDateFormat("DD-MM-YYYY");
        String date = dateformat.format(txtdate.getDate());

    }

    private void setrecord() {
        try {

//            prepared_statement = Sqlconnection.prepareStatement("select * from fees_data order by id desc limit 1");
            prepared_statement = Sqlconnection.prepareStatement("select * from fees_data order by id desc limit 1");

            Result_set = prepared_statement.executeQuery();
            Result_set.next();

            txtreciept.setText(Result_set.getString("recieptno"));
//            gstintxt.setText(Result_set.getString("gstin"));
            rollnotxt.setText(Result_set.getString("registeration"));
            txttotal.setText(Result_set.getString("totalamount"));
            txttotalwords.setText(Result_set.getString("total_inwords"));
            txtyear1.setText(Result_set.getString("year1"));
            txtyear2.setText(Result_set.getString("year2"));
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(Result_set.getString("date"));

            txtdate.setDate(date1);
            txtrecieved.setText(Result_set.getString("studentname"));
            txtcoursename.setText(Result_set.getString("studentname"));

            txtremarks.setText(Result_set.getString("remarks"));
            txtcgst.setText(Result_set.getString("cgst"));
            txtsgst.setText(Result_set.getString("sgst"));
            txtamount.setText(Result_set.getString("amount"));
            coursecombo.setSelectedItem(Result_set.getString("coursename"));
            paymentcombo.getSelectedItem().toString();
            chequetxt.setText(Result_set.getString("chequno"));
            txtbank.setText(Result_set.getString("bankname"));
            ddnotxt.setText(Result_set.getString("ddno"));
            paymentcombo.setSelectedItem(Result_set.getString("paymentm"));

//            prepared_statement = Sqlconnection.prepareStatement(string)
//            coursecombo.setSelectedItem(Result_set.getString("course_name"));
            JOptionPane.showMessageDialog(null, "Edit");

        } catch (HeadlessException | SQLException | ParseException e) {
        }

    }

    public boolean update_data() {
        System.out.println("update");
        int recieptno = Integer.parseInt(txtreciept.getText());
        String studenname = txtrecieved.getText();
        int rollno = Integer.parseInt(rollnotxt.getText());
        String pymode = paymentcombo.getSelectedItem().toString();
        String txtchequeno = chequetxt.getText();
        String bankname = txtbank.getText();
        String ddno = ddnotxt.getText();

        String couresname = coursecombo.getSelectedItem().toString();
        float gstin = Float.parseFloat(txtreciept.getText());
        float totalamount = Float.parseFloat(txttotal.getText());

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateformat.format(txtdate.getDate());

        float initaialamount = Float.parseFloat(txtamount.getText());
        float cgst = Float.parseFloat(txtcgst.getText());
        float sgst = Float.parseFloat(txtsgst.getText());

        String wrodstotal = txttotalwords.getText();
        String remarks = txtremarks.getText();
        int year1 = Integer.parseInt(txtyear1.getText());
        int year2 = Integer.parseInt(txtyear2.getText());

        try {
            prepared_statement = Sqlconnection.prepareStatement("update fees_data set recieptno=?, studentname=?, "
                    + " registeration=?, paymentm=?, chequno=?, bankname=?,  ddno=?,  coursename=?, gstin=?, totalamount=?, date=?,"
                    + "amount=?,  cgst=?, sgst=?, total_inwords=?, remarks=?,  year1=?, year2=?");

//            prepared_statement = Sqlconnection.prepareStatement("update fees_data set recieptno, studentname,"
//                    + " registeration,  paymentm, chequno, bankname,  ddno,  coursename, gstin, totalamount, date,"
//                    + "amount,  cgst, sgst, total_inwords, remarks,  year1, year2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            prepared_statement.setInt(1, recieptno);
            prepared_statement.setString(2, studenname);
            prepared_statement.setInt(3, rollno);
            prepared_statement.setString(4, pymode);
            prepared_statement.setString(5, txtchequeno);
            prepared_statement.setString(6, bankname);
            prepared_statement.setString(7, ddno);
            prepared_statement.setString(8, couresname);
            prepared_statement.setFloat(9, gstin);
            prepared_statement.setFloat(10, totalamount);
            prepared_statement.setString(11, date);
            prepared_statement.setFloat(12, initaialamount);
            prepared_statement.setFloat(13, cgst);
            prepared_statement.setFloat(14, sgst);
            prepared_statement.setString(15, wrodstotal);
            prepared_statement.setString(16, remarks);
            prepared_statement.setInt(17, year1);
            prepared_statement.setInt(18, year2);

            int rowcount = prepared_statement.executeUpdate();
            System.out.println("row count");
            System.out.println(rowcount);
            if (rowcount == 1) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("e sql");
        }
        return false;
    }

    private void coursecombobox() {
        try {
            prepared_statement = Sqlconnection.prepareStatement("select course_name from courses");
            Result_set = prepared_statement.executeQuery();
            while (Result_set.next()) {
                coursecombo.addItem(Result_set.getString("course_name"));
            }
        } catch (SQLException e) {
        }
    }

    public boolean validation() {
        if (txtrecieved.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Username");
            return false;
        }
        if (txtdate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Enter Date");
            return false;
        }
        if (txtamount.getText().equals("") && txtamount.getText().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(null, "Enter amount in numbers");
            return false;
        }
        if (paymentcombo.getSelectedItem().toString().equalsIgnoreCase("cheque")) {
            if (chequetxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter cheque no");
                return false;
            }
            if (txtbank.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Bank Name");
                return false;
            }
        }
        if (paymentcombo.getSelectedItem().toString().equalsIgnoreCase("dd")) {
            if (ddnotxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter ddno ");
                return false;
            }
            if (txtbank.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Bank Name");
                return false;
            }
        }
        if (paymentcombo.getSelectedItem().toString().equalsIgnoreCase("card")) {
            if (txtbank.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Bank Name");
                return false;
            }
        }
        return true;
    }

    private void displayfirst() {
        ddnolbl.setVisible(false);
        ddnotxt.setVisible(false);

        banklbl.setVisible(false);
        txtbank.setVisible(false);

        chequelbl.setVisible(false);
        chequetxt.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelparent = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chequelbl = new javax.swing.JLabel();
        ddnolbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtreciept = new javax.swing.JTextField();
        ddnotxt = new javax.swing.JTextField();
        chequetxt = new javax.swing.JTextField();
        panelchild = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rollnotxt = new javax.swing.JTextField();
        coursecombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtrecieved = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        txtcgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtsgst = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtcoursename = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txttotalwords = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtremarks = new javax.swing.JTextArea();
        Updatebtn = new javax.swing.JButton();
        txtyear1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtyear2 = new javax.swing.JTextField();
        txtbank = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        paymentcombo = new javax.swing.JComboBox<>();
        banklbl = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        panelsidebar = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelparent.setBackground(new java.awt.Color(0, 153, 153));
        panelparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Reciept No: SOC - ");
        panelparent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Mode of Payment :");
        panelparent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        chequelbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chequelbl.setText("Cheque no: ");
        panelparent.add(chequelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        ddnolbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ddnolbl.setText("ddno :");
        panelparent.add(ddnolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Date:");
        panelparent.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 72, -1, 30));

        txtreciept.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelparent.add(txtreciept, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 150, -1));

        ddnotxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelparent.add(ddnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 140, -1));

        chequetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelparent.add(chequetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 140, -1));

        panelchild.setBackground(new java.awt.Color(0, 255, 204));
        panelchild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("The Following Pyamention the College Office for Year");
        panelchild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 430, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Amount (Rs)");
        panelchild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        rollnotxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rollnotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollnotxtActionPerformed(evt);
            }
        });
        panelchild.add(rollnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 70, 30));

        coursecombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        coursecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursecomboActionPerformed(evt);
            }
        });
        panelchild.add(coursecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 220, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("TO");
        panelchild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));
        panelchild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1000, 20));
        panelchild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 1000, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Roll No:");
        panelchild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Sr. No");
        panelchild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Remarks:");
        panelchild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        txtrecieved.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtrecieved.setText(" ");
        panelchild.add(txtrecieved, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 260, 30));

        txtamount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtamount.setText(" ");
        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        panelchild.add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 130, 30));

        txtcgst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcgst.setText(" ");
        txtcgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcgstActionPerformed(evt);
            }
        });
        panelchild.add(txtcgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 130, 30));
        panelchild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 180, 20));

        txtsgst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtsgst.setText(" ");
        txtsgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsgstActionPerformed(evt);
            }
        });
        panelchild.add(txtsgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 130, 30));

        txttotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttotal.setText(" ");
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        panelchild.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 130, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Heads");
        panelchild.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("CGST 9%");
        panelchild.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        txtcoursename.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcoursename.setText(" ");
        txtcoursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoursenameActionPerformed(evt);
            }
        });
        panelchild.add(txtcoursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 340, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("SGST 9% ");
        panelchild.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Recever Signature");
        panelchild.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, 30));

        txttotalwords.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttotalwords.setText(" ");
        txttotalwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalwordsActionPerformed(evt);
            }
        });
        panelchild.add(txttotalwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 380, 50));
        panelchild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 180, 10));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Total In Words:");
        panelchild.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 30));

        txtremarks.setColumns(20);
        txtremarks.setRows(5);
        jScrollPane1.setViewportView(txtremarks);

        panelchild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 380, 70));

        Updatebtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Updatebtn.setText("Update");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });
        panelchild.add(Updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 100, 30));

        txtyear1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtyear1.setText(" ");
        panelchild.add(txtyear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 70, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Recieved From:");
        panelchild.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Course:");
        panelchild.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        txtyear2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelchild.add(txtyear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 70, 30));

        panelparent.add(panelchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1310, 710));

        txtbank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtbank.setText(" ");
        panelparent.add(txtbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 150, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("GSIN :");
        panelparent.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        paymentcombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        paymentcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "DD", "Cheque", "Card" }));
        paymentcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentcomboActionPerformed(evt);
            }
        });
        panelparent.add(paymentcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 68, 150, 30));

        banklbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        banklbl.setText("Bank name:");
        panelparent.add(banklbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        panelparent.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 72, 140, 30));

        getContentPane().add(panelparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 940));

        panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/left-arrow.png"))); // NOI18N
        jLabel7.setText("  Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 70));

        panelsidebar.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 330, 70));

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

        panelsidebar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 330, 70));

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

        panelsidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 330, 70));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/list_1.png"))); // NOI18N
        jLabel32.setText("  Course List");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 70));

        panelsidebar.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 330, 70));

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

        panelsidebar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 330, 70));

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

        panelsidebar.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 330, 70));

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

        panelsidebar.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 330, 70));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 1040));

        setSize(new java.awt.Dimension(1853, 975));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void coursecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursecomboActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
        float amnt = Float.parseFloat(txtamount.getText());
        float cgst = (float) (amnt * 0.09);
        float sgst = (float) (amnt * 0.09);

        String strcgst = String.valueOf(cgst);
        String strsgst = String.valueOf(sgst);

        txtcgst.setText(strcgst);
        txtsgst.setText(strsgst);
        float total = amnt + cgst + sgst;
        String strtotal = String.valueOf(total);

        txttotal.setText(strtotal);
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtcgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstActionPerformed

    private void txtsgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsgstActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtcoursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoursenameActionPerformed

    private void txttotalwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalwordsActionPerformed

    private void paymentcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentcomboActionPerformed
        // TODO add your handling code here:
        if (paymentcombo.getSelectedIndex() == 0) {
            chequelbl.setVisible(false);
            chequetxt.setVisible(false);
            banklbl.setVisible(false);
            txtbank.setVisible(false);
            ddnolbl.setVisible(false);
            ddnotxt.setVisible(false);
        } else if (paymentcombo.getSelectedIndex() == 1) {
            ddnolbl.setVisible(true);
            ddnotxt.setVisible(true);
            banklbl.setVisible(true);
            txtbank.setVisible(true);

            chequelbl.setVisible(false);
            chequetxt.setVisible(false);

        } else if (paymentcombo.getSelectedIndex() == 2) {
            chequelbl.setVisible(true);
            chequetxt.setVisible(true);
            banklbl.setVisible(true);
            txtbank.setVisible(true);
            ddnolbl.setVisible(false);
            ddnotxt.setVisible(false);
        } else if (paymentcombo.getSelectedIndex() == 3) {
            ddnolbl.setVisible(false);
            ddnotxt.setVisible(false);
            banklbl.setVisible(true);
            txtbank.setVisible(true);

            chequelbl.setVisible(false);
            chequetxt.setVisible(false);

        }
    }//GEN-LAST:event_paymentcomboActionPerformed

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        // TODO add your handling code here:
        boolean val = validation();
        if (val == true) {
            boolean status = update_data();
            if (status == true) {
                JOptionPane.showMessageDialog(null, "Update Succesful!");
                printReciept_page rptc = new printReciept_page();
                rptc.setVisible(true);
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Update Failed!");
            }
        }
    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void rollnotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollnotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollnotxtActionPerformed

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Addfee_page adpg = new Addfee_page();
        adpg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(Addfee_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addfee_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addfee_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addfee_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addfee_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Updatebtn;
    private javax.swing.JLabel banklbl;
    private javax.swing.JLabel chequelbl;
    private javax.swing.JTextField chequetxt;
    private javax.swing.JComboBox<String> coursecombo;
    private javax.swing.JLabel ddnolbl;
    private javax.swing.JTextField ddnotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel panelchild;
    private javax.swing.JPanel panelparent;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JComboBox<String> paymentcombo;
    private javax.swing.JTextField rollnotxt;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtbank;
    private javax.swing.JTextField txtcgst;
    private javax.swing.JTextField txtcoursename;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtreciept;
    private javax.swing.JTextField txtrecieved;
    private javax.swing.JTextArea txtremarks;
    private javax.swing.JTextField txtsgst;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotalwords;
    private javax.swing.JTextField txtyear1;
    private javax.swing.JTextField txtyear2;
    // End of variables declaration//GEN-END:variables
}
