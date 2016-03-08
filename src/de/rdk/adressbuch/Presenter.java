package de.rdk.adressbuch;

import de.rdk.databinding.Connector;
import de.rdk.validation.Validation;
import de.rdk.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public final class Presenter {
    private final View view;
    private final Model model;
    private final List<Validation> validations;
    
    public Presenter() {
        view = new View();
        model = new Model();
        validations = new ArrayList<>();
    }
    
    public void display(JPanel panel) {
        initBindings();
        initValidations();
        initActions();
        
        view.build(panel);
    }
    
    private void initBindings() {
        Connector.connectTextField(view.name(), model.person().name());
    }
    
    private void initValidations() {
        validations.add(Validator.validateTextField(view.name(), model.person().nameValidator()));
    }
    
    private void initActions() {
        view.validate().addActionListener(e -> {
            boolean successful = true;
            for (Validation validation : validations) {
                successful &= validation.validate();
            }
        });
    }
}
