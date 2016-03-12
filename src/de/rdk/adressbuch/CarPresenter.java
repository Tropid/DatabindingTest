package de.rdk.adressbuch;

import de.rdk.databinding.DataBinding;
import de.rdk.gui.mvp.Presenter;
import de.rdk.gui.mvp.View;

public class CarPresenter implements Presenter {

    private final CarModel model;
    private final CarView view;

    public CarPresenter() {
        this.model = new CarModel();
        this.view = new CarView();
    }
    
    @Override
    public void initActionBinding() {
        
    }

    @Override
    public void initDataBinding() {
        DataBinding.connectTextField(view.name(), model.car().name());
        DataBinding.connectTextField(view.licensePlate(), model.car().licensePlate());
    }

    @Override
    public void initValidation() {
        
    }

    @Override
    public View getView() {
        return view;
    }
}
