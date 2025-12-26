class Solution {
    static int INF = Integer.MAX_VALUE/2;
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int sum = 0;
        for(int a : nums) sum += a;
        if(Math.abs(t) > sum) return 0;

        int dp[][] = new int[n][sum*2 + 1];

        if(nums[0] == 0) dp[0][sum] = 2;
        else{
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = -sum; j <= sum; j++){
                int p = 0;
                if(j + nums[i] <= sum) p += dp[i - 1][j + nums[i] + sum];
                if(j - nums[i] >= -sum) p += dp[i - 1][j - nums[i] + sum];
                dp[i][j + sum] += p;
            }
        }
        return dp[n - 1][t + sum];
    }
}