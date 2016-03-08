package de.rdk.adressbuch;

import de.rdk.databinding.ObservableString;
import de.rdk.validation.StringValidator;
import de.rdk.validation.Validator;

public class Person {
    private ObservableString name;

    public Person(String name) {
        this.name = new ObservableString(name);
    }

    public ObservableString name() {
        return name;
    }
    
    public Validator<String> nameValidator() {
        StringValidator validator = new StringValidator();
        validator.minLength(2);
        validator.maxLength(50);
        return validator;
    }
}
