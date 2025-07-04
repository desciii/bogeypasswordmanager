package com.descii.bpm;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Bogey Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        // Show the first screen
        showPanel(new LoginPanel(this));

        setVisible(true);
    }

    public void showPanel(JPanel panel) {
        setContentPane(panel);               
        revalidate();                        
        repaint();                           
        pack();                              
        setLocationRelativeTo(null);         
    }
    
    public void showLoginPanel() {
        setContentPane(new LoginPanel(this)); // or whatever your login panel is
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);   
    }
}


