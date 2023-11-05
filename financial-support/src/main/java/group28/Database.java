package group28;

import java.util.HashMap;

public class Database {
    private static HashMap<Integer, FinancialSupportForm> forms = new HashMap<Integer, FinancialSupportForm>();
    
    // Returns null if the form does not exist
    public static FinancialSupportForm getForm(int id) {
        return forms.get(id);
    }

    // Returns true if the form already existed.
    // Returns false if the form did not exist yet. Still sets the form if returns false.
    public static boolean setForm(FinancialSupportForm form) {
        return forms.put(form.ID, form) != null;
    }
}
