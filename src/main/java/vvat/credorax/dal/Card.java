package vvat.credorax.dal;

import com.fasterxml.jackson.annotation.JsonInclude;
import vvat.credorax.data.fields.Cvv;
import vvat.credorax.data.fields.Expiry;
import vvat.credorax.data.fields.Pan;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    private final vvat.credorax.data.struct.Card cardStruct;

    private String pan;
    private String expiry;
    private int cvv;

    public Card(vvat.credorax.data.struct.Card card) {
        cardStruct = card;
    }

    public Card() {
        cardStruct = null;
    }

    public void setPan(String pan) {
        this.pan = Encoder.decode(pan);
    }

    public void setExpiry(String expiry) {
        this.expiry = Encoder.decode(expiry);
    }

    public vvat.credorax.data.struct.Card generateCardStruct() {
        return new vvat.credorax.data.struct.Card(new Pan(pan), new Expiry(expiry), new Cvv(0));
    }

    public String getPan() {
        return Encoder.encode(cardStruct.getPan().getValue());
    }

    public String getExpiry() {
        return Encoder.encode(cardStruct.getExpiry().getValue());
    }
}
