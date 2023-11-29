package group28;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

// Class for testing the ApprovalScreen class functionality
public class ApprovalScreenTester {

    // Tests the authentication method
    @Test
    public void testAuthentication() {
        ApprovalScreen screen = new ApprovalScreen();
        // When this test is fully implemented, these inputs will be sourced from the login database.
        boolean result = screen.authenticate("admin", "pass", 123);
        assertEquals(true, result);
    }

    // Tests the form workflow through the ApprovalScreen class
    // Covers multiple methods
    @Test
    public void testFormWorkflow() {
        ApprovalScreen screen = new ApprovalScreen();
        ApprovalScreenController controller = new ApprovalScreenController();
        screen.setController(controller);
        WorkflowTable table = WorkflowTable.masterTable;
        // Get fake forms
        FinancialSupportForm formToApprove = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm formToSendToReview = Faker.getFakeFinancialSupportForm();
        formToApprove.saveForm();
        formToSendToReview.saveForm();
        // insert forms into workflow table
        table.addPendingApproval(formToApprove);
        table.addPendingApproval(formToSendToReview);
        // getNextForm
        screen.getNextForm();
        assertEquals(formToApprove.getID(), screen.currentFormId);
        // No feedback from approveForm method, can't definitively test
        screen.approveForm();
        // sendFormToReview
        screen.getNextForm();
        assertEquals(formToSendToReview.getID(), screen.currentFormId);
        screen.sendFormToReview();
        assertEquals(formToSendToReview, table.getNextPendingReview());
        // Postcondition - WorkflowTable is empty
        assertEquals(null, table.getNextPendingApproval());
        assertEquals(null, table.getNextPendingReview());
    }

    // Test the showScreen method
    @Test
    public void testShowScreen() {
        // TODO
        // How do you prove the window is on screen?
        ApprovalScreen screen = new ApprovalScreen();
        assertEquals(true, true);
    }

    // Tests the form workflow through the ApprovalScreen class
    // Uses the button methods in APprovalScreenController,
    //  simulating button presses in the window
    @Test
    public void testApprovalScreenButtons() {
        ApprovalScreen screen = new ApprovalScreen();
        ApprovalScreenController controller = new ApprovalScreenController();
        screen.setController(controller);
        controller.setMasterScreen(screen);
        WorkflowTable table = WorkflowTable.masterTable;
        // Get fake forms
        FinancialSupportForm formToApprove = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm formToSendToReview = Faker.getFakeFinancialSupportForm();
        formToApprove.saveForm();
        formToSendToReview.saveForm();
        // insert forms into workflow table
        table.addPendingApproval(formToApprove);
        table.addPendingApproval(formToSendToReview);
        // getNextForm
        controller.nextFormButtonPressed(); // Calls getNextForm
        assertEquals(formToApprove.getID(), screen.currentFormId);
        // No feedback from approveForm method, can't definitively test
        controller.approveButtonPressed();  // Calls approveForm
        // sendFormToReview
        controller.nextFormButtonPressed(); // Calls getNextForm
        assertEquals(formToSendToReview.getID(), screen.currentFormId);
        controller.reviewButtonPressed();   // Calls sendFormToReview
        assertEquals(formToSendToReview, table.getNextPendingReview());
        // Postcondition - WorkflowTable is empty
        assertEquals(null, table.getNextPendingApproval());
        assertEquals(null, table.getNextPendingReview());
    }
}
