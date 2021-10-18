package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Cvv;
import vvat.credorax.data.fields.Expiry;
import vvat.credorax.data.fields.Pan;

public class Card extends AbstractStruct {
    public Card(Pan pan, Expiry expiry, Cvv cvv) {
        fields.add(pan);
        fields.add(expiry);
        fields.add(cvv);
    }
}
