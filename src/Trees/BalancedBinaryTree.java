package Trees;
public class BalancedBinaryTree {
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
       
        System.out.println("Is balanced: "+isBalancedBinaryTree(root));
    }
    
    private static int heightOfTree(TreeNode root)
	{
		if (root == null)
			return 0;
		
			return 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right)); 
	}
    private static boolean isBalancedBinaryTree(TreeNode root){
    	
    	if (root == null)
    		return true;
    	
    	int lh = heightOfTree(root.left);
    	int rh = heightOfTree(root.right);
    	
    	if (Math.abs(lh-rh) > 1)
    		return false;
    	
    	boolean ilb = isBalancedBinaryTree(root.left);
    	boolean irb = isBalancedBinaryTree(root.right);
    	
    	return ilb && irb;  		
    }
}
