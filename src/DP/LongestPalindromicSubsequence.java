/*
*       b   b   b   a   b
*
*   b   1   2   3   3   4
*
*   b       1   2   2   3
*
*   b           1   1   3
*
*   a               1   1
*
*   b                   1
dp[i][j] represents the length of the longest palindromic subsequence in the substring s[i:j] (i.e., from index i to j).

If s.charAt(i) and s.charAt(j) are equal:
We can extend the palindromic subsequence found in s[i+1:j-1] by adding s[i] and s[j] on both ends.
The new palindromic subsequence length is
     dp[i][j]=2+dp[i+1][j−1]
Why +2? Because s[i] and s[j] themselves contribute 2 characters to the length.

If s.charAt(i) and s.charAt(j) are not equal:
    We must discard one of the characters (s[i] or s[j]) and take the best possible LPS from either:
dp[i+1][j] (ignoring s[i])
dp[i][j-1] (ignoring s[j])
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        int res = 0;

        for (int d=0; d<length; d++){
            for (int i=0, j=d; j<length; j++,i++){
                if (d == 0){
                    dp[i][j] = 1;
                }
                else if(d==1){
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && i+1 < length && j-1 >= 0){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                    else{
                        if (i+1 < length && j-1 >=0){
                            dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                        }
                    }
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
