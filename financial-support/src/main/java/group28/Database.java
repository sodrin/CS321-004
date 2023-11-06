package group28;

import java.util.HashMap;

public class Database {

    // Singleton for global access
    public static Database masterDatabase = new Database();

    private HashMap<Integer, FinancialSupportForm> forms = new HashMap<Integer, FinancialSupportForm>();
    private int databaseSize = 0;

    //  Hide constructor
    private Database() { }
    
    // Returns null if the form does not exist
    public FinancialSupportForm getForm(int id) {
        return forms.get(id);
    }

    // Returns true if the form already existed.
    // Returns false if the form did not exist yet. Still sets the form if returns false.
    public boolean setForm(FinancialSupportForm form) {
        boolean newForm = forms.put(form.ID, form) != null;
        // Keep track of the size of the database
        // Database doesn't shrink 'cause there isn't a way to delete forms yet
        if (newForm) databaseSize ++;
        return newForm;
    }

    // Returns an array of all IDs of forms that exist in the database
    public Integer[] getKeys() {
        return forms.keySet().toArray(new Integer[]{});
    }

    public int getSize() {
        return databaseSize;
    }
}
