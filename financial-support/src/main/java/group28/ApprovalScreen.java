package group28;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ApprovalScreen handles creation of the window for the approval process.
 */
public class ApprovalScreen {

	// For authentication / blame tracking in the future.
	private int employeeId = -1;
	// For keeping track of which form we're performing default actions on.
	public int currentFormId = -1;
	// For changing elements on the screen after the screen is launched.
	private ApprovalScreenController controller;

	// TODO authentication / login screen before main screen
	public boolean authenticate(String username, String password, int employeeId) {
		// TODO authentication here
		boolean authenticated = true;

		if (authenticated) {
			this.employeeId = employeeId;
			return true; 
		}

		return false;
	}
	
	// Called fron the controller on button press
	public boolean getNextForm() {
		if (controller == null) return false;
		FinancialSupportForm nextForm = WorkflowTable.masterTable.getNextPendingApproval();
		if (nextForm != null) {
			currentFormId = nextForm.getID();
			controller.setNoMoreFormsMessageVisibility(false);
			controller.displayForm(nextForm);
			controller.formMode();
			return true;
		} else {
			controller.setNoMoreFormsMessageVisibility(true);
			return false;
		}
	}

	// We're always going to be referring to the current fomr anyway
	public void approveForm() {
		this.approveForm(currentFormId);
	}

	// Called fron the controller on button press
	public void approveForm(int formId) {
		// TODO set form status as approved
		// TODO send Email to applicant
		controller.clearForm();
		controller.noFormMode();
	}

	// We're always going to be referring to the current fomr anyway
	public void sendFormToReview() {
		this.sendFormToReview(currentFormId);
	}

	// Called from the controller on button press
	public void sendFormToReview(int formId) {
		WorkflowTable.masterTable.addPendingReview(FinancialSupportForm.getForm(formId));
		controller.clearForm();
		controller.noFormMode();
	}
    
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

			// TODO remove this, for testing only
			// for (int i = 0; i < 5; i ++) {
			// 	FinancialSupportForm form = Faker.getFakeFinancialSupportForm();
			// 	form.saveForm();
			// 	WorkflowTable.masterTable.addPendingApproval(form);
			// }

			// Initialize the form's state
			controller = fxmlView.getController();
			controller.setMasterScreen(this);
			controller.clearForm();
			controller.noFormMode();
		} catch (IOException e) {
			// Error loading the FXML, can't load the screen.
			System.out.println("Error loading the ApprovalScreen.fxml file. Make sure it exists!");
			e.printStackTrace();
		}
    }
}
