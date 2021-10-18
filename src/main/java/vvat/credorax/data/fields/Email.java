package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.RegexValidatorsFactory;
import vvat.credorax.data.TextField;
import vvat.credorax.data.ValidationCriteria;

import java.util.ArrayList;
import java.util.List;

public class Email extends TextField {

    private static final List<ValidationCriteria<String>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("email"),
                RegexValidatorsFactory.generateValidator("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")));
    }

    public Email(String value) {
        super(value, validationCriterias);
    }
}
