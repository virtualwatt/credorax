package vvat.credorax.data;

import java.util.List;

public interface Validatable {
    boolean validate(List<Error> errors);
}
