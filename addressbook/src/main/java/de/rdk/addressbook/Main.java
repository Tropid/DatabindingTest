package de.rdk.addressbook;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import de.rdk.gui.PageManager;
import de.rdk.gui.mvp.MvpPage;

public class Main {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Addressbook");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // todo: dispose better option?
        JPanel mainPanel = new JPanel();
        
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        
        PageManager pageManager = new PageManager(mainFrame, mainPanel);
        pageManager.transition(new MvpPage(new AddressbookPresenter()));
        
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            SwingUtilities.invokeLater(() -> pageManager.transition(new MvpPage(new CarPresenter())));
        }).start();
    }
}
