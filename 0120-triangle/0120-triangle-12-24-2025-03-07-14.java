class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int m = list.size();
        int dp[][] = new int[m][];

        for(int i = 0; i < m; i++){
            dp[i] = new int[list.get(i).size()];
        }
        for(int arr[] : dp) Arrays.fill(arr, (int)1e5);
        dp[0][0] = list.get(0).get(0);
        int min = Integer.MAX_VALUE / 2;
        for(int i = 0; i < list.get(m - 1).size(); i++){
            min = Math.min(min, f(list, dp, m - 1, i));
        }
        return min;
    }
    int f(List<List<Integer>> list, int[][] dp, int i, int j){
        // System.out.print(i + " " + j);
        // System.out.println();
        if(j < 0 || j > list.get(i).size() - 1) return Integer.MAX_VALUE/2;

        if(dp[i][j] !=1e5) return dp[i][j];

        return dp[i][j] = list.get(i).get(j) + 
                            Math.min(f(list, dp, i - 1, j), f(list, dp, i - 1, j - 1));
    }
}