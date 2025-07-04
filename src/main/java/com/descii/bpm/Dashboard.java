/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.descii.bpm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

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
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        
        togglePasswordButton = new javax.swing.JToggleButton("Show Passwords");
        togglePasswordButton.addActionListener(evt -> loadPasswords());

        this.add(togglePasswordButton); 
        togglePasswordButton.setBounds(contents.getX(), contents.getY() - 40, 150, 30);
        this.setComponentZOrder(togglePasswordButton, 0); // Bring above if hidden

        logintitle.setBounds(20, 20, 300, 30); 
        loadPasswords(); 
        
        contents.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting() && contents.getSelectedRow() != -1) {
            int row = contents.getSelectedRow();

            // Set values to Edit fields
            jTextField4.setText((String) contents.getValueAt(row, 3)); // Website
            jTextField5.setText((String) contents.getValueAt(row, 1)); // Username/Email

            if (jToggleButton1.isSelected()) {
                // Show decrypted password
                jPasswordField2.setText((String) contents.getValueAt(row, 2));
            } else {
                // Fetch encrypted password from DB to decrypt
                int id = (int) contents.getValueAt(row, 0);
                try {
                    Connection conn = DBConnection.getConnection();
                    String sql = "SELECT password FROM passwords WHERE id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        String decrypted = EncryptionHelper.decrypt(rs.getString("password"));
                        jPasswordField2.setText(decrypted);
                    }
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    }


    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setText("Copy");
            setFont(new Font("Arial", Font.PLAIN, 14));
            setBackground(new Color(51, 51, 51));
            setForeground(Color.WHITE);
            setBorderPainted(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String password;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("Copy");
            button.setOpaque(true);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setBackground(new Color(51, 51, 51));
            button.setForeground(Color.WHITE);
            button.setBorderPainted(false);

            button.addActionListener(e -> {
                if (isPushed) {
                    StringSelection stringSelection = new StringSelection(password);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(button, "Password copied to clipboard!");
                }
                isPushed = false;
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
            password = (value != null) ? value.toString() : "";
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return password;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
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
        addpanel1 = new javax.swing.JPanel();
        editpassword = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        editwebsite = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        editusername = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setToolTipText("");

        contents.setBackground(new java.awt.Color(51, 51, 51));
        contents.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        contents.setForeground(new java.awt.Color(255, 255, 255));
        contents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Website", "Username / Email", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            contents.getColumnModel().getColumn(3).setResizable(false);
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
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add a Password");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addContainerGap(47, Short.MAX_VALUE))
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

        jToggleButton1.setBackground(new java.awt.Color(0, 51, 51));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("See Passwords");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        addpanel1.setBackground(new java.awt.Color(40, 40, 40));

        editpassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        editpassword.setForeground(new java.awt.Color(255, 255, 255));
        editpassword.setText("Edit Password");

        jTextField4.setBackground(new java.awt.Color(0, 51, 51));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        editwebsite.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        editwebsite.setForeground(new java.awt.Color(255, 255, 255));
        editwebsite.setText("Edit Website");

        jPasswordField2.setBackground(new java.awt.Color(0, 51, 51));
        jPasswordField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit a Password");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        editusername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        editusername.setForeground(new java.awt.Color(255, 255, 255));
        editusername.setText("EditUsername/ Email");

        jTextField5.setBackground(new java.awt.Color(0, 51, 51));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addpanel1Layout = new javax.swing.GroupLayout(addpanel1);
        addpanel1.setLayout(addpanel1Layout);
        addpanel1Layout.setHorizontalGroup(
            addpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(addpanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(addpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addpanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(addpanel1Layout.createSequentialGroup()
                        .addGroup(addpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5)
                            .addComponent(jPasswordField2)
                            .addGroup(addpanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(editwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editusername, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        addpanel1Layout.setVerticalGroup(
            addpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editusername, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jButton3.setBackground(new java.awt.Color(102, 51, 0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 51, 51));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField1MouseReleased(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jTextField1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(addpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3)
                            .addComponent(logintitle, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logintitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadPasswords() {
        try {
            DefaultTableModel model = new DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Website", "Username / Email", "Password", "Copy" }
            ) {
                boolean[] canEdit = new boolean[] { false, false, false, false, true };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };

            contents.setModel(model);

            // Hide the ID column
            contents.getColumnModel().getColumn(0).setMinWidth(0);
            contents.getColumnModel().getColumn(0).setMaxWidth(0);
            contents.getColumnModel().getColumn(0).setWidth(0);
            contents.getColumnModel().getColumn(0).setPreferredWidth(0);

            Connection conn = DBConnection.getConnection();
            String sql = "SELECT id, website, username, password FROM passwords WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            boolean show = jToggleButton1.isSelected();

            while (rs.next()) {
                int id = rs.getInt("id");
                String website = rs.getString("website");
                String userOrEmail = rs.getString("username");
                String encryptedPass = rs.getString("password");

                String displayedPass = show ? EncryptionHelper.decrypt(encryptedPass) : "••••••••";
                String actualPass = EncryptionHelper.decrypt(encryptedPass);

                model.addRow(new Object[]{id, userOrEmail, displayedPass, website, actualPass});
            }

            stmt.close();
            conn.close();

            // Set button renderer/editor
            contents.getColumn("Copy").setCellRenderer(new ButtonRenderer());
            contents.getColumn("Copy").setCellEditor(new ButtonEditor(new javax.swing.JCheckBox()));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = contents.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row to edit.");
            return;
        }

        int id = (int) contents.getValueAt(row, 0);
        String website = jTextField4.getText().trim();
        String username = jTextField5.getText().trim();
        String password = new String(jPasswordField2.getPassword()).trim();

        if (website.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE passwords SET website = ?, username = ?, password = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, website);
            stmt.setString(2, username);
            stmt.setString(3, EncryptionHelper.encrypt(password));
            stmt.setInt(4, id);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Password updated!");
            loadPasswords();

            jTextField4.setText("");
            jTextField5.setText("");
            jPasswordField2.setText("");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update failed.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = contents.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a password to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this password?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Get the ID (hidden column)
            int passwordId = (int) contents.getValueAt(selectedRow, 0);

            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM passwords WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, passwordId);

            int affectedRows = stmt.executeUpdate();
            stmt.close();
            conn.close();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Password deleted.");
                loadPasswords();
                // Clear edit fields
                jTextField4.setText("");
                jTextField5.setText("");
                jPasswordField2.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting password.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                jTextField4.setText("");
                jTextField5.setText("");
                jPasswordField2.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseReleased

    }//GEN-LAST:event_jTextField1MouseReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel ob=(DefaultTableModel) contents.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        contents.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addpanel;
    private javax.swing.JPanel addpanel1;
    private javax.swing.JLabel addwebsite;
    private javax.swing.JLabel addwebsite1;
    private javax.swing.JLabel addwebsite2;
    private javax.swing.JTable contents;
    private javax.swing.JLabel editpassword;
    private javax.swing.JLabel editusername;
    private javax.swing.JLabel editwebsite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logintitle;
    // End of variables declaration//GEN-END:variables
}
