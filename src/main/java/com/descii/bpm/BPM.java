/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.descii.bpm;

import javax.swing.SwingUtilities;

/**
 *
 */
public class BPM {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new MainFrame().setVisible(true);
            });
        }
}
