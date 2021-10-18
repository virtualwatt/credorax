package vvat.credorax.data;

import java.util.function.Function;
import java.util.regex.Pattern;

public abstract class RegexValidatorsFactory {

    private RegexValidatorsFactory() {}

    public static Function<String, Boolean> generateValidator(String pattern) {
        return new Function<>() {
            private final Pattern thePattern = Pattern.compile(pattern);

            @Override
            public Boolean apply(String stringValue) {
                return thePattern.matcher(stringValue).find();
            }
        };
    }
}
