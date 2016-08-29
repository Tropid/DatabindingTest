package de.rdk.validation;

import com.google.common.collect.ImmutableList;
import javax.swing.JComboBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComboboxValidation<E> implements Validation {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComboboxValidation.class);
    
    private final JComboBox<E> combobox;
    private final Validator<E> validator;

    public ComboboxValidation(JComboBox<E> combobox, Validator<E> validator) {
        this.combobox = combobox;
        this.validator = validator;
    }
    
    @Override
    public boolean validate() {
    	final int selectedIndex = combobox.getSelectedIndex();
    	
    	// Reject undefined items
    	if (selectedIndex == -1) {
    		return false;
    	}
    	
        ImmutableList<Validator.Violation> violations = validator.validate(combobox.getItemAt(selectedIndex));
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
