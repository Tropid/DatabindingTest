package de.rdk.validation;

import com.google.common.collect.ImmutableList;

public class StringValidator implements Validator<String> {
    private int minLength;
    private int maxLength;
    
    public StringValidator() {
        minLength = 0;
        maxLength = Integer.MAX_VALUE; 
   }
    
    public void minLength(int minLength) {
        this.minLength = minLength;
    }

    public void maxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public ImmutableList<Violation> validate(String value) {
        if (minLength > maxLength) {
            throw new IllegalStateException("MinLength is smaller than MaxLength");
        }
        
        ImmutableList.Builder<Violation> violationsBuilder = ImmutableList.<Violation>builder();
        
        if (value.length() < minLength) {
            violationsBuilder.add(new Violation(String.format("Length is to short: %d", value.length())));
        }
        else if (value.length() > maxLength) {
            violationsBuilder.add(new Violation(String.format("Length is to large: %d", value.length())));
        }
        
        return violationsBuilder.build();
    }
}
