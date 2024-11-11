package RecursionBackTracking;
import java.util.*;
/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * 
 * Keep on adding element in temporary list and while backtracking after call of recursive call, just remove 
 * last elemnt from temporary list. 
 * Complexity: Runtime: 2^N because every candidate element we are left with 2 options.. Either to take the element or not to take the number
 * Space complexity: O(N) because it is to store 
 * 
 * @author Manoj Kumar
 *
 */
public class Subsets {
	    public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        backtrack(result, nums,new ArrayList<Integer>(), 0);
	        return result;
	    }
	    
	    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> list, int start){
	        result.add(new ArrayList<>(list));
	        for (int i=start; i<nums.length;i++){
	            list.add(nums[i]);
	            backtrack(result,nums,list,i+1);
	            list.remove(list.size() - 1);
	        }
	    }
	    
	    public static void main(String args[]) {
	    	int nums[] = {1,2,3};
	    	List<List<Integer>> result = subsets(nums);
	    	System.out.println(result);	    
	    }
}
