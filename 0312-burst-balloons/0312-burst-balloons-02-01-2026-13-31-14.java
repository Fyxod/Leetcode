class Solution {
    int n;
    int dp[][];
    int arr[];
    int INF = Integer.MIN_VALUE / 2;
    public int maxCoins(int[] nums) {
        n = nums.length;
        arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for(int i = 1; i <= n; i++) arr[i] = nums[i - 1];
        dp = new int[n + 2][n + 2];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, n + 1);
    }
    int f(int i, int j){
        if(j - i < 2) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = INF;
        for(int k = i + 1; k < j; k++){
            max = Math.max(max, arr[i] * arr[j] * arr[k] + f(i, k) + f(k, j));
        } 

        return dp[i][j] = max;
    }
}