package LinkList;

public class LinkedListCycle1 
{
	static class ListNode
	{
		int val;
		ListNode next;
		public ListNode(int val)
		{
			this.val = val;
		}
	}
	 public boolean hasCycle(ListNode head)
	 {
	    if (head == null || head.next == null)
	        return false;
	        
	    ListNode slow = head;
	    ListNode fast = head;
	   
	    while(fast != null && fast.next != null)
	    {
	       fast = fast.next.next;
	       slow = slow.next;
	            
	       if (slow != null && fast != null && fast.val == slow.val)
	           return true;
	    }
	    return false;
	  }
	 
	 public ListNode detectCycle(ListNode head)
	 {
	    if (head == null || head.next == null)
	        return null;
	        
	    ListNode slow = head;
	    ListNode fast = head;

	    while(fast != null && fast.next != null && slow != fast)
	    {
	        slow = slow.next;
	        fast = fast.next.next;
	    }      
	    
	    if (slow == fast){
	    	slow = head;
            while(slow != fast)
            {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
	    }
	   return null;
	 }
}
