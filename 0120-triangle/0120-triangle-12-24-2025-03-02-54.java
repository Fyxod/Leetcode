class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int m = list.size();
        int dp[] = new int[1];

        // for(int i = 0; i < m; i++){
        //     dp[i] = new int[list.get(i).size()];
        // }
        dp[0] = list.get(0).get(0);

        for(int i = 1; i < m; i++){
            int n = list.get(i).size();
            int curr[] = new int[n];
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE / 2;
                if(j != n - 1) min = Math.min(min, dp[j]);
                if(j > 0) min = Math.min(min, dp[j - 1]);
                curr[j] = min + list.get(i).get(j);
            }
            dp = curr;
        }
        int min = Integer.MAX_VALUE / 2;
        for(int a : dp) min = Math.min(min, a);
        return min;
    }
}