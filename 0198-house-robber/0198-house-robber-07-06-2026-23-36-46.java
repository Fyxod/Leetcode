class Solution {
    int nums[];
    int n;
    int dp[];
    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1) return nums[0];
        this.nums = nums;
        dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 2];
            if(i - 3 >= 0) dp[i] = Math.max(dp[i], dp[i - 3]);
            dp[i] += nums[i];
        }

        return Math.max(
            dp[n - 1],
            dp[n - 2]
        );
    }
    int helper(int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = nums[i] + Math.max(helper(i + 2), helper(i + 3));
    }
}