package de.rdk.adressbuch;

public final class AddressbookModel {
    private final Person person;
    
    public AddressbookModel() {
        this.person = new Person("");
    }
    
    public Person person() {
        return this.person;
    }
}
