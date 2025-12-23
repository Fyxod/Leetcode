class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int m = list.size();
        int dp[][] = new int[m][];

        for(int i = 0; i < m; i++){
            dp[i] = new int[list.get(i).size()];
        }
        dp[0][0] = list.get(0).get(0);

        for(int i = 1; i < m; i++){
            int n = list.get(i).size();
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE / 2;
                if(j != n - 1) min = Math.min(min, dp[i - 1][j]);
                if(j > 0) min = Math.min(min, dp[i - 1][j - 1]);
                dp[i][j] = min + list.get(i).get(j);
            } 
        }
        int min = Integer.MAX_VALUE / 2;
        for(int a : dp[m - 1]) min = Math.min(min, a);
        return min;
    }
}