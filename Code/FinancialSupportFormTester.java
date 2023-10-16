import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FinancialSupportFormTester {

    FinancialSupportForm form = new FinancialSupportForm();

    @Test
    void test1() {
        
        assertEquals(form, form.getForm(123));
    }
}
