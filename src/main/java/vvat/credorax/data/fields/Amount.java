package vvat.credorax.data.fields;

import vvat.credorax.data.NonValidatableField;

public class Amount extends NonValidatableField<Double> {
    protected Amount(Double value) {
        super(value);
    }
}
