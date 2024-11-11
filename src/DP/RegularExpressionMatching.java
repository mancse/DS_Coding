package DP;
/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for 
 * '.' and '*' where: '.' Matches any single character.​​​ '*' Matches zero or more of the preceding element. 
 * The matching should cover the entire input string (not partial).
 * 
 * Input string: mississippi,  pattern: mis.is*i*
 * 
 * 		   -	m	i	s	s	i	s	s	i	p	p	i
		   
	  -    T    F   F	F	F	F	F	F	F	F	F	F

      m    F    T	F	F	F	F	F	F	F	F	F	F

   	  i    F    F	T	F	F	F	F	F	F	F	F	F
	  
	  s    F    F	F	T	F	F	F	F	F	F	F	F
	  
	  .    F    F	F	F	T	F	F	F	F	F	F	F 
	  
	  i    F    F	F	F	F	T	F	F	F	F	F	F
	  
	  s    F    F	F	F	F	F	T	F	F	F	F	F
	  
	  *    F	F	F	F	F	T	T	T	T	T	T	T
	  
	  i    F	F	F	F	F	F	F	F	T	F	F	T
	  
	  *    F	F	F	F	F	T	T	T	T	T	T	T
	  
	  Logic:
	 
	  a. If pattern character at index i is character and pattern character matches with string character 
	     dp[i][j] = dp[i-1][j-1];
	     else
	     dp[i][j] = false;
	  b. if pattern character at index i is dot then it can match with any single character of string at index j so,
	     dp[i][j] = dp[i-1][j-1];
	  c. if pattern character at index i is star(*) then check character before * is dot (.) or character before 
	     start is equal to character of input string at index j
	     dp[i][j] = dp[i-2][j] || dp[i][j-1]
	     else
	     dp[i][j] = dp[i-2][i]
	      
 * @author Manoj.K
 *
 */
public class RegularExpressionMatching 
{
	public boolean isMatch(String s, String p)
    {
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        
        dp[0][0] = true;
        
        for (int i=1; i < dp.length; i++)
        {
            if (p.charAt(i-1) == '*')
            {
                dp[i][0] = dp[i-2][0];
            }
            else
            {
                dp[i][0] = false;
            }
        }
        
        for (int i=1; i < dp.length; i++)
        {
            for (int j=1; j < dp[0].length; j++)
            {
                if (p.charAt(i-1) == '*')
                {
                    if (p.charAt(i-2) == '.' || p.charAt(i-2) == s.charAt(j-1))
                        dp[i][j] = dp[i-2][j] || dp[i][j-1]; 
                    else
                        dp[i][j] = dp[i-2][j];
                }
                
                else if (p.charAt(i-1) == '.')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    if (p.charAt(i-1) == s.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
