package LinkList;
public class SortLinkedList 
{
	static class ListNode
	{
		int val = 0;
		ListNode next = null;
		
		public ListNode(int val)
		{
			this.val = val;
		}
	}
	
	public static ListNode sortList(ListNode head) 
    {
        if (head == null || head.next == null)
            return head;
        /*
         * Idea is to divide each time list into two halves where one list is created 
         * from head node to pslow node as tail node and second node head is slow and tail is fast. 
        */
        ListNode pslow = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next != null)
        {
            pslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        /**
        * Break the first list from second list by assigning pslow.next = null
        */
        pslow.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return mergeTwoLists(l1,l2);
    }
    
    private static  ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 != null)
            curr.next = l1;
        
        else if (l2 != null)
            curr.next = l2;
        
        return dummy.next;
    }
    
    public static void main(String args[])
    {
    	ListNode list = new ListNode(3);
		list.next = new ListNode(1);
		list.next.next = new ListNode(4);
		list.next.next.next = new ListNode(2);
		list.next.next.next.next = new ListNode(5);
		
		ListNode head = sortList(list);
		ListNode curr = head;
		
		System.out.println("Sorted list is :");
		while(curr != null)
		{
			System.out.print(" "+curr.val);
			curr = curr.next;
		}
    }
}
