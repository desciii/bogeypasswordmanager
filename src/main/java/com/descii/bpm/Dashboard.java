/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.descii.bpm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlou
 */
public class Dashboard extends javax.swing.JPanel {

    
    private int userId;
    private javax.swing.JToggleButton togglePasswordButton;

    public Dashboard(String username, int userId) {
        this.userId = userId;
        initComponents();
        
        togglePasswordButton = new javax.swing.JToggleButton("Show Passwords");
        togglePasswordButton.addActionListener(evt -> loadPasswords());

        this.add(togglePasswordButton); 
        togglePasswordButton.setBounds(contents.getX(), contents.getY() - 40, 150, 30);
        this.setComponentZOrder(togglePasswordButton, 0); // Bring above if hidden

        logintitle.setBounds(20, 20, 300, 30); 
        loadPasswords(); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contents = new javax.swing.JTable();
        logintitle = new javax.swing.JLabel();
        addpanel = new javax.swing.JPanel();
        addwebsite = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        addwebsite1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addwebsite2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setToolTipText("");

        contents.setBackground(new java.awt.Color(255, 255, 255));
        contents.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        contents.setForeground(new java.awt.Color(0, 0, 0));
        contents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username / Email", "Password", "Website"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contents.setRowHeight(30);
        contents.setSelectionBackground(new java.awt.Color(0, 102, 102));
        contents.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(contents);
        if (contents.getColumnModel().getColumnCount() > 0) {
            contents.getColumnModel().getColumn(0).setResizable(false);
            contents.getColumnModel().getColumn(1).setResizable(false);
            contents.getColumnModel().getColumn(2).setResizable(false);
        }

        logintitle.setBackground(new java.awt.Color(0, 51, 51));
        logintitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        logintitle.setForeground(new java.awt.Color(255, 255, 255));
        logintitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logintitle.setText("Bogey's Password Manager");

        addpanel.setBackground(new java.awt.Color(40, 40, 40));

        addwebsite.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addwebsite.setForeground(new java.awt.Color(255, 255, 255));
        addwebsite.setText("Add Password");

        jTextField2.setBackground(new java.awt.Color(0, 51, 51));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        addwebsite1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addwebsite1.setForeground(new java.awt.Color(255, 255, 255));
        addwebsite1.setText("Add Website");

        jPasswordField1.setBackground(new java.awt.Color(0, 51, 51));
        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Add a Password");

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addwebsite2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addwebsite2.setForeground(new java.awt.Color(255, 255, 255));
        addwebsite2.setText("Add Username/ Email");

        jTextField3.setBackground(new java.awt.Color(0, 51, 51));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout addpanelLayout = new javax.swing.GroupLayout(addpanel);
        addpanel.setLayout(addpanelLayout);
        addpanelLayout.setHorizontalGroup(
            addpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addpanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(addpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpanelLayout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(addpanelLayout.createSequentialGroup()
                        .addGroup(addpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jPasswordField1)
                            .addComponent(jButton1)
                            .addComponent(addwebsite1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addwebsite2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        addpanelLayout.setVerticalGroup(
            addpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addwebsite1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addwebsite2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("See Passwords");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logintitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(129, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logintitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadPasswords() {
       try {
           javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) contents.getModel();
           model.setRowCount(0); // Clear table

           Connection conn = DBConnection.getConnection();
           String sql = "SELECT username, password, website FROM passwords WHERE user_id = ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setInt(1, userId);
           ResultSet rs = stmt.executeQuery();

           boolean show = jToggleButton1.isSelected();

           while (rs.next()) {
               String userOrEmail = rs.getString("username");
               String encryptedPass = rs.getString("password");
               String website = rs.getString("website");

               String displayedPass = show ? EncryptionHelper.decrypt(encryptedPass) : "••••••••";

               model.addRow(new Object[]{userOrEmail, displayedPass, website});
           }

           stmt.close();
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String website = jTextField2.getText().trim();
        String login = jTextField3.getText().trim();
        String password = new String(jPasswordField1.getPassword());

        if (website.isEmpty() || login.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.");
            return;
        }

        boolean success = PasswordManager.addPassword(userId, website, login, password);

        if (success) {
            JOptionPane.showMessageDialog(this, "Password added!");
            loadPasswords();
            jTextField2.setText("");
            jTextField3.setText("");
            jPasswordField1.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add password.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    if (jToggleButton1.isSelected()) {
        jToggleButton1.setText("Hide Passwords");
    } else {
        jToggleButton1.setText("Show Passwords");
    }
    loadPasswords();
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addpanel;
    private javax.swing.JLabel addwebsite;
    private javax.swing.JLabel addwebsite1;
    private javax.swing.JLabel addwebsite2;
    private javax.swing.JTable contents;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logintitle;
    // End of variables declaration//GEN-END:variables
}
