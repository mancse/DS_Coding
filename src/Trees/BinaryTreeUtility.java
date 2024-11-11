package Trees;
public class BinaryTreeUtility 
{
	 static class Node
	    {
	    	int data;
	    	Node left, right;
	    	Node(int d)
	    	{
	    		left = null;
	    		right = null;
	    		data = d;
	    	}
	    }
	    
	    public Node root;
	    
	    Node addToBST(int d)
	    {
	    	Node newnode = new Node(d);
	    	Node origroot = null;
	    	Node prev = null;
	    	
	    	if (root == null)
	    	{
	    		root = newnode;
	    		origroot = root;
	    	}
	    		
	    	else
	    	{
	    		origroot = root;
	    		while (root != null)
	    		{
	    			if (newnode.data < root.data)
	    			{
	    				prev = root;
	    				root = root.left;
	    			}
	    			else if (newnode.data > root.data)
	    			{
	    				prev = root;
	    				root = root.right;
	    			}
	    		}
	    		if (newnode.data < prev.data)
	    			prev.left = newnode;
	    		else if (newnode.data > prev.data)
	    		    prev.right = newnode;
	    	}
	        return origroot;
	    }
	    
	    Node removeFromBST(Node root, int d)
	    {
	    	Node targetnode = new Node(d);
	    	Node curr = root;
	    	Node prev = null;
	    	Node newroot = null;
	    	
	    	while (curr != null)
	    	{
	    		if (targetnode.data == curr.data)
	    		{
	    			break;
	    		}
	    		if (targetnode.data < curr.data)
	    		{
	    			prev = curr;
	    		    curr = curr.left;
	    		}
	    		else if (targetnode.data > curr.data)
	    		{
	    			prev = curr;
	    			curr = curr.right;
	    		}
	    	}
	    	
	    	if (curr == root)
	    	{
	    		if (root.left == null && root.right == null)
	    		{
	    			root = null;
	    		}
	    		else if (root.left != null && root.right != null)
	    		{
	    		    curr = curr.right;
	    		    newroot = curr;
	    		    while(curr != null)
	    		    {
	    		    	prev = curr;
	    		    	curr = curr.left;
	    		    }
	    		    
	    		    prev.left = root.left;
	    		    root = newroot;
	    		}
	    		else if(root.left == null && root.right != null)
	    		{
	    			root = root.right;
	    		}
	    		else if (root.left != null && root.right == null)
	    		{
	    			root = root.left;
	    		}
	    	}
	    	
	    	else if (curr == prev.left)
	    	{
	            if (curr.left == null && curr.right == null)
	            {
	            	prev.left = null;
	            }
	            else if (curr.right == null)
	            {
	            	prev.left = curr.left;
	            }
	            else if (curr.left == null)
	            {
	            	prev.left = curr.right;
	            }
	            else if (curr.left != null && curr.right != null)
	            {
	            	prev.left = curr.right;
	            	curr.right.left = curr.left;
	            }
	    	}
	    	else if (curr == prev.right)
	    	{
	    		if (curr.left == null && curr.right == null)
	    		{
	    			prev.right = null;
	    		}
	    		else if (curr.left != null && curr.right != null)
		        {
		           	prev.right = curr.left;
		            curr.left.right = curr.right;
		        }
	            else if (curr.right == null)
	            {
	            	prev.right = curr.left;
	            }
	            else if (curr.left == null)
	            {
	            	prev.right = curr.right;
	            }
	    	}
	    	
	    	return root;
	    }
	    
	    void inorder (Node root)
	    {
	    	if (root != null)
	    	{
	    		inorder(root.left);
	    		System.out.print(" "+root.data);
	    		inorder(root.right);
	    	}
	    }
	    
	    void postorder (Node root)
	    {
	    	if (root != null)
	    	{
	    		inorder(root.left);
	    		inorder(root.right);
	    		System.out.print(" "+root.data);
	    	}
	    }
}
