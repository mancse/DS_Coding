package arrays;

import java.util.HashMap;
import java.util.Map;

public class ShortestUnsortedContiguousSubArray 
{
	
	/**
	 * Idea is following:
	 * 1. Find first minimum element from left and assign it to min variable.
	 * 2. Find first maximum element from right of the array and assign it to max variable. 
	 * 3. Now again start left pointer from 0 and check if nums[left] > min. If yes, then
	 *    it means that particular left index is candidate of unsorted subarry and need to sort.
	 * 4. Similarly, start right pointer from n-1 and check if nums[right] < max. If yes then
	 *    it means that particular right index is the candidate of unsorted subarray and need to sort.
	 * right of the arry. 
	 * @param nums
	 * @return
	 */
    private static Map<String,Integer> findUnsortedSubarray(int[] nums)
    {
        int min=Integer.MAX_VALUE; 
        int max=Integer.MIN_VALUE;
        Map<String,Integer> result = new HashMap();
        for (int i=1; i<nums.length; i++)
        {
            if (nums[i] < nums[i-1])
            {
                min = Math.min(min,nums[i]);
            }
        }
        
        for (int i= nums.length-2; i>=0; i--)
        {
            if (nums[i] > nums[i+1])
            {
                max= Math.max(max,nums[i]);
            }
        }
        int left=0, right=nums.length -1;
        for (; left < nums.length; left++)
        {
            if (nums[left] > min)
            {
            	result.put("left",left);
                break;
            }
        }
        
        for (; right >=0; right--)
        {
            if (nums[right] < max)
            {
            	result.put("right",right);
                break;
            }
        }
        return result;
    }
    
    public static void main(String args[])
    {
    	int nums[] = {2, 6, 4, 8, 10, 9, 15};
    	Map<String,Integer> result = findUnsortedSubarray(nums);
    	System.out.println("Left index: "+result.get("left")+" Right index: "+result.get("right"));
    	
    	int nums1[] = {2, 6, 4, 8, 10, 14, 15};
    	Map<String,Integer> result1 = findUnsortedSubarray(nums1);
    	System.out.println("Left index: "+result1.get("left")+" Right index: "+result1.get("right"));
    }
}
