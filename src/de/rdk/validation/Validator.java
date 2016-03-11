package de.rdk.validation;

import com.google.common.collect.ImmutableList;

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
}
