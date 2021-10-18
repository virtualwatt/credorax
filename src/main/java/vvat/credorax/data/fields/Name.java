package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.RegexValidatorsFactory;
import vvat.credorax.data.TextField;
import vvat.credorax.data.ValidationCriteria;

import java.util.ArrayList;
import java.util.List;

public class Name extends TextField {

    private static final List<ValidationCriteria<String>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("name"),
                RegexValidatorsFactory.generateValidator("^[a-zA-Z]+\\s[a-zA-Z]+$")));
    }

    public Name(String value) {
        super(value, validationCriterias);
    }
}
