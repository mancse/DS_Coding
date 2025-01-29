class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int lis = 0;
        for (int i=0; i<dp.length; i++){
            for (int j=0; j < i; j++){
                if (nums[j] < nums[i]){
                    //Retrieve maximum LIS count before ith index
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
            lis = Math.max(lis,dp[i]);
        }
        
        return lis;
    }
}
