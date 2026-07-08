class Solution {
    int n;
    int cuts[];
    int dp[][];
    int l;
    int arr[];
    int INF = Integer.MAX_VALUE / 2;
    public int minCost(int l, int[] cuts) {
        Arrays.sort(cuts);
        this.l = l;
        this.cuts = cuts;
        n = cuts.length;
        arr = new int[n + 2];
        arr[n + 1] = l;
        for(int i = 0; i < n; i++){
            arr[i + 1] = cuts[i];
        }

        dp = new int[n + 2][n + 2];
        for(int len = 2; len <= n + 1; len++){
            for(int i = 0; i + len <= n + 1; i++){
                int j = i + len;

                int min = INF;
                for(int k = i + 1; k < j; k++){
                    min = Math.min(min, arr[j] - arr[i] + dp[i][k] + dp[k][j]);
                }

                dp[i][j] = min;
            }
        }

        return dp[0][n + 1];
    }
}