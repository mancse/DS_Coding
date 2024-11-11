package Trees;

public class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length ==0)
            return null;
        
        TreeNode root = constructSortedArrayToBST(nums,0,nums.length-1);
        return root;
    }
    
    private static TreeNode constructSortedArrayToBST(int[] nums, int low, int high){
        if (high < low)
            return null;
        
        int mid = low + (high - low)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructSortedArrayToBST(nums,low,mid-1);
        root.right= constructSortedArrayToBST(nums,mid+1,high);
        return root;
    }
}
