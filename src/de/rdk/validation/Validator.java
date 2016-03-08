package de.rdk.validation;

import com.google.common.collect.ImmutableList;
import javax.swing.JTextField;

public interface Validator<T> {

    ImmutableList<Violation> validate(T value);

    public static final class Violation {
        private String message;

        public Violation(String message) {
            this.message = message;
        }

        public String message() {
            return message;
        }
    }
    
    public static Validation validateTextField(JTextField textField, Validator<String> validator) {
        return new TextFieldValidation(textField, validator);
    }
}