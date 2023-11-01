package group28;

import java.util.Queue;

public class WorkflowTable{
  Queue<Integer> pendingReviews;
  Queue<Integer> pendingApprovals;

  FinancialSupportForm BO = new FinancialSupportForm();

  FinancialSupportForm getNextPendingReview(){
    Integer formID = pendingReviews.poll();
    if (formID == null) return null;
    // TODO: We need some static way to get forms from form IDs, unless
    //   we are using one global BusinessObject instance.
    return BO.getForm(formID);
  }

  FinancialSupportForm getNextPendingApproval(){
    Integer formID = pendingApprovals.poll();
    if (formID == null) return null;
    return BO.getForm(formID);
  }

  Boolean addPendingReview(FinancialSupportForm form){
    Boolean result = pendingReviews.offer(form.ID);
    return result;
  }

  Boolean addPendingApproval(FinancialSupportForm form){
    Boolean result = pendingApprovals.offer(form.ID);
    return result;
  }
}
