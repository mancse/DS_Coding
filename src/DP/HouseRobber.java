package DP;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber 
{
	public static void main(String args[])
    {
    	int nums [] = {2,7,9,3,1};
    	int max = rob(nums);
    	System.out.println("Max robbed amount: "+max);
    }
	/**
	 * Find maximum possible stolen value from houses. There are n houses build in a line, each of which contains some value in it. 
	 * A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses because the owner of the stolen houses 
     * will tell his two neighbours left and right side. What is the maximum stolen value?
	 * @param nums
	 * @param nl
	 * @return
	 */
	public static int rob(int[] nums)
    {
        if (nums.length ==0)
            return 0;
        Map<Integer,Integer> memo = new HashMap<>();
        int maxAmt = maxRob(nums,0,memo);
        return maxAmt;
    }
    
    private static int maxRob(int nums[],int i,Map<Integer,Integer> memo)
    {
        if (i >= nums.length)
            return 0;
        if (memo.containsKey(i))
            return memo.get(i);
        int maxAmt =  Math.max((nums[i]+maxRob(nums,i+2,memo)),maxRob(nums,i+1,memo));
        memo.put(i,maxAmt);
        return maxAmt;
    }
	
    public int maxRobBottomUp(int[] nums) {
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
