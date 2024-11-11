package arrays;
/**
 * Question: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 */
import java.util.HashMap;
import java.util.Map;

public class LongestConsequitiveSubSequenceInArray {
    public static int longestConsecutive(int[] nums) {
    	
        Map<Integer,Boolean> map = new HashMap<>();
        
        /**
         * First assign true against every element as true. Here, we are just assuming that all array element is 
         * the starting element of it's consecutive sequence. 
         */
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],true);
        }
        
        /**
         * Now, check if map already contains element previous to nums[i] element, i.e if map already contains nums[i]-1
         * as key, it means nums[i] can't be the start element of its consecutive sequence. So, assign false against those
         * nums[i]. 
         */
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i] - 1)){
                map.put(nums[i],false);
            }
        } 
        int maxLen=0;
        /**
         * Now, check only those nums[i] as key in the map whose value is true. It means those are really the start of 
         * it's consecutive sequence. 
         */
        for (int i=0; i<nums.length; i++){
            if (map.get(nums[i]) == true){
                int startNum = nums[i];
                int curLen=1;
                int nextNum = startNum + 1;
                while(map.containsKey(nextNum)){
                    nextNum = nextNum + 1;
                    curLen++;
                }
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;
    }
    
    public static void main(String args[]){
    	int nums[] = {100,4,200,1,3,2};
    	int res = longestConsecutive(nums);
    	System.out.println("Longest consecutive sequence: "+res);
    }
}
