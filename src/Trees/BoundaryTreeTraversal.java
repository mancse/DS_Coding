package Trees;
/**
 * 1. Print the left boundary in top-down manner.
   2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…     2.1 Print all leaf nodes of left sub-tree from left to right.
…..   2.2 Print all leaf nodes of right subtree from left to right.
   3. Print the right boundary in bottom-up manner.
 * @author Manoj.K
 *
 */
public class BoundaryTreeTraversal {
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			this.val = val;
		}
	}
    public static void main(String args[]){
    	TreeNode root= new TreeNode(1);
    	root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10); 
        root.right.right.right = new TreeNode(11); 
        
        boundaryTraversal(root);
    }
    
    public static void boundaryTraversal(TreeNode root)
    {
    	if (root == null)
    		return;
    	
    	System.out.println(" "+root.val);
    	
    	printLeftBoundary(root.left);
    	
    	printLeaves(root.left);
    	printLeaves(root.right);
    	
    	printRightBoundary(root.right);
    }
    
    private static void printLeftBoundary(TreeNode root)
    {
    	if (root == null)
    		return;
    	if (root.left != null)
    	{
    		System.out.println(" "+root.val);
    		printLeftBoundary(root.left);
    	}
    	
    	else if(root.right != null)
    	{
    		System.out.println(" "+root.val);
    		printLeftBoundary(root.right);
    	}
    	else
    	{
    		//Do nothing if it is leaf node.
    	}
    	
    }
    
    private static void printRightBoundary(TreeNode root)
    {
    	if(root == null)
    		return;
    	
    	if (root.right != null)
    	{
    		printRightBoundary(root.right);
    		System.out.println(" "+root.val);
    	}
    	else if(root.left != null)
    	{
    		printRightBoundary(root.left);
    		System.out.println(" "+root.val);
    	}
    	else
    	{
    		//Do nothing if leaf node
    	}
    }
    
    private static void printLeaves(TreeNode root)
    {
    	if (root == null)
    		return;
    	
    	printLeaves(root.left);
    	if (root.left == null && root.right == null)
    		System.out.println(" "+root.val);
    	printLeaves(root.right);
    }
}
