class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        int dp[][] = new int[n][sum + 1];
        return f(nums, 0, 0, n, sum, dp);
    }
    boolean f(int nums[], int i, int sum1, int n, int sum, int[][] dp){
        if(sum1 > sum) return false;
        if(i == n){
            if(sum1 == sum) return true;
            else return false;
        }

        if(dp[i][sum1] != 0) return dp[i][sum1] == 1;
        if(f(nums, i + 1, sum1 + nums[i], n, sum, dp) || f(nums, i + 1, sum1, n, sum, dp)) dp[i][sum1] = 1;
        else dp[i][sum1] = -1;
        return dp[i][sum1] == 1;
    }
}