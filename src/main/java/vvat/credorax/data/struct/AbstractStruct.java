package vvat.credorax.data.struct;

import vvat.credorax.data.Error;
import vvat.credorax.data.Validatable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStruct implements Validatable {
    protected List<Validatable> fields = new ArrayList<>();

    @Override
    public boolean validate(List<Error> errors) {
        boolean result = true;
        for (Validatable field : fields) {
            if (!field.validate(errors))
                result = false;
        }
        return result;
    }
}
