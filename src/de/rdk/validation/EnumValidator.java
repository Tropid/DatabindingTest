package de.rdk.validation;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class EnumValidator<E extends Enum> implements Validator<E> {
    
    private final List<E> invalidValues;
    
    public EnumValidator() {
        this.invalidValues = new ArrayList<>();
    }
    
    public void addInvalidValue(E value) {
        this.invalidValues.add(value);
    }

    @Override
    public ImmutableList<Violation> validate(E value) {
        ImmutableList.Builder<Violation> violationBuilder = ImmutableList.builder();
        if (invalidValues.contains(value)) {
            violationBuilder.add(new Violation(String.format("Enum value \"%s\" is invalid", value.toString())));
        }
        return violationBuilder.build();
    }
}
