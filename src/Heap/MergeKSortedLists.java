package Heap;

import java.util.PriorityQueue;

public class MergeKSortedLists 
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
	
	public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode head = null, tail = null;
        if (lists == null || lists.length == 0)
            return head;
        
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((l1,l2)->l1.val - l2.val);
        
        for (ListNode listHead : lists)
        {
            if(listHead != null)
                pQueue.add(listHead);
        }
        
        while(!pQueue.isEmpty())
        {
            ListNode node = pQueue.remove();
            
            if (head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = tail.next;
            }
            
           if (node.next != null)
           {
               pQueue.add(node.next);
           }
      
        }
        return head;
    }
}
