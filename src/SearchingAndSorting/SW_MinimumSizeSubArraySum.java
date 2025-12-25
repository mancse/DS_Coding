/**
** Problem: https://leetcode.com/problems/minimum-size-subarray-sum/description/
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; 
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(right < nums.length){
            if (sum < target){
                sum += nums[right++];
            }
            while(sum >= target){
                min = Math.min(min, (right - left));
                sum -= nums[left++];
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
