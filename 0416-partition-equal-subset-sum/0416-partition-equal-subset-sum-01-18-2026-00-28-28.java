class Solution {
    int n;
    int sum;
    int dp[][];
    public boolean canPartition(int[] nums) {
        n = nums.length;
        sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        dp = new int[n][sum + 1];

        return f(0, 0, nums);
    }
    boolean f(int i, int s, int nums[]){
        if(i == n) return s * 2 == sum;
        if(dp[i][s] != 0) return dp[i][s] == 1;

        boolean res = f(i + 1, s, nums) || f(i + 1, s + nums[i], nums);
        dp[i][s] = res ? 1 : -1;
        return res;
    }
}