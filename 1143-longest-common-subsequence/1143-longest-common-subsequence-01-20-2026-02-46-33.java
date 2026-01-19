class Solution {
    static int n1;
    static int n2;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        int dp[][] = new int[n1][n2];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(dp, text1, text2, 0, 0);
    }
    int f(int dp[][], String text1, String text2, int i, int j){
        if(i == n1 || j == n2) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + f(dp, text1, text2, i + 1, j + 1);
        }
        else return dp[i][j] = Math.max(
            f(dp, text1, text2, i + 1, j),   
            f(dp, text1, text2, i, j + 1)   
        );
    }
}