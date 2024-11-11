package Trees;

import java.util.ArrayList;
import java.util.List;
class TreeNode
{
	int val;
	TreeNode right;
	TreeNode left;
	public TreeNode(int val)
	{
		this.val = val;
	}
}

public class PathSum 
{
    
	int count = 0;

	 public static int pathSum(TreeNode root, int sum) 
	 {
	    int count = totalPathSum(root,new ArrayList<Integer>(),sum);
	    return count;
	 }
	    
	 public static int totalPathSum(TreeNode root, List<Integer> list,int sum)
	 {
	    if (root == null)
	        return 0;
	        
	    list.add(root.val);
	        
	    int tmp = 0;
	    int count = 0;
	    for (int i= list.size() -1; i>=0; i--)
	    {
	        tmp = tmp +  list.get(i);   

	        if (sum == tmp)
	        {
	            count++;
	        }
	    }
	    int left_count = totalPathSum(root.left,list,sum);
	    int right_count = totalPathSum(root.right,list,sum);
	    
	    count = count + left_count +  right_count;   
	    list.remove(list.size()-1);
	    return count;
	 }
	 
	 public static void main(String args[])
	 {
		 TreeNode root = new TreeNode(0);
		 root.left = new TreeNode(1);
		 root.right = new TreeNode(1);
		 
		 System.out.println("Total paths: "+pathSum(root,1));
	 }
}
