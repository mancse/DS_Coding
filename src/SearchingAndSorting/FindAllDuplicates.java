package SearchingAndSorting;

import java.util.ArrayList;
import java.util.List;
/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear
 * once. Find all the elements that appear twice in this array. Could you do it without extra space and in O(n)
 * runtime?
 * @author Manoj.K
 *
 */
public class FindAllDuplicates 
{
	public static List<Integer> findDuplicates(int[] nums) 
    {
        List<Integer> result = new ArrayList<>();
        
	    if (nums.length == 0)
	        return result;
	        
     
	    for (int i=0; i<nums.length; i++)
	    {
	       int idx = Math.abs(nums[i]);
	       
	       if (nums[idx-1] < 0)
	    	   result.add(idx);
	       else
	    	   nums[idx-1] = -1 * nums[idx-1];
	    } 
	    return result;
    }
	
	public static void main(String args[])
	{
		 int nums[] = {10,2,5,10,9,1,1,4,3,7};
		 List<Integer> result = findDuplicates(nums);
		 System.out.println(result);
	}
}
