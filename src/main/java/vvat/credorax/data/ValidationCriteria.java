package vvat.credorax.data;

import java.util.List;
import java.util.function.Function;

public class ValidationCriteria <T> {
    private final Error error;
    private final Function<T, Boolean> validator;

    public ValidationCriteria(Error error, Function<T, Boolean> validator) {
        this.error = error;
        this.validator = validator;
    }

    public boolean validate(T value, List<Error> errors) {
        if (!validator.apply(value)) {
            errors.add(error);
            return false;
        }
        return true;
    }
}
