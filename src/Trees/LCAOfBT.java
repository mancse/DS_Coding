package Trees;

class Node 
{
	  int val;
	  Node left;
	  Node right;
	  Node(int x) { val = x; }
}

/**
 * Idea behind finding LCA of binary tree is 
 * @author Manoj.K
 * Assumption: It is assumed that both nodes are present in binary tree for which LCA to be found. 
 * 
 * 
 */
public class LCAOfBT 
{ 
    public Node findLCA(Node root, Node p, Node q)
    {
    	if (root == null)
    	{
    		return null;
    	}
    	
    	/**
    	 * Propogate the current node if value of the current node is equal to the given Nodes values.
    	 * If one of the key is ancestor of other given key then the ancestor key is the LCA. 
    	 */
    	if (root.val == p.val || root.val == q.val)
    	{
    		return root;
    	}
        
    	/**
    	 * Recurse the binary tree in left and right subtree. 
    	 */
    	Node left = findLCA(root.left,p,q);
    	Node right = findLCA(root.right,p,q);
    	
    	/**
    	 * If left and right node are not null, it means we have found both key matched in both sides
    	 * of subtrees of the current node. So, current node is the LCA. 
    	 */
    	if (left != null && right != null)
    	{
    		return root;
    	}
    	
    	/**
    	 * Otherwise check if LCA is in left or right of the subtree. 
    	 */
    	return (left != null ? left : right);
    }
    
    public static void main(String args[])
    {
    	LCAOfBT bt = new LCAOfBT();
    	Node root;
    	root = new Node(1);
    	root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        
        Node p = new Node(4);
        Node q = new Node(5);
        
        Node lca = bt.findLCA(root, p, q);
        
        System.out.println("LCA of 4 and 5 is: "+lca.val);
        
        Node q1 = new Node(6);
        
        Node lca1 = bt.findLCA(root, q, q1);
        
        System.out.println("LCA of 5 and 6 is: "+lca1.val);
        
        Node p2 = new Node(6);
        Node q2 = new Node(3);
        Node lca2 = bt.findLCA(root, p2, q2);
        
        System.out.println("LCA of 3 and 6 is: "+lca2.val);
    }
}
