package de.rdk.databinding;

public final class ObservableString extends ObservableValue<String> {

    public ObservableString() {
        super("");
    }
    
    public ObservableString(String value) {
        super(value);
    }
}
