class Solution {
    int nums[];
    int n;
    int dp[];
    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.max(
            helper(0),
            helper(1)
        );
    }
    int helper(int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = nums[i] + Math.max(helper(i + 2), helper(i + 3));
    }
}