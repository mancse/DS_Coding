package DP;

/**
 * 
 * 
 * 		0,1,2,3,4,5,6,7,8,9,10
      4 T F F F T F F F F F F 
	  2 T F T F T F T F F F F
	  7 T F T F T F T T F T F
	  1 T T T T T T T T T T T
	  3 T T T T T T T T T T T 
      	  
 * @author Manoj.K
 *
 */
public class TargetSumSubset 
{
	public static void main(String args[])
	{
		int sum = 10;
		int arr[] = {4,2,7,1,3};
		
		boolean ret = isTargetSumSubsetPresent(arr,sum);
		System.out.println(ret);
	}
	
	private static boolean isTargetSumSubsetPresent(int arr[], int sum)
	{
		boolean ret = false;
		
		boolean dp[][] = new boolean[arr.length][sum+1];
		
		for (int i =0 ; i<arr.length; i++)
		{
			dp[i][0] = true;
		}
		
		for (int i=1; i< arr.length ; i++)
		{
			for (int j=1; j <= sum; j++)
			{
				/**
				 * if arr[i] contributes to the current sum value at index j then check if rest sum i.e (j - arr[i])
				 * can be achieved from earlier subarray numbers i.e arr[i-1]. So, 
				 * dp[i][j] = dp[i-1][j-arr[i]]
				 * 
				 * If arr[i] doesn't contributes to the current sum at index j then total current sum i.e j will have 
				 * to be achieved from earlier subarray only i.e arr[i-1]. So, 
				 * dp[i][j] = dp[i-1][j]
				 */
				if (j-arr[i] >=0)
					dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i]];
				else 
					dp[i][j] = dp[i-1][j];
			}
		}
		
		ret = dp[arr.length-1][sum];
		return ret;
	}
}
