package RecursionBackTracking;
/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Approach: This problem is similar to finding subset of numbers from given input number array with condition that each subset should add up to given number.  
 * Complexity: Runtime: 2^N because every candidate element we are left with 2 options.. Either to take the element or not to take the number
 * Space complexity: O(N) because it is to store 
 * @author Manoj.K
 * 
 * https://leetcode.com/problems/combination-sum/
 *
 */
public class CombinationSum 
{
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
		
		
		for (int i=start ; i < candidates.length; i++)
		{
			if (candidates[i] > target)
				break;
			    
			    /**
			     * Taking candidates[i] 
			     */
			    combination.add(candidates[i]);
			    
			    //Here i is used because same number can be used multiple times
			    findCombinationSumToGivenTarget(results,combination,candidates,target-candidates[i],i);
			    
			    /*
			     * This is to backtrack. - Not taking 
			     */
			    combination.remove(combination.size() -1);
		}
		
	}
    public static void main(String args[])
    {
    	int[] candidates = {3,2,6,7};
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
