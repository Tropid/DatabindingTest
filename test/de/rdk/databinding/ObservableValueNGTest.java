package de.rdk.databinding;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ObservableValueNGTest {

    @Test
    public void testValue() {
        ObservableValue<Integer> observable = new ObservableValue<>(4);
        assertEquals((int)observable.value(), 4);
    }

    @Test
    public void testSet() {
        ObservableValue<Integer> observable = new ObservableValue<>(4);
        observable.set(8);
        assertEquals((int)observable.value(), 8);
    }

    @Test
    public void testRegisterChangeListener() {
        ObservableValue<String> observable = new ObservableValue<>("Hello");
        observable.registerChangeListener((oldValue, newValue) -> {
            assertEquals(oldValue, "Hello");
            assertEquals(newValue, "World");
        });
        
        observable.set("World");
    }

    @Test
    public void testUnregisterChangeListener() {
        ObservableValue<String> observable = new ObservableValue<>("Hello");
        
        ObservableValue.ChangeListener<String> listener = (oldValue, newValue) -> {
            fail("Listener should not be called.");
        };
        
        observable.registerChangeListener(listener);
        observable.unregisterChangeListener(listener);
        
        observable.set("World");
    }
    
}
