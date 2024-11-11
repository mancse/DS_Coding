package Trees;

/**
 * Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also
 * a Binary Search Tree (BST).
 * 
 * 
 * 
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * @author Manoj.K
 *
 */
public class MaximumSumBSTInBinaryTree {
	static class Pair{
        boolean bst;
        int sum;
        int min;
        int max;
        int res;
       }
    
	/**
     * Idea is to take bottom up approach and maintain above 5 parameters on each node. 
     * 
     * Time Complexity: O(N)
     * @param root
     * @return
     */
    public static int maxSumBST(TreeNode root) {
        Pair p = findMaxSumBST(root);
        return p.res;
    }
    
    private static Pair findMaxSumBST(TreeNode root){
        
        if (root == null){
            Pair p = new Pair();
            p.bst = true;
            p.sum=0;
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            return p;
        }
        
        Pair lPair = findMaxSumBST(root.left);
        Pair rPair = findMaxSumBST(root.right);
                
        Pair pair = new Pair();
        pair.bst = lPair.bst && rPair.bst && root.val > lPair.max && root.val < rPair.min;
        pair.min = Math.min(root.val,Math.min(lPair.min,rPair.min));
        pair.max = Math.max(root.val,Math.max(lPair.max,rPair.max));
        
        if (pair.bst){
            pair.sum = root.val + lPair.sum + rPair.sum;
            pair.res = Math.max(pair.sum,Math.max(lPair.res,rPair.res));
        }
        else
        {
            pair.res = Math.max(lPair.res,rPair.res);
        }
        
        return pair;
    }
}
