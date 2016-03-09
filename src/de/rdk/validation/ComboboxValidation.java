package de.rdk.validation;

import com.google.common.collect.ImmutableList;
import javax.swing.JComboBox;
import org.apache.log4j.Logger;

public class ComboboxValidation<E> implements Validation {
    private static final Logger LOGGER = Logger.getLogger(ComboboxValidation.class);
    
    private final JComboBox<E> combobox;
    private final Validator<E> validator;

    public ComboboxValidation(JComboBox<E> combobox, Validator<E> validator) {
        this.combobox = combobox;
        this.validator = validator;
    }
    
    @Override
    public boolean validate() {
        ImmutableList<Validator.Violation> violations = validator.validate((E) combobox.getSelectedItem());
        StringBuilder violationText = new StringBuilder();
        for (Validator.Violation violation : violations) {
            violationText.append(violation.message());
            violationText.append("\n");
            LOGGER.info(String.format("Constraint Violation: %s", violation.message()));
        }
        combobox.setToolTipText(violationText.toString());
        return violations.isEmpty();
    }
}
