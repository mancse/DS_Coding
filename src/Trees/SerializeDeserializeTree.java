package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeTree 
{
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			this.val=val;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		String str = serialize(root);
		
		System.out.println("Serialized string: "+str);
		
		TreeNode desRoot = deserialize(str);
		
		System.out.println(" Root of deserialized tree string: "+desRoot.val);
	}

	private static String serialize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();
		serializeBT(root,sb);
		return sb.toString();
	}
	
	private static TreeNode deserialize(String str)
	{
		List<String> list = new LinkedList<String>();
		list.addAll(Arrays.asList(str.split(",")));
	    return deserializeBT(list);   
	}
	private static void serializeBT(TreeNode root, StringBuilder sb)
	{
		if (root == null)
		{
			sb.append("#").append(",");
			return;
		}
		else
		{
			sb.append(root.val).append(",");
		}
		
		serializeBT(root.left,sb);
		serializeBT(root.right,sb);
	}
	
	private static TreeNode deserializeBT(List<String> list)
	{
		String v = list.remove(0);
		
		if (v.equals("#"))
			return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(v));
		root.left = deserializeBT(list);
		root.right = deserializeBT(list);
		return root;
	}
}
