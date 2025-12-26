class Solution {
    static int INF = Integer.MAX_VALUE/2;
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int sum = 0;
        for(int a : nums) sum += a;
        int dp[][] = new int[n][sum*2 + 1];
        for(int arr[] : dp) Arrays.fill(arr, INF);
        return f(nums, dp, t, 0, 0, sum);
    }
    int f(int nums[], int dp[][], int t, int i, int sum, int tot){
        if(i == nums.length){
            if(t == sum) return 1;
            else return 0;
        }
        if(dp[i][sum + tot] != INF) return dp[i][sum + tot];

        return dp[i][sum + tot] = f(nums, dp, t, i + 1, sum + nums[i], tot) + f(nums, dp, t, i + 1, sum - nums[i], tot);
    }
}