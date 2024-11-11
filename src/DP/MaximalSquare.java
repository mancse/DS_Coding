package DP;
/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's 
 * and return its area.
 * 
 * Input: matrix = [["1","0","1","0","0"],
 *                  ["1","0","1","1","1"],
 *                  ["1","1","1","1","1"],
 *                  ["1","0","0","1","0"]]
 *                  
 *                  
 *         
 * DP array: 
 * 
 *        	0	 1	 2	 3	 4	 5   
 *        
 *     0	0    0   0   0   0   0
 *     
 *     1    0    1   0   1   0   0
 *     
 *     2    0    1   0   1   1   1
 *     
 *     3    0    1   1   1   2   2
 *     
 *     4    0    1   0   0   1   0
 *     
 * Output: 4
 * Link: https://leetcode.com/problems/maximal-square/
 * @author Manoj.K
 *
 */
public class MaximalSquare {
	
	/**
	 * Logic: if '1' is present at an index i,j then it can add up to make larger square from previous sized
	 * squares only if this '1' is diagonally adjacent to previous square and cells of row i are '1' and all
	 * cells at column j are '1'.
	 * 
	 * So, recurrence formula is: 
	 * dp[i][j]=1+minimum(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])-- if mat[i][j] is equal to '1' 
	 * @param matrix
	 * @return
	 */
	public static int maximalSquare(char[][] matrix) {
		
        int dp[][]=new int[matrix.length+1][matrix[0].length+1];
        int maxLength=0;
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    maxLength = Math.max(maxLength,dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
