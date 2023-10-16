public class WorkflowTable{
  int[] PendingReview;
  int[] PendingApproval;

  FinancialSupportForm GetNextPendingReview(){
    return null;
  }

  FinancialSupportForm GetNextPendingApproval(){
    return null;
  }

  Boolean AddPendingReview(FinancialSupportForm form){
    return false;
  }

  Boolean AddPendingApproval(FinancialSupportForm form){
    return false;
  }
}
