package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Email;
import vvat.credorax.data.fields.Name;

public class Cardholder extends AbstractStruct {
    public Cardholder(Name name, Email email) {
        fields.add(name);
        fields.add(email);
    }
}
