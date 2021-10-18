package vvat.credorax.controllers;

import vvat.credorax.data.fields.Amount;
import vvat.credorax.data.fields.Currency;
import vvat.credorax.data.fields.InvoiceNumber;

public class Invoice {
    private Integer invoice;
    private Double amount;
    private String currency;
    private Cardholder cardholder;
    private Card card;

    private final vvat.credorax.data.struct.Invoice invoiceStruct;

    public Invoice() {
        invoiceStruct = null;
    }

    public Invoice(vvat.credorax.data.struct.Invoice invoice) {
        invoiceStruct = invoice;
    }

    public Integer getInvoice() {
        return invoiceStruct.getInvoiceNumber().getValue();
    }

    public Double getAmount() {
        // return String.format("%,0.02f", invoiceStruct.getAmount().getValue());
        return invoiceStruct.getAmount().getValue();
    }

    public String getCurrency() {
        return invoiceStruct.getCurrency().getValue();
    }

    public Cardholder getCardholder() {
        return new Cardholder(invoiceStruct.getCardholder());
    }

    public Card getCard() {
        return new Card(invoiceStruct.getCard());
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCardholder(Cardholder cardholder) {
        this.cardholder = cardholder;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public vvat.credorax.data.struct.Invoice generateInvoiceStruct() {
        return new vvat.credorax.data.struct.Invoice(
                new InvoiceNumber(invoice),
                new Amount(amount),
                new Currency(currency),
                cardholder.generateCardholderStruct(),
                card.generateCardStruct());
    }
}
