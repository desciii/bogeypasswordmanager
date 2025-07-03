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
        setContentPane(panel);               // set the new panel
        revalidate();                        // update layout
        repaint();                           // redraw UI
        pack();                              // resize window to fit
        setLocationRelativeTo(null);         // center on screen
    }
}
