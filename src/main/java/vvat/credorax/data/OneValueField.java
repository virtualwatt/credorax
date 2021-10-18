package vvat.credorax.data;

public abstract class OneValueField<T> {
    private final T value;

    protected OneValueField(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
