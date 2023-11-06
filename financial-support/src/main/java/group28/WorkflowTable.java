package group28;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkflowTable{
  // Singleton instance for consistant global access
  public static WorkflowTable masterTable = new WorkflowTable();

  private Queue<Integer> pendingReviews = new LinkedBlockingQueue<Integer>();
  private Queue<Integer> pendingApprovals = new LinkedBlockingQueue<Integer>();

  // Returns null if the queue is empty
  public FinancialSupportForm getNextPendingReview(){
    Integer formID = pendingReviews.poll();
    if (formID == null) return null;
    return FinancialSupportForm.getForm(formID);
  }

  // Returns null if the queue is empty
  public FinancialSupportForm getNextPendingApproval(){
    Integer formID = pendingApprovals.poll();
    if (formID == null) return null;
    return FinancialSupportForm.getForm(formID);
  }

  // Returns true if the element was added successfully
  public Boolean addPendingReview(FinancialSupportForm form){
    return pendingReviews.offer(form.ID);
  }

  // Returns true if the element was added successfully
  public Boolean addPendingApproval(FinancialSupportForm form){
    return pendingApprovals.offer(form.ID);
  }
}
