class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0; 
        for (int num : nums) {
            sum += num;
        }
        
        // Edge case: If (sum + target) is odd or target is too large
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        // Compute P = (sum + target) / 2
        int P = (sum + target) / 2;

        // DP table where dp[i][j] is number of subsets using first i elements with sum j
        int[][] dp = new int[nums.length + 1][P + 1];

        // Base case: There is one way to form sum 0 (by choosing no elements)
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= P; j++) {
                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element if it's not greater than target sum j
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][P];
    }
}
