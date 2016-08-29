package de.rdk.addressbook;

import com.google.common.collect.ImmutableList;
import de.rdk.databinding.ObservableString;
import de.rdk.validation.Validator;
import java.util.regex.Pattern;

public class Car {
    
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("[A-Z]{2,3}[0-9]{1,4}");
    
    private ObservableString name;
    private ObservableString licensePlate;

    public Car() {
        name = new ObservableString();
        licensePlate = new ObservableString();
    }
    
    public ObservableString name() {
        return name;
    }
    
    public ObservableString licensePlate() {
        return licensePlate;
    }
    
    public Validator<String> licensePlateValidator() {
        return new Validator<String>() {
            @Override
            public ImmutableList<Validator.Violation> validate(String value) {
                boolean valid = LICENSE_PLATE_PATTERN.matcher(value).matches();
                if (!valid) {
                    return ImmutableList.of(new Validator.Violation("License plate invalid"));
                } else {
                    return ImmutableList.of();
                }
            }
        };
    }
}
