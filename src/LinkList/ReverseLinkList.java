package LinkList;

/**
 * Idea is to keep two additional pointers let's say prev and next apart from current. 
 * Loop until curr not equal to null. 
 * 	   next = curr.next
 * 	   curr.next = prev
 * 	   prev = curr
 * 	   curr = next
 * 
 * return prev as head of the reversed list
 * @author Manoj.K
 *
 */
public class ReverseLinkList 
{
    static Node head;
    
    static class Node
    {
    	int data;
    	Node next;
    	Node (int d)
    	{
    		data = d;
    		next = null;
    	}
    }
    
    Node reverseList(Node head)
    {
    	Node prev = null;
    	Node next = null;
    	Node curr = head;
    	
    	while (curr != null)
    	{
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	return prev;
    }
    
    
    void printList(Node head)
    {
    	while (head != null)
    	{
    		System.out.print(" "+head.data);
    		head = head.next;
    	}
    }
    
    public static void main(String args[])
    {
    	ReverseLinkList list = new ReverseLinkList();
    	list.head = new Node(1);
    	list.head.next = new Node(2);
    	list.head.next.next = new Node(3);
    	list.head.next.next.next = new Node(4);
    	
    	System.out.println("Origninal list: ");
    	list.printList(head);
    	
    	System.out.println("Reversed list: ");
    	head = list.reverseList(head);
    	list.printList(head);
    }
}
