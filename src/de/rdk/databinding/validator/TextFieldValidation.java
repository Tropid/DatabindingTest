package de.rdk.databinding.validator;

import de.rdk.databinding.ObservableString;
import org.apache.log4j.Logger;

public class TextFieldValidation {
    private static final Logger LOGGER = Logger.getLogger(TextFieldValidation.class);
    private final ObservableString observable;
    private final Validator<String> validator;

    public TextFieldValidation(ObservableString value, Validator<String> validator) {
        this.observable = value;
        this.validator = validator;
    }
    
    public void validate() {
        for (Validator.Error error : validator.validate(observable.value())) {
            LOGGER.warn(String.format("Validation failed: %s", error.message()));
        }
    }
}
