package Trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal 
{
	static class TreeNode
	{
		int val;
		TreeNode right;
		TreeNode left;
		public TreeNode(int val)
		{
			this.val = val;
		}
	}
	public static List<Integer> inorderTraversal(TreeNode root) 
	{
	    List<Integer> result = new ArrayList<Integer>();
	        
	    if (root == null)
	        return result;
	        
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curr = root;
	    while(!stack.isEmpty() || curr != null)
	    {
	        while(curr != null)
	        {
	            stack.push(curr);
	            curr = curr.left;
	        }
	        curr = stack.pop();
	        result.add(curr.val);
	           
	        curr = curr.right;
	    }
	        return result;
	}
	
	public static void main(String args[])
	{
		TreeNode trees = new TreeNode(5);
		trees.left = new TreeNode(3);
		trees.right = new TreeNode(9);
		//trees.left.left = new TreeNode(2);
		//trees.left.right = new TreeNode(4);
		//trees.right.left = new TreeNode(10);
		
		List<Integer> list = inorderTraversal(trees);
		
		for (Integer i : list)
		{
			System.out.print(" "+i);
		}
	}
}
