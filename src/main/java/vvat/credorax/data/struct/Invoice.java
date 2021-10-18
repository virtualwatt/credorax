package vvat.credorax.data.struct;

import vvat.credorax.data.fields.Amount;
import vvat.credorax.data.fields.Currency;
import vvat.credorax.data.fields.InvoiceNumber;

public class Invoice extends AbstractStruct {
    public Invoice(InvoiceNumber invoiceNumber, Amount amount, Currency currency, Cardholder cardholder, Card card) {
        fields.add(invoiceNumber);
        fields.add(amount);
        fields.add(currency);
        fields.add(cardholder);
        fields.add(card);
    }
}
