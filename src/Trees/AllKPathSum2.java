package Trees;
import java.util.*;
/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the
 * sum of the node values in the path equals targetSum. Each path should be returned as a list of the
 * node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node
 * with no children.
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 *
 * Leetcode: https://leetcode.com/problems/path-sum-ii/
 */
public class AllKPathSum2 {
	 public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        
		    List<List<Integer>> result = new ArrayList<>();
	        pathSumHelper(root,targetSum, new ArrayList<Integer>(),result);
	        return result;
	    }
	    
	    private static void pathSumHelper(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result){
	        
	        if (root == null){
	            return;
	        }
	        
	        currentPath.add(root.val);
	        if (root.left == null && root.right == null){
	            int sum =0;
	            for (int i=0; i<currentPath.size(); i++){
	                sum+=currentPath.get(i);
	            }
	            
	            if (sum == targetSum){
	                result.add(new ArrayList(currentPath));
	            }
	        }
	        
	        pathSumHelper(root.left, targetSum, currentPath,result);
	        pathSumHelper(root.right, targetSum, currentPath,result);
	        currentPath.remove(currentPath.size()-1);
	    }
}
