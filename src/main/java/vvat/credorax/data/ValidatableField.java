package vvat.credorax.data;

import java.util.List;

public abstract class ValidatableField<T> extends OneValueField<T> implements Validatable {

    private final List<ValidationCriteria<T>> validationCriterias;

    public ValidatableField(T value, List<ValidationCriteria<T>> validationCriterias) {
        super(value);
        this.validationCriterias = validationCriterias;
    }

    @Override
    public boolean validate(List<Error> errors) {
        boolean validationPassed = true;
        for (ValidationCriteria<T> validationCreteria : validationCriterias) {
            if (!validationCreteria.validate(getValue(), errors))
                validationPassed = false;
        }
        return validationPassed;
    }
}
