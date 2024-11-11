package Trees;


public class BinaryToSumTree {
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
        printInOrder(root);
        System.out.println("----------");
        convertSumTree(root);
        printInOrder(root);
    }
    
    
    private static void printInOrder(TreeNode root)
    {
    	if (root == null)
    		return;
    	
    	printInOrder(root.left);
    	
    	System.out.println(" "+root.val);
    	
    	printInOrder(root.right);
    }
    
    private static int convertSumTree(TreeNode root)
    {
    	if (root == null)
    		return 0;
    	
    	int data = root.val;
    	
    	root.val = convertSumTree(root.left) + convertSumTree(root.right);
    	
    	return root.val + data;
    }
}
