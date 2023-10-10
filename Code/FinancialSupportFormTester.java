import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FinancialSupportFormTester {
    
    @Test
    void test1() {
        FinancialSupportForm form = new FinancialSupportForm();
        assertEquals(form.getForm(), null);
    }
}
