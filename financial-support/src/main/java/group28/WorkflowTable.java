package group28;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkflowTable{
  Queue<Integer> pendingReviews = new LinkedBlockingQueue<Integer>();
  Queue<Integer> pendingApprovals = new LinkedBlockingQueue<Integer>();

  FinancialSupportForm BO = new FinancialSupportForm();

  // Returns null if the queue is empty
  FinancialSupportForm getNextPendingReview(){
    Integer formID = pendingReviews.poll();
    if (formID == null) return null;
    return FinancialSupportForm.getForm(formID);
  }

  // Returns null if the queue is empty
  FinancialSupportForm getNextPendingApproval(){
    Integer formID = pendingApprovals.poll();
    if (formID == null) return null;
    return FinancialSupportForm.getForm(formID);
  }

  // Returns true if the element was added successfully
  Boolean addPendingReview(FinancialSupportForm form){
    return pendingReviews.offer(form.ID);
  }

  // Returns true if the element was added successfully
  Boolean addPendingApproval(FinancialSupportForm form){
    return pendingApprovals.offer(form.ID);
  }
}
