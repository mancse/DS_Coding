/**
** Problem: Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
https://leetcode.com/problems/continuous-subarray-sum/description/
Solution: 
  Idea: To check (prefixSum % k) repeats, if yes then Then the subarray between those indices has sum divisible by k.

 */
class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
       //Map to store rem (prefixSum % k) vs index
       Map<Integer,Integer> map = new HashMap<>();
       map.put(0,-1);
       int sum=0;
       for (int i=0; i<nums.length; i++){
           sum += nums[i];
           int rem = sum % k;
           
           //Check at least two length of continuous array
           if (map.containsKey(rem)){
               if (i - map.get(rem) >= 2){
                return true;
               }
           }
           //Insert if rem is not present. 
           else{
              map.put(rem,i);
           }
       }
    return false;
    }
}
