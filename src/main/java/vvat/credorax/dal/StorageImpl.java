package vvat.credorax.dal;

import org.springframework.stereotype.Service;
import vvat.credorax.data.struct.Invoice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StorageImpl implements Storage {

    private Map<Integer, Invoice> storage = new ConcurrentHashMap<>();

    @Override
    public void store(Invoice invoice) {
        storage.put(invoice.getInvoiceNumber().getValue(), invoice);
    }

    @Override
    public Invoice retrieve(Integer invoiceNumber) {
        return storage.get(invoiceNumber);
    }
}
