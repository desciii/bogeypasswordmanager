package com.descii.bpm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Marlou
 */
public class RegisterPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;


    public RegisterPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // You can hash this later if needed

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        password = new javax.swing.JPasswordField();
        usernamelabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        logintitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 51));

        Container.setBackground(new java.awt.Color(51, 51, 51));
        Container.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        Container.setForeground(new java.awt.Color(0, 51, 51));

        password.setBackground(new java.awt.Color(51, 51, 51));
        password.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        usernamelabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        usernamelabel.setForeground(new java.awt.Color(255, 255, 255));
        usernamelabel.setText("Username");

        passwordlabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        passwordlabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordlabel.setText("Password");

        username.setBackground(new java.awt.Color(51, 51, 51));
        username.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(0, 0, 0));
        RegisterButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernamelabel)
                        .addComponent(RegisterButton))
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(password))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        logintitle.setBackground(new java.awt.Color(0, 51, 51));
        logintitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        logintitle.setForeground(new java.awt.Color(255, 255, 255));
        logintitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logintitle.setText("Bogey's Password Manager");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logintitle, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logintitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
    String user = username.getText();
    String pass = new String(password.getPassword());

    // Hash the password
    String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());

    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, user);
        stmt.setString(2, hashedPassword);

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Registered successfully!");
            mainFrame.showPanel(new LoginPanel(mainFrame)); // ✅ switch to login panel
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Registration failed!");
    }
    }//GEN-LAST:event_RegisterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel logintitle;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
