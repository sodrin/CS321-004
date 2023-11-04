package group28;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ApprovalScreen handles creation of the window for the approval process.
 */
public class ApprovalScreen {
    
	// Entry code for the ApprovalScreen class
    public void showScreen(){
		// Try/catch block because we read for a file that _should_ always exist, but technically could be not there
		try {
			// Load the FXML template into the scene
			FXMLLoader fxmlView = new FXMLLoader(getClass().getResource("fxml/ApprovalScreen.fxml"));
			Scene scene = new Scene(fxmlView.load());

			// Set the stage and show the window
			Stage newWindow = new Stage();
			newWindow.setTitle("Form Approval UI");
			newWindow.setScene(scene);
			newWindow.show();

			// Initialize the form's state
			ApprovalScreenController controller = fxmlView.getController();
			controller.clearForm();
			controller.noFormMode();
		} catch (IOException e) {
			// Error loading the FXML, can't load the screen.
			System.out.println("Error loading the ApprovalScreen.fxml file. Make sure it exists!");
			e.printStackTrace();
		}
    }
}
