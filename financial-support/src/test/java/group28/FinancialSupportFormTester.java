package group28;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FinancialSupportFormTester {

    FinancialSupportForm form = new FinancialSupportForm();
    

    @Test
    void saveFormTest(){
        
        form.setID(1);
        assertEquals(true, form.saveForm());

        form.setID(123);
        assertEquals(true, form.saveForm());

        assertEquals(false, form.saveForm());
    }

    @Test
    void getFormTest(){
        assertEquals(null, FinancialSupportForm.getForm(99));

        form.setID(123);
        form.saveForm();
        assertEquals(form, FinancialSupportForm.getForm(123));
    }
}
