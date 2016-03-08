package de.rdk.databinding.validator;

public class ValidatorFactory {
    public static StringValidator string() {
        return new StringValidator();
    }
}
