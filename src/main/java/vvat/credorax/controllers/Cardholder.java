package vvat.credorax.controllers;

public class Cardholder {

    private final vvat.credorax.data.struct.Cardholder cardholder;

    public Cardholder(vvat.credorax.data.struct.Cardholder cardholder) {
        this.cardholder = cardholder;
    }

    public String getName() {
        return cardholder.getName().getSanitizedValue();
    }

    public String getEmail() {
        return cardholder.getEmail().getValue();
    }
}
