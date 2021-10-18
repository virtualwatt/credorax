package vvat.credorax.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vvat.credorax.data.fields.Amount;
import vvat.credorax.data.fields.Currency;
import vvat.credorax.data.fields.InvoiceNumber;

@RestController
public class PaymentController {

    @GetMapping("/SubmitPayment")
    public Invoice submitPayment(int invoice, double amount, String currency, InputCardholder cardholder, InputCard card) {
        vvat.credorax.data.struct.Invoice invoiceStruct = new vvat.credorax.data.struct.Invoice(
                new InvoiceNumber(invoice),
                new Amount(amount),
                new Currency(currency),
                cardholder.getCardholder(),
                card.getCard());
        return new Invoice(invoiceStruct);
    }
}
