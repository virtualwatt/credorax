package vvat.credorax.dal;

import com.fasterxml.jackson.annotation.JsonInclude;
import vvat.credorax.data.fields.Email;
import vvat.credorax.data.fields.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cardholder {

    private final vvat.credorax.data.struct.Cardholder cardholderStruct;

    private String name;
    private String email;

    public Cardholder(vvat.credorax.data.struct.Cardholder cardholder) {
        cardholderStruct = cardholder;
    }

    public Cardholder() { cardholderStruct = null; }

    public void setName(String name) {
        this.name = Encoder.decode(name);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public vvat.credorax.data.struct.Cardholder generateCardholderStruct() {
        return new vvat.credorax.data.struct.Cardholder(new Name(name), new Email(email));
    }

    public String getName() {
        return Encoder.encode(cardholderStruct.getName().getValue());
    }

    public String getEmail() {
        return cardholderStruct.getEmail().getValue();
    }
}
