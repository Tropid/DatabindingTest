package de.rdk.databinding.validator;

import java.util.List;

public interface Validator<T> {
    List<Error> validate(T value);
    
    public static final class Error {
        private final String message;

        public Error(String message) {
            this.message = message;
        }

        public String message() {
            return message;
        }
    }
}
