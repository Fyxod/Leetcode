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
        for(int len = 2; len <= n + 1; len++){
            for(int i = 0; i + len <= n + 1; i++){
                int j = i + len;
                int max = 0;
                for(int k = i + 1; k < j; k++){
                    max = Math.max(max, nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]);
                }

                dp[i][j] = max;
            }
        }

        return dp[0][n + 1];
    }
}