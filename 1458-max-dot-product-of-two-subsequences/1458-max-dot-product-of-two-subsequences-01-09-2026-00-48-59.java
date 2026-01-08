class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int INF = Integer.MIN_VALUE / 2;
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) dp[i][m] = INF;
        for(int i = 0; i <= m; i++) dp[n][i] = INF;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int pro = nums1[i] * nums2[j];
                int max = pro;
                max = Math.max(max, pro + dp[i + 1][j + 1]);
                max = Math.max(max, dp[i + 1][j + 1]);
                max = Math.max(max, dp[i + 1][j]);
                max = Math.max(max, dp[i][j + 1]);

                dp[i][j] = max;
            }
        }

        return dp[0][0];
    }
}