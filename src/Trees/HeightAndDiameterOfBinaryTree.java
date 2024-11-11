package Trees;
import Trees.BinaryTreeUtility.Node;
public class HeightAndDiameterOfBinaryTree 
{
	public static int heightOfTree(Node root)
	{
		if (root == null)
			return 0;
		
			return 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right)); 
	}
	
	public static int diameterOfTree(Node root)
	{
		if (root == null)
			return 0;
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);
		
		int ldiameter = diameterOfTree(root.left);
		int rdiameter = diameterOfTree(root.right);
	
		return Math.max(lheight + rheight, Math.max(ldiameter, rdiameter));
	}
	
	public static void main(String args[])
    {
    	BinaryTreeUtility tree = new BinaryTreeUtility();
    	
    	int data[] = {9,3,15,13,21,25,33,37,40,16,12,11,10};
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree.root = tree.addToBST(data[i]);
    	}
    	System.out.println("Binary search tree is: ");
    	tree.inorder(tree.root);
    	
    	System.out.println("Height of tree: "+heightOfTree(tree.root));
    	System.out.println("Diameter of tree: "+diameterOfTree(tree.root));
    }
}
