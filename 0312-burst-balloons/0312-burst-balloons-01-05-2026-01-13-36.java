class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for(int i = 0; i < n; i++) arr[i + 1] = nums[i];

        int dp[][] = new int[n + 2][n + 2];
        for(int a[] : dp) Arrays.fill(a, -1);
        return f(dp, arr, 1, n);
    }
    int f(int dp[][], int nums[], int i, int j){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = -1000000000;
        for(int k = i; k <= j; k++){
            int c = nums[i - 1] * nums[k] * nums[j + 1] + f(dp, nums, i, k - 1) + f(dp, nums, k + 1, j);
            max = Math.max(max, c);
        }

        return dp[i][j] = max;
    }
}