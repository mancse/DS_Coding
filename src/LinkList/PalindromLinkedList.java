package LinkList;

public class PalindromLinkedList 
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
	
	
    public static boolean isPalindrome(ListNode head) 
    {
       ListNode fast = head;
       ListNode slow = head;
       
       while(fast != null && fast.next != null)
       {
    	   fast = fast.next.next;
    	   slow = slow.next;
       }
       
       ListNode head1 = reverseList(slow);
       
       ListNode head2 = head;
       
       while(head1 != null)
       {
    	   if (head1.val != head2.val)
    	   {
    		   return false;
    	   }
    	   head1 = head1.next;
    	   head2 = head2.next;
       }
       return true;
    }
    
    private static ListNode reverseList(ListNode head)
    {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev= null;
        
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String args[])
    {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(0);
    	head.next.next.next = new ListNode(2);
    	head.next.next.next.next = new ListNode(1);
    	boolean ret = isPalindrome(head);
    	System.out.println(ret);
    }
}
