package de.rdk.adressbuch;

import javax.swing.JFrame;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        
        JFrame mainPanel = new JFrame("Adressbuch");
        mainPanel.setSize(200, 100);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // todo: dispose better option?
        
        Presenter presenter = new Presenter();
        presenter.display(mainPanel);
        
        mainPanel.setVisible(true);
    }
}
