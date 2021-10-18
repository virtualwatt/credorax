package vvat.credorax.controllers;

import vvat.credorax.data.fields.Email;
import vvat.credorax.data.fields.Name;

public class Cardholder {

    private final vvat.credorax.data.struct.Cardholder cardholderStruct;

    private String name;
    private String email;

    public Cardholder(vvat.credorax.data.struct.Cardholder cardholder) {
        cardholderStruct = cardholder;
    }

    public Cardholder() { cardholderStruct = null; }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public vvat.credorax.data.struct.Cardholder generateCardholderStruct() {
        return new vvat.credorax.data.struct.Cardholder(new Name(name), new Email(email));
    }

    public String getName() {
        return cardholderStruct.getName().getSanitizedValue();
    }

    public String getEmail() {
        return cardholderStruct.getEmail().getValue();
    }
}
