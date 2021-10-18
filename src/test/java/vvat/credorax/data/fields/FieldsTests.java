package vvat.credorax.data.fields;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import vvat.credorax.data.Error;

import java.util.ArrayList;
import java.util.List;

public class FieldsTests {

    @Test
    public void testCvv() {
        List<Error> errors = new ArrayList<>();
        Cvv cvv = new Cvv(753);
        Assert.assertTrue(cvv.validate(errors));
        Assert.assertEquals(0, errors.size());
        Assert.assertEquals("***", cvv.getSanitizedValue());
        Assert.assertEquals(753, cvv.getValue().intValue());

        cvv = new Cvv(1753);
        Assert.assertFalse(cvv.validate(errors));
        Assert.assertEquals(1, errors.size());
        Assert.assertEquals("cvv", errors.get(0).getKey());
    }

    // Accordingly to the example above add other fields tests
}
