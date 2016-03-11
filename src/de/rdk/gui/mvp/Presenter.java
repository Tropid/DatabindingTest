package de.rdk.gui.mvp;

public interface Presenter {
    void initActionBinding();
    void initDataBinding();
    void initValidation();
    
    View getView();
}
