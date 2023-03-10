/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package school_management;

/**
 *
 * @author asgha
 */
public class MainMenu2 extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu2
     */
    public MainMenu2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Signin_btn = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addstudent1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Signup_btn = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(10, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INSTITUTE MANAGEMENT SYSTEM");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 910, 120));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Signin_btn.setBackground(new java.awt.Color(0, 102, 102));
        Signin_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Signin_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signin_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Signin_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Signin_btnMouseExited(evt);
            }
        });
        Signin_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Signin_btnKeyPressed(evt);
            }
        });
        Signin_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/signup.png"))); // NOI18N
        jLabel10.setText(" Sign In");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        Signin_btn.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 510, 170));

        jPanel1.add(Signin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 670, 170));

        addstudent1.setBackground(new java.awt.Color(0, 102, 102));
        addstudent1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        addstudent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addstudent1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addstudent1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addstudent1MouseExited(evt);
            }
        });
        addstudent1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addstudent1KeyPressed(evt);
            }
        });
        addstudent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/Add.png"))); // NOI18N
        jLabel11.setText("Admission Form");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        addstudent1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 530, 180));

        jPanel1.add(addstudent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 670, 180));

        Signup_btn.setBackground(new java.awt.Color(0, 102, 102));
        Signup_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Signup_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signup_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Signup_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Signup_btnMouseExited(evt);
            }
        });
        Signup_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Signup_btnKeyPressed(evt);
            }
        });
        Signup_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectImages/signup.png"))); // NOI18N
        jLabel12.setText("   Sign Up");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        Signup_btn.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 510, 170));

        jPanel1.add(Signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 670, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1370, 740));

        setSize(new java.awt.Dimension(1382, 901));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        login_page signin = new login_page();
        signin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void Signin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signin_btnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Signin_btnMouseClicked

    private void Signin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signin_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Signin_btnMouseEntered

    private void Signin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signin_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Signin_btnMouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        Admission_page sad = new Admission_page();
        sad.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void addstudent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addstudent1MouseClicked
        // TODO add your handling code here:
        Admission_page sad = new Admission_page();
        sad.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addstudent1MouseClicked

    private void addstudent1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addstudent1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addstudent1MouseEntered

    private void addstudent1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addstudent1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addstudent1MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        signup_page sad = new signup_page();
        sad.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel12MouseClicked

    private void Signup_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signup_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Signup_btnMouseClicked

    private void Signup_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signup_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Signup_btnMouseEntered

    private void Signup_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Signup_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Signup_btnMouseExited

    private void Signin_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Signin_btnKeyPressed
        // TODO add your handling code here:
        login_page signin = new login_page();
        signin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Signin_btnKeyPressed

    private void Signup_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Signup_btnKeyPressed
        // TODO add your handling code here:
        signup_page sad = new signup_page();
        sad.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Signup_btnKeyPressed

    private void addstudent1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addstudent1KeyPressed
        // TODO add your handling code here:
        Admission_page sad = new Admission_page();
        sad.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addstudent1KeyPressed

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
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu2().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Signin_btn;
    private javax.swing.JPanel Signup_btn;
    private javax.swing.JPanel addstudent1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
