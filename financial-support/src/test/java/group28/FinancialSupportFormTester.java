package group28;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FinancialSupportFormTester {

    FinancialSupportForm form = new FinancialSupportForm();
    
    // Tests saving functionality
    @Test
    void saveFormTest(){
        form.setID(100);
        // Should return true because any form with that ID does not exist yet
        assertEquals(true, form.saveForm());

        form.setID(123);
        // Should return true because any form with that ID does not exist yet
        assertEquals(true, form.saveForm());

        // Should return FALSE because we have already saved this form with the same ID
        assertEquals(false, form.saveForm());
    }

    // Tests the getForm method
    @Test
    void getFormTest(){
        // Should return null because there is no form with 99 as the ID
        assertEquals(null, FinancialSupportForm.getForm(99));

        // Pick an ID we haven't used yet
        form.setID(456);
        // Save form into database so we can get it later
        form.saveForm();
        // Should return true because we saved the form with that ID
        assertEquals(form, FinancialSupportForm.getForm(456));
    }
}
