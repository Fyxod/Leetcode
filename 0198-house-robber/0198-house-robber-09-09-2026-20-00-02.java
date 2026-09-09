class Solution {
    int n;
    int nums[];
    int dp[];
    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0);
    }
    int f(int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i] + f(i + 2), f(i + 1));
    }
}