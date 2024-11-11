package Trees;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a node and distance k, in binary tree. Find all k distance away nodes around given node in binary tree. 
 * 
 * Idea: Following are the approach to solve this.
 *       a. Write a function printKDistanceDownNodes which can print all nodes k distance down a given node. 
 *       b. Find list of nodes from given node to root of the tree. 
 *          Iterate the above list of nodes and do like following
 *          -For first node in the list... print all nodes k distance down. 
 *          -For second node in the list print all nodes k-1 distance down.
 *          -For third node in the list print all nodes k-2 distance down.
 *          -and so on. 
 *          -Also, while processing ith node in the list keep (i-1)th node as blocker to printKDistanceDownNodes() function. 
 *        
 * @author Manoj.K
 *
 */
public class KdistanceAwayNodes {
	
	public static List<TreeNode> nodeToRootPaths;
	
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
        nodeToRootPaths = new ArrayList<>();
        printKDistanceAwayNodes(root,2,2);
	}
	
	private static void printKDistanceAwayNodes(TreeNode root, int val, int k)
	{
		findNodeToRootPaths(root,val);
		System.out.println("Node to root path: ");
		for (TreeNode node : nodeToRootPaths) {
			System.out.print(" "+node.val);
		}
		System.out.println("\n All "+k+" th distance nodes are: ");
		for (int i=0; i < nodeToRootPaths.size(); i++)
		{
			/**
			 * Idea behind blocker node is to restrict those nodes which have already printed by child node before by printKDistanceDownNodes() function.
			 */
			TreeNode blocker = i == 0 ? null : nodeToRootPaths.get(i-1);
			printKDistanceDownNodes(nodeToRootPaths.get(i),k-i,blocker);
		}
	}
	/**
	 * Function to get list of nodes from given node to the root node of the binary tree. 
	 * @param root
	 * @param val
	 * @return
	 */
	private static boolean findNodeToRootPaths(TreeNode root, int val)
	{
		if (root == null)
		   return false;
		
		if (root.val == val)
		{
			nodeToRootPaths.add(root);
			return true;
		}
		
		boolean lf = findNodeToRootPaths (root.left,val);
		boolean rf = findNodeToRootPaths(root.right,val);
		
		if (lf)
		{
			nodeToRootPaths.add(root);
			return lf;
		}
		else if (rf)
		{
			nodeToRootPaths.add(root);
			return rf;
		}
		
		return false;
	}
	
	/**
	 * Print all nodes at kth distance from the given node root
	 * @param root
	 * @param k
	 * @param blocker
	 */
	private static void printKDistanceDownNodes(TreeNode root, int k,TreeNode blocker)
	{
		if (root == null || k < 0 || root == blocker)
			return;
		if (k == 0)
		{
			System.out.print(" "+root.val);
		}
		printKDistanceDownNodes(root.left,k-1,blocker);
		printKDistanceDownNodes(root.right,k-1,blocker);
	}
}
