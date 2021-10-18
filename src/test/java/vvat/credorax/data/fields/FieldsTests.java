package vvat.credorax.data.fields;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vvat.credorax.data.Error;

import java.util.ArrayList;
import java.util.List;

public class FieldsTests {

    @Test
    public void testCvv() {
        List<Error> errors = new ArrayList<>();
        Cvv cvv = new Cvv(753);
        Assertions.assertTrue(cvv.validate(errors));
        Assertions.assertEquals(0, errors.size());
        Assertions.assertNull(cvv.getSanitizedValue());
        Assertions.assertEquals(753, cvv.getValue().intValue());

        cvv = new Cvv(1753);
        Assertions.assertFalse(cvv.validate(errors));
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("cvv", errors.get(0).getKey());
    }

    // Accordingly to the example above add other fields tests
}
