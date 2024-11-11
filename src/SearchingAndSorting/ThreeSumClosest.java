package SearchingAndSorting;

import java.util.Arrays;
/*
 * Find closest sum of 3 numbers in an array to a given target value. 
 * Note: Here we need to find the sum of the three numbers which is closest to given target and not the numbers. 
 */
public class ThreeSumClosest {
	 public int threeSumClosest(int[] nums, int target) {
	        int result =0;
	        int minDiff = Integer.MAX_VALUE;
	        Arrays.sort(nums);
	        for (int i=0; i<nums.length-2; i++){
	            int lo = i + 1;
	            int hi = nums.length -1;
	            System.out.println("index i: "+i+" lo: "+lo+" hi: "+hi);
	            while(lo < hi)
	            {
	                int sum = nums[i] + nums[lo] + nums[hi];
	            
	                 if (sum == target){
	                    return sum;
	                 }
	            
	                 int diff = Math.abs(target - sum);
	                 if (diff < minDiff){
	                     minDiff = diff;
	                     result = sum;
	                 }
	              
	                 if (sum < target){
	                    lo++;
	                 }
	                else{
	                     hi--;
	                 }
	                
	                System.out.println("diff: "+diff+" minDiff: "+minDiff);
	            }
	        }
	        
	        return result; 
	    }
}
