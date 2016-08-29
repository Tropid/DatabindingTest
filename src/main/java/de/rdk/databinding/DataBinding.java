package de.rdk.databinding;

import de.rdk.databinding.binding.CheckboxBinding;
import de.rdk.databinding.binding.ComboboxBinding;
import de.rdk.databinding.binding.TextFieldBinding;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DataBinding {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBinding.class);
    
    public static void connectTextField(JTextField textField, ObservableString observable) {
        TextFieldBinding binding = new TextFieldBinding(textField, observable);
        textField.getDocument().addDocumentListener(binding);
        observable.registerChangeListener(binding);
    }
    
    public static void connectCheckbox(JCheckBox checkbox, ObservableValue<Boolean> observable) {
        CheckboxBinding binding = new CheckboxBinding(checkbox, observable);
        checkbox.addItemListener(binding);
        observable.registerChangeListener(binding);
    }
    
    public static <E> void connectCombobox(JComboBox<E> combobox, ObservableValue<E> observable) {
        ComboboxBinding binding = new ComboboxBinding(combobox, observable);
        combobox.addItemListener(binding);
        observable.registerChangeListener(binding);
    }
}
