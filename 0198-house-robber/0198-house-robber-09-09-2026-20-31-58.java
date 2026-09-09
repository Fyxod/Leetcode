class Solution {
    int n;
    int nums[];
    int dp[];
    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[n + 2];
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return dp[0];
    }
}