package de.rdk.databinding.validator;

import de.rdk.databinding.ObservableString;

public class Validation {
    public static TextFieldValidation validateString(ObservableString value, Validator<String> validator) {
        TextFieldValidation validation = new TextFieldValidation(value, validator);
        return validation;
    }
}
