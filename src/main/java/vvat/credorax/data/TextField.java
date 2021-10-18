package vvat.credorax.data;

import java.util.List;

public abstract class TextField extends ValidatableField<String> {

    public TextField(String value, List<ValidationCriteria<String>> validationCriterias) {
        super(value, validationCriterias);
    }
}
