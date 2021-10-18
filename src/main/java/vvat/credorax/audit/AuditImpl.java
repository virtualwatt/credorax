package vvat.credorax.audit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vvat.credorax.Marshaller;

import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class AuditImpl implements Audit {

    private static final Logger logger = LogManager.getLogger(AuditImpl.class);

    private final BufferedWriter auditWriter;
    private final ObjectMapper objectMapper = Marshaller.getMapper();

    public AuditImpl(@Value( "${audit.file.path}" ) String auditFilePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(auditFilePath));
        } catch (IOException e) {
            logger.error("Could not initialize audit service", e);
        }
        auditWriter = writer;
    }

    @Override
    public void audit(Object object) {
        if (auditWriter == null)
            return;
        try {
            objectMapper.writeValue(auditWriter, object);
            auditWriter.newLine();
        } catch (IOException e) {
            logger.error("Error writing audit log", e);
        }
    }

    @PreDestroy
    private void shutdown() {
        try {
            auditWriter.close();
        } catch (IOException e) {
            logger.error("Could not close audit log file", e);
        }
    }
}
