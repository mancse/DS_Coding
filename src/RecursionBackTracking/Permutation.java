package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;
/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

 * Idea: Idea here is to take recursive & backtracking approach where each index position is placed with 
 * different number one by one in recursion. 
 * Time and space complexity is N!. Because,  initially we have N choices and for each choice we can 
 * have N-1 choices and for those N-1 choices we have N-2 choices so this results into N*(N-1)*(N-2)*(N-3)…. 1 
 * Space complexity is also N!
 * @author Manoj Kumar
 *
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,result,0);
        return result;
    }
    private static void permute(int[] nums,List<List<Integer>> result, int idx)  {
        if (idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=idx; i<nums.length; i++){
            swap(nums,idx,i);
            permute(nums,result,idx+1);
            swap(nums,idx,i);
        }
    }
    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String args[]) {
    	int[] input = {1,2,3};
    	List<List<Integer>> res = permute(input);
    	System.out.println(res);
    }
}