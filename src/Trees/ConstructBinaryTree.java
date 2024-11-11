package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree 
{
	static int pindex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length-1);
    }
    
    private static TreeNode buildTree(int[] preorder, int[] inorder,int start,int end){
        if (start > end){
            return null;
        }
        
        int num = preorder[pindex++];
        TreeNode root = new TreeNode(num);
        int i=start;
        for (; i<end; i++){
            if (inorder[i] == num){
                break;
            }
        }
        
        root.left = buildTree(preorder,inorder,start,i-1);
        root.right = buildTree(preorder,inorder,i+1,end);
        
        return root;
    }
	 public static void main(String args[])
	 {
		 int preorder[] = {1,2,3};
		 int inorder[] = {2,3,1};
		 
		 TreeNode root = buildTree(preorder,inorder);
	 }
}
