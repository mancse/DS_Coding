package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given a N story building and K eggs. Find the number of minimum trial to find the floor from 
 * where if an egg is dropped it will break certainly. 
 * 
 * Note: Here, we don't have to find the number of floor from where egg will break but we need to find minimum 
 * number of trial, in which ith floor is identified from where egg will will break for sure. 
 * 
 * Assumptions:
 * ------------
 * a. An egg survives a fall can be used again
 * b. A broken egg must be discarded.
 * c. The effect of fall is same for all eggs.
 * d. An egg not broken from floor x, can't be broken from any floor lower to x.
 * e. An egg if breaks from any floor x, must break from any floor higher than x. 
 * f. It is not ruled out that an egg can be broken from very first floor as well as can't break from highest floor.
 * 
 * @author Manoj.K
 *
 */
public class EggDropping 
{
	public static int eggDrop(int n, int k)
	{
		if (n==0)
			return 0;
		if (n==1)
			return 1;
		
		if (k==0)
			return 0;
		if (k==1)
			return n;
	    
		
		int min = Integer.MAX_VALUE;
		int res;
		/**
		 * Consider all dropping from 0th floor to nth floor and consider the minimum trial.
		 * Logic: Here main logic is that on each step there are two possiblities i.e an egg can break or 
		 * can't break.
		 * 
		 * a. If egg breaks at floor i (where 1=<i<=n), it means we need to check floors lower than ith so 
		 *    floor count is reduced to i-1 and egg count reduced to k-1
		 *    
		 * b. If egg doesn't break at floor i (where 1=<i<=n), it means we need to check floors higher than 
		 *    ith floor. So, problem reduced to remaining floor count as n-i and egg count is still k. 
		 *    
		 * So, each step, we need to find the maximum trial and that can be found by comparing the trials 
		 * using (eg. Math.max)
		 * of step a and b. So, minimum trial is the minimum value from every such ith floor. 
		 * 
		 */
	    for (int i=1; i<=n ; i++)
	    {
	    	System.out.println("floor: "+i+" egg: "+k);
	    	
	    	res = 1 + Math.max(eggDrop(i-1,k-1) , eggDrop(n-i,k));
	        
	    	
	    	min = Math.min(min, res);
	    }
	    
	    return min;
	}
	
	public static int eggDropByDP(int n, int k, Map<String,Integer> memo)
	{
		if (n==0)
			return 0;
		if (n==1)
			return 1;
		
		if (k==0)
			return 0;
		if (k==1)
			return n;
	    
		
		int min = Integer.MAX_VALUE;
		int res;
		
		/**
		 * Consider all dropping from 0th floor to nth floor and consider the minimum trial.
		 * Logic: Here main logic is that on each step there are two possiblities i.e an egg can break or can't break.
		 * 
		 * a. If egg breaks at floor i (where 1=<i<=n), it means we need to check floors lower than ith so 
		 *    floor count is reduced to i-1 and egg count reduced to k-1
		 *    
		 * b. If egg doesn't break at floor i (where 1=<i<=n), it means we need to check floors higher than ith floor. 
		 *    So, problem reduced to remaining floor count as n-i and egg count is still k. 
		 *    
		 * So, each step, we need to find the maximum trial and that can be found by comparing the trials using (eg. Math.max)
		 * of step a and b. So, minimum trial is the minimum value from every such ith floor. 
		 * 
		 */
		if (memo.containsKey(n+"_"+k))
			return memo.get(n+"_"+k);
		
	    for (int i=1; i<=n ; i++)
	    {
	    	
	    	System.out.println("floor: "+i+" egg: "+k);
	    	res = 1 + Math.max(eggDropByDP(i-1,k-1,memo) , eggDropByDP(n-i,k,memo));
	    	min = Math.min(min, res);
	    	memo.put(n+"_"+k, min);
	    }
	    
	    return min;
	}
    public static void main(String args[])
    {
    	//int res = eggDrop(10,2);
    	Map<String,Integer> memo = new HashMap<String,Integer> ();
    	int res = eggDropByDP(10,2,memo);
    	System.out.println("Minimum trial in worst case to find floor: "+res);
    }
}
