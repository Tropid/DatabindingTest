package de.rdk.databinding.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StringValidator implements Validator<String> {
    
    private int maxLength;
    private int minLength;
    private Optional<Pattern> pattern;

    StringValidator() {
        maxLength = Integer.MAX_VALUE;
        minLength = 0;
        pattern = Optional.empty();
    }

    public StringValidator maxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public StringValidator minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringValidator pattern(Pattern pattern) {
        this.pattern = Optional.of(pattern);
        return this;
    }

    @Override
    public List<Error> validate(String value) {
        List<Error> errors = new ArrayList<>();
        if (value.length() > maxLength) {
            errors.add(new Validator.Error(String.format("Max length is: %d", maxLength)));
        }
        
        if (value.length() < minLength) {
            errors.add(new Validator.Error(String.format("Min length is: %d", minLength)));
        }
        
        if (pattern.isPresent() && !pattern.get().matcher(value).matches()) {
            errors.add(new Validator.Error(String.format("No pattern match: %s", pattern.get().pattern())));
        }
        
        return errors;
    }
}
