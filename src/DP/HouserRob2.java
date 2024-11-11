package DP;

import java.util.HashMap;
import java.util.Map;

public class HouserRob2 
{
	/**
	 * You are a professional robber planning to rob houses along a street. Each house has a certain 
	 * amount of money stashed. All houses at this place are arranged in a circle. That means the 
	 * first house is the neighbor of the last one. Meanwhile, adjacent houses have security system 
	 * connected and it will automatically contact the police if two adjacent houses were broken into 
	 * on the same night.Given a list of non-negative integers representing the amount of money of each house,
	 *  determine the maximum amount of money you can rob tonight without alerting the police.
	 * @param args
	 */
	public static void main(String args[])
	{
		int nums[] = {1,2,3,1};
		int maxAmt = rob(nums);
		System.out.println("Maximum Rob Amount: "+maxAmt);
	}
	public static  int rob(int[] nums) 
    {
        if (nums.length == 0)
            return 0;
        if (nums.length ==1)
            return nums[0];
        int amt1 = maxRob(nums,0,nums.length-2,new HashMap<Integer,Integer>());
        int amt2 = maxRob(nums,1,nums.length-1,new HashMap<Integer,Integer>());
        
        return Math.max(amt1 , amt2);
    }
    
    private static int maxRob(int nums[],int i,int n, Map<Integer,Integer> memo)
    {
        if (i > n)
            return 0;
        
        if (memo.containsKey(i))
            return memo.get(i);
        
        int maxAmt =  Math.max((nums[i]+maxRob(nums,i+2,n,memo)),maxRob(nums,i+1,n,memo));
        memo.put(i,maxAmt);
        return maxAmt;
    }
    
public int robBottomUp(int[] nums) {
        
        if (nums.length == 0){
            return 0;
        }
        if (nums.length ==1){
            return nums[0];
        }
        int nums1[] = new int[nums.length -1];
        int nums2[] = new int[nums.length -1];
        
        for (int i=0; i<nums.length-1; i++){
            nums1[i] = nums[i];
        }
        
        for (int i=1; i<nums.length; i++){
            nums2[i-1] = nums[i]; 
        }
        
        int max1 = maxRobBottomUp(nums1);
        int max2 = maxRobBottomUp(nums2);
        
        return Math.max(max1,max2);
    }
    
    private int maxRobBottomUp(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
}
