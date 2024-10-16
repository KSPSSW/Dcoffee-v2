/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.model.User;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.awt.Image;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author os
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();

        setImage("logo", 160, 160, lblLogo);
        setImage("backgroundLogin", 2000, 750, lblBackground);
        setImage("userlogo", 65, 65, lblUserLogo);
        setImage("passwordlogo", 65, 65, lblPasswordLogo);
        
    }

    public static void setImage(String imageName, int widthImage, int heightImage, JLabel label) {
        // โหลดรูปภาพ
        ImageIcon icon = new ImageIcon("./loginframepic/" + imageName + ".png");
        Image image = icon.getImage();

        if (image != null && image.getWidth(null) > 0) {
            // ขนาดเดิม
            int originalWidth = image.getWidth(null);
            int originalHeight = image.getHeight(null);

            // คำนวณอัตราส่วน
            float aspectRatio = (float) originalWidth / originalHeight;

            // ขนาดใหม่
            int newWidth = widthImage;
            int newHeight = heightImage;

            // คำนวณขนาดใหม่ตามอัตราส่วน โดยปรับตามความกว้างหรือความสูงก่อน
            if (widthImage / (float) heightImage > aspectRatio) {
                // ปรับตามความสูงที่กำหนด เพราะสัดส่วนที่ต้องการกว้างเกินไป
                newWidth = (int) (heightImage * aspectRatio);
            } else {
                // ปรับตามความกว้างที่กำหนด เพราะสัดส่วนที่ต้องการสูงเกินไป
                newHeight = (int) (widthImage / aspectRatio);
            }

            // ปรับขนาดรูปภาพใหม่
            Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // ตั้งค่า ImageIcon ใหม่ที่ปรับขนาดแล้ว
            icon.setImage(newImage);
            label.setIcon(icon);
        } else {
            System.out.println("ไม่สามารถโหลดรูปภาพ: " + imageName + ".png");
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

        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblSignIn = new javax.swing.JLabel();
        lblUserLogo = new javax.swing.JLabel();
        lblPasswordLogo = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        edtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255,80));
        jPanel2.setPreferredSize(new java.awt.Dimension(345, 349));

        lblLogo.setPreferredSize(new java.awt.Dimension(160, 160));

        lblSignIn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignIn.setText("ลงชื่อเข้าใช้");

        lblUserLogo.setBackground(new java.awt.Color(204, 255, 204));
        lblUserLogo.setOpaque(true);

        lblPasswordLogo.setBackground(new java.awt.Color(204, 255, 204));
        lblPasswordLogo.setOpaque(true);

        btnLogin.setBackground(new java.awt.Color(200, 162, 127));
        btnLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSignIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPasswordLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edtPassword)
                            .addComponent(edtLogin))
                        .addGap(18, 18, 18)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUserLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPasswordLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 430, 560));
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 630));

        setSize(new java.awt.Dimension(1040, 652));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String login = edtLogin.getText();
        String password = new String(edtPassword.getPassword());

        UserService userService = new UserService();
        User user = userService.login(login, password);
        
        if (user != null) {
            System.out.println(UserService.getCurrentUser().getName());
            this.dispose();
            
            // เปิด MainFrame
            Mainframe mainFrame = new Mainframe(); // สร้างอ็อบเจกต์ของ MainFrame
            mainFrame.setVisible(true); // แสดง MainFrame
        } else {
            
            edtLogin.setText("");
            edtPassword.setText("");
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE); // แสดงข้อความล็อกอินไม่สำเร็จ
        }


    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JPasswordField edtPassword;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPasswordLogo;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JLabel lblUserLogo;
    // End of variables declaration//GEN-END:variables
}
