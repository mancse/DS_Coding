package Trees;
/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum
 * of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards 
 * (i.e., traveling only from parent nodes to child nodes).
 * 
 * Leetcode: https://leetcode.com/problems/path-sum-iii/
 */
import java.util.ArrayList;
import java.util.List;

public class AllKPathSum3 
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
    public static void main(String args[]){
    	TreeNode root= new TreeNode(1);
    	root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(4); 
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10); 
        root.right.right.right = new TreeNode(11); 
        int k=7;
        
        List<List<Integer>> paths = new ArrayList<>();
        findAllKSumPaths(root,paths,new ArrayList<Integer>(),k);
        
        System.out.println(paths);
    }
    
    private static void findAllKSumPaths(TreeNode root,List<List<Integer>> results,List<Integer> path,int k){
    	
    	if (root == null)
    		return;
    	
    	path.add(root.val);
    	List<Integer> list = new ArrayList<>(); 
    	int sum = 0;
    	for (int i=path.size()-1 ; i >= 0 ; i--)
    	{
    		int v = path.get(i);
    		list.add(v);
    		sum = sum + v;
    		if (sum == k)
    		{
    			results.add(list);
    			break;
    		}
    	}
    	
    	findAllKSumPaths(root.left,results,path,k);
    	findAllKSumPaths(root.right,results,path,k);
    	
    	//Backtrack
    	path.remove(path.size() - 1);
    	
    	//System.out.println("###"+path);
    }
}
