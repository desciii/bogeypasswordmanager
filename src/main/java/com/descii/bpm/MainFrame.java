package com.descii.bpm;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Bogey Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Set the custom icon (PNG version)
        try {
            ImageIcon icon = new ImageIcon("src/main/java/com/descii/bpm/logo.png");
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("Could not load icon: " + e.getMessage());
        }
        
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
        setContentPane(new LoginPanel(this));
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);   
    }
}