package de.rdk.adressbuch;

import de.rdk.databinding.Connector;
import de.rdk.validation.ComboboxValidation;
import de.rdk.validation.TextFieldValidation;
import de.rdk.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

public final class Presenter {
    private final Logger LOGGER = Logger.getLogger(Presenter.class);
    
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
        Connector.connectCheckbox(view.active(), model.person().active());
        Connector.connectCombobox(view.sex(), model.person().sex());
    }
    
    private void initValidations() {
        validations.add(new TextFieldValidation(view.name(), model.person().nameValidator()));
        validations.add(new ComboboxValidation(view.sex(), model.person().sexValidator()));
    }
    
    private void initActions() {
        view.validate().addActionListener(e -> {
            boolean successful = true;
            for (Validation validation : validations) {
                successful &= validation.validate();
            }
            
            if (successful) {
                LOGGER.info("Validated successfully");
            }
        });
    }
}
