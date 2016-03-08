package de.rdk.adressbuch;

import javax.swing.JButton;
import javax.swing.JFrame;
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
        }
        
        return validate;
    }

    void build(JFrame frame) {
        frame.add(name());
        frame.add(validate());
    }
}
