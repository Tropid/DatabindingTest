package de.rdk.adressbuch;

public final class Model {
    private final Person person;
    
    public Model() {
        this.person = new Person("");
    }
    
    public Person person() {
        return this.person;
    }
}
