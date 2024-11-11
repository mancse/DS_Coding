package RecursionBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations
 * in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Idea: 
Approach is same as above except additional 
condition. Sort the input array before passing it to backtrack function and inside backtrack function, skip in following two cases:
  - If current index element is already picked 
  - If earlier element is already picked and current element is equal to previous indexed element in the
    input array.
  
   Time and space complexity is same i.e N!. 
 * @author Manoj Kumar
 *
 */
public class Permutation2 {
	private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,res,list,picked);
        return res;
    }
    
    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] picked){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i=0; i<nums.length; i++){
            if (!picked[i]){
            	//If previous element is already picked and current element is equal to previous element then continue. 
            	if (picked[i-1] && nums[i] == nums[i-1])
            		continue;
            	
                picked[i] = true;
                list.add(nums[i]);
                backtrack(nums,res,list,picked);
                picked[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String args[]) {
    	int[] input = {1,2,3};
    	List<List<Integer>> res = permute(input);
    	System.out.println(res);
    }
}
