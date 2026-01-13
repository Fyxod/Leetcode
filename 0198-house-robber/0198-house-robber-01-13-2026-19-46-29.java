class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return f(dp, nums, 0);
    }
    int f(int dp[], int nums[], int i){
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(
            nums[i] + f(dp, nums, i + 2),
            f(dp, nums, i + 1)
        );
    }
}