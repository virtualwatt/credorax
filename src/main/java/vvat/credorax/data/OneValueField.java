package vvat.credorax.data;

import java.util.Arrays;

public abstract class OneValueField<T> {
    private final T value;

    protected OneValueField(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String getSanitizedValue() {
        String val = value.toString();
        char[] charArray = new char[val.length()];
        Arrays.fill(charArray, '*');
        return new String(charArray);
    }
}
