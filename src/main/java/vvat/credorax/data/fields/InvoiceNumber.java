package vvat.credorax.data.fields;

import vvat.credorax.data.NonValidatableField;

public class InvoiceNumber extends NonValidatableField<Integer> {
    // Actually non-null check should be added here but it's enough complexity for this example
    public InvoiceNumber(Integer value) {
        super(value);
    }
}
