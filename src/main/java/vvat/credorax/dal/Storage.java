package vvat.credorax.dal;

import vvat.credorax.data.struct.Invoice;

public interface Storage {

    void store(Invoice invoice);

    Invoice retrieve(Integer invoiceNumber);

}
