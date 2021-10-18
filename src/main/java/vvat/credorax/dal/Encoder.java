package vvat.credorax.dal;

import java.util.Base64;

public class Encoder {

    private Encoder() {}

    public static String encode(String source) {
        return Base64.getEncoder().encodeToString(source.getBytes());
    }

    public static String decode(String source) {
        byte[] decodedBytes = Base64.getDecoder().decode(source);
        return new String(decodedBytes);
    }
}
