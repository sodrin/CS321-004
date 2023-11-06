package group28;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ApprovalScreen handles creation of the window for the approval process.
 */
public class ApprovalScreen {

	private int employeeId = -1;
	public int currentFormId = -1;
	private ApprovalScreenController controller;

	public boolean authenticate(String username, String password, int employeeId) {
		// TODO authentication here
		boolean authenticated = true;

		if (authenticated) {
			this.employeeId = employeeId;
			return true; 
		}

		return false;
	}
	
	public boolean getNextForm() {
		// TODO
		if (controller == null) return false;
		FinancialSupportForm nextForm = WorkflowTable.masterTable.getNextPendingApproval();
		if (nextForm != null) {
			controller.displayForm(nextForm);
			controller.formMode();
			return true;
		}
		return false;
	}

	public void approveForm() {
		this.approveForm(currentFormId);
	}

	public void approveForm(int formId) {
		// TODO
		controller.clearForm();
		controller.noFormMode();
	}

	public void sendFormToReview() {
		this.sendFormToReview(currentFormId);
	}
	
	public void sendFormToReview(int formId) {
		// TODO
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
