package de.rdk.databinding.binding;

import de.rdk.databinding.ObservableValue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import org.apache.log4j.Logger;

public class CheckboxBinding implements ItemListener, ObservableValue.ChangeListener<Boolean> {
    
    private static final Logger LOGGER = Logger.getLogger(CheckboxBinding.class);
    
    private final JCheckBox checkbox;
    private final ObservableValue<Boolean> observable;

    public CheckboxBinding(JCheckBox checkbox, ObservableValue<Boolean> observable) {
        this.checkbox = checkbox;
        this.observable = observable;
        updateCheckbox(observable.get());
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        updateObservable(checkbox.isSelected());
    }

    @Override
    public void onValueChanged(Boolean oldValue, Boolean newValue) {
        if (newValue != null) {
            updateCheckbox(newValue);
        }
    }
    
    private void updateObservable(boolean newValue) {
        if (!observable.get().equals(newValue)) {
            observable.set(newValue);
            LOGGER.info(String.format("Updated observable to new value \"%s\".", observable.get()));
        }
    }
    
    private void updateCheckbox(boolean newValue) {
        if (checkbox.isSelected() != newValue) {
            checkbox.setSelected(newValue);
            LOGGER.info(String.format("Updated checkbox to new value \"%s\".", Boolean.toString(newValue)));
        }
    }
}
