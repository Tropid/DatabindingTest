package de.rdk.adressbuch;

import de.rdk.gui.mvp.View;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CarView implements View {
    
    private final JTextField name;
    private final JTextField licensePlate;

    public CarView() {
        this.name = new JTextField();
        this.licensePlate = new JTextField();
    }
    
    @Override
    public void onCreate(JPanel panel) {
        panel.add(name());
        panel.add(licensePlate());
    }

    public JTextField name() {
        return name;
    }
    
    public JTextField licensePlate() {
        return licensePlate;
    }
}
