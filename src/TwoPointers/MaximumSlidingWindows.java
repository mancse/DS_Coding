package TwoPointers;
/**
 * Given an array arr of size N and an integer K, the task is to find the maximum for
 * each and every contiguous subarray of size K.
 * Example:
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * All ccontigious subarrays of size k are
 * {1, 2, 3} => 3
 * {2, 3, 1} => 3
 * {3, 1, 4} => 4
 * {1, 4, 5} => 5
 * {4, 5, 2} => 5
 * {5, 2, 3} => 5
 * {2, 3, 6} => 6
 * @author Manoj.K
 *
 * Idea: Idea is to start left pointer from 0 and right from k-1. Loop through the array until right < nums.length
 *       Assign left = right - (k-1)
 *       
 *       initialize max variable as Integer.MIN_VALUE for each window iteration by left pointer.
 *       
 *       Loop until left <= right
 *         max = Math.max(max,nums[left++])
 *         
 *       Store max found in the above windo in result set.
 */

public class MaximumSlidingWindows 
{
	 public static int[] maxSlidingWindow(int[] nums, int k) 
	 {
		int [] result = new int[nums.length - k +1];
	    if (nums.length == 0)
	    	return result;
	    
	    int right = k -1;
	    
	    int left = 0;
	    int r=0;
	    while(right < nums.length)
	    {
	        left = right -(k -1);
	    	int max = Integer.MIN_VALUE;
	    	while (left <= right)
	    	{
	    		max = Math.max(max, nums[left++]);
	    	}
	    	result[r++] = max;
	    	right++;
	    }
	    return result;
	 }
	 
	 public static void main(String args[])
	 {
		 int nums[] = {1,3,-1,-3,5,3,6,7};
		 int [] result =  maxSlidingWindow(nums,3);
		 for (int i=0; i < result.length ; i++)
		 {
			 System.out.print(" "+result[i]);
		 }
	 }
}
