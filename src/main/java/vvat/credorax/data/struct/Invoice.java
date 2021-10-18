package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Amount;
import vvat.credorax.data.fields.Currency;
import vvat.credorax.data.fields.InvoiceNumber;

public class Invoice extends AbstractStruct {
    private final InvoiceNumber invoiceNumber;
    private final Amount amount;
    private final Currency currency;
    private final Cardholder cardholder;
    private final Card card;

    public Invoice(InvoiceNumber invoiceNumber, Amount amount, Currency currency, Cardholder cardholder, Card card) {
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.currency = currency;
        this.cardholder = cardholder;
        this.card = card;
        fields.add(invoiceNumber);
        fields.add(amount);
        fields.add(currency);
        fields.add(cardholder);
        fields.add(card);
    }

    public InvoiceNumber getInvoiceNumber() {
        return invoiceNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Cardholder getCardholder() {
        return cardholder;
    }

    public Card getCard() {
        return card;
    }
}
