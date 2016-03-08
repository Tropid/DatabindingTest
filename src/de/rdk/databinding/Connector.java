package de.rdk.databinding;

import de.rdk.databinding.binding.TextFieldBinding;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

public final class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);
    
    public static void connectTextField(JTextField textField, ObservableString observable) {
        TextFieldBinding binding = new TextFieldBinding(textField, observable);
        textField.getDocument().addDocumentListener(binding);
        observable.registerChangeListener(binding);
    }
    
}
