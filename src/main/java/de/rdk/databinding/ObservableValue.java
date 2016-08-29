package de.rdk.databinding;

import java.util.ArrayList;
import java.util.List;

public class ObservableValue<T> {
    
    private T value;
    
    private final List<ChangeListener<T>> changeListener;
    
    public ObservableValue(T value) {
        this.value = value;
        this.changeListener = new ArrayList<>();
    }
    
    public T get() {
        return this.value;
    }
    
    public void set(T newValue) {
        T oldValue = this.value;
        this.value = newValue;
        
        notifyChangeListener(oldValue, newValue);
    }
    
    public void registerChangeListener(ChangeListener<T> listener) {
        this.changeListener.add(listener);
    }
    
    public void unregisterChangeListener(ChangeListener<T> listener) {
        this.changeListener.remove(listener);
    }
    
    private void notifyChangeListener(T oldValue, T newValue) {
        for (ChangeListener<T> listener : this.changeListener) {
            listener.onValueChanged(oldValue, newValue);
        }
    }
    
    public interface ChangeListener<T> {
        void onValueChanged(T oldValue, T newValue);
    }
}
