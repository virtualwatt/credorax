package vvat.credorax.controllers;

public class Card {

    private final vvat.credorax.data.struct.Card card;

    public Card(vvat.credorax.data.struct.Card card) {
        this.card = card;
    }

    public String getPan() {
        return card.getPan().getSanitizedValue();
    }

    public String getExpiry() {
        return card.getExpiry().getSanitizedValue();
    }
}
