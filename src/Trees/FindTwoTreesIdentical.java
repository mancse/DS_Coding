package Trees;
import Trees.BinaryTreeUtility.Node;
public class FindTwoTreesIdentical 
{
	public static boolean isIdenticalTree(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
			return true;
		
		else if (root1 != null && root2 == null)
			return false;
		else if (root1 == null && root2 != null)
			return false;
		else if (root1.data != root2.data)
			return false;
		else
		{
			return isIdenticalTree(root1.left,root2.left) && isIdenticalTree(root1.right,root2.right);
		}
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
    	tree1.inorder(tree2.root);
    	
    	System.out.println("\n Trees are identical: "+isIdenticalTree(tree1.root,tree2.root));
    	BinaryTreeUtility tree3 = new BinaryTreeUtility();
    	BinaryTreeUtility tree4 = new BinaryTreeUtility();
    	
    	int data1[] = {9,3,5,15,13,21,11,25,7,12};
    	for (int i=0 ; i< data1.length; i++)
    	{
    		tree3.root = tree3.addToBST(data[i]);
    	}
    	System.out.println("\n Binary search tree3 is: ");
    	tree1.inorder(tree3.root);
    	
    	
    	for (int i=0 ; i< data1.length; i++)
    	{
    		tree4.root = tree4.addToBST(data1[i]);
    	}
    	System.out.println("\n Binary search tree4 is: ");
    	tree1.inorder(tree4.root);
    	System.out.println("\n Trees are identical: "+isIdenticalTree(tree3.root,tree4.root));
    }
}
