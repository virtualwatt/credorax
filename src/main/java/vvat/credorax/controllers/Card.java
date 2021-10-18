package vvat.credorax.controllers;

import vvat.credorax.data.fields.Cvv;
import vvat.credorax.data.fields.Expiry;
import vvat.credorax.data.fields.Pan;

public class Card {

    private final vvat.credorax.data.struct.Card cardStruct;

    private String pan;
    private String expiry;
    private int cvv;

    public Card(vvat.credorax.data.struct.Card card) {
        cardStruct = card;
    }

    public Card() {cardStruct = null;}

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public vvat.credorax.data.struct.Card generateCardStruct() {
        return new vvat.credorax.data.struct.Card(new Pan(pan), new Expiry(expiry), new Cvv(cvv));
    }

    public String getPan() {
        return cardStruct.getPan().getSanitizedValue();
    }

    public String getExpiry() {
        return cardStruct.getExpiry().getSanitizedValue();
    }

    public String getCvv() { return cardStruct.getCvv().getSanitizedValue(); }
}
