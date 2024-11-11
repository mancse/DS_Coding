package LinkList;

public class RemoveNthNodeFromEnd 
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
	public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null || n == 0)
            return head;
        
        
        ListNode first = head;
        ListNode second = head;
        ListNode prev = head;
        
        int count = 0;
        
        if (head.next == null && n == 1)
            return null;
        
        while(second != null && count < n)
        {
            second = second.next;
            count = count + 1;
        }
        
        while (second != null)
        {
            prev = first;
            first = first.next;
            second = second.next;
        }
        
        if (first == head)
        {
        	head = first.next;
        }
        else
        {
        	 prev.next = first.next;
             first.next = null;
        } 
        
        return head;
    }

	public static void main(String args[])
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		ListNode head1 =  removeNthFromEnd(head,2);
		System.out.println(head1.val);
	}
}
