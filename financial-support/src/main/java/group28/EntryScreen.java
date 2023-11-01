package group28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * This is the class for the data entry screen.
 */
public class EntryScreen {
    
    private FinancialSupportForm currentForm;

    public void showScreen(){
        Label label = new Label("I'm a Label the entry screen");

		StackPane layout = new StackPane();
		layout.getChildren().add(label);

		Scene scene = new Scene(layout, 230, 100);

        
        Stage newWindow = new Stage();
		newWindow.setTitle("Data Entry");
		newWindow.setScene(scene);

		newWindow.show();
    }

    public boolean submitForm(){
        return false;
    }
}
