package de.rdk.addressbook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.rdk.databinding.DataBinding;
import de.rdk.gui.mvp.Presenter;
import de.rdk.gui.mvp.View;
import de.rdk.validation.ComboboxValidation;
import de.rdk.validation.TextFieldValidation;
import de.rdk.validation.Validation;

public final class AddressbookPresenter implements Presenter {
    private final Logger LOGGER = LoggerFactory.getLogger(AddressbookPresenter.class);
    
    private final AddressbookView view;
    private final AddressbookModel model;
    private final List<Validation> validations;
    
    public AddressbookPresenter() {
        view = new AddressbookView();
        model = new AddressbookModel();
        validations = new ArrayList<>();
    }

    @Override
    public void initActionBinding() {
        view.validate().addActionListener(e -> {
            for (Validation v : validations) {
                v.validate();
            }
        });
    }

    @Override
    public void initDataBinding() {
        DataBinding.connectTextField(view.name(), model.person().name());
        DataBinding.connectCheckbox(view.active(), model.person().active());
        DataBinding.connectCombobox(view.sex(), model.person().sex());
    }

    @Override
    public void initValidation() {
        validations.add(new TextFieldValidation(view.name(), model.person().nameValidator()));
        validations.add(new ComboboxValidation<Person.Sex>(view.sex(), model.person().sexValidator()));
    }

    @Override
    public View getView() {
        return view;
    }
}
