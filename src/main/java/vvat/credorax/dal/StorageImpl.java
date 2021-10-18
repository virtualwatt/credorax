package vvat.credorax.dal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import vvat.credorax.Marshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StorageImpl implements Storage {

    private static final Logger logger = LogManager.getLogger(StorageImpl.class);

    private final ObjectMapper objectMapper = Marshaller.getMapper();
    private Map<Integer, String> storage = new ConcurrentHashMap<>();

    @Override
    public void store(Invoice invoice) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            objectMapper.writeValue(os, invoice);
            storage.put(invoice.getInvoice(), os.toString(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Could not store invoice", e);
        }
        try {
            os.close();
        } catch (IOException e) {
            logger.error("Could not finalize invoice storing procedure", e);
        }
    }

    @Override
    public Invoice retrieve(Integer invoiceNumber) {
        String str = storage.get(invoiceNumber);
        if (str == null)
            return null;
        //ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        Invoice invoice = null;
        try {
            invoice = objectMapper.readValue(str.getBytes(StandardCharsets.UTF_8), Invoice.class);
        } catch (IOException e) {
            logger.error("Could not restore invoice", e);
        }
        return invoice;
    }
}
