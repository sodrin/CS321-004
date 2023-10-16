import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class WorkflowTableTester {

    WorkflowTable table = new WorkflowTable();

    @Test
    void test1() {

        assertEquals(table, form.GetNextPendingReview());
        assertEquals(table, form.GetNextPendingApproval());
    }
}
