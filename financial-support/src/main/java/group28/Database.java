package group28;

import java.util.HashMap;

public class Database {
    private static HashMap<Integer, FinancialSupportForm> forms = new HashMap<Integer, FinancialSupportForm>();
    public static int databaseSize = 0;
    
    // Returns null if the form does not exist
    public static FinancialSupportForm getForm(int id) {
        return forms.get(id);
    }

    // Returns true if the form already existed.
    // Returns false if the form did not exist yet. Still sets the form if returns false.
    public static boolean setForm(FinancialSupportForm form) {
        boolean newForm = forms.put(form.ID, form) != null;
        // Keep track of the size of the database
        // Database doesn't shrink 'cause there isn't a way to delete forms yet
        if (newForm) databaseSize ++;
        return newForm;
    }

    public static Integer[] getKeys() {
        return forms.keySet().toArray(new Integer[]{});
    }
}
