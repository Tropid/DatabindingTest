package de.rdk.adressbuch;

import de.rdk.databinding.Connector;
import de.rdk.databinding.validator.StringValidator;
import de.rdk.databinding.validator.TextFieldValidation;
import de.rdk.databinding.validator.Validation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public final class Presenter {
    private final View view;
    private final Model model;
    
    public Presenter() {
        view = new View();
        model = new Model();
    }
    
    public void display(JFrame frame) {
        initBindings();
        initValidation();
        initActions();
        
        view.build(frame);
    }
    
    private void initBindings() {
        Connector.connectTextField(view.name(), model.name());
    }
    
    private void initValidation() {
        StringValidator nameValidator = new StringValidator();
        nameValidator.setMaxLength(10);
        // todo: ValidatorFactory mit Builder-Pattern?
        this.validations.add(Validation.validateTextField(view.name(), nameValidator));
    }
    
    private void initActions() {
        view.validate().addActionListener(e -> {
            validations.get(0).validate();
        });
    }
}
