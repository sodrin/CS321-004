package group28;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReviewScreenController {

    // Text Fields in ReviewScreen.fxml
    @FXML
    private TextField APPLICANT_FNAME;
    @FXML
    private TextField APPLICANT_LNAME;
    @FXML
    private TextField APPLICANT_SSN;
    @FXML
    private TextField APPLICANT_EMAIL;
    @FXML
    private TextField RECIPIENT_FNAME;
    @FXML
    private TextField RECIPIENT_LNAME;
    @FXML
    private TextField RECIPIENT_DOB;
    @FXML
    private TextField RECIPIENT_ALIEN_NUMBER;
    @FXML
    private TextField RECIPIENT_EMAIL;

    // Buttons in ReviewScreen.fxml
    @FXML
    private Button nextFormButton;
    @FXML
    private Button reviewButton;
    @FXML
    private Button denyButton;
    @FXML
    private Button validateButton;

    // Message label for when there aren't forms left for review
    @FXML
    private Label NO_MORE_FORMS_MSG;
    // Message label for when form has inputs validated again.
    private Label VALIDATE_MSG;
    // Message label for when form has been updated by being sent to approval or
    // denied.
    private Label UPDATE_MSG;

    // Link to screen that launched the controller
    private ReviewScreen masterScreen;

    // Called from ReviewScreen.
    public void setMasterScreen(ReviewScreen screen) {
        masterScreen = screen;
    }

    // Load the information from an entire form into the text fields
    public void displayForm(FinancialSupportForm form) {
        setApplicantFirstName(form.FirstName);
        setApplicantLastName(form.LastName);
        setApplicantSSN(form.SSN);
        setApplicantEmail(form.ApplicantEmail);
        setRecipientFirstName(form.RecipientFirstName);
        setRecipientLastName(form.RecipientLastName);
        setRecipientDateOfBirth(form.RecipientDateOfBirth.toString());
        setRecipientAlienNumber(form.RecipientAlienNumber);
        setRecipientEmail(form.RecipientEmail);
    }

    // Clear all text fields, replace with N/A to indicate no form is loaded.
    public void clearForm() {
        setApplicantFirstName("N/A");
        setApplicantLastName("N/A");
        setApplicantSSN("N/A");
        setApplicantEmail("N/A");
        setRecipientFirstName("N/A");
        setRecipientLastName("N/A");
        setRecipientDateOfBirth("N/A");
        setRecipientAlienNumber("N/A");
        setRecipientEmail("N/A");
    }

    // Form mode disables the next form request button, and enables the decision
    // buttons
    public void formMode() {
        setDisableNextFormButton(true);
        setDisableDenyButton(false);
        setDisableReviewButton(false);
        setDisableValidateButton(false);
    }

    // No Form mode enables the next form request button, and disables the decision
    // buttons
    public void noFormMode() {
        setDisableNextFormButton(false);
        setDisableDenyButton(true);
        setDisableReviewButton(true);
        setDisableValidateButton(true);
    }

    // Granular control below

    public void setApplicantFirstName(String newString) {
        APPLICANT_FNAME.setText(newString);
    }

    public void setApplicantLastName(String newString) {
        APPLICANT_LNAME.setText(newString);
    }

    public void setApplicantSSN(String newString) {
        APPLICANT_SSN.setText(newString);
    }

    public void setApplicantEmail(String newString) {
        APPLICANT_EMAIL.setText(newString);
    }

    public void setRecipientFirstName(String newString) {
        RECIPIENT_FNAME.setText(newString);
    }

    public void setRecipientLastName(String newString) {
        RECIPIENT_LNAME.setText(newString);
    }

    public void setRecipientDateOfBirth(String newString) {
        RECIPIENT_DOB.setText(newString);
    }

    public void setRecipientAlienNumber(String newString) {
        RECIPIENT_ALIEN_NUMBER.setText(newString);
    }

    public void setRecipientEmail(String newString) {
        RECIPIENT_EMAIL.setText(newString);
    }

    public void setDisableNextFormButton(boolean disable) {
        nextFormButton.setDisable(disable);
    }

    public void setDisableReviewButton(boolean disable) {
        reviewButton.setDisable(disable);
    }

    public void setDisableDenyButton(boolean disable) {
        denyButton.setDisable(disable);
    }

    public void setDisableValidateButton(boolean disable) {
        validateButton.setDisable(disable);
    }

    public void setNoMoreFormsMessageVisibility(boolean visible) {
        NO_MORE_FORMS_MSG.setVisible(visible);
    }

    public void setFormUpdateMessageVisibility(boolean visible) {
        UPDATE_MSG.setVisible(visible);
    }

    public void setValidateMessageVisibility(boolean visible) {
        VALIDATE_MSG.setVisible(visible);
    }

    // Event listeners for the buttons

    // Calls corresponding parent ReviewScreen method
    public void nextFormButtonPressed() {
        System.out.println("Requesting new form...");
        if (masterScreen == null)
            return;
        masterScreen.getNextForm();
    }

    // Calls corresponding parent ReviewScreen method
    public void reviewButtonPressed() {
        System.out.println("Sending current form to approval...");
        if (masterScreen == null)
            return;
        masterScreen.sendFormToApproval();
    }

    // Calls corresponding parent ReviewScreen method
    public void denyButtonPressed() {
        System.out.println("Denying current form...");
        if (masterScreen == null)
            return;
        masterScreen.denyForm();
    }

    // Calls corresponding parent ReviewScreen method
    public void validateButtonPressed() {
        System.out.println("Validating inputs...");
        if (masterScreen == null)
            return;
        masterScreen.validateForm();
    }
}
