package de.rdk.adressbuch;

import de.rdk.databinding.ObservableString;
import de.rdk.databinding.validator.StringValidator;
import de.rdk.databinding.validator.TextFieldValidation;
import de.rdk.databinding.validator.Validation;
import de.rdk.databinding.validator.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

public final class Model {
    private final ObservableString name;
    
    private List<TextFieldValidation> validations;
    
    public Model() {
        this.name = new ObservableString();
        
        this.validations = new ArrayList<>();
        
        StringValidator nameValidator = ValidatorFactory.string().minLength(0).maxLength(10);
        this.validations.add(Validation.validateTextField(view.name(), nameValidator));
    }
    
    public ObservableString name() {
        return this.name;
    }
}
