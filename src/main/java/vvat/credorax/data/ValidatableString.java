package vvat.credorax.data;

import java.util.List;

public class ValidatableString implements Validatable {
    @Override
    public boolean validate(List<Error> errors) {
        return false;
    }
}
