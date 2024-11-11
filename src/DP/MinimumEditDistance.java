package DP;
/**
 * Question: Given two strings. Return minimum number of operations to convert one string to another.
 * 
 * Word1: horse, Word2= ros
 * 	    -	r	o	s
	-   0   1   2   3
	h   1   1   2   3 
	o   2   2   1   2  
	r   3   2   2   2 
	s   4   3   3	2 
	e   5   4   4   3
	
   Initial condition: 
   a. Minimum number of operation to convert a blank string to a given string is equal
   	  to the length of the string (i.e that many number of insert operation has to be done)
   	  dp[0][j] = j
   	  
   b. Minimum number of operation to convert a string to blank is equal to the length of the string
      (i.e that many number of delete operations has to be done)
   	  dp[i][0] = i
   
   c. if word1 character at index i matches with word2 indexes at j then there is no operation
      required to convert the matching character. Hence, dp[i][j] = dp[i-1][j-1].
      
   d. if word1 character at index i doesn't match with word2 character at index j then there will be
      1 operation to convert this current character plus minimum of dp[i-1][j-1],dp[i-1][j] and dp[i][j-1].
 
 * @author Manoj.K
 *
 */
public class MinimumEditDistance 
{
	public int minDistance(String word1, String word2)
    {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        
        for (int i=0; i<dp.length; i++)
        {
            dp[i][0] = i;
        }
        
        for (int j=0; j<dp[0].length; j++)
        {
            dp[0][j] = j;
        }
        
        for (int i=1; i<dp.length; i++)
        {
            for (int j=1; j<dp[0].length;j++)
            {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
