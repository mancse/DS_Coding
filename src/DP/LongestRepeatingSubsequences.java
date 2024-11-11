package DP;
/**
 * Given a string str, find length of the longest repeating subsequence such that the two subsequence don’t
 * have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t 
 * have the same index in the original string.
 * 
 * So, to put it in simple word, longest repeating subsequence is the subsequence which repeats multiple times
 * and any character of the repeated subsequence doesn't share same character of original string. 
 * E.g: 
 * Input: str = "abacbc"
 * Output: 2
 * Explanation: The longest repeating subsequence is "abc".
 * In this string there are two occurances of subsequence "abc" i.e a(0)b(1)c(3) and a(2)b(3)c(4). So, if we see
 * no character of abc are of same indexed character in original string.   
 * 
 * Idea: Take LCS of the string with itself with one extra condition is that when character at ith and jth index
 * matches, that time, i shouldn't match with j. 
 * @author Manoj.K
 *
 */
public class LongestRepeatingSubsequences {
	public int LongestRepeatingSubsequence(String str)
    {
        int dp[][] = new int[str.length()+1][str.length()+1];
        
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (i!=j && str.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[str.length()][str.length()];
    }
}
