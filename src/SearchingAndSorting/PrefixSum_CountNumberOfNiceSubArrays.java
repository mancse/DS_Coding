/**
    Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/description/
    
    Idea: 

    1. Convert each odd number to 1 and even to 0 in the array. 
       So, input [1,1,2,1,1] will be transformed to [1,1,0,1,1]
    2. Now, problem is simplified to find the numbers of continuous subarrays whoes sum equals to K. 
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         //Convert
         for (int i=0; i<nums.length; i++){
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
         }
         
         //Prefix sum vs frequency map
         Map<Integer,Integer> map = new HashMap<>();
        
         //Sum 0 has frequency 1. 
         map.put(0,1);
        
         int sum = 0;
         int count = 0; 
         for (int i=0; i<nums.length; i++){
            sum += nums[i];

            count += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0)+1);
         }

         return count;
    }
}
