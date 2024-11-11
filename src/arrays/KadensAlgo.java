package arrays;

/**
 * Problem: Find the sum of contiguous subarray elements of one dimensional array of numbers which has 
 * largest sum.
 * 
 * Idea: Maintain two variables named currentMax and maxSoFar. Add each element into currentMax. 
 * If currentMax > maxSoFar then assign currentMax into maxSoFar. Return maxSoFar as result after
 * complete array traversal.
 * 
 * Algorithm:
 * Initialize:
    maxSoFar = 0
    currMax = 0

    Loop for each element of the array
    (a) currMax = currMax + a[i]
    (b) maxSoFar= Math.max(currMax,maxSoFar);
    (b) if(currMax < 0)
            currMax = 0
    
            
return max_so_far
 * @author Manoj.K
 *
 */
public class KadensAlgo 
{
	private static int findLargestSubArraySum(int nums[])
	{
	    int maxSoFar = Integer.MIN_VALUE ;
		int currMax = 0;
		for (int i=0 ; i < nums.length; i++)
		{
			currMax = currMax + nums[i];
			maxSoFar=Math.max(currMax,maxSoFar);
			currMax = Math.max(currMax,0);
		}
		return maxSoFar;
	}
    public static void main(String args[])
    {
    	int nums [] = {-2,-3,4,-1,-2,1,5,-3};
    	
    	System.out.println("Maximum contiguous subarray sum is: "+ findLargestSubArraySum(nums));
    }
}
