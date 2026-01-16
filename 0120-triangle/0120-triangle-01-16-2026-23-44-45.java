class Solution {
    int INF = Integer.MAX_VALUE/ 2;
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int dp[][] = new int[n][];
        for(int i = 0; i < n; i++){
            dp[i] = new int[tri.get(i).size()];
        }
        for(int arr[] : dp) Arrays.fill(arr, INF);

        return f(dp, n, tri, 0, 0);
    }
    int f(int dp[][], int n, List<List<Integer>> tri, int i, int j){
        if(i == n - 1) return tri.get(i).get(j);

        if(dp[i][j] != INF) return dp[i][j];

        return dp[i][j] = tri.get(i).get(j) + Math.min(
            f(dp, n, tri, i + 1, j),
            f(dp, n, tri, i + 1, j + 1)
        );
    }
}