package LinkList;

public class MergeTwoSortedLists 
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
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null && l2 !=null)
        {
            if (l1.val < l2.val)
            {
              head.next = l1;
              l1 = l1.next;
            }
            else
            {
               head.next = l2;
               l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null)
        {
        	head.next = l1;
        }
        else if (l2 != null)
        {
        	head.next = l2;
        }
        return dummy.next;
    }
	
	public static void main(String args[])
	{
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(5);
		
		ListNode head = mergeTwoLists(list1,list2);
		ListNode tmp = head;
		
		while(tmp != null)
		{
			System.out.print(" "+tmp.val);
			tmp = tmp.next;
		}
	}
}
