package RecursionBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
  Note: The solution set must not contain duplicate combinations.
  Example 1:
  Input: candidates = [10,1,2,7,6,1,5], target = 8
  Output: 
	[
		[1,1,6],
		[1,2,5],
		[1,7],
		[2,6]
	]
	Example 2:

	Input: candidates = [2,5,2,1,2], target = 5
	Output: 
	[
		[1,2,2],
		[5]
	]
	
   https://leetcode.com/problems/combination-sum-ii/
   
   Idea: approach is same as above only with few more constraints as mentioned below:
    - Sort the input array before passing it to backtrack function
    -Skip the element if current indexed element is equal to previous indexed element. 
 * @author Manoj Kumar
 *
 */
public class CombinationSum2 {

	public static List<List<Integer>> findCombinationSum(int[] candidates, int target)
	{
		List<List<Integer>> results = new ArrayList<>();
		
		if (candidates == null || candidates.length == 0)
		{
			return results;
		}
		Arrays.sort(candidates);
		
		List<Integer> combination = new ArrayList<>();
		findCombinationSumToGivenTarget(results,combination,candidates,target,0);
		return results;
	}
	
	private static void findCombinationSumToGivenTarget(List<List<Integer>> results, List<Integer> combination, int[] candidates, int target, int start)
	{
		if (target == 0)
		{
			/*
			 * Taking deep copy of combination list into results. It is because combination list is always changing. If we don't
			 * take deep copy then results array will also be changing as and when combination list is changing. So, it will cause
			 * wrong result. 
			 */
			results.add(new ArrayList<>(combination));
			return;
		}
		
		if (target < 0)
			return;
		
		for (int i=start ; i < candidates.length; i++)
		{
			
			if (i > start && candidates[i] == candidates[i-1]) {
				continue;
			}
			
			
			/**
			 * Taking candidates[i] 
			*/
			combination.add(candidates[i]);
			
			// Here i+1 is used because same number can be used only once.
			findCombinationSumToGivenTarget(results,combination,candidates,target-candidates[i],i+1); 
			    
		   /*
			* This is to backtrack. - Not taking 
			*/
			combination.remove(combination.size() -1);
		}
		
	}
    public static void main(String args[])
    {
    	int[] candidates = {1,2,2,4};
    	List<List<Integer>> results = findCombinationSum(candidates,7);
    	
    	for (List<Integer> result : results)
    	{
    		for (Integer res : result)
    		{
    			System.out.print(" "+res);
    		}
    		System.out.println();
    	}
    }
}
