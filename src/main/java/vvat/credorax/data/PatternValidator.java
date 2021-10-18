package vvat.credorax.data;

import java.util.function.Supplier;
import java.util.regex.Pattern;

public class PatternValidator implements Supplier<Boolean> {
    private final Pattern pattern;
    private final Supplier<String> targetAccessor;

    public PatternValidator(Pattern pattern, Supplier<String> targetAccessor) {
        this.pattern = pattern;
        this.targetAccessor = targetAccessor;
    }

    @Override
    public Boolean get() {
        return pattern.matcher(targetAccessor.get()).matches();
    }
}
