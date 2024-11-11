package DP;

/**
 * Problem: You are climbing a stair case of N steps to reach to the top. You can either take 1 step or 2 at a time. 
 * How many distinct ways you can take to reach to the top. 
 * 
 * Note: Given N steps are positive number. 
 * 
 * c(0,5) = c(1,5) + c(2,5)
 * c(1,5) = c(2,5) + c(3,5)
 * c(2,5) = c(3,5) + c(4,5)
 * c(3,5) = c(4,5) + c(5,5)
 * c(4,5) = c(5,5) + c(6,5)
 * 
 * c(5,5) = 1
 * c(6,5) = 0
 * @author Manoj.K
 *
 */
public class ClimbingStairs
{
	/* Idea: c(i,n) = c(i+1,n) + c(i+2,n) where i is the current step and n is the destination step.
	   In this case, time complexity is 2^n where each step can be either of 1 step or 2 steps of recursion tree*/
	public static int climbStairs(int i, int n)
	{
		if (i > n)
			return 0;
		if (i == n)
			return 1;
		
		return (climbStairs(i+1,n) + climbStairs(i+2, n));
	}
	
	/* Idea: c(i,n) = c(i+1,n) + c(i+2,n) where i is the current step and n is the destination step.
	         Here, we are storing the result of previous step in current if it is already available
	         E.g c(3,5)=c(4,5) + c(5,5) but if we look carefully, c(4,5) and c(5,5) are already calculated earlier. */
	public static int climbStairsWithDP(int i, int n,int memo[])
	{
		if (i > n)
			return 0;
		if (i == n)
			return 1;
		
		if (memo[i] > 0)
			return memo[i];
		
		return memo[i] = (climbStairsWithDP(i+1,n,memo) + climbStairsWithDP(i+2, n,memo));
	}
	public static int climbStairsWithBottomUpDP(int n){
       
	    int dp[] = new int[n+1];
	    
	    /*
	     * If a person is at 0th step, then he can't come from any previous step.  
	     * So, there 1 way to climb stair at step 0 i.e don't climb at all. 
	     */
        dp[0] = 1;
        
        /*
         * There is 1 way to climb stair at step 1
         */
        dp[1] = 1;
        
        for (int i=2; i<=n; i++){
        	/*
        	 * In order to reach to i'th step, one can come from it's previous or previous to previous step because
        	 * there are only 2 steps allowed at a time. 
        	 */
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
	}
	public static void main(String args[])
	{		
		int n = 5;
		System.out.println("Total number of ways to climb top of the stairs with ClimbingStairs() : "+climbStairs(0,n));
		int memo[] = new int[n + 1];
		System.out.println("Total number of ways to climb top of the stairs with climbStairsWithDP() : "+climbStairsWithDP(0,n,memo));
	}
}