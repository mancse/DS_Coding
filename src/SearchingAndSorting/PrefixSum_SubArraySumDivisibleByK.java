/**
    Problem: https://leetcode.com/problems/subarray-sums-divisible-by-k/
    Algorithm:
    1. Keep a running prefix sum
    2. Compute remainder = prefixSum % k
    3. Normalize remainder to handle negatives to have positive modulo 
    4. If remainder appeared before → add its frequency to answer
    5. Increment remainder frequency
 */
class SubArraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {

        //Map of (prefixSum % k) vs frequency
        Map<Integer,Integer> map = new HashMap<>();

        //Base case of remainder=0 has frequency = 1 for subarray starting from index 0
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++){
            sum+= nums[i];
            int rem = sum % k;

            if (rem < 0){
                rem = rem + k;
            }
            count += map.getOrDefault(rem, 0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
