package vvat.credorax.data;

import java.util.List;

public abstract class NonValidatableField<T> extends OneValueField<T> implements Validatable {
    protected NonValidatableField(T value) {
        super(value);
    }

    @Override
    public boolean validate(List<Error> errors) {
        return true;
    }
}
