package vvat.credorax.controllers;

import vvat.credorax.data.fields.Email;
import vvat.credorax.data.fields.Name;
import vvat.credorax.data.struct.Cardholder;

public class InputCardholder {
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cardholder getCardholder() {
        return new Cardholder(new Name(name), new Email(email));
    }
}
