package Trees;
import Trees.BinaryTreeUtility.Node;
public class BinaryToDoublyLinkedList 
{
	/*
	 * Idea is to do in-order traversal of Binary tree. While doing inorder traversal, keep track
	 * of previously visited node in a variable say prev. For each visited node, make prev.right=curr 
	 * and curr.left=prev. Note: here, right is equivalent to next of DLL and left is equivalent to 
	 * previous of DLL.
	 */
	static Node head;
	static Node prev = null;
	public static Node convertBinaryTreeToDLL(Node root)
	{
		if (root == null)
			return null;
		
	    convertBinaryTreeToDLL(root.left);
	    if (head == null)
	    	head = prev;
	    else
	    {
	    	prev.right =root;
	        root.left = prev;
	    }
	    prev = root;
	    convertBinaryTreeToDLL(root.right);
		return head;
	}
	public static void main(String args[])
    {
    	BinaryTreeUtility tree = new BinaryTreeUtility();
    	
    	int data[] = {9,3,5,15,13,21,11,25,7,33};
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree.root = tree.addToBST(data[i]);
    	}
    	System.out.println("Binary search tree is: ");
    	tree.inorder(tree.root);
    	
    	Node head = convertBinaryTreeToDLL(tree.root);
    	System.out.println("\n Doubly linked list is: ");
    	
    	Node tail = null;
    	while(head != null)
    	{
    		tail = head;
    		System.out.print(" "+head.data);
    		head = head.right;
    	}
    	
    	System.out.println("\n Doubly linked list is: ");
    	while (tail != null)
    	{
    		System.out.print(" "+tail.data);
    		tail = tail.left;
    	}
    	
    }
}
