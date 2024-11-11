package DP;

/**
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' 
 * where: '?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * 
 * Input string: abeccdcb, pattern: a*c?cb
 * @author Manoj.K
 * 
 *         -    a   b   e   c   c   d   c   b
 *		   
 *	   -   T    F	F	F	F	F	F	F	F
 *	   
 *	   a   F    T   F	F	F	F	F	F	F
 *	   
 *	   *   F    T   T   T   T   T   T   T   T 
 *	   
 *	   c   F    F	F	F	T	T	F   T   F
 *	   
 *	   ?   F    F	F	F	F	T	T	F	T 
 *	   
 *	   c   F    F	F	F	F	F	F	T	F
 *	   
 *	   b   F    F	F	F	F	F	F	F	T
 * 
 * Logic: 
 * a. if pattern character at index i is char and pattern character matches with string character j
 *       dp[i][j] = dp[i-1][j-1]
 *       else
 *       dp[i][j] = false
 * b. if pattern character at index i is '?' then it can eat the current string current at j so,
 *       dp[i][j] = dp[i-1][j-1]
 * c. if pattern character at index i is '*' then there can be two possibilities, either * itself can
 *    disappear or it eats up current character at j and still * is present to eat other character as well. 
 *    	-When it disappear, then need to check if remaining pattern from 0 to i-1 is able to eat up string from 
 *    	 0 to j. So, check value of dp[i-1][j]
 *   	 -When * eats up current input character at j, then need to check if pattern from 0 to i is able to eat up
 *    	 string 0 to j-1. so, 
 *       dp[i][j] = dp[i-1][j] || dp[i][j-1]
 */
public class WildcardMatching
{
    public static void main(String args[])
    {
    	boolean match = isMatch("abeccdcb","a*c?cb");
    	System.out.println(match);
    }
    
    public static boolean isMatch(String s, String p) 
    {
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        
        dp[0][0] = true;
        
        for (int i=1; i < dp.length; i++)
        {
            if (p.charAt(i-1) == '*')
            {
                dp[i][0] = dp[i-1][0]; 
            }
            else
            {
                dp[i][0] = false;
            }
        }
        
        for (int i=1; i < dp.length; i++)
        {
            for (int j=1; j<dp[0].length; j++)
            {
                if (p.charAt(i-1) == '*')
                {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if (p.charAt(i-1) == '?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (p.charAt(i-1) == s.charAt(j-1))
                {
                	dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
}
