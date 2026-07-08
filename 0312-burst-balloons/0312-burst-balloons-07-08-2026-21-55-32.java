class Solution {
    int nums[];
    int n;
    int dp[][];
    public int maxCoins(int[] c) {
        n = c.length;
        nums = new int[n + 2];
        nums[0] = nums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            nums[i + 1] = c[i];
        }

        dp = new int[n + 2][n + 2];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, n + 1);
    }
    int f(int i, int j){
        if(j - i < 2) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for(int k = i + 1; k < j; k++){
            max = Math.max(max, nums[i] * nums[k] * nums[j] + f(i, k) + f(k, j));
        }

        return dp[i][j] = max;
    }
}