package group28;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class WorkflowTableTester {

    WorkflowTable table = WorkflowTable.masterTable;

    // * Name tests for what we want to test

    // Test inserting and removing 3 forms with queue-like functionality
    // This test proves functionality of:
    // - FIFO queue functionality
    // - Automatic removal from queue on method call
    // These are pretty much all the things we need to test for to prove complete functionality.
    @Test
    void getReviewsInOrder() {
        FinancialSupportForm firstForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm secondForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm thirdForm = Faker.getFakeFinancialSupportForm();
        firstForm.saveForm();
        secondForm.saveForm();
        thirdForm.saveForm();
        table.addPendingReview(firstForm);
        table.addPendingReview(secondForm);
        table.addPendingReview(thirdForm);
        assertEquals(firstForm, table.getNextPendingReview());
        assertEquals(secondForm, table.getNextPendingReview());
        assertEquals(thirdForm, table.getNextPendingReview());
    }

    // Test inserting and removing 3 forms with queue-like functionality
    // Duplicate of above test for the approval queue
    @Test
    void getApprovalsInOrder() {
        FinancialSupportForm firstForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm secondForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm thirdForm = Faker.getFakeFinancialSupportForm();
        firstForm.saveForm();
        secondForm.saveForm();
        thirdForm.saveForm();
        table.addPendingApproval(firstForm);
        table.addPendingApproval(secondForm);
        table.addPendingApproval(thirdForm);
        assertEquals(firstForm, table.getNextPendingApproval());
        assertEquals(secondForm, table.getNextPendingApproval());
        assertEquals(thirdForm, table.getNextPendingApproval());
    }


}
