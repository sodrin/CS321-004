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

public class ReviewScreen {
	private FinancialSupportForm currentForm;
	private ReviewScreenController controller;
	// For authentication / blame tracking in the future.
	private int employeeId = -1;
	// For keeping track of which form we're performing default actions on.
	public int currentFormId = -1;

    public void showScreen(){
		// Try/catch block because we read for a file that _should_ always exist, but technically could be not there
		try {
			// Load the FXML template into the scene
			FXMLLoader fxmlView = new FXMLLoader(getClass().getResource("/fxml/ReviewScreen.fxml"));
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
			System.out.println("Error loading the ReviewScreen.fxml file. Make sure it exists!");
			e.printStackTrace();
		}
    }
	public boolean getNextForm() {
		if (controller == null) return false;
		FinancialSupportForm nextForm = WorkflowTable.masterTable.getNextPendingReview();
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

	public void sendFormToApproval() {
		this.sendFormToApproval(currentFormId);
	}
	public void sendFormToApproval(int formId){
		WorkflowTable.masterTable.addPendingApproval(FinancialSupportForm.getForm(formId));
		controller.clearForm();
		controller.noFormMode();
	}

	public void denyForm() {
		this.denyForm(currentFormId);
	}
	public void denyForm(int formId){
		FinancialSupportForm.sendDenialEmail(currentFormId);
		controller.clearForm();
		controller.noFormMode();
	}

	public boolean validateForm(){
		return true;
	}
}
