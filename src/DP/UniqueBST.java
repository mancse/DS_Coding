package DP;
/*
 * Given a number n. Find total number of BST that can be constructed from it. 
 * 
 * Logic: It is based on catalan numbers as mentioned below.
 * 
 *  Cn = C0*Cn-1 + C1*Cn-2 + ......... + Cn-1*C0
 *  C1 = C0 * C0
 *  C2 = C0 * C1 + C1 * C0
 */
public class UniqueBST 
{
	 public int numTrees(int n) 
	 {
		 int dp[] = new int[n+1];
	        
		 dp[0] = 1;
	     dp[1] = 1;
	        
	     for (int i=2; i <= n; i++)
	     {
	        for (int j=0; j < i ; j++)
	        {
	            dp[i] += dp[j] * dp[i-1-j];
	        } 
	     }        
	     return dp[n];
	 }
}
