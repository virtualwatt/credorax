package vvat.credorax.data.fields;

import vvat.credorax.Errors;
import vvat.credorax.data.RegexValidatorsFactory;
import vvat.credorax.data.TextField;
import vvat.credorax.data.ValidationCriteria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expiry extends TextField {

    private static final List<ValidationCriteria<String>> validationCriterias = new ArrayList<>();

    static {
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("expiry"),
                RegexValidatorsFactory.generateValidator("^\\n{4}$")));
        validationCriterias.add(new ValidationCriteria<>(Errors.errorFor("expired"),
                value -> {
                    String month = value.substring(0, 1);
                    String year = value.substring(2);
                    String yearMonth = year + month;
                    int ym = Integer.parseUnsignedInt(yearMonth);
                    int curYM = Integer.parseInt(new SimpleDateFormat("yyMM").format(new Date()));
                    return ym < curYM;
                }));
    }

    public Expiry(String value) {
        super(value, validationCriterias);
    }
}
