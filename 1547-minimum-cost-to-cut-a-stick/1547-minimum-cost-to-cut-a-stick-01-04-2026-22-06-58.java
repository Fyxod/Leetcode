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
        for(int a[] : dp) Arrays.fill(a, -1);

        return f(arr, dp, 1, m);
    }

    int f(int cuts[], int dp[][], int i, int j){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int c = cuts[j + 1] - cuts[i - 1];
        int min = INF;
        for(int k = i; k <= j; k++){
            int cost = c + f(cuts, dp, i, k - 1) + f(cuts, dp, k + 1, j);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}