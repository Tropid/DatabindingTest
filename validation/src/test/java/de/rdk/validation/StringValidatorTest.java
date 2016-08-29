package de.rdk.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringValidatorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
    
    public StringValidatorTest() {
    }

    @Test
    public void testMinLength() {
        StringValidator validator = new StringValidator();
        assertTrue(validator.validate("").isEmpty());
        
        validator.minLength(5);
        assertEquals(validator.validate("Shor").size(), 1);
        assertTrue(validator.validate("Matching").isEmpty());
    }

    @Test
    public void testMaxLength() {
        StringValidator validator = new StringValidator();
        assertTrue(validator.validate("").isEmpty());
        assertTrue(validator.validate("VERYVERYVERYVERYVERYLONGTEXT").isEmpty());
        
        validator.maxLength(5);
        assertTrue(validator.validate("Short").isEmpty());
        assertEquals(validator.validate("LongerThanFiveCharacters").size(), 1);
    }
    
    @Test
    public void testMinMaxLength() {
        StringValidator validator = new StringValidator();
        validator.minLength(2);
        validator.maxLength(5);
        
        assertTrue(validator.validate("Short").isEmpty());
        assertEquals(validator.validate("A").size(), 1);
        assertEquals(validator.validate("LongerThanFiveCharacters").size(), 1);
    }
    
    @Test
    public void testMinLargerThanMax() {
        StringValidator validator = new StringValidator();
        validator.minLength(8);
        validator.maxLength(3);
        thrown.expect(IllegalStateException.class);
        validator.validate("");
    }
    
    @Test
    public void testMinEqualToMax() {
        StringValidator validator = new StringValidator();
        validator.minLength(8);
        validator.maxLength(8);
        assertEquals(validator.validate("Short").size(), 1);
        assertTrue(validator.validate("Exactly8").isEmpty());
        assertEquals(validator.validate("TextWhichIsToLong").size(), 1);
    }
}
