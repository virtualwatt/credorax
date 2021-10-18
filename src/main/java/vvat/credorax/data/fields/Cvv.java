package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.ValidatableField;
import vvat.credorax.data.ValidationCriteria;

import java.util.ArrayList;
import java.util.List;

public class Cvv extends ValidatableField<Integer> {

    private static final List<ValidationCriteria<Integer>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("cvv"),
                value -> value >= 100 && value <= 999));
    }

    public Cvv(Integer value) {
        super(value, validationCriterias);
    }

    @Override
    public String getSanitizedValue() {
        return null;
    }
}
