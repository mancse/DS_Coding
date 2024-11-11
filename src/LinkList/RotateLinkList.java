package LinkList;
public class RotateLinkList 
{
    static Node head;
    static Node curr;
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
    
    void push (int data)
    {
    	Node node = new Node(data);
    	
    	if (head == null)
    	{
    		head = node;
    		curr = head;
    	}
    	else
    	{
    		curr.next = node;
    		curr = curr.next;
    	}
    }
    
    void printList(Node head)
    {
    	while (head != null)
    	{
    		System.out.print(" "+head.data);
    		head = head.next;
    	}
    }
    
    Node rotateList (int k)
    {
    	if (k<=0)
    		return head;
    	
        Node oldHead = head;
        Node curr = head;
        Node prev = null;
        
        int i = 0;
        
        while (i < k && curr != null)
        {
        	prev = curr;
            curr = curr.next;	
        	i++;
        }
        
        prev.next = null;
        
        head = curr;
        
        while (curr.next != null)
        {
        	curr = curr.next;
        }
        
        curr.next = oldHead;
        
        return head;
    }
    
    public static void main(String args[])
    {
    	RotateLinkList list = new RotateLinkList();
    	for (int i = 10 ; i< 60 ; i= i+10)
    	{
    		list.push(i);
    	}
    	
    	System.out.print ("Given List: ");
    	
    	list.printList(head);
    	
    	list.rotateList(2);
    	
    	System.out.print("Rotated List: ");
    	
    	list.printList(head);
    }
}
