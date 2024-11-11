package Trees;
import Trees.BinaryTreeUtility.Node;
public class MirrorAndSymmetricTree 
{
	public static boolean isMirror(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null && root2 != null
				 || root1 != null && root2 == null)
			return false;
		else
			return root1.data == root2.data 
			&& isMirror(root1.left,root2.right) 
			&& isMirror(root1.right,root2.left);
			      
	}
	
	/*
	 * Tree is symmetric if it is mirror image of itself.
	 */
	public static boolean isSymmetric(Node root)
	{
		return isMirror(root,root);
	}
	
	public static void main(String args[])
    {
    	BinaryTreeUtility tree1 = new BinaryTreeUtility();
    	BinaryTreeUtility tree2 = new BinaryTreeUtility();
    	int data[] = {9,3,5,15,13,21,11,25,7,33};
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree1.root = tree1.addToBST(data[i]);
    	}
    	System.out.println("\n Binary search tree1 is: ");
    	tree1.inorder(tree1.root);
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree2.root = tree2.addToBST(data[i]);
    	}
    	System.out.println("\n Binary search tree2 is: ");
    	tree2.inorder(tree2.root);
    	
    	System.out.println(" Are Tree 1 and Tree2 mirror of each other: "+isMirror(tree1.root,tree2.root));
    	
    	System.out.println(" Tree1 is symmetric of itself: "+isSymmetric(tree1.root));
    }
}
