package vvat.credorax.audit;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class AuditImpl implements Audit {

    private static final Logger logger = LogManager.getLogger(AuditImpl.class);

    private final BufferedWriter auditFile;
    private final ObjectMapper objectMapper;

    public AuditImpl(@Value( "${audit.file.path}" ) String auditFilePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(auditFilePath));
        } catch (IOException e) {
            logger.error("Could not initialize audit service", e);
        }
        auditFile = writer;

        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        objectMapper = new ObjectMapper(jsonFactory);
    }

    @Override
    public void audit(Object object) {
        if (auditFile == null)
            return;
        try {
            objectMapper.writeValue(auditFile, object);
            auditFile.newLine();
        } catch (IOException e) {
            logger.error("Error writing audit log", e);
        }
    }

    @PreDestroy
    private void shutdown() {
        try {
            auditFile.close();
        } catch (IOException e) {
            logger.error("Could not close audit log file", e);
        }
    }
}
