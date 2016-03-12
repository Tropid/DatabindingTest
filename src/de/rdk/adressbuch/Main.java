package de.rdk.adressbuch;

import de.rdk.gui.PageManager;
import de.rdk.gui.mvp.MvpPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        
        JFrame mainFrame = new JFrame("Adressbuch");
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
