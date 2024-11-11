package DP;

import java.util.HashMap;

public class PartitionEqualSubSetSum 
{
	/*
	 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two
	 * subsets such that the sum of elements in both subsets is equal.
	 */
	public static void main(String args[])
	{
		int nums[] = {1,4,5};
		
		
		boolean res = canPartition(nums);
		System.out.println("Result : "+res);
		
		
		res = canPartitionDP(nums);
		System.out.println("Result DP: "+res);
		
		System.out.println("Result DP using tabular approach: "+res);
		res = isPartitionEqualSubsetSum(nums);
	}
	
	/**
	 * This is tabulation approach where same concept is used as used in subset sum problem with following points
	 * considered additionally.
	 * 1. If sum of all the elements are odd then there is no such equal sum partition possible, so return false
	 * 2. Else check if sum/2 can be achieved in one set. If yes then another set will automatically will addup to sum/2.
	 * 3. So, problem reduces to subset sum problem to find if set of elemets exists whose sum is equal to given sum/2.
	 * 
	 *    input[]={1,4,5}
	 *    sum=1+4+5=10
	 *    
	 *    sum/2=5
	 *    
	 * Recurrence relation:
	 *  if input[i-1]>j
	 * 		dp[i][j] = dp[i-1][j]  
	 *  else if input[i-1]==j
	 *      dp[i][j] = true
	 *  else
	 * 		dp[i][j] = dp[i-1][j] || dp[i-1][j-input[i-1]]
	 * 
	 * ---------------------------------------------------
	 * 		0	1	2	3	4	5
	 *  0   T	F	F	F	F	F
	 *  
	 *  1   T   T	F	F	F	F
	 *  
	 *  4   T	T	F	F	T	T
	 *  
	 *  5   T	T	F	F	T	T
	 *    
	 * @return
	 */
	private static boolean isPartitionEqualSubsetSum(int nums[]){
		int sum = 0;
		for (int i=0; i<nums.length; i++){
			sum +=nums[i];
		}
		
		if (sum%2!=0){
			return false;
		}
		boolean dp[][] = new boolean[nums.length+1][sum/2+1];
		for (int i =0 ; i<nums.length; i++)
		{
			dp[i][0] = true;
		}
	    for(int i=1; i<dp.length; i++){
	    	for (int j=1; j<dp[0].length;j++){
	    		if (nums[i-1] > j){
	    			dp[i][j]=dp[i-1][j];
	    		}
	    		else{
	    			dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
	    		}
	    	}
	    }
		return dp[nums.length][sum/2];
	}
	
	private static boolean canPartition(int[] nums) 
    {
        int total =0;
        for (int i=0; i< nums.length; i++)
        {
        	total = total + nums[i];
        }
        
        if (total ==0 || total % 2 != 0)
        {
        	return false;
        }
        return isPartitionSubsetSum(nums,0,0,total);
    }
	

    private static boolean isPartitionSubsetSum(int[] nums, int start, int sum, int total)
    {
    	if (total/2 == sum)
    	{
    		return true;
    	}
    	if (start >= nums.length)
    		return false;
    	
    	return isPartitionSubsetSum(nums, start+1, sum+nums[start],total) || isPartitionSubsetSum(nums, start+1, sum,total);
    }
    
	private static boolean canPartitionDP(int[] nums) 
    {
        int total =0;
        for (int i=0; i< nums.length; i++)
        {
        	total = total + nums[i];
        }
        
        if (total ==0 || total % 2 != 0)
        {
        	return false;
        }
        return isPartitionSubsetSumDP(nums,0,0,total,new HashMap<String,Boolean>());
    }
	
    private static boolean isPartitionSubsetSumDP(int[] nums, int start, int sum, int total,HashMap<String,Boolean> dp)
    {
    	if (dp.containsKey(start+"-"+sum))
    	{
    		return dp.get(start+"-"+sum);
    	}
    	if (total / 2 == sum)
    	{
    		return true;
    	}
    	boolean ret;
    	
    	if (start >= nums.length)
    	{
    		return false;
    	}
    	
    	ret = isPartitionSubsetSumDP(nums, start+1, sum+nums[start],total,dp) || isPartitionSubsetSumDP(nums, start+1, sum,total,dp);
    	dp.put(start+"-"+sum, ret);
    	return ret;
    }
}
