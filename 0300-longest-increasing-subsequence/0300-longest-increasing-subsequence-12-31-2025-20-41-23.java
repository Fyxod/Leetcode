class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(nums, 0, 0, dp);
    }
    int f(int nums[], int i, int last, int[][] dp){
        if(i == nums.length) return 0;

        int val = last == 0 ? Integer.MIN_VALUE : nums[last - 1];

        if(dp[i][last] != -1) return dp[i][last];

        int l;
        if(nums[i] > val) l = Math.max(
            1 + f(nums, i + 1, i + 1, dp),
            f(nums, i + 1, last, dp)
        );
        else l = f(nums, i + 1, last, dp);
        return dp[i][last] = l;
    }
}