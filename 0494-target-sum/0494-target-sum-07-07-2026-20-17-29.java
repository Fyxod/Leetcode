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
        dp = new int[n][sum*2 + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0);
    }
    int f(int i, int s){
        if(i == n) return s == target ? 1 : 0;

        if(dp[i][s + sum] != -1) return dp[i][s + sum];

        return dp[i][s + sum] = f(i + 1, s + nums[i]) + f(i + 1, s - nums[i]);
    }
}
