package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.TextField;
import vvat.credorax.data.ValidationCriteria;

import java.util.ArrayList;
import java.util.List;

public class Currency extends TextField {

    private static final List<ValidationCriteria<String>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("currency"),
                value -> value != null && !value.isEmpty()));
    }

    public Currency(String value) {
        super(value, validationCriterias);
    }
}
