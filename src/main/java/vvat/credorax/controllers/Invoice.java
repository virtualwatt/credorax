package vvat.credorax.controllers;

public class Invoice {

    private final vvat.credorax.data.struct.Invoice invoice;

    public Invoice(vvat.credorax.data.struct.Invoice invoice) {
        this.invoice = invoice;
    }

    public int getInvoice() {
        return invoice.getInvoiceNumber().getValue();
    }

    public String getAmount() {
        return String.format("%,.2f", invoice.getAmount().getValue());
    }

    public String getCurrency() {
        return invoice.getCurrency().getValue();
    }

    public Cardholder getCardholder() {
        return new Cardholder(invoice.getCardholder());
    }

    public Card getCard() {
        return new Card(invoice.getCard());
    }
}
