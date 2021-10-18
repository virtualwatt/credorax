package vvat.credorax.dal;

public interface Storage {

    void store(Invoice invoice);

    default void storeStruct(vvat.credorax.data.struct.Invoice invoice) {
        store(new Invoice(invoice));
    }

    Invoice retrieve(Integer invoiceNumber);

    default vvat.credorax.data.struct.Invoice retrieveStruct(Integer invoiceNumber) {
        Invoice invoice = retrieve(invoiceNumber);
        if (invoice == null)
            return null;
        return invoice.generateInvoiceStruct();
    }

}
