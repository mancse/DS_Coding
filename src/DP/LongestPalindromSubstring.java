package DP;

public class LongestPalindromSubstring 
{
	
	/*
	 *      g e e k s s k e e g
	 *    g T 0 0 0 0 0 0 0 0 T
	 *    e   T T 0 0 0 0 0 T 0
	 *    e     T 0 0 0 0 T 0 0
	 *    k       T 0 0 T 0 0 0
	 *    s         T T 0 0 0 0
	 *    s           T 0 0 0 0
	 *    k             T 0 0 0
	 *    e               T T 0
	 *    e                 T 0
	 *    g                   T   
	 * 
	 */
	public static int longestPalindromSubStringLength(String str)
	{
		int count = 0;
		int n = str.length();

		boolean [][] dp = new boolean[n][n];
		/*
		 * Traverse on gap diagonal
		 */
		for (int g=0; g<dp.length; g++)
		{
			for (int i=0, j=g; j < dp[0].length; j++, i++)
			{
				/*
				 * This is for each single character on gap zero diagonal. 
				 */
				if (g == 0)
				{
					dp[i][j] = true;
				}
				
				/**
				 * This is to check if two character substring is palindrom or not on gap size 1. 
				 */
				else if (g == 1)
				{
					if (str.charAt(i) == str.charAt(j))
					{
						dp[i][j] = true;
					}
				}
				else
				{
					if (str.charAt(i) == str.charAt(j) && i+1 < str.length() && j-1 >= 0 && dp[i+1][j-1] == true)
					{
						dp[i][j] = true;
					}
				}
				
				if (dp[i][j] == true)
				{
					count = g+1;
				}
			}
		}
		return count;
	}
	
	public static String findLongestPalindrome(String s) {
        String result = null;
        boolean dp[][] = new boolean [s.length()][s.length()];
        int maxi =0;
        int maxj = 0;
        for (int g=0; g < s.length(); g++)
        {
            for (int i=0, j=g; j < dp[0].length ; i++, j++)
            {
                if (g == 0)
                {
                	//All single character string are palindrome by default.
                    dp[i][j] = true;
                }
                else if (g == 1)
                {
                	//If string length is of two length, then check if both characters are same. 
                	//If yes, then palindrome.
                    if (s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = true;
                    }
                }
                else
                {
                	/**
                	 * Check for each possible string between index i and j where i always starts from 0 and j=g. 
                	 * If character at i and j matches then check if substring after removing ith and jth character
                	 * are already a palindrom or not from DP if yes then string between i and j are palindrom.
                	 * 
                	 * 
                	 * Note: Below dp[i+1][j-1] stores the palindrome status of substring after removing ith and jth 
                	 * characters from string formed by characters between i and j. 
                	 */
                    if (s.charAt(i) == s.charAt(j) && i+1 < s.length() && j-1 >= 0 && dp[i+1][j-1] == true)
                    {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true)
                {
                    maxi = i;
                    maxj = j;
                }
            }
        }

        result = s.substring(maxi,maxj + 1);
        return result;
    }
	
	public static int countPalindromicSubstrings(String s) 
    {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count =0;
        for (int g=0; g < s.length(); g++)
        {
            for (int i=0, j=g; j < dp[0].length; i++, j++)
            {
                if (g == 0 )
                {
                    dp[i][j] = true;
                }
                else if (g == 1)
                {
                    if (s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = true;
                    }
                }
                else
                {
                    if (s.charAt(i) == s.charAt(j) && i+1 < s.length() && j-1 < s.length() && dp[i+1][j-1] == true)
                    {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[])
    {
    	String str = "geeksskee"; 
        System.out.println("Length of longest palindromic substring in string: "+str+ " is: " +  
        		longestPalindromSubStringLength(str)); 
        
        System.out.println("Longest palindrom in string: "+str+" is: "+findLongestPalindrome(str));
    }
}
