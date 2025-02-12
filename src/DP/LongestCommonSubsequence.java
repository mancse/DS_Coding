package DP;

/**
 * 
 *         -   a   c   e
 *	   -   0   0   0   0
 *	   
 *     a   0   1   1   1 
 *	   
 *	   b   0   1   1   1    
 *	   
 *	   c   0   1   2   2   
 *	   
 *	   d   0   1   2   2 
 *	   
 *	   e   0   1   2   3
 *
 *
 * @author Manoj.K
 *
 */
public class LongestCommonSubsequence 
{
	public static void longestCommonSubsequence(String text1, String text2) 
    {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        
        int lcs =0;
        
        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
            	/**
            	 * If character matches, then length of longest subsequence at dp[i][j] is found by 1 + dp[i-1][j-1]].
            	 * Here, dp[i-1][j-1] is the subsequence of remaining string after removing matching character. 
            	 */
                if (text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                /**
                 * If characters are not matching, then longest subsequence is max value of longest subsequence by removing
                 * non-matching character from each string at a time. E.g: dp[2][2] can be found by max(dp[1][2],dp[2][1]).
                 * Because, at dp[2][2], b and c are not matching. So, remove b from ab of original string (abcde) which 
                 * will be equal to dp[1][2]. Similarly remove c from ac of original string (ace) which will be equal to dp[2][1].
                 * So, take maximum value from both. 
                 */
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                
                lcs = Math.max(lcs,dp[i][j]);
                System.out.println("lcs: "+lcs);
            }
        }
        findLongestCommonSubsequenceString(text1, text2, dp);
    }


	private static void findLongestCommonSubsequenceString(String text1, String text2, int[][] dp) {
		StringBuilder sb = new StringBuilder();
        int i= text1.length(), j=text2.length();
        while (i >=1 && j >=1)
        {
        	  //Traverse DP table from end and check if character of two string matches then 
        	  //traverse diagonally backward else if dp[i-1][j] >= dp[i][j-1] then check decrement i (i.e find in text1)
        	  // else decrement j i.e check in text2.  
              if (text1.charAt(i-1) == text2.charAt(j-1))
              {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
              }
              else
              {
                if (dp[i-1][j] >= dp[i][j-1])
                {
                  i--;
                }
                else
                {
                  j--;
                }
              }
        }
        System.out.println("LCS String: "+sb.reverse().toString());
	}
	
	
	public static void main(String args[]){
		longestCommonSubsequence("abcde","ace");
	}
}
