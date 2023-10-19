import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FinancialSupportFormTester {

    FinancialSupportForm form = new FinancialSupportForm();

    @Test
    void saveFormTest(){
        
        assertEquals(true, form.saveForm());

        form.setID(123);
        assertEquals(true, form.saveForm());

        assertEquals(false, form.saveForm());
    }

    @Test
    void getFormTest(){
        assertEquals(false, FinancialSupportForm.getForm(99));

        assertEquals(true, FinancialSupportForm.getForm(123));
    }
}
