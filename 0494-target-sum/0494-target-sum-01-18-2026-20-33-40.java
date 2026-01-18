class Solution {
    int n;
    int sum;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        for(int a : nums) sum += a;
        if(target > sum || target < -sum) return 0;
        dp = new int[n + 1][2*sum + 1];
        dp[n][sum + target] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int s = -sum; s <= sum; s++){
                int idx = sum + s;
                int ways = 0;

                if(idx + nums[i] <= 2 * sum) ways += dp[i + 1][idx + nums[i]];
                if(idx - nums[i] >= 0) ways += dp[i + 1][idx - nums[i]];
                dp[i][sum + s] = ways;
            }
        }

        return dp[0][sum];
    }
}