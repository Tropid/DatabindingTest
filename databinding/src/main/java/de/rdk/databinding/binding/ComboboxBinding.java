package de.rdk.databinding.binding;

import de.rdk.databinding.ObservableValue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComboboxBinding<E> implements ItemListener, ObservableValue.ChangeListener<E> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ComboboxBinding.class);
    
    private final JComboBox<E> combobox;
    private final ObservableValue<E> observable;

    public ComboboxBinding(JComboBox<E> combobox, ObservableValue<E> observable) {
        this.combobox = combobox;
        this.observable = observable;
        updateCombobox(observable.get());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    	final int selectedIndex = combobox.getSelectedIndex();
    	
    	// Remove value from observable if nothing is selected
    	if (selectedIndex == -1) {
    		updateObservable(null);
    	} else {
    		updateObservable(combobox.getItemAt(selectedIndex));
    	}
    }

    @Override
    public void onValueChanged(E oldValue, E newValue) {
        updateCombobox(newValue);
    }
    
    private void updateCombobox(E newValue) {
        if (!combobox.getSelectedItem().equals(newValue)) {
            combobox.setSelectedItem(newValue);
            LOGGER.info(String.format("Updated combobox to new value \"%s\".", newValue.toString()));
        }
    }
    
    private void updateObservable(E newValue) {
        if (!observable.get().equals(newValue)) {
            observable.set(newValue);
            LOGGER.info(String.format("Updated observable to new value \"%s\".", newValue.toString()));
        }
    }
}
