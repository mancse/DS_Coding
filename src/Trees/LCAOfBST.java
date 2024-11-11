package Trees;
import Trees.BinaryTreeUtility.Node;
public class LCAOfBST 
{
	/*
	 * Following condition should be met for finding LCA of a BST.
	 * 
	 * a. root.data should be between the values of n1 and n2 
	 *    so, check if n1 < root.data and root.data < n2 condition is true then return root.data as LCA.
	 * b. if n1 is equal to root.data then n1 is the LCA
	 * c. else if n2 is equal to root.data then n2 is the LCA.
	 * d. if any of the above condition doesn't match then check following.
	 *    - If root.data < n1 and root.data < n2 then LCA lies in right subtree. So, recurse right subtree. 
	 *    - If root.data > n1 and root.data > n2 then LCA lies in the left subtree. So, recurse left subtree. 
	 * 
	 */
    static int findLCA(Node root,int n1,int n2)
    {
    	int retVal = -1;
    	 if (n1 == root.data)
    		 retVal =  n1;
    	 else if (n2 == root.data)
    		 retVal =  n2;
         else if ( n1 < root.data && root.data < n2)
    		 retVal = root.data;
    	 
         else
         {
        	 if (root.data < n1 && root.data < n2)
        	     retVal = findLCA(root.right,n1,n2);
        	 if (root.data > n1 && root.data > n2)
        		 retVal = findLCA(root.left,n1,n2);
         }
    	 return retVal;
    }
    public static void main(String args[])
    {
    	BinaryTreeUtility tree = new BinaryTreeUtility();
    	
    	int data[] = {9,3,5,15,13,21,11,25,7};
    	
    	for (int i=0 ; i< data.length; i++)
    	{
    		tree.root = tree.addToBST(data[i]);
    	}
    	System.out.println("Binary search tree is: ");
    	tree.inorder(tree.root);
    	
    	int LCA = findLCA(tree.root,13,21);
    	System.out.println("\nLCA of 13,21 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,13,25);
    	System.out.println("\nLCA of 13,25 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,11,25);
    	System.out.println("\nLCA of 11,25 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,7,11);
    	System.out.println("\nLCA of 7,11 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,21,25);
    	System.out.println("\nLCA of 21,25 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,3,7);
    	System.out.println("\nLCA of 3,7 is: "+ LCA);
    	
    	LCA = findLCA(tree.root,3,7);
    	System.out.println("\nLCA of 3,7 is: "+ LCA);
    	
    	
    	LCA = findLCA(tree.root,5,7);
    	System.out.println("\nLCA of 5,7 is: "+ LCA);
    }
}
