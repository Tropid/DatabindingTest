package de.rdk.addressbook;

import de.rdk.gui.mvp.View;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class AddressbookView implements View {
    private JTextField name;
    private JCheckBox active;
    private JComboBox<Person.Sex> sex;
    private JButton validate;
    
    public JTextField name() {
        if (name == null) {
            name = new JTextField();
        }
        
        return name;
    }
    
    public JCheckBox active() {
        if (active == null) {
            active = new JCheckBox();
            active.setText("Aktiv");
        }
        
        return active;
    }
    
    public JComboBox<Person.Sex> sex() {
        if (sex == null) {
            sex = new JComboBox<>(Person.Sex.values());
            sex.setRenderer(new SexCellRenderer());
        }
        
        return sex;
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

    @Override
    public void onCreate(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(name());
        panel.add(active());
        panel.add(sex());
        panel.add(validate());
    }
    
    private static final class SexCellRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Object item = value;
            
            if (item instanceof Person.Sex) {
                item = ((Person.Sex) item).title();
            }
            return super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
        }
    }
}
