package group28;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ApprovalScreen {

	@FXML private TextField APPLICANT_EMAIL;
    
    public void showScreen(){
        // Label label = new Label("I'm a Label the approval screen");

		// StackPane layout = new StackPane();
		// layout.getChildren().add(label);
		
		try {
			FXMLLoader fxmlView = new FXMLLoader(getClass().getResource("fxml/ApprovalScreen.fxml"));
			Scene scene = new Scene(fxmlView.load());
			Stage newWindow = new Stage();
			newWindow.setTitle("Form Approval UI");
			newWindow.setScene(scene);
			newWindow.show();

			ApprovalScreenController controller = fxmlView.getController();

			controller.setApplicantFirstName("Jane");
			controller.setApplicantLastName("Doe");
			controller.setApplicantSSN("555-55-5555");
			controller.setApplicantEmail("JaneDoe@example.com");

			controller.setRecipientFirstName("John");
			controller.setRecipientLastName("Smith");
			controller.setRecipientDateOfBirth("01-01-1999");
			controller.setRecipientAlienNumber("55-55-55-555");
			controller.setRecipientEmail("JohnSmith@example.co.uk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/*
	 * Visible attributes of a form:
	 * Applicant first / last name
	 * SSN
	 * Applicant Email
	 * Recipient first / last name
	 * Recipient DOB, Alien number
	 * Recipient Email
	 */
}
