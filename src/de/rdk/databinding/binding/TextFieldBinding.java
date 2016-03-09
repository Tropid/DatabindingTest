package de.rdk.databinding.binding;

import de.rdk.databinding.ObservableString;
import de.rdk.databinding.ObservableValue;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.log4j.Logger;

public final class TextFieldBinding implements DocumentListener, ObservableValue.ChangeListener<String> {
    
    private static final Logger LOGGER = Logger.getLogger(TextFieldBinding.class);
    
    private final ObservableString observable;
    private final JTextField textField;

    public TextFieldBinding(JTextField textField, ObservableString observable) {
        this.textField = textField;
        this.observable = observable;
        updateTextField(observable.get());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateObservable(textField.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateObservable(textField.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    @Override
    public void onValueChanged(String oldValue, String newValue) {
        updateTextField(observable.get());
    }

    private void updateObservable(String newValue) {
        if (!newValue.equals(observable.get())) {
            observable.set(newValue);
            LOGGER.info(String.format("Updated observable to new value \"%s\".", observable.get()));
        }
    }

    private void updateTextField(String newValue) {
        if (!textField.getText().equals(newValue)) {
            textField.setText(newValue);
            LOGGER.info(String.format("Updated textfield to new value \"%s\".", observable.get()));
        }
    }
}
