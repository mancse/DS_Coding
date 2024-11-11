package DP;
/**
*
*         c   b   b   d
*   		  
*     c   1   1   2   2
*	  
*	  b   0   1   2   2
*	  
*	  b   0   0   1   1 
*	  
*	  d   0   0   0   1
* @author Manoj.K
*
*/
public class LongestPalindromicSubsequence 
{
	public static int longestPalindromeSubseq(String s) 
    {
        int dp[][] = new int[s.length()][s.length()];
        int result =0;
        for (int g=0; g < dp[0].length; g++)
        {
            for (int i=0, j=g; j < dp[0].length; i++, j++)
            {
                if (g == 0)
                {
                    dp[i][j] = 1;
                }
                else if (g == 1)
                {
                    if (s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = 2;
                    }
                    else
                    {
                        dp[i][j] = 1;
                    }
                }
                else
                {
                    if (s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
	
	public static void main(String args[]){
		int res = longestPalindromeSubseq("cbbdbc");
		System.out.println("Longest palindrom subsequence: "+res);
	}
}
