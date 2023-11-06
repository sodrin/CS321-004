package group28;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ApprovalScreenController {

    // Text Fields in ApprovalScreen.fxml
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

    // Buttons in ApprovalScreen.fxml
    @FXML
    private Button nextFormButton;
    @FXML
    private Button reviewButton;
    @FXML
    private Button approveButton;

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

    // Form mode disables the next form request button, and enables the decision buttons
    public void formMode() {
        setDisableNextFormButton(true);
        setDisableApproveButton(false);
        setDisableReviewButton(false);
    }

    // No Form mode enables the next form request button, and disables the decision buttons
    public void noFormMode() {
        setDisableNextFormButton(false);
        setDisableApproveButton(true);
        setDisableReviewButton(true);
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

    public void setDisableApproveButton(boolean disable) {
        approveButton.setDisable(disable);
    }


    // Event listeners for the buttons

    public void nextFormButtonPressed() {
        System.out.println("Requesting new form...");
        // TODO: Link to business object instead of generating fake form here
        FinancialSupportForm fakeForm = Faker.getFakeFinancialSupportForm();
        displayForm(fakeForm);
        formMode();
    }

    public void reviewButtonPressed() {
        System.out.println("Sending current form back to review...");
        clearForm();
        noFormMode();
    }

    public void approveButtonPressed() {
        System.out.println("Approving current form...");
        clearForm();
        noFormMode();
    }
}
