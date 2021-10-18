package vvat.credorax.data;

public class Error {
    private String key;
    private String description;

    public Error(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
