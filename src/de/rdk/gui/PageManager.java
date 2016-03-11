/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.rdk.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PageManager {
    private Page currentPage;
    
    private final JFrame frame;
    private final JPanel panel;

    public PageManager(JFrame mainFrame, JPanel mainPanel) {
        this.frame = mainFrame;
        this.panel = mainPanel;
    }
    
    public void transition(Page newPage) {
        if (currentPage != null) {
            currentPage.close();
        }
        
        panel.removeAll();
        
        currentPage = newPage;
        currentPage.open(panel);
        
        // Refresh/Revalidate layout
        frame.pack();
    }
}
