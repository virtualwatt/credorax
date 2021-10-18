package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Email;
import vvat.credorax.data.fields.Name;

public class Cardholder extends AbstractStruct {
    private final Name name;
    private final Email email;

    public Cardholder(Name name, Email email) {
        this.name = name;
        this.email = email;
        fields.add(name);
        fields.add(email);
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
}
