package Trees;
import Trees.BinaryTreeUtility.Node;
public class CheckBST 
{
	public static boolean isBST(Node root)
	{
        return checkBST(root,null,null);
	}
	
	/*
	 * Idea is that for each node in BST, value at all nodes in it's left sub-tree is lesser than the current node 
	 * and value of all nodes in its right sub tree is greater than the current node. 
	 * 
	 * So, we need to pass value of current node as max value in it's left sub-tree and min value in it's right sub
	 * tree. On each recursion in left or right subtree, we check if root.data >= max or root.data <=min, then above
	 * condition gets violated and return false.
	 * 
	 * Base condition is if root == null then return true. 
	 * 
	 * Else recurse left and right subtree passing root.data as max value in its left subtree and root.data as min 
	 * value in its right subtree. 
	 */
	private static boolean checkBST(Node root, Integer max, Integer min)
	{
		if (root == null)
		{
			return true;
		}
		else if (max != null && root.data >= max || min != null && root.data <= min)
		{
			return false;
		}
		else 
		{
			return checkBST(root.left, root.data, min) && checkBST(root.right, max,root.data);
		}
	}
	public static void main(String args[])
    {
    	BinaryTreeUtility tree = new BinaryTreeUtility();
    	
    	int data[] = {9,3,5,15,13,21,11,25,7};
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree.root = tree.addToBST(data[i]);
    	}
    	System.out.println("Binary search tree is: ");
    	tree.inorder(tree.root);
    	
    	System.out.println("Tree is BST : "+isBST(tree.root));
    }
}
