package Trees;

import Trees.BinaryTreeUtility.Node;

public class InvertTree 
{
	
	private static Node invertTree(Node root)
	{
		if (root == null)
			return null;
		
		Node left = invertTree(root.left);
		Node right = invertTree(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	public static void main(String args[])
    {
    	BinaryTreeUtility util = new BinaryTreeUtility();
    	
    	Node root = new Node(9);
    	root.left = new Node(5);
    	root.left.left = new Node(1);
    	root.right = new Node(15);
    	root.right.left = new Node(11);
    	System.out.println("Inorder traversal of original binary tree: ");
    	util.inorder(root);
    	
    	Node res = invertTree(root);
    	
    	System.out.println("\nInorder traversal of inverted binary tree: ");
    	util.inorder(res);
    }
}
