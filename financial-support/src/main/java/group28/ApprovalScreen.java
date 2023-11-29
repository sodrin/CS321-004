package group28;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Test comment

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

	// Sets the controller manually, for testing
	public void setController(ApprovalScreenController newController) {
		this.controller = newController;
	}
	
	// Called fron the controller on button press
	public boolean getNextForm() {
		if (controller == null) return false;
		FinancialSupportForm nextForm = WorkflowTable.masterTable.getNextPendingApproval();
		if (nextForm != null) {
			currentFormId = nextForm.getID();
			try {
				controller.setNoMoreFormsMessageVisibility(false);
				controller.displayForm(nextForm);
				controller.formMode();
			} catch (NullPointerException e) {
				System.out.println("Warning: Controller threw NullPointerException");
			}
			return true;
		} else {
			try {
				controller.setNoMoreFormsMessageVisibility(true);
			} catch (NullPointerException e) {
				System.out.println("Warning: Controller threw NullPointerException");
			}
			return false;
		}
	}

	// We're always going to be referring to the current fomr anyway
	public void approveForm() {
		this.approveForm(currentFormId);
	}

	// Called fron the controller on button press
	public void approveForm(int formId) {
		FinancialSupportForm.sendApprovalEmail(currentFormId);
		try {
			controller.clearForm();
			controller.noFormMode();
		} catch (NullPointerException e) {
			System.out.println("Warning: Controller threw NullPointerException");
		}
	}

	// We're always going to be referring to the current fomr anyway
	public void sendFormToReview() {
		this.sendFormToReview(currentFormId);
	}

	// Called from the controller on button press
	public void sendFormToReview(int formId) {
		WorkflowTable.masterTable.addPendingReview(FinancialSupportForm.getForm(formId));
		try {
			controller.clearForm();
			controller.noFormMode();
		} catch (NullPointerException e) {
			System.out.println("Warning: Controller threw NullPointerException");
		}
	}
    
	// Entry code for the ApprovalScreen class
    public void showScreen(){
		// Try/catch block because we read for a file that _should_ always exist, but technically could be not there
		try {
			// Load the FXML template into the scene
			URL fxmlFile = getClass().getResource("/fxml/ApprovalScreen.fxml");
			System.out.println("FXML FILE: " + fxmlFile);
			FXMLLoader fxmlView = new FXMLLoader(fxmlFile);
			Scene scene = new Scene(fxmlView.load());

			// Set the stage and show the window
			Stage newWindow = new Stage();
			newWindow.setTitle("Form Approval UI");
			newWindow.setScene(scene);
			newWindow.show();

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
