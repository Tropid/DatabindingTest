package de.rdk.adressbuch;

import com.google.common.collect.ImmutableList;
import de.rdk.databinding.ObservableString;
import de.rdk.validation.StringValidator;
import de.rdk.validation.Validator;
import org.apache.log4j.Logger;

public final class Model {
    
    private static final Logger LOGGER = Logger.getLogger(Model.class);
    
    private final Person person;
    
    public Model() {
        this.person = new Person("");
    }
    
    public Person person() {
        return this.person;
    }
    
    public boolean validate() {
        StringValidator nameValidator = new StringValidator();
        nameValidator.maxLength(10);
        nameValidator.minLength(3);
        
        ImmutableList<Validator.Violation> violations = nameValidator.validate(person().name().get());
        for (Validator.Violation violation : violations) {
            LOGGER.info(String.format("Constraint Violation: %s", violation.message()));
        }
        return violations.isEmpty();
    }
}
