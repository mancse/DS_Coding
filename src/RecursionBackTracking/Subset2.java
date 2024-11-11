package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * Idea: Same as above approach with following extra condition:
 * - Sort input array before passing it to recursive method
 * - while looping through elements inside recursive method, if value of i > start and nums[i] == nums[i-1] 
 * then continue. 
 * 
 * Complexity: Runtime: 2^N because every candidate element we are left with 2 options.. Either to take the element or not to take the number
 * Space complexity: O(N) because it is to store 
 * @author Manoj Kumar
 *
 */
public class Subset2 {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums,new ArrayList<Integer>(), 0);
        return result;
    }
    
    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> list, int start){
        result.add(new ArrayList<>(list));
        for (int i=start; i<nums.length;i++){
        	if (i > start && nums[i] == nums[i-1]) {
        		continue;
        	}
            list.add(nums[i]);
            backtrack(result,nums,list,i+1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String args[]) {
    	int nums[] = {1,2,2};
    	List<List<Integer>> result = subsets(nums);
    	System.out.println(result);	    
    }
}
