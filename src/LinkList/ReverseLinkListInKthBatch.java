package LinkList;


/**
 * Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. 
 * Let the pointer to the next node be next and pointer to the previous node be prev. 
 * head->next = reverse(next, k) ( Recursively call for rest of the list and link the two sub-lists )
 * Return prev ( prev becomes the new head of the list.
 * @author Manoj.K
 *
 */

class Node 
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class ReverseLinkListInKthBatch 
{
	private static Node reverstLinkListInKthBatch(Node head,int k)
	{
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		int count =0;
		
		while (count < k && curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if (next != null)
			head.next = reverstLinkListInKthBatch(next,k);
		
		return prev;
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		
		System.out.println("Origninal list: ");
        
		Node curr = head;
	    while (curr != null)
	    {
	    	System.out.print(" "+curr.data);
	    	curr = curr.next;
	    }
		
		head = reverstLinkListInKthBatch(head,3);
		
		System.out.println("\nReversed list: ");

	    while (head != null)
	    {
	    	System.out.print(" "+head.data);
	    	head = head.next;
	    }
	}
}
