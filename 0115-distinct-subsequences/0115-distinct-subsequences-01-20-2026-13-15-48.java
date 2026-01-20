class Solution {
    public int numDistinct(String s, String t) {
        int p = s.length();
        int q = t.length();
        if(q > p) return 0;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int dp[][] = new int[p + 1][q + 1];

        for(int arr[] : dp) arr[0] = 1;

        for(int i = 1; i <= p; i++){
            for(int j = 1; j <= q; j++){
                if(arr1[i - 1] == arr2[j - 1]) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[p][q];
    }
}