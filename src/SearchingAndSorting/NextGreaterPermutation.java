package SearchingAndSorting;
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of
 * numbers.If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory i.e find smallest but still greater than the original number in 
 * the given number. 
 * 
 * Eg: 
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * 
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * 
 * Input: nums = [3,1,6,9,8,7,5,4,2]
 * Output: [3,1,7,9,8,6,5,4,2]
 * 
 * https://leetcode.com/problems/next-permutation/
 */
import java.util.Arrays;

public class NextGreaterPermutation {
	
	public void nextPermutation(int[] nums) {
	        int j=0;
	        
	        /**
	    	 * Traverse the array from backward and find the index where number is greater than it's 
	    	 * previous index element and store that index in a variable.
	    	 */
	        for (int i=nums.length-1; i>0; i--){
	            if (nums[i] > nums[i-1]){
	                j=i;
	                break;
	            }
	        }
	        
	        /**
	         * Now, again traverse from backward and find the first element which greater than (j-1)th
	         * index element because and swap them. 
	         */
	        for (int i= nums.length-1; i >=j ; i--){
	            if (j>0 && nums[j-1] < nums[i]){
	                swap(nums,j-1,i);
	                break;
	            }
	        }
	        /**
	         * Now, sort the elements from jth index to array length to ensure that the permutaion found 
	         * is the smallest but greater than original array elements. 
	         */
	        Arrays.sort(nums,j,nums.length);
	    }
	    
	    private void swap(int [] nums, int i, int j){
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	    }
}
