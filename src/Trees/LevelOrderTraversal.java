package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrderTraversal 
{
	static class Node
	{
		int val;
		Node left;
		Node right;
		
		public Node(int val)
		{
			this.val = val;
		}
	}
	public static List<List<Integer>> levelOrder(Node root) 
    {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty())
        {
            List<Integer> list = new ArrayList();
            
            int n = queue.size();
            
            for (int i=0; i< n ; i++)
            {
                Node node = queue.remove();
                list.add(node.val);
                
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            
            result.add(list);
        }
        return result;
    }
	
    public static List<Integer> rightSideView(Node root){
	List<Integer> resList = new ArrayList<>();
	List<Node> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty())
	{
	    int n = queue.size();
        System.out.println("size: "+n);
		for (int i=0; i<n; i++)
		{
			Node node = queue.remove(0);
            if (node != null)
            {
            	if (i== n-1)
            	{
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
    public static void main(String args[])
    {
    	Node root = new Node(1);
    	root.left = new Node(2);
    	root.right = new Node(3);
    	root.left.right = new Node(5);
    	root.right.right = new Node(4);
    	List<List<Integer>> result = levelOrder(root);
    	System.out.println(result);
    	
    	List<Integer> rightViewList = rightSideView(root);
    }
}
