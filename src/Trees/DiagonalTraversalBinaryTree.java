package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiagonalTraversalBinaryTree {
	
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
	
	/**
	 * Idea: Idea is to store the values of nodes in a map where key is the distance of current slope from the
	 * right most top slope. While traversinng current node left increment the slope distance (d) where as while
	 * moving right, keep it same. 
	 * @param root
	 * @param map
	 * @param d
	 */
	public static void diagonalTreeTraversal(TreeNode root, Map<Integer,ArrayList<Integer>> map,int d){
		if (root == null)
			return;
		
		ArrayList<Integer> list = map.get(d);
		if (list == null){
			list = new ArrayList<>();
		}
		list.add(root.val);
		map.put(d, list);
		/**
		 * Increment slope distance d by 1 when traversing left. 
		 */
		diagonalTreeTraversal(root.left,map,d+1);
		/**
		 * Keep same slope distance d when traversing right. 
		 */
		diagonalTreeTraversal(root.right,map,d);
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
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        diagonalTreeTraversal(root,map,0);
        System.out.println("Diagonal Tree Traversal is: ");
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
        	ArrayList<Integer> list = entry.getValue();
        	
        	for(Integer i: list){
        		System.out.print(" "+i);
        	}
        	System.out.println();
        }
    }
	
	
}
