package Trees;

import Trees.BinaryTreeUtility.Node;

public class MergeBinaryTree
{
	public static void mergeBinaryTrees(Node root1, Node root2)
	{
		mergeTrees(root1,root2);
		BinaryTreeUtility util = new BinaryTreeUtility();
		
		System.out.println("Merged tree is: ");
        util.inorder(root1);
	}
	
	private static Node mergeTrees(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
		{
			return null;
		}
		
		if (root1 == null)
		{
			return root2;
		}
		else if (root2 == null)
		{
			return root1;
		}
		root1.data = root1.data + root2.data;
		root1.left = mergeTrees(root1.left,root2.left);
		root1.right = mergeTrees(root1.right,root2.right);
		return root1;
	}
	public static void main(String args[])
    {
    	BinaryTreeUtility tree1 = new BinaryTreeUtility();
    	BinaryTreeUtility tree2 = new BinaryTreeUtility();
    	int data1[] = {9,5,1,15,11};
    	int data2[] = {10,6,8,13,15};
    	
    	for (int i=0 ; i< data1.length; i++)
    	{
    		tree1.root = tree1.addToBST(data1[i]);
    	}
    	
    	for (int i=0 ; i< data2.length; i++)
    	{
    		tree2.root = tree2.addToBST(data2[i]);
    	}
    	mergeBinaryTrees(tree1.root, tree2.root);
    }
}
