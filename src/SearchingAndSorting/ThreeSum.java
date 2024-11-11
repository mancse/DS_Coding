package SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Idea: Idea is to iterate each element of the array and find 0 - num[i] as target sum to find in
 * Two sum problem. 
 * 
 * @author Manoj.K
 *
 */
public class ThreeSum 
{
	
	public static void main(String args[])
	{
		int nums[] = {0,0,0,0};
		List<List<Integer>> res = threeSum(nums);
		System.out.println(res);
	}
	
	 public static List<List<Integer>> threeSum(int[] nums) 
	    {
	        List<List<Integer>> result = new ArrayList<>();
	        if (nums == null || nums.length ==0)
	        {
	            return result;
	        }
	        Arrays.sort(nums);
	        int sum=0;
	       
	        for (int i=0; i< nums.length; i++)
	        {
	            if (i>0 && nums[i] == nums[i-1])
	                continue;
	            int rest = sum-nums[i];
	            twoSum(result, nums, rest,i); 
	        }
	         
	        return result;
	    }
	    
	    private static void twoSum(List<List<Integer>> result,int[] nums, int rest,int i)
	    {
	        int left = i+1;
	        int right = nums.length-1;
	          
	        while(left < right)
	        {
	            int sum= nums[left] + nums[right];
	            
	            /*
	             * Add the array elements at index i, left and right in the result array.  
	             */
	            if (sum == rest)
	            {
	                List<Integer> list = new ArrayList<>();
	                list.add(nums[i]);
	                list.add(nums[left]);
	                list.add(nums[right]);
	                
	                result.add(list);
	                
	                /*
	                 * If there is any duplicate combination from left pointer then 
	                 * ignore them. 
	                 */
	                while(left < right && nums[left] == nums[left+1])
	                {
	                    left++;
	                }
	                
	                /*
	                 * If there is any duplicate combination from right pointer then 
	                 * ignore them. 
	                 */
	                while(left < right  && nums[right] == nums[right-1])
	                {
	                    right--;
	                }
	                //This increment in left pointer is required to check next combination of pairs.
	                //Notice: only left pointer is updated because there could be another pair after left
	                //counter including right pointer which along with initial element can form uniqueue triplet. 
	                left++;
	            }
	            if(sum > rest)
	            {
	                right--;
	            }
	        
	           if(sum < rest)
	           {
	                left++;
	           }
	        }
	    }
}
