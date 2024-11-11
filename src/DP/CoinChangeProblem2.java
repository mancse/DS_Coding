package DP;
/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000

Solution:
---------
/**
*       0   1   2   3   4   5
*
*  0    1   0   0   0   0   0 
*
*  1    1   1   1   1   1   1    
*
*  2    1   1   2   2   3   3  
*
*  5    1   1   2   2   3   4   
*  
*  
*  Idea: 
*  a. Assign dp[0][0] = 1  --- Because amount of value 0 can be achieved from 0 coins in 1 way. i.e just exclude all coins. 
*  b. dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]  
*     a.Here there are two possibilities. i.e coin at particular index can be excluded or included. 
*     b. If coin at particular index is excluded, then check value of dp[i-1][j]
*     c. But,coin at particular index is included, then check check the value in dp array in same row 
*     (as there is infine supply of coins) and column equal to j-coins[i-1]. 
*     d. Sum a+b and assign it to dp[i][j]
*      
*/

public class CoinChangeProblem2 {
	 public int change(int amount, int[] coins) {
	        
	        int dp[][] = new int[coins.length+1][amount+1];
	        
	        for (int i=0; i <= coins.length; i++){
	            for (int j=0; j<=amount; j++){
	                if (i==0 && j==0){
	                    dp[i][j] = 1;
	                }
	                else if (i == 0){
	                    dp[i][j] = 0;
	                }
	                else if (j == 0){
	                    dp[i][j] = 1;
	                }
	                else{
	                    if (coins[i-1] > j){
	                        dp[i][j] = dp[i-1][j];
	                    }
	                    else{
	                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
	                    }
	                }
	            }
	        }
	        return dp[coins.length][amount];
	    }
}
