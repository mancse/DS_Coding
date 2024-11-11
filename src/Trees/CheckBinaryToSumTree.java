package Trees;

public class CheckBinaryToSumTree {
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
    	TreeNode root= new TreeNode(26);
    	root.left = new TreeNode(10); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(6); 
        root.right.right = new TreeNode(3); 
        
        boolean sumTree = isSumTree(root);
        System.out.println("Sum tree: "+sumTree);
    }
    
    private static int sum(TreeNode root){
    	if(root == null)
    	   return 0;
    	return sum(root.left) + root.val + sum(root.right);
    }
    
    private static boolean isSumTree(TreeNode root){
    	if (root == null || root.left == null && root.right == null)
    		return true;
    	
    	int lss = sum(root.left);
    	int rss = sum(root.right);
    	
    	if (root.val == (lss + rss) && isSumTree(root.left) && isSumTree(root.right))
    	    return true;
    	    else
    	    	return false;
    }
}
