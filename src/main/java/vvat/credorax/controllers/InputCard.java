package vvat.credorax.controllers;

import vvat.credorax.data.fields.Cvv;
import vvat.credorax.data.fields.Expiry;
import vvat.credorax.data.fields.Pan;
import vvat.credorax.data.struct.Card;

public class InputCard {
    private String pan;
    private String expiry;
    private int cvv;

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Card getCard() {
        return new Card(new Pan(pan), new Expiry(expiry), new Cvv(cvv));
    }
}
