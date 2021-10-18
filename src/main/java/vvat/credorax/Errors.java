package vvat.credorax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vvat.credorax.data.Error;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// This functionality is better to write using Spring injection as it done for DAL and Audit but lt's use for example old simple singletone too
public class Errors {

    private static final Logger logger = LogManager.getLogger(Errors.class);

    private static final Errors errorsFactory = new Errors();

    private final Properties prop = new Properties();
    private final Map<String, Error> errors = new HashMap<>();

    public static Error errorFor(String key) {
        return errorsFactory.getError(key);
    }

    private Error getError(String key) {
        Error error = errors.get(key);
        if (error == null) {
            String err = (String)prop.get(key);
            error = new Error(key, err == null ? "Undefined error" : err);
            errors.put(key, error);
        }
        return error;
    }

    private Errors() {
        try {
            prop.load(ClassLoader.getSystemResourceAsStream("errors.properties"));
        } catch (IOException e) {
            logger.error("Error loading errors list", e);
            System.exit(1);
        }
    }
}
