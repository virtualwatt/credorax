package vvat.credorax.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping(value = "/SubmitPayment", consumes = "application/json", produces = "application/json")
    public Invoice submitPayment(@RequestBody Invoice invoice) {
        return new Invoice(invoice.generateInvoiceStruct());
    }
}
