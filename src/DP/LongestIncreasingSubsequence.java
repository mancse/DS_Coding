package DP;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * @author Manoj.K
 *
 */
public class LongestIncreasingSubsequence 
{
	/**
	 * Idea: Create dp table of size equal to given array. 
	 *       Store the length of longest increasing subsequence at any 
	 *       index such that length of  subsequence at any given index in dp array 
	 *       must be up to the value of original array at that 
	 *       index and must not exceed it's value
	 * 
	 * nums[]	10,	9,	2,	5,	3,	7,	101,	18
	   
	   dp[]		1	1	1	2	2	3   4       4
	   			
	   			10	9	2	2,  2,  2,  2,      2,
      subseq                5   3   5,  5,      5,
					                7   7,      7,
							            101     18
	 * @param nums
	 * @return
	 */
    public static int lengthOfLongestIncreasingSubsequence(int[] nums) 
    {
        int dp[] = new int[nums.length];
        int lis = 0;
        
        for (int i=0; i<dp.length; i++)
        {
            int maxsofar = 0;
            for(int j=0; j<=i; j++)
            {
                if (nums[j] < nums[i])
                {
                    maxsofar = Math.max(maxsofar, dp[j]);
                }
            }
            dp[i] = maxsofar + 1;
            
            lis = Math.max(lis,dp[i]);
        }
        
        return lis;
    }
	
	public static  int lengthOfLIS(int[] nums) 
    {
        int memo[][] = new int[nums.length +1][nums.length];
        for (int[] m : memo)
        {
            Arrays.fill(m,-1);
        }
        return LengthOfLongestIncreasingSubsequence(nums,-1,0,memo);
    }
    
    public static int LengthOfLongestIncreasingSubsequence(int nums[],int prev,int curr,int memo[][])
    {
        if (curr == nums.length)
            return 0;
        
        if (memo[prev+1][curr] >= 0)
            return memo[prev+1][curr];
        int take = 0;
        
        /**
         * Idea is following: 
         * 1. If current element is greater than previous element included in LIS, then consider the 
         *    current element aspart of longest increasing subsequence. Thus, we find out the length of 
         *    the LIS obtained by including it. 
         *    
         * 2. The current element is smaller than the previous element included in the LIS. In this case, 
         *    we can't include the current element in the LIS. Thus, we find out only the length of the LIS 
         *    possible by not including the current element in the LIS, which is returned by the current 
         *    function call.
         *    
         * 3. Returns maximum of above two as LIS.  
         *
         */
        if (prev < 0 || nums[curr] > nums[prev])
            take = 1 + LengthOfLongestIncreasingSubsequence(nums,curr,curr+1,memo);
      
        int nottake = LengthOfLongestIncreasingSubsequence(nums,prev,curr+1,memo);
        
        int max = Math.max(take,nottake);
        
        memo[prev+1][curr] = max;
        return max;
    }
    
    public static void main(String args[])
    {
    	int nums[] = {10,	9,	2,	5,	3,	7,	101,	18};
    	lengthOfLongestIncreasingSubsequence(nums);
    }
}

