package DP;
/**
 * Given: A list of items whose weights and prices are given in the two different lists and also one bag 
 * of capacity W is provided. Fill the bag in such a way to achieve the maximum profit and also total capacity
 * of items should also not exceed oveall capacity of the bag.
 * 
 * weight[]={3,4,2}
 * profit[]={5,6,4}
 * W=6
 * 
 *      0	1	2	3	4	5	6
 *      
 *  0   0	0	0	0	0	0	0
 *  
 *  3   0	0   0	5	5	5	5	
 *  
 *  4	0	0	0	5	6	6	6
 *  
 *  2	0	0	4	5	6	9   10
 * 
 *  dp[i][j] = dp[i-1][j]  -- When weight[i-1] > j 
 *  
 *  dp[i][j] = Math.max(dp[i-1][j],profit[i-1]+dp[i-1][j-weight[i-1])
 *  
 * @author Manoj.K
 *
 */
public class ZeroOneKnapsack {
	public static int getMaxProfit(int weight[],int profit[],int W){
		
		int dp[][] = new int[weight.length+1][W+1];
		for (int i=1; i<dp.length; i++){
			for (int j=1; j<dp[i].length; j++){
				if (weight[i-1] > j){
					dp[i][j] = dp[i-1][j];
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], profit[i-1]+dp[i-1][j-weight[i-1]]);
				}
			}
		}
		
		return dp[weight.length][W];
	}
	
	public static void main(String args[]){
		int weight[]={3,4,2};
		int profit[]={5,6,4};
		int W=6;
		
		int maxProfit = getMaxProfit(weight,profit,W);
		
		System.out.println("Max profit: "+maxProfit);
	}
}
