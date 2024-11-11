package arrays;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears 
 * more than  n/2 times.
 * @author Manoj.K
 *
 */
public class MajorityElement 
{
	/**
	 * If we sort the array, majority element must be at mid of the array. Time complexity of this algorith
	 * is N log(N) i.e equal to the time complexity of sorting of the array.
	 * @param nums
	 * @return
	 */
	private static int majorityElementBySorting(int nums[])
	{
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	/**
	 * Idea behind this algorithm is to maintain a count which to be incremented when we see current candidte
	 * element occurance and decrement the counter if anything else. If count becomes 0, it means forget everything
	 * and treat the current element as the candidate element hence forth till end of the array.
	 * 
	 * In case of elements counts are equal in array then the last distinct element is the majority element.
	 * 
	 * Time complexity of this algorithm is O(N).
	 * @param nums
	 * @return
	 */
	 public static int majorityElement(int[] nums) 
	 {
	     int candidate = nums[0];
	     int count = 0;
	     for (int num: nums)
	     {
	        if (count == 0)
	        {
	           candidate = num;
	        }
	        if (num == candidate)
	        {
	            count++;
	        }
	        else
	        {
	            count--;
	        }
	    }
	    return candidate;
	}
    public static void main(String args[])
    {
    	int nums[] = {2,2,1,1,1,2,2};
    	System.out.println("Majority element is: "+ majorityElementBySorting(nums));
    	
    	int nums1[] = {3,3,4};
    	System.out.println("Majority element is: "+ majorityElement(nums1));
    	
    	int nums2[] = {2,2,1,1,1,1,2,2,3,3,3,3};
    	System.out.println("Majority element is: "+ majorityElement(nums2));
    }
}
