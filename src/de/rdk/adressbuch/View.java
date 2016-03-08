package de.rdk.adressbuch;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class View {
    private JTextField name;
    private JButton validate;
    
    public JTextField name() {
        if (name == null) {
            name = new JTextField();
        }
        
        return name;
    }
    
    public JButton validate() {
        if (validate == null) {
            validate = new JButton();
            validate.setText("Validieren");
            validate.setAlignmentX(Component.CENTER_ALIGNMENT);
            validate.setPreferredSize(new Dimension(200, 30));
        }
        
        return validate;
    }

    void build(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(name());
        panel.add(validate());
    }
}
