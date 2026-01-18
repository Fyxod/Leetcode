class Solution {
    int n;
    int sum;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        for(int a : nums) sum += a;
        dp = new int[n][2*sum + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(nums, target, 0, 0);
    }
    int f(int nums[], int target, int i, int s){
        if(i == n) return s == target ? 1 : 0;

        if(dp[i][sum + s] != -1) return dp[i][sum + s];

        return dp[i][sum + s] = f(nums, target, i + 1, s + nums[i]) + f(nums, target, i + 1, s - nums[i]);
    }
}