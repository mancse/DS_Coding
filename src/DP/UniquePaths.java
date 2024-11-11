package DP;

import java.util.ArrayList;
import java.util.List;

public class UniquePaths 
{
	private static List <List<Integer>> findALlUniquePaths(int arr[][])
	{
		List <List<Integer>> results = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		findUniquePaths(results,list,0,0,arr);
		return results;
	}
	
	private static void findUniquePaths(List <List<Integer>> results, List<Integer> list, int i, int j,int arr[][])
	{
	    if (i>= arr.length || j>= arr[0].length)
	    {
	       return;
	    }
	    list.add(arr[i][j]);

	    if (i==arr.length -1 && j == arr[0].length -1)
	    {
	       results.add(new ArrayList<Integer>(list));
	       return;
	    }
	    
	    findUniquePaths(results,list,i,j+1,arr);
	    findUniquePaths(results,list,i+1,j,arr);
	    
	    list.remove(list.size() - 1);
	}
  
   private static int findUniquePathsDP(int arr[][])
   {
	   int result = 0 ;
	   int [][] dp = new int[arr.length][arr[0].length];
	   
	   for (int i=0 ; i < arr.length; i++)
	   {
		   dp[i][0] = 1;
	   }
	   
	   for (int i=0 ; i < arr[0].length; i++)
	   {
		   dp[0][i] = 1;
	   }
	   
	   for (int i=1; i< arr.length ; i++)
	   {
		   for (int j=1; j<arr[i].length; j++)
		   {
			   dp[i][j] = dp[i-1][j] + dp[i][j-1];
		   }
	   }
	   
	   result = dp[dp.length-1][dp[0].length-1];
	   return result;
   }
   
   private static int findUniquePathsDP(int dp[][], int i, int j,int arr[][])
   {
	    if (i>= arr.length || j>= arr[0].length)
	    {
	       return 0;
	    }
	    
	    if (dp[i][j] > 0)
	    	return dp[i][j];
	    
	    if (i==arr.length -1 && j == arr[0].length -1)
	    {
	       return 1;
	    }
	    
	    dp[i][j] =  findUniquePathsDP(dp,i,j+1,arr) + findUniquePathsDP(dp,i+1,j,arr);
	    
	    return dp[i][j];
   }
   
   public static void main(String args[])
   {
	   int a[][]=new int[7][3];
	   int dp[][]=new int[7][3];
	   List <List<Integer>> results = findALlUniquePaths(a);
	   System.out.println("Total paths: "+results.size());
	   System.out.println("Total paths DP:"+findUniquePathsDP(a));
	   System.out.println("Total paths DP2: "+findUniquePathsDP(dp,0,0,a));
   }
}
