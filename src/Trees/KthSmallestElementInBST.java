package Trees;

public class KthSmallestElementInBST 
{
	static int cnt=0;
	static int res=0;
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
	
    private static void findKthSmallest(Node root,int k)
    {
        if (root == null)
            return;
        
        findKthSmallest(root.left, k);   
        cnt = cnt+1;
         if (cnt==k)
         {
           res=root.val;
           return ;
         }  
         findKthSmallest(root.right, k);
    }
    
    
	public static void main(String args[]){
		Node root= new Node(9);
    	root.left = new Node(4); 
        root.right = new Node(12); 
        root.left.left = new Node(2); 
        root.left.right = new Node(6); 
        root.right.left = new Node(10); 
        root.right.right = new Node(15);        
        findKthSmallest(root,3);
        System.out.println("Kth smallest: "+res);
	}
}
