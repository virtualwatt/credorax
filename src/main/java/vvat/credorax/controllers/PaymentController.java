package vvat.credorax.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vvat.credorax.Errors;
import vvat.credorax.audit.Audit;
import vvat.credorax.dal.Storage;
import vvat.credorax.data.Error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PaymentController {

    private final Storage storage;
    private final Audit audit;

    public PaymentController(Storage storage, Audit audit) {
        this.storage = storage;
        this.audit = audit;
    }

    @PostMapping(value = "/SubmitPayment", consumes = "application/json", produces = "application/json")
    public Result submitPayment(@RequestBody Invoice invoice) {
        vvat.credorax.data.struct.Invoice invoiceStruct = invoice.generateInvoiceStruct();
        List<Error> errors = new ArrayList<>();
        invoiceStruct.validate(errors);
        Result result = new Result(errors);
        if (result.approved) {
            storage.storeStruct(invoiceStruct);
            audit.audit(new Invoice(invoiceStruct));
        }
        return result;
    }

    private final static Result transactionNotFound = new Result(Collections.singletonList(Errors.errorFor("notStored")));

    @GetMapping("/RetrieveTransaction")
    public Object retrieveTransaction(Integer invoice) {
        vvat.credorax.data.struct.Invoice invoiceStruct = storage.retrieveStruct(invoice);
        return invoiceStruct == null ? transactionNotFound : new Invoice(invoiceStruct);
    }
}
