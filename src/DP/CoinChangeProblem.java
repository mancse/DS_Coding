package DP;

import java.util.HashMap;
import java.util.Map;
/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Solution:
---------
 *   |  0	1	2	3	4	5	6	7	8	9	10	11
 * --|------------------------------------------------
 * 0 |  0   inf inf inf inf inf inf inf inf inf inf inf
 * 1 |  0	1	2	3	4	5	6	7	8	9	10	11
 *   |
 * 2 |  0	1	1	2	2	3	3	4	4	5	5	6
 *   | 
 * 5 |  0   1	1	2	2	1	2	2	3	3	2	3
 * 
 * 
 * Logic:
 * 
 * a. Assign a[i][0]=0 for all values of i because minimum number of coins to make sum 0 will be 0 with any denomination.
 * b. if (coins[i] >= j)
 *       dp[i][j] = dp[i-1][j]
 *    else
 *       dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-coins[i]])
 *       
 *    a.Here there are two possibilities. i.e coin at particular index can be excluded or included. 
*     b. If coin at particular index is excluded, then check value of dp[i-1][j]
*     c. But,coin at particular index is included, then check check the value in dp array in same row 
*     (as there is infine supply of coins) and column equal to j-coins[i-1]. 
*     d. dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-coins[i]])
 * @author Manoj.K
 *
 */
public class CoinChangeProblem 
{
	public static void main(String args[])
	{
		int coins[] = {1, 2, 5};
		int res = coinChangeDP(coins,11);
		System.out.println("Minimum coin change: "+res);
	}
	
	public static int coinChangeDP(int[] coins, int amount) {

		int n = coins.length;
		int inf = Integer.MAX_VALUE - 1;
		int[][] dp = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= amount; j++) {
				if (j == 0)
					dp[i][j] = 0;
				else if (i == 0)
					dp[i][j] = inf;
				else if (coins[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]],dp[i - 1][j]);
			}
		}
		return dp[n][amount] >= inf ? -1 : dp[n][amount];
	}
	 public static int coinChange(int[] coins, int amount)
    {
		Map<String, Integer> memo = new HashMap<String, Integer>();
		int minWays = findMinNumsOfWaysCoinChange(coins, 0, amount, memo);
		return minWays;
	}
	    
	private static int findMinNumsOfWaysCoinChange(int coins[], int i, int sum,
			Map<String, Integer> memo) 
	{
		if (sum == 0) {
			return 0;
		}

		else if (sum < 0) {
			return -1;
		}

		if (i >= coins.length) {
			return -1;
		}
		String key = i + "-" + sum;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int coins1 = findMinNumsOfWaysCoinChange(coins, i, sum - coins[i], memo);

		int coins2 = findMinNumsOfWaysCoinChange(coins, i + 1, sum, memo);

		if (coins1 > -1)
			coins1 = 1 + coins1;

		if (coins1 > -1 && coins2 > -1) {
			int min = Math.min(coins1, coins2);
			memo.put(key, min);
			return min;
		}

		else if (coins1 == -1 && coins2 > -1) {
			memo.put(key, coins2);
			return coins2;
		}
		memo.put(key, coins1);
		return coins1;
	}
}
