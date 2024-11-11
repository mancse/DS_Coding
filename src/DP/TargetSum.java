package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * 
 * Example: 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 

 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 * @author Manoj.K
 *
 */
public class TargetSum 
{
   public static void main(String args[])
   {
	   int input[] = {17,2,1,20,17,36,6,47,5,23,19,9,4,26,46,41,12,11,12,8};
	   	   
	   /*
	    * Take the column size 1001 because sum of the array can't exceeds 1000
	    */
	   int[][] memo = new int[input.length][2001];
       for (int[] row: memo)
           Arrays.fill(row, Integer.MIN_VALUE);
	   
	   int res1 = targetSumDP(input,0,26,new HashMap<String,Integer>());
	   System.out.println("Number of ways using DP: "+res1);	
   }
      
   private static int targetSumDP(int input[],int start,int sum,Map<String,Integer> store)
   {	
	   String key = start+"_"+sum;
	   
	   if (store.containsKey(key))
		   return store.get(key);
	   
	   if (input == null || input.length ==0)
	   {
		   return -1;
	   }
		   
	   if (sum == 0 && start == input.length)
	   {
		   return 1;
	   }
	   
	   if (start >= input.length)
		   return 0;
	   
	   System.out.println(" Start: "+start+" Sum: "+sum);
	      
	   /*
	    * This condition is required because we don't have to memorize negative sum. 
	    */
	   int res = targetSumDP(input,start+1,sum-input[start],store) + targetSumDP(input,start+1,sum+input[start],store);
	   store.put(key, res);
	   return res;
   }
   
   
   private static int targetSumDP1(int input[],int start,int sum,int memo[][])
   {	    
	   if (input == null || input.length ==0)
	   {
		   return -1;
	   }
		   
	   if (sum == 0 && start == input.length)
	   {
		   return 1;
	   }
	   
	   if (start >= input.length)
		   return 0;
	   
	   System.out.println(" Start: "+start+" Sum: "+sum);
	   
	   /*
	    * If we have already got the positive or 0 value stored in memo array then just return it. 
	    */
	   if (memo[start][sum+1000] > Integer.MIN_VALUE)
	   {
		   System.out.println("Memorization: "+memo[start][sum+1000]);
		   return memo[start][sum+1000];
	   }
		   
	   /*
	    * This condition is required because we don't have to memorize negative sum. 
	    */
	   Map<String,Integer> store = new HashMap<String,Integer>();
	   memo[start][sum+1000] = targetSumDP1(input,start+1,sum-input[start],memo) + targetSumDP1(input,start+1,sum+input[start],memo);
	   
	   return memo[start][sum+1000];
   }
}
