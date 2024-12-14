package TwoPointers;

import java.util.Arrays;

/*
 * Find closest sum of 2 numbers in an array to a given target value. 
 * Note: Here we need to find the sum of the two numbers which is closest to given target and not the numbers.
 *
 * Idea: Follow similar way like two pointer approach to find two sum equal to target approach with small
 * difference that keep maintaining the closest sum.
 */
public class TwoSumClosest {
    public static int findTwoSumClosest(int[] nums, int target) {
    	int res = 0;
    	
    	int lo = 0; 
    	int hi = nums.length - 1;
    	
    	int minDiff = Integer.MAX_VALUE;
    	Arrays.sort(nums);
    	while (lo < hi) {
    		int sum = nums[lo] + nums[hi];
    		if (sum == target) {
    			return sum;
    		}
    		
    		int diff = Math.abs(target - sum);
    		if (diff < minDiff) {
    			minDiff = diff;
    		    res = sum;
    		}
    		if (sum < target) {
    			lo++;
    		}
    		else {
    			hi--;
    		}
    	}
    	return res;
    }
}
