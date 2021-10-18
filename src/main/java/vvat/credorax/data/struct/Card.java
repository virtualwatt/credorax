package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Cvv;
import vvat.credorax.data.fields.Expiry;
import vvat.credorax.data.fields.Pan;

public class Card extends AbstractStruct {
    private final Pan pan;
    private final Expiry expiry;
    private final Cvv cvv;

    public Card(Pan pan, Expiry expiry, Cvv cvv) {
        this.pan = pan;
        this.expiry = expiry;
        this.cvv = cvv;
        fields.add(pan);
        fields.add(expiry);
        fields.add(cvv);
    }

    public Pan getPan() {
        return pan;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public Cvv getCvv() {
        return cvv;
    }
}
