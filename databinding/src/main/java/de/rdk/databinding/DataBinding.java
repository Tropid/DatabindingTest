package de.rdk.databinding;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import de.rdk.databinding.binding.CheckboxBinding;
import de.rdk.databinding.binding.ComboboxBinding;
import de.rdk.databinding.binding.TextFieldBinding;

public final class DataBinding {
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
