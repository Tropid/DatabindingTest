package de.rdk.adressbuch;

import de.rdk.databinding.ObservableString;
import de.rdk.databinding.ObservableValue;
import de.rdk.validation.EnumValidator;
import de.rdk.validation.StringValidator;
import de.rdk.validation.Validator;

public class Person {
    private ObservableString name;
    private ObservableValue<Boolean> active;
    private ObservableValue<Sex> sex;

    public Person(String name) {
        this.name = new ObservableString(name);
        this.active = new ObservableValue<>(true);
        this.sex = new ObservableValue<>(Sex.Undefined);
    }

    public ObservableString name() {
        return name;
    }
    
    public ObservableValue<Boolean> active() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active().set(active);
    }
    
    public ObservableValue<Sex> sex() {
        return this.sex;
    }
    
    public void setSex(Sex newSex) {
        this.sex().set(newSex);
    }
    
    public Validator<String> nameValidator() {
        StringValidator validator = new StringValidator();
        validator.minLength(2);
        validator.maxLength(50);
        return validator;
    }
    
    public Validator<Person.Sex> sexValidator() {
        EnumValidator validator = new EnumValidator();
        validator.addInvalidValue(Person.Sex.Undefined);
        return validator;
    }
    
    public enum Sex {
        Male("Männlich"),
        Female("Weiblich"),
        Undefined("Unbekannt"),
        ;
        
        private final String title;

        private Sex(String title) {
            this.title = title;
        }
        
        public String title() {
            return title;
        }
    }
}
