class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n2 > n1) return 0;
        int dp[][] = new int[n1 + 1][n2 + 1];
        for(int arr[] : dp) arr[n2] = 1;

        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                else dp[i][j] = dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}