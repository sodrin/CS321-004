package group28;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class WorkflowTableTester {

    WorkflowTable table = new WorkflowTable();

    // TODO: Faker class that can generate fake objects for testing,
    //   or put it somewhere else, maybe a factory method in the class itself...

    // Name tests for what we want to test

    // Test inserting and removing 3 forms with queue-like functionality
    // TODO: Assumes getNextPendingReview automatically removes the form from the workflow table
    @Test
    void getReviewsInOrder() {
        FinancialSupportForm firstForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm secondForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm thirdForm = Faker.getFakeFinancialSupportForm();
        table.addPendingReview(firstForm);
        table.addPendingReview(secondForm);
        table.addPendingReview(thirdForm);
        assertEquals(table.getNextPendingReview(), firstForm);
        assertEquals(table.getNextPendingReview(), secondForm);
        assertEquals(table.getNextPendingReview(), thirdForm);
    }

    // Test inserting and removing 3 forms with queue-like functionality
    // TODO: Assumes getNextPendingApproval automatically removes the form from the workflow table
    @Test
    void getApprovalsInOrder() {
        FinancialSupportForm firstForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm secondForm = Faker.getFakeFinancialSupportForm();
        FinancialSupportForm thirdForm = Faker.getFakeFinancialSupportForm();
        table.addPendingApproval(firstForm);
        table.addPendingApproval(secondForm);
        table.addPendingApproval(thirdForm);
        assertEquals(table.getNextPendingApproval(), firstForm);
        assertEquals(table.getNextPendingApproval(), secondForm);
        assertEquals(table.getNextPendingApproval(), thirdForm);
    }


}
