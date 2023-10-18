public class WorkflowTable{
  int[] PendingReview;
  int[] PendingApproval;

  FinancialSupportForm getNextPendingReview(){
    return null;
  }

  FinancialSupportForm getNextPendingApproval(){
    return null;
  }

  Boolean addPendingReview(FinancialSupportForm form){
    return false;
  }

  Boolean addPendingApproval(FinancialSupportForm form){
    return false;
  }
}
