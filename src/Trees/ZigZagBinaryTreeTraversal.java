package Trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinaryTreeTraversal 
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
    	TreeNode root= new TreeNode(3);
    	root.left = new TreeNode(9); 
        root.right = new TreeNode(20); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
      
        root.right.right.left = new TreeNode(10); 
        root.right.right.right = new TreeNode(11); 
        List<List<Integer>> result = zigzagLevelOrder(root);
        
        for (int i=0; i<result.size(); i++)
        {
        	List<Integer> list = result.get(i);
        	
        	for (int j=0; j<list.size(); j++){
        		System.out.print(" "+list.get(j));
        	}
        	
        }
    }
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
    	if (root == null)
            return result;
    	Stack<TreeNode> s1 = new Stack<>();
    	
    	Stack<TreeNode> s2 = new Stack<>();
    	
    	s1.add(root);
    	
    	while(!s1.isEmpty() || !s2.isEmpty())
    	{
            List<Integer> res = new ArrayList<>();
            if (!s1.isEmpty()) {
            	while (!s1.isEmpty()){
        			TreeNode node = s1.pop();
                    res.add(node.val);
        			if (node.left != null)
        				s2.add(node.left);
        			if (node.right != null)
        				s2.add(node.right);
        		    }
            }
            else {
            	 while (!s2.isEmpty()){
         			TreeNode node = s2.pop();
         			res.add(node.val);
         			if (node.right != null)
         				s1.add(node.right);
         			if (node.left != null)
         				s1.add(node.left);
         		    }
            }
            result.add(res);
    	}
    	return result;
    }
}
