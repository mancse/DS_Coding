package DP;


/**
 * Given strings are: abcdad and cda
 * Find length of longest substring and the substring itself
 * 
 * 		-	a   b   c   d   a   d 
	 
   -    0	0	0	0	0	0	0

   c    0   0	0	1	0	0	0 

   d    0   0	0	0	2	0	1

   a    0   1	0	0	0	3	0
   
 * @author Manoj.K
 *
 */
public class LongestCommonSubstring 
{
   public static void main(String args[])
   {
	   longestCommonSubstring("cda","abcdad");
   }
   
   public static void longestCommonSubstring(String s1, String s2)
   {
	   int dp[][] = new int[s1.length() + 1][s2.length() + 1];
	   
	   for(int i=0; i<dp.length; i++)
	   {
		   dp[i][0] = 0;
	   }
	   
	   for (int i=0; i<dp[0].length; i++)
	   {
		   dp[0][i] = 0;
	   }
	   
	   int maxlen = 0;
	   int maxi = 0;
	   int maxj = 0;
	   
	   for (int i=1; i < dp.length ; i++)
	   {
		   for (int j=1; j< dp[0].length; j++)
		   {
			   if (s1.charAt(i-1) == s2.charAt(j-1))
			   {
				   dp[i][j] = 1+ dp[i-1][j-1];
				   if (maxlen < dp[i][j])
				   {
					   maxlen = dp[i][j];
					   maxi = i;
					   maxj = j;
				   }
			   }
		   }
	   }
	   
	   int mini = maxi;
	   int minj = maxj;
	   int len = maxlen;
	   while (len > 0)
	   {
		   mini = mini -1;
		   minj = minj -1;
		   len--;
	   }
	   
	   System.out.println("Length of common substring: "+maxlen);
	   System.out.println("Longest common substring: "+s1.substring(mini, maxi));
	   System.out.println("Longest common substring: "+s2.substring(minj, maxj));
   }
}
