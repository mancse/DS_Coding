package arrays;

/*
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * 
 * E.g: 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray 
{
	/**
	 * Idea is to keep 3 variables curMax,curMin and finalMax on each index where
	 * - curMax can be evaluated as maximum from curMax*nums[i], curMin*nums[i] and nums[i]
	 * - curMin can be evaluated as minimum from cMax*nums[i], curMin*num[i] and nums[i]
	 * - finalMax will be maximum from curMax and finalMax on each index. 
	 * @param nums
	 * @return
	 */
	private static int maxProduct(int[] nums) {
        if (nums.length == 0)
            return -1;
        
        int curMax = nums[0];
        int curMin = nums[0];
        int finalMax = nums[0];
        
        for (int i=1; i<nums.length;i++){
            int cMax = curMax;
            curMax = Math.max(Math.max(curMax*nums[i],curMin*nums[i]),nums[i]);
            curMin = Math.min(Math.min(cMax*nums[i],curMin*nums[i]),nums[i]);
            
            finalMax = Math.max(curMax,finalMax);
        }
        return finalMax;
    }
    
    public static void main(String args[])
    {
    	int nums[] = {2,3,-2,4};
    	int maxProduct = maxProduct(nums);
    	System.out.println("Max product: "+maxProduct);
    }
}
