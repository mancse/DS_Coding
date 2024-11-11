package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> resList = new ArrayList<>();
		List<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
		    int n = queue.size();
	        System.out.println("size: "+n);
			for (int i=0; i<n; i++)
			{
				TreeNode node = queue.remove(0);
	            if (node != null){
				if (i== n-1){
	                resList.add(node.val);
	            }
					
				if (node.left != null)
				{
	                System.out.print("Node val: "+node.val+" left: "+node.left.val);
					queue.add(node.left);
				}
				if (node.right != null)
				{
	                System.out.print("Node val: "+node.val+" right: "+node.right.val);
					queue.add(node.right);
				}
	          }
			}
		}
		return resList;
	}
}
