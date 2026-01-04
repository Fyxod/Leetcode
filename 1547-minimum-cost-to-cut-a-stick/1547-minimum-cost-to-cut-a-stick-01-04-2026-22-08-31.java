class Solution {
    int INF = 1000000000;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int arr[] = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for(int i = 0; i < m; i++) arr[i + 1] = cuts[i];

        int dp[][] = new int[m + 2][m + 2];

        for(int len = 1; len < m + 2; len++){
            for(int i = 1; i + len - 1 <= m; i++){
                int j = i + len - 1;
                int c = arr[j + 1] - arr[i - 1];
                int min = INF;
                for(int k = i; k <= j; k++){
                    int cost = c + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min == INF ? 0 : min;
            }
        }

        return dp[1][m];
    }
}