package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Datastctures to be used are one Queue for level order traversal and one TreeMap of key as horizontal distance and
 * list of node values.
 * @author Manoj.K
 *
 */
public class VerticalOrderTraversal 
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			this.val = val;
		}
	}
	static class Node{
	    TreeNode tNode;
	    int hd;
	    public Node(int hd,TreeNode tNode)
	    {
	        this.hd = hd;
	        this.tNode = tNode;
	    }
	}
	public static List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList();
        
        if (root == null)
            return result;
               
        Map<Integer,List<Integer>> tMap = new TreeMap();
        
        performVerticalTraversal(root,tMap);
        
        for (Map.Entry<Integer,List<Integer>> entry : tMap.entrySet())
        {
            List<Integer> list = entry.getValue();
            result.add(list);
        }
        return result;
    }
    
    private static void performVerticalTraversal(TreeNode root,Map<Integer,List<Integer>> tMap)
    {
        
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(0,root));
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for (int i=0; i<size; i++)
            {
                Node node = queue.remove();
                
                TreeNode tNode = node.tNode;
                int hd = node.hd;
                
                List<Integer> list = tMap.get(hd);
                
                if (list == null)
                {
                    list = new ArrayList();
                    tMap.put(hd,list);
                }
                list.add(tNode.val);
                
                if(tNode.left != null)
                {
                    queue.add(new Node(hd-1,tNode.left));
                }
                if(tNode.right != null)
                {
                    queue.add(new Node(hd+1,tNode.right));
                }
            }
        }
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
	}
}
