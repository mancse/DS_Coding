package LinkList;

public class AddTwoNumbers 
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
    
    public static void main(String args[])
    {
    	ListNode l1= new ListNode(5);
    	ListNode l2 = new ListNode(5);
    	
    	ListNode res = addTwoNumbers(l1,l2);
    	
    	ListNode curr = res;
        while(curr != null)
        {
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
    }
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode result =  addTwoNumbersList(l1, l2);
        ListNode curr = result;
        while(curr != null)
        {
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        return result;
    }
    
    private static ListNode addTwoNumbersList(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode resHead = null; 
        ListNode resTail = null;
        int sum = 0;
        while(l1 != null || l2 != null)
        {
            if (l1 != null && l2 != null)
            {
                sum = carry + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null)
            {
                sum = carry + l1.val;
                l1 = l1.next;
            }
            else if (l2 != null)
            {
                sum = carry + l2.val;
                l2 = l2.next;
            }
            
            int unit = sum % 10;
            carry = sum/10;
                
            ListNode newNode = new ListNode(unit);
            if (resTail == null)
            {
                resHead = newNode;
                resTail = newNode;
            }
            else
            {
               resTail.next = newNode;
               resTail = resTail.next;
            }
        }
        
        if (carry > 0 && l1== null && l2 == null)
        {
        	ListNode newNode = new ListNode(carry);
        	resTail.next = newNode;
            resTail = resTail.next;
        }
        return resHead;
    }
}
