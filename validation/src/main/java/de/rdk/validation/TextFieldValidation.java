package de.rdk.validation;

import com.google.common.collect.ImmutableList;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFieldValidation implements Validation {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextFieldValidation.class);
    
    private final JTextField textField;
    private final Validator<String> validator;

    public TextFieldValidation(JTextField textField, Validator<String> validator) {
        this.textField = textField;
        this.validator = validator;
    }
    
    @Override
    public boolean validate() {
        ImmutableList<Validator.Violation> violations = validator.validate(textField.getText());
        StringBuilder violationText = new StringBuilder();
        for (Validator.Violation violation : violations) {
            violationText.append(violation.message());
            violationText.append("\n");
            LOGGER.info(String.format("Constraint Violation: %s", violation.message()));
        }
        textField.setToolTipText(violationText.toString());
        return violations.isEmpty();
    }
}
