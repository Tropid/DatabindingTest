package de.rdk.adressbuch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        
        JFrame mainFrame = new JFrame("Adressbuch");
        mainFrame.setSize(200, 100);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // todo: dispose better option?
        JPanel mainPanel = new JPanel();
        
        Presenter presenter = new Presenter();
        presenter.display(mainPanel);
        
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
