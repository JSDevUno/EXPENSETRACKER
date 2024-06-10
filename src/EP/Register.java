/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EP;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    private int initialClickX, initialClickY;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Register() {
        setLocationRelativeTo(null);
        initComponents();
        con = Db.myconnection();
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,30));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        minusreg = new javax.swing.JLabel();
        exreg = new javax.swing.JLabel();
        TextFirstname = new javax.swing.JTextField();
        TextMiddlename = new javax.swing.JTextField();
        TextLastname = new javax.swing.JTextField();
        hidepass = new javax.swing.JLabel();
        showpass = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBackground(new java.awt.Color(51, 0, 51));
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseDragged(evt);
            }
        });
        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION");

        minusreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_subtract_30px.png"))); // NOI18N
        minusreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minusregMouseClicked(evt);
            }
        });

        exreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_multiply_30px.png"))); // NOI18N
        exreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exregMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(minusreg)
                .addGap(18, 18, 18)
                .addComponent(exreg)
                .addGap(7, 7, 7))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exreg)
                    .addComponent(minusreg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 594, -1));

        TextFirstname.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        kGradientPanel1.add(TextFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 179, 295, -1));

        TextMiddlename.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        kGradientPanel1.add(TextMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 251, 295, -1));

        TextLastname.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        kGradientPanel1.add(TextLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 323, 295, -1));

        hidepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EP/icons8_invisible_20px_1.png"))); // NOI18N
        hidepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidepassMouseClicked(evt);
            }
        });
        kGradientPanel1.add(hidepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, 20));

        showpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EP/icons8_eye_20px_5.png"))); // NOI18N
        showpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showpassMouseClicked(evt);
            }
        });
        kGradientPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, 20));

        TextPassword.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        kGradientPanel1.add(TextPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 468, 295, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FIRSTNAME:");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 180, 79, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MIDDLENAME:");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 252, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LASTNAME:");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 324, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PASSWORD:");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 470, -1, -1));

        kButton1.setText("REGISTER");
        kButton1.setkBorderRadius(15);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 523, 119, 27));

        kButton2.setText("LOGIN");
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 573, 89, 22));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Already have an account?");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 577, -1, -1));

        TextEmail.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        kGradientPanel1.add(TextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 395, 295, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EMAIL:");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 397, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        String Fname = TextFirstname.getText();
        String Mname = TextMiddlename.getText();
        String Lname = TextLastname.getText();
        String Email = TextEmail.getText();
        String Pword = new String(TextPassword.getText());
        
        if (Fname.isEmpty()|| Mname.isEmpty()|| Lname.isEmpty()||Email.isEmpty()|| Pword.isEmpty()){
            JOptionPane.showMessageDialog(this, "All fields must be filled");
            return;
        }
        
        try {
            pst = con.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");
            pst.setString(1, Email);
            rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.");
                TextEmail.setText("");
                return;
            }
            pst=con.prepareStatement("INSERT INTO users (firstname, middlename, lastname,email, password) VALUES(?,?,?,?,?)");
            pst.setString(1, Fname);
            pst.setString(2, Mname);
            pst.setString(3, Lname);
            pst.setString(4, Email);
            pst.setString(5, Pword);
            
            int k=pst.executeUpdate();
            
            if(k==1){
                TextFirstname.setText(" ");
                TextMiddlename.setText(" ");
                TextLastname.setText(" ");
                TextEmail.setText(" ");
                TextPassword.setText(" ");
                
                JOptionPane.showMessageDialog(this, "SUCCESFULLY REGISTERED");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        dispose();
        Login l = new Login();
        l.setVisible(true);
        l.setLocationRelativeTo(null);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kGradientPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseDragged
        int newX = getX() + evt.getX() - initialClickX;
        int newY = getY() + evt.getY() - initialClickY;
        setLocation(newX, newY);
    }//GEN-LAST:event_kGradientPanel2MouseDragged

    private void kGradientPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MousePressed
        initialClickX = evt.getX();
        initialClickY = evt.getY();
    }//GEN-LAST:event_kGradientPanel2MousePressed

    private void hidepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidepassMouseClicked
        TextPassword.setEchoChar((char)0);
        hidepass.setVisible(false);
        hidepass.setEnabled(false);
        showpass.setVisible(true);
        showpass.setEnabled(true);
    }//GEN-LAST:event_hidepassMouseClicked

    private void showpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpassMouseClicked
        TextPassword.setEchoChar('*');
        hidepass.setVisible(true);
        hidepass.setEnabled(true);
        showpass.setVisible(false);
        showpass.setEnabled(false);
    }//GEN-LAST:event_showpassMouseClicked

    private void minusregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusregMouseClicked
        this.setExtendedState(Register.ICONIFIED);
    }//GEN-LAST:event_minusregMouseClicked

    private void exregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exregMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exregMouseClicked

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextFirstname;
    private javax.swing.JTextField TextLastname;
    private javax.swing.JTextField TextMiddlename;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JLabel exreg;
    private javax.swing.JLabel hidepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel minusreg;
    private javax.swing.JLabel showpass;
    // End of variables declaration//GEN-END:variables
}
