class Solution {
    int nums[];
    int target;
    int n;
    int dp[][];
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;
        for(int a : nums) sum += a;

        if(Math.abs(target) > sum) return 0;
        dp = new int[n + 1][sum*2 + 1];
        dp[n][target + sum] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int s = -sum; s <= sum; s++){
                if(s + nums[i] <= sum) dp[i][s + sum] += dp[i + 1][s + sum + nums[i]];
                if(s - nums[i] >= -sum) dp[i][s + sum] += dp[i + 1][s + sum - nums[i]];
            }
        }

        return dp[0][sum];
    }
    int f(int i, int s){
        if(i == n) return s == target ? 1 : 0;

        if(dp[i][s + sum] != -1) return dp[i][s + sum];

        return dp[i][s + sum] = f(i + 1, s + nums[i]) + f(i + 1, s - nums[i]);
    }
}
