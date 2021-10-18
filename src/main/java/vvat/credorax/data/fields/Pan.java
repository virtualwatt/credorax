package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.RegexValidatorsFactory;
import vvat.credorax.data.TextField;
import vvat.credorax.data.ValidationCriteria;

import java.util.ArrayList;
import java.util.List;

public class Pan extends TextField {

    private static final List<ValidationCriteria<String>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("pan"),
                RegexValidatorsFactory.generateValidator("^\\n{16}$")));
    }

    public Pan(String value) {
        super(value, validationCriterias);
    }

    @Override
    public String getSanitizedValue() {
        return "************" + getValue().substring(12);
    }
}
