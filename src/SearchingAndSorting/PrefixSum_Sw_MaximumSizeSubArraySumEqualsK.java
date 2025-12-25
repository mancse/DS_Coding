/*
**  Problem: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
**  
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int right=0; right < nums.length; right++){
            sum +=nums[right];
            
            //If sum itself = k then update max vaule with right + 1. 
            if (sum == k){
                max =  right+ 1;
            }

            if (map.containsKey(sum - k)){
                int left = map.get(sum - k);
                max = Math.max(max, right - left);
            }

            //Note: Here use putIfAbsent() method instead of put() because if for same sum if two indexes are there then retain leftmost index and don't overrite it with right index because we need maximum length array. 
            map.putIfAbsent(sum, right);
        }
        return max;
    }
}
