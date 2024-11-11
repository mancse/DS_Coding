package Trees;


public class MinimumDistanceBetween2Nodes
{
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
	public static void main(String args[])
	{
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
	    
	    TreeNode lca = findLCA(root,new TreeNode(4), new TreeNode(11));
	    
	    System.out.println("LCA is : "+lca.val);
	    int ld = getDepthFromLCA(lca,4,0);
	    int rd = getDepthFromLCA(lca,11,0);
	    
	    int dist = ld + rd;

	    System.out.println("Distance: "+dist);
	}
	
	private static int getDepthFromLCA(TreeNode root, int key,int depth)
	{
		if (root == null)
			return -1;
		
		if (root.val == key)
			return depth;
		
		int left = getDepthFromLCA(root.left,key,depth+1);
		
	    int right =  getDepthFromLCA(root.right,key,depth+1);
		
		return left == -1 ? right : left;
	}
	private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q)
	{
	  	if (root == null)
	   	{
	   		return null;
	   	}
	    	
	  /**
	   * Propogate the current node if value of the current node is equal to the given Nodes values.
	   * If one of the key is ancestor of other given key then the ancestor key is the LCA. 
	   */
	    if (root.val == p.val || root.val == q.val)
	    {
	    	return root;
	    }
	        
	    /**
	     * Recurse the binary tree in left and right subtree. 
	     */
	    TreeNode left = findLCA(root.left,p,q);
	    TreeNode right = findLCA(root.right,p,q);
	    
	    /**
	     * If left and right node are not null, it means we have found both key matched in both sides
	     * of subtrees of the current node. So, current node is the LCA. 
	     */
	    if (left != null && right != null)
	    {
	    	return root;
	    }
	    	
	    /**
	     * Otherwise check if LCA is in left or right of the subtree. 
	     */
	    return (left != null ? left : right);
	}
}
